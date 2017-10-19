package bikes

import org.apache.spark.sql.SparkSession

object RouteAnalysis {

  val file = "data/2012-journeys.csv"

  def firstTenRows(spark: SparkSession): Array[String] = ???

  /**
    * A route is described by the 'StartStation Name' to 'EndStation Name'.
    * Consider the reverse route as distinct.
    *
    * Result: The top 10 most popular routes, with the count:
    * StartStation Name,  EndStation Name,  count
    */
  def tenMostPopularRoutes(spark: SparkSession): Array[(String, String, Long)] = ???

  /**
    * @see tenMostPopularRoutes
    *
    * Result: As before, with the addition of the average journey time.
    * StartStation Name,  EndStation Name,  count,  Average Journey Time
    */
  def mostPopularRoutesWithAverageJourneyTime(spark: SparkSession): Array[(String, String, Long, Double)] = ???

}
