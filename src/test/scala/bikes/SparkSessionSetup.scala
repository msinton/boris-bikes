package bikes

import org.apache.spark.sql.SparkSession

trait SparkSessionSetup {
  def withSparkSession(testMethod: (SparkSession) => Any) {
    val spark = SparkSession.builder
      .master("local")
      .appName("Spark test")
      .getOrCreate()

    try {
      testMethod(spark)
    }
    finally spark.stop()
  }
}
