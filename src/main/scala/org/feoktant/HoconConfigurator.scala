package org.feoktant

import ch.qos.logback.classic.{LoggerContext, PatternLayout}
import ch.qos.logback.classic.layout.TTLLLayout
import ch.qos.logback.classic.spi.{Configurator, ILoggingEvent}
import ch.qos.logback.core.ConsoleAppender
import ch.qos.logback.core.encoder.LayoutWrappingEncoder
import ch.qos.logback.core.spi.ContextAwareBase
import com.typesafe.config.ConfigFactory
import org.slf4j.Logger

class HoconConfigurator extends ContextAwareBase with Configurator {

  def apply() = {}

  val config = ConfigFactory.load() getConfig("logging")

  def configure(lc: LoggerContext) = {
    addInfo("Setting up default configuration.")

    val ca = new ConsoleAppender[ILoggingEvent]
    ca.setContext(lc)
    ca.setName("console")
    val encoder = new LayoutWrappingEncoder[ILoggingEvent]
    encoder.setContext(lc)

    // same as
    // PatternLayout layout = new PatternLayout();
    // layout.setPattern("%d{HH:mm:ss.SSS} [%thread] %-5level %logger{36} - %msg%n");
    val layout = new PatternLayout

    layout.setPattern(config.getString("pattern.console"))
    layout.setContext(lc)
    layout.start()
    encoder.setLayout(layout)

    ca.setEncoder(encoder)
    ca.start()

    val rootLogger = lc.getLogger(Logger.ROOT_LOGGER_NAME)
    rootLogger.addAppender(ca)
  }
}
