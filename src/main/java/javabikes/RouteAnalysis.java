package javabikes;

import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

public class RouteAnalysis {

    private static String file = "data/2012-journeys.csv";

    public static String[] firstTenRows(SparkSession spark) {
        return null;
    }


    /**
     * A route is described by: starting station to end station.
     * Consider the reverse route as distinct.
     * <p>
     * Result: The top 10 most popular routes together with the count of that route:
     * StartStation Name,  EndStation Name,  count
     */
    public static Row[] tenMostPopularRoutes(SparkSession spark) {
        return null;
    }


    /**
     * @see this.tenMostPopularRoutes
     * <p>
     * Result: As before, with the addition of the average journey time.
     * StartStation Name,  EndStation Name,  count,  Average Journey Time
     */
    public static Row[] mostPopularRoutesWithAverageJourneyTime(SparkSession spark) {
        return null;
    }

}
