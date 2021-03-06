import jgo.tools.compiler._
import parser.BlockLang
import parser.combinatorExten._
import lexer.Scanner

import interm.codeseq._

class ParserTests(val tests: String*) extends ParserTestSuite

trait ParserTestSuite extends App {
  
  testAll()
  
  val tests: Seq[String]
  
  def testAll() {
    tests foreach test
  }
  
  def test(in: String) {
    try {
      println("testing: " + in)
      val bl = new BlockLang(Scanner(in)) with ExceptionTracing //with TracePrintingParsers
      bl.result match {
        case ns: bl.NoSuccess =>
          println("\nsyntax error:\n" + ns)
        
        case bl.Success(outM, _) =>
          if (outM.isDefined)
            println("\n" + outM.get.listing)
          else {
            println("\ncompilation errors:")
            outM.errors foreach { err => println(err.longString) }
          }
      }
    }
    catch {
      case e =>
        println("!!!!!\t!!!!!\t!!!!!")
        println("EXCEPTION: " + e)
        e.printStackTrace()
        println("!!!!!\t!!!!!\t!!!!!")
    }
    println()
  }
}
