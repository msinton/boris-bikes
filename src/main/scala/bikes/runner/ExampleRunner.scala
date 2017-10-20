package bikes.runner

import bikes.RouteAnalysis
import org.apache.spark.sql.SparkSession

object ExampleRunner extends App {

  val spark: SparkSession = SparkSession.builder
    .master("local")
    .appName("Boris Bikes")
    .getOrCreate()

  RouteAnalysis.firstTenRows(spark)

  spark.stop()
}
