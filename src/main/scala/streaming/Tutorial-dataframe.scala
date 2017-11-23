package streaming

import org.apache.spark.sql.SparkSession

object Tutorial {

  def wordCount(spark: SparkSession) {

    // Change logging to reduce noise
    import org.apache.log4j.{Level, Logger}

    Logger.getLogger("org").setLevel(Level.WARN)
    Logger.getLogger("akka").setLevel(Level.WARN)
    // -----

    import spark.implicits._

    val lines = spark.readStream
      .textFile("data")

    // Split the lines into words
    val words = lines.as[String]
      .flatMap(_.split(" "))
      .map(_.replaceAll("""[.,]""", "")) // strip punctuation

    words.createOrReplaceTempView("words")
    val sql = "SELECT value, COUNT(*) as count FROM words GROUP BY value"

    val query = spark.sql(sql).writeStream
      .outputMode("complete")
      .format("console")
      .option("truncate", false)
      .option("numRows", 100)
      .start()

    query.awaitTermination()
  }

}
