import scala.io.Source
object Ngram {

  def main(args:Array[String]): Unit = {
    
	var testFile:String = args(0)
	println("This is the name of the test file: " + testFile)


	//Turns input file into a 2D array of strings
	var lineCount = 0
	var curLine = ""	
	var len = 256
	//An array of sentences (Aka an Array of Strings)
	var tokenStrings = new Array[Array[String]](len)
	//
	for(curLine <- Source.fromFile(testFile).getLines){
	  tokenStrings(lineCount) = curLine.split(" ")
	  lineCount = lineCount + 1
	}

	val noNoChars = "?,.;-':()`"

	var i = 0
	var j = 0;
	for(i <- 0 to lineCount-1) {
		for(j <- 0 to tokenStrings(i).size-1){
			tokenStrings(i)(j)=tokenStrings(i)(j).filter(char => !(noNoChars.contains(char) || char == '\\' || char =='/))
			print(tokenStrings(i)(j))
			print(" ")
		}
		println("")
	}
 }
} 