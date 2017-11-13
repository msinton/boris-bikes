package javabikes.runner;

import javabikes.RouteAnalysis;
import javachess.GameData;
import javachess.MoveAnalysis;
import javachess.performance.Benchmark;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Encoder;
import org.apache.spark.sql.Encoders;
import org.apache.spark.sql.SparkSession;

import java.util.Arrays;

public class ExampleRunner {
    public static void main(String[] args) {

        SparkSession spark = SparkSession.builder()
            .master("local")
            .appName("Boris Bikes")
            .getOrCreate();

        Arrays.stream(RouteAnalysis.firstTenRows(spark)).forEach(System.out::println);

        spark.stop();
    }
}
