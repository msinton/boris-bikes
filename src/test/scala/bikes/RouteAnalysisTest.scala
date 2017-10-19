package bikes

import java.text.DecimalFormat

import utest._

object RouteAnalysisTest extends TestSuite with SparkSessionSetup {

  import ExpectedRouteAnalysisResults._
  import RouteAnalysis._

  def tests = Tests {

    'firstTenRows {
      withSparkSession { spark =>
        val result = firstTenRows(spark)

        assert(result.length == expectedFirstTenRows.length)
        assert(result sameElements expectedFirstTenRows)
      }
    }

    'tenMostPopularRoutes {
      withSparkSession { spark =>
        val result = tenMostPopularRoutes(spark)

        assert(result.length == expectedMostPopularRoutes.length)
        assert(result sameElements expectedMostPopularRoutes)
      }
    }

    'mostPopularRoutesWithAverageJourneyTime {
      withSparkSession { spark =>
        val decimalFormat = new DecimalFormat("#.00")

        val resultToTwoDecimalPlaces = mostPopularRoutesWithAverageJourneyTime(spark) map {
          case (start, end, count, average) => (start, end, count, decimalFormat.format(average).toDouble)
        }

        assert(resultToTwoDecimalPlaces.length == expectedMostPopularWithAverageJourney.length)
        assert(resultToTwoDecimalPlaces sameElements expectedMostPopularWithAverageJourney)
      }
    }
  }
}

