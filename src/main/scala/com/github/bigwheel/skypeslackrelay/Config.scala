package com.github.bigwheel.skypeslackrelay

trait Config {
  val skypeChatId: String
  val slackApiToken: String
  val slackChannelName: String
  val slackPostIcon: String
}
