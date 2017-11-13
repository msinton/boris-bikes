package javachess;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Encoder;
import org.apache.spark.sql.Encoders;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.api.java.UDF1;
import org.apache.spark.sql.expressions.Window;
import org.apache.spark.sql.expressions.WindowSpec;
import org.apache.spark.sql.types.DataTypes;

import static org.apache.spark.sql.functions.*;

public class MoveAnalysis {

    static String evaluationValueToName(Integer value) {
        switch (value) {
            case 1:
                return "Blunder";
            case 2:
                return "Mistake";
            case 3:
                return "Dubious";
            case 4:
                return "Normal";
            default:
                return "unknown";
        }
    }

    static UDF1<Integer, String> evaluationValueToNameUDF = MoveAnalysis::evaluationValueToName;

    public static Dataset<GameData> getChessDS(SparkSession spark) {
        Encoder<GameData> gameDataEncoder = Encoders.bean(GameData.class);

        return spark
                .read()
                .schema(gameDataEncoder.schema())
                .parquet("data/chess")
                .as(gameDataEncoder);
    }

    public static void allMoveEvalPercents(SparkSession spark, Dataset<GameData> chessDS, int withinMoveNum) {

        spark.sqlContext().udf().register("evaluationValueToName", evaluationValueToNameUDF, DataTypes.StringType);

        WindowSpec windowByMove = Window.partitionBy("move")
                .rangeBetween(Window.unboundedPreceding(), Window.unboundedFollowing());

        chessDS.filter(col("n").lt(withinMoveNum))
                .groupBy("move", "evalSymbol")
                .count()
                .withColumn("evalSymbol", callUDF("evaluationValueToName", col("evalSymbol")))
                .withColumn("percent",
                        format_number(
                                col("count").divide(sum(col("count")).over(windowByMove)).multiply(100)
                                , 3)
                )
                .sort(col("percent").desc())
                .show();
    }
}
