# skypeslackrelay

Skype -> Slack relay java apllication.
This is one directional, there is no relay from Slack to Skype.

## requirements

* Java
* sbt(for compile)

## Installation

1. clone this repository
2. sbt assembly
3. create config file like this

  ```scala
  import com.github.bigwheel.skypeslackrelay.Config

  new Config {
    val skypeChatId: String = "#bigwheel/$den8;50ea9fe468132296"
    val slackApiToken: String = "generate_here_https://api.slack.com/web"
    val slackChannelName: String = "#channel_name_with_#"
    val slackPostIcon: String =
      "https://icon_for_slack_post.jpeg"
  }
  ```
4. java -jar target/scala-2.11/skypeslackrelay-assembly-{{version}}.jar config.scala
