package chess

import org.apache.spark.sql.{Encoders, SparkSession}
import org.apache.spark.sql.functions._

object Sequences {

  case class Sequence(url: String, moves: Seq[String], evalSymbol: Int)

  def percentThatEndInMistake(spark: SparkSession)(sequenceLength: Int): Unit = {

    import spark.implicits._

    val chessDS = spark.read.schema(Encoders.product[FlatGameData].schema).parquet("data/chess").as[FlatGameData]

    val sequences = chessDS
      .filter(x => x.n <= sequenceLength)
      .sort("url", "n")
      .groupBy("url")
      .agg(
        collect_list("move") as "moves",
        last("evalSymbol") as "evalSymbol"
      )
      .as[Sequence]

    val normalVal = Evaluations.Normal.value

    // UDF: user defined function
    // to discard the last move - to leave us with the sequence that may or may not have ended in a mistake
    val removeLastMoveUDF = udf((m: Seq[String]) => m.init)

    val endInMistakes = sequences
      .filter(_.evalSymbol < normalVal)
      .withColumn("moves", removeLastMoveUDF.apply($"moves"))
      .groupBy("moves")
      .agg(
        first("url"),
        count("*") as "mistakes"
      )

    val sequenceCounts = sequences
      .withColumn("moves", removeLastMoveUDF.apply($"moves"))
      .groupBy("moves")
      .count

    // join sequence mistakes and counts to calculate percentage that are mistakes
    // sort and filter to present most significant results
    endInMistakes.join(sequenceCounts, "moves")
      .withColumn("percent mistakes", $"mistakes" / $"count" * 100).drop("mistakes")
      .sort($"percent mistakes".desc)
      .filter($"count" > 10)
      .show(400, truncate = false)
  }


  def runMany(spark: SparkSession)(f: (SparkSession) => (Int) => Unit): Unit = (5 to 10) foreach f(spark)

}
