package com.harmeetsingh13.chapter1

import akka.actor.ActorSystem
import akka.testkit.TestActorRef
import com.harmeetsingh13.chapter1.examples.AkkadmeyDBFirst
import com.harmeetsingh13.chapter1.messages.SetRequest
import org.scalatest.{Matchers, FunSpecLike, BeforeAndAfterEach, FunSpec}
import org.scalatest.matchers.Matcher

/**
 * Created by james on 24/4/16.
 */
class AkkadmeyDBFirstTest extends FunSpecLike with Matchers with BeforeAndAfterEach{

  implicit val system = ActorSystem()
  describe("akkadmey-db-first-test"){
    describe("given SetRequest"){
      it("should place key/value into map"){
        val actorRef = TestActorRef(new AkkadmeyDBFirst)
        actorRef ! SetRequest("key", "value")
        val akkadmeyDb = actorRef.underlyingActor
        akkadmeyDb.map.get("key") should equal (Some("value"))
      }
    }
  }
}
