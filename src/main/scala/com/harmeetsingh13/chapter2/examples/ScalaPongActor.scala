package com.harmeetsingh13.chapter2.examples

import akka.actor.{Props, Status, Actor}
import akka.event.Logging

/**
 * Created by Harmeet Singh(Taara) on 24/4/16.
 * @version 1.0
 */
class ScalaPongActor extends Actor{

  val log = Logging(context.system, this)

  override def receive = {
    case "Ping" => {
      log.info("New message recived")
      sender() ! "Pong"
    }
    case _ => sender() ! Status.Failure(new Exception("unknow message"))
  }
}

object ScalaPongActor{
  def props(response: String): Props = {
    Props(classOf[ScalaPongActor], response)
  }
}
