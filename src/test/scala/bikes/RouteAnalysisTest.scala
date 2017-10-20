package bikes

import java.math.RoundingMode
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
        assert(result.map(_._3) sameElements expectedMostPopularRoutes.map(_._3))
      }
    }

    'mostPopularRoutesWithAverageJourneyTime {
      withSparkSession { spark =>
        val decimalFormat = new DecimalFormat("#.00")
        decimalFormat.setRoundingMode(RoundingMode.HALF_UP)

        val resultToTwoDecimalPlaces = mostPopularRoutesWithAverageJourneyTime(spark) map {
          case (start, end, count, average) => (start, end, count, decimalFormat.format(average))
        }

        assert(resultToTwoDecimalPlaces.length == expectedMostPopularWithAverageJourney.length)
        assert(resultToTwoDecimalPlaces.map(x => (x._3, x._4)) sameElements
          expectedMostPopularWithAverageJourney.map(x => (x._3, x._4)))
      }
    }
  }
}

