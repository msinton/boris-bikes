package javachess.performance;

import org.apache.spark.sql.SparkSession;

public class Benchmark {

    public static void run(Runnable f) {
        long startTime = System.nanoTime();
        f.run();
        long endTime = System.nanoTime();
        System.out.println("Time taken " + (endTime - startTime) / 1000_000_000.0 + " seconds");
    }

    public static void withWarmUp(SparkSession spark, Runnable f) {
        spark.range(1000L * 1000 * 1000).selectExpr("sum(id)").collect();
        run(f);
    }
}
