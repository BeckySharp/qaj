package indexing

import scala.collection.mutable.ArrayBuffer

/**
  * Created by bsharp on 9/19/16.
  * Classes for dividing knowledge sources into passages for indexing
  */
trait PassageGenerator {
  var nPassagesSeen: Int = 0
  val passageTypePrefix:String
  def generatePassageId(): String = s"$passageTypePrefix$nPassagesSeen"
  def divideFileText (filename:String): Seq[Passage]
}

class SentenceGenerator() extends PassageGenerator {

  val passageTypePrefix = "Sent"

  def divideFileText (fn: String): Seq[Passage] = {
    val out = new ArrayBuffer[Passage]

    // Open the file
    val source = scala.io.Source.fromFile(fn)
    val lines = source.getLines().toArray

    // Process the text
    for (line <- lines) {
      // Process the line (this is really a placeholder for more complex processing...
      val sentence = line.trim()

      // Add the passage to the buffer
      out.append(new Passage(generatePassageId(), sentence))

      // Increment the nPassagesSeen to serve as a passageID for indexing
      nPassagesSeen += 1
    }

    // Housekeeping
    source.close()

    out.toSeq
  }
}
