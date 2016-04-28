package com.harmeetsingh13.chapter2.examples

import java.io.File

import akka.actor.{Props, ActorSystem}
import com.typesafe.config.ConfigFactory

/**
 * Created by Harmeet Singh(Taara) on 26/4/16.
 * @version 1.0
 */
object Main extends App{


  private val configFile = getClass.getClassLoader.getResource("application.conf").getFile;
  private val config = ConfigFactory.parseFile(new File(configFile ))

  val system = ActorSystem("SimpleClientServer", config)
  system.actorOf(Props[AkkadmeyDB], name = "akkademy-db")
}
