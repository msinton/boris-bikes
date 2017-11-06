package performance

import org.apache.spark.sql.SparkSession

object Benchmark {

  def run(f: => Unit): Unit = {
    val startTime = System.nanoTime
    f
    val endTime = System.nanoTime
    println(s"Time taken ${(endTime - startTime).toDouble / 1000000000} seconds")
  }

  def withWarmUp(spark: SparkSession)(f: => Unit): Unit = {
    spark.range(1000L * 1000 * 1000).selectExpr("sum(id)").collect()
    run(f)
  }
}
