package org.template.rntn

import io.prediction.controller.IEngineFactory
import io.prediction.controller.Engine

case class Query(content: String) extends Serializable

case class PredictedResult(sentiments: Int) extends Serializable

object Engine extends IEngineFactory {
  def apply() = {
    new Engine(
      classOf[DataSource],
      classOf[Preparator],
      Map("rntn" -> classOf[Algorithm]),
      classOf[Serving])
  }
}
