package com.github.bigwheel.skypeslackrelay

import com.skype._
import com.twitter.util.Eval
import java.io.File
import scala.concurrent.ExecutionContext.Implicits.global
import scalaz.Scalaz._
import slack.api.BlockingSlackApiClient

object Main {
  def main(args: Array[String]) = {
    Skype.setDaemon(false) // to prevent exiting from this program

    val config = new Eval(None).apply[Config](new File(args(0)))

    Skype.addChatMessageListener(new ChatMessageAdapter() {
      // 何度もAPIを叩くことを回避するため、private val化している
      private[this] val lolChat =
        Skype.getAllChats.find(_.getId == config.skypeChatId).get
      private[this] val slackClient =
        BlockingSlackApiClient(config.slackApiToken)

      private[this] def reaction(chatMessage: ChatMessage) =
        if (chatMessage.getType == ChatMessage.Type.SAID && chatMessage.getChat == lolChat) {
          slackClient.postChatMessage(
            config.slackChannelName,
            chatMessage.getContent,
            chatMessage.getSenderDisplayName.some,
            false.some,
            iconUrl = config.slackPostIcon.some
          )
        }

      override def chatMessageReceived(received: ChatMessage) = reaction(received)
      override def chatMessageSent(sent: ChatMessage) = reaction(sent)
    })
  }
}
