package com.harmeetsingh13.chapter2

import akka.actor.{Props, ActorSystem}
import akka.testkit.TestActorRef
import akka.util.Timeout
import akka.pattern.ask
import scala.concurrent.Await
import scala.concurrent.duration._
import com.harmeetsingh13.chapter2.examples.ScalaPongActor
import org.scalatest.{BeforeAndAfterEach, Matchers, FunSpecLike}

/**
 * Created by Harmeet Singh(Taara) on 24/4/16.
 * @version 1.0
 */
class ScalaPongActorTest extends FunSpecLike with Matchers with BeforeAndAfterEach  {

  implicit val system = ActorSystem()
  implicit val timeout = Timeout(5 seconds)
  val pongActor = system.actorOf(Props(classOf[ScalaPongActor]))

  describe("akkadmey-second-chapter-test"){
    it("should respond with pong"){
      val future = pongActor ? "Ping"
      val results = Await.result(future.mapTo[String], 1 second)
      assert(results == "Pong")
    }
    it("should fail an unknown message"){
      val future = pongActor ? "unknown"
      intercept[Exception]{
        Await.result(future.mapTo[String], 1 second)
      }
    }
  }
}
