package object chess {

  object Evaluations {
    sealed abstract class Evaluation(val representation: String, val value: Int)
    case object Blunder extends Evaluation("??", 1)
    case object Mistake extends Evaluation("?", 2)
    case object Dubious extends Evaluation("?!", 3)
    case object Normal extends Evaluation("", 4)

    val set = Set(Blunder, Mistake, Dubious, Normal)
    val reprToVal: Map[String, Int] = (set map (e => (e.representation, e.value))).toMap
    val valToName: Map[Int, String] = (set map (e => (e.value, e.toString))).toMap
  }

  case class FlatGameData(url: String, move: String, eval: String, evalSymbol: Int, n: Int)

}
