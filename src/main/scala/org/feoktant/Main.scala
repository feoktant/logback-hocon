package org.feoktant

import com.typesafe.config.ConfigFactory
import org.slf4j.LoggerFactory

object Main extends App {

  private val logger = LoggerFactory.getLogger(Main.getClass)

  val config = ConfigFactory.load()

  logger.error(config.getConfig("test").toString)
  logger.info(config.getConfig("test").toString)
  logger.warn(config.getConfig("test").toString)
  logger.debug(config.getConfig("test").toString)
  logger.trace(config.getConfig("test").toString)
}
