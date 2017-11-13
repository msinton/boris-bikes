package bikes.runner

import bikes.RouteAnalysis
import org.apache.spark.sql.SparkSession

object ExampleRunner {

  def main(args: Array[String]): Unit = {

    val spark: SparkSession = SparkSession.builder
      .master("local")
      .appName("Boris Bikes")
      .getOrCreate()

    RouteAnalysis.firstTenRows(spark).foreach(println)

    spark.stop()
  }

}
