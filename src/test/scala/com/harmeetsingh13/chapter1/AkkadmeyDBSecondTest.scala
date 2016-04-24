package com.harmeetsingh13.chapter1

import akka.actor.ActorSystem
import akka.testkit.TestActorRef
import com.harmeetsingh13.chapter1.examples.AkkadmeyDBSecond
import com.harmeetsingh13.chapter1.messages.Message
import org.scalatest.{BeforeAndAfterEach, Matchers, FunSpecLike}

/**
 * Created by james on 24/4/16.
 */
class AkkadmeyDBSecondTest extends FunSpecLike with Matchers with BeforeAndAfterEach {

  implicit val system = ActorSystem();

  describe("akkadmey-db-homework-first-test"){
    describe("receive-msg-correctly"){
      it("should receive message correctly"){
        val actorRef = TestActorRef(new AkkadmeyDBSecond)
        actorRef ! Message("First Message .... ")
        actorRef ! Message("Second Message .... ")
        val akkadmeyDb = actorRef.underlyingActor;
        akkadmeyDb.messages.apply(0) should equal("First Message ....")
        akkadmeyDb.messages.apply(1) should equal("Second Message ....")
      }
    }
  }
}
