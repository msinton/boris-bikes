package bikes

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object RouteAnalysis {

  val file = "data/2012-journeys.csv"

  def firstTenRows(spark: SparkSession): Array[String] = {
    spark.read.textFile(file).take(10)
  }

  /**
    * Consider the reverse of a route as distinct.
    *
    * Result: The top 10 most popular routes, with the count:
    * StartStation Name,  EndStation Name,  count
    */
  def tenMostPopularRoutes(spark: SparkSession): Array[(String, String, Long)] = {
    import spark.implicits._

    spark.read.option("header", value = true).csv(file)
      .groupBy("StartStation Id", "EndStation Id")
      .agg(
        first("StartStation Name").as("StartStation Name"),
        first("EndStation Name").as("EndStation Name"),
        count("*").as("count")
      ).select("StartStation Name", "EndStation Name", "count")
      .sort($"count".desc)
      .as[(String, String, Long)]
      .take(10)
  }

  /**
    * @see tenMostPopularRoutes
    *
    * Result: As before, with the addition of the average journey time.
    * StartStation Name,  EndStation Name,  count,  Average Journey Time
    */
  def mostPopularRoutesWithAverageJourneyTime(spark: SparkSession): Array[(String, String, Long, Double)] = {
    import spark.implicits._

    val result = spark.read.option("header", value = true).csv(file)
      .groupBy("StartStation Id", "EndStation Id")
      .agg(
        first("StartStation Name").as("StartStation Name"),
        first("EndStation Name").as("EndStation Name"),
        count("*").as("count"),
        avg("Duration").as("Average Duration")
      ).select("StartStation Name", "EndStation Name", "count", "Average Duration")
      .sort($"count".desc)
      .as[(String, String, Long, Double)]

    result.show(false)
    result.take(10)
  }
}
