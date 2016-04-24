package com.harmeetsingh13.chapter1.examples

import akka.actor.Actor
import akka.event.Logging
import com.harmeetsingh13.chapter1.messages.SetRequest

import scala.collection.mutable.HashMap

/**
 * Created by james on 24/4/16.
 */
class AkkadmeyDBFirst extends Actor{

  val map = new HashMap[String, Object]
  val log = Logging(context.system, this)

  override def receive = {
    case SetRequest(key, value) => {
      log.info("received SetRequest - key: {} value: {}", key, value)
      map.put(key, value)
    }
    case o => log.info("received unknown message: {}", o)
  }
}
