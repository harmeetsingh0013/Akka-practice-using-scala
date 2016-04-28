package com.harmeetsingh13.chapter2.messages

/**
 * Created by Harmeet Singh(Taara) on 24/4/16.
 * @version 1.0
 */
case class SetRequest (key: String, value: Object)

case class GetRequest(key: String)

case class KeyNotFoundException(key: String) extends Exception
