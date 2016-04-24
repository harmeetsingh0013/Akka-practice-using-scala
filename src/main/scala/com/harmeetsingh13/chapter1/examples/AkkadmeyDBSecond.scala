package com.harmeetsingh13.chapter1.examples

import akka.actor.Actor
import akka.event.Logging
import com.harmeetsingh13.chapter1.messages.Message

import scala.collection.mutable.ListBuffer

/**
 * Created by james on 24/4/16.
 */
class AkkadmeyDBSecond extends Actor{

  val messages = new ListBuffer[String];
  val log = Logging(context.system, this)

  override def receive = {
    case Message(msg) => {
      log.info("received new Message - msg: {}", msg)
      messages.+=(msg.trim)
    }
    case o => log.info("unknown message: ", o)
  }
}
