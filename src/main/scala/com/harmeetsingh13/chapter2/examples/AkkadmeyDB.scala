package com.harmeetsingh13.chapter2.examples

import akka.actor.{Status, Actor}
import akka.actor.Actor.Receive
import akka.event.Logging
import com.harmeetsingh13.chapter2.messages.{KeyNotFoundException, GetRequest, SetRequest}

import scala.collection.mutable.HashMap

/**
 * Created by Harmeet Singh(Taara) on 26/4/16.
 * @version 1.0
 */
class AkkadmeyDB extends Actor{

  val map = new HashMap[String, Object]
  val log = Logging(context.system, this)

  override def receive: Receive = {
    case SetRequest(key, value) =>
      log.info("received SetRequest - key: {} value: {}", key, value)
      map.put(key, value)
      sender() ! Status.Success
    case GetRequest(key) =>
      log.info("received GetRequest - key: {}", key)
      val response = map.get(key)
      response match{
        case Some(x) => sender() ! x
        case None => Status.Failure(new KeyNotFoundException(key))
      }
    case o => Status.Failure(new ClassNotFoundException())
  }
}
