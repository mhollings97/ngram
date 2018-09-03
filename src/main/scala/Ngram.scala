import scala.io.Source
import scala.collection.mutable.ListBuffer
object Ngram {

  def main(args:Array[String]): Unit = {
    
	var testFile:String = args(0)
	println("This is the name of the test file: " + testFile)


	//Turns input file into a 2D array of strings
	var lineCount = 0
	var curLine = ""	
	var len = 256
	//tokenMatrix - An Array of Strings Arrays
	var tokenMatrix = new Array[Array[String]](len)
	//curline - A String retrieved from the imported file
	for(curLine <- Source.fromFile(testFile).getLines){
	  //Tokenizing the lines and storing them as they are read in
	  tokenMatrix(lineCount) = curLine.split(" ")
	  lineCount = lineCount + 1
	}

	//Text File has been translated into a 2D array of Strings

	val tokenList = new ListBuffer[String]()

	val noNoChars = "?,.;-':()`"

	var i = 0
	var j = 0;
	for(i <- 0 to lineCount-1) {
		for(j <- 0 to tokenMatrix(i).size-1){
			//iterating over every single word in the matrix them doing final translation
			tokenList+=tokenMatrix(i)(j).filter(char => !(noNoChars.contains(char) || char == "\\" || char =="/"))
		}
	}
 
	tokenList.foreach(token => println(token))
 
 }
} 