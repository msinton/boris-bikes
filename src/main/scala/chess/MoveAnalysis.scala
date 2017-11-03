package chess

import org.apache.spark.sql.{Dataset, SparkSession}
import org.apache.spark.sql.expressions.Window
import org.apache.spark.sql.functions._


object MoveAnalysis {

  def allMoveEvalPercents(spark: SparkSession)(chessDS: Dataset[FlatGameData], withinMoveNum: Int) = {

    import spark.implicits._

    val w = Window.partitionBy("move").rangeBetween(Window.unboundedPreceding, Window.unboundedFollowing)

    chessDS.filter(_.n < withinMoveNum)
      .groupBy("move", "evalSymbol")
      .count
      .withColumn("evalSymbol", udf(Evaluations.valToName).apply($"evalSymbol"))
      .withColumn("percent", format_number($"count" / sum($"count").over(w) * 100, 3))
      .sort($"percent".desc)
      .show
  }
}
