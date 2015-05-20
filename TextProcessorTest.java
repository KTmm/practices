import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;


public class TextProcessorTest {
	
	@Test
	public void isCorrect_forTextParser() throws textNotParsedException {
		TextProcessor tp1 = new TextProcessor(" N.B.  i.e. 44.5 is a country, this is sentence 1. Sentence 2 ! Sentence 3 ? Sentence 4");
		tp1.parseTextIntoWords();
		assertEquals(4, tp1.getParsedText().size());
		assertEquals("N.B.", tp1.getParsedText().get(0)[0]);
	}
	
	@Test(expected = textNotParsedException.class)
	public void wordCountThrowsExceptionIfTextNotParsed() throws textNotParsedException{
		TextProcessor tp2 = new TextProcessor("U.S. i.e. 44.5 is a country, this is sentence 1. Sentence 2 ! Sentence 3 ? Sentence 4");
		tp2.countWordFrequencyAndPositions();
	}
	
	@Test
	public void isCorrect_forWordCounts() throws textNotParsedException, wordCountHasNotBeenConductedYetException, wordNotExistException{
		TextProcessor tp3 = new TextProcessor("U.S. i.e. 44.5 is a country, this is sentence 1. Sentence 2 ! Sentence 3 ? Sentence 4");
		tp3.parseTextIntoWords();
		tp3.countWordFrequencyAndPositions();
		assertEquals(3, tp3.getWordCount("Sentence"));
		assertEquals(1, tp3.getWordCount("U.S."));
		assertEquals(1, tp3.getWordCount("44.5"));
	}
	
	@Test(expected = wordCountHasNotBeenConductedYetException.class)
	public void wordCountThrowsWordCountHasNotBeenConductedException() throws wordCountHasNotBeenConductedYetException, wordNotExistException{
		TextProcessor tp4 = new TextProcessor("Sentence 1. sentence 2 ! sentence 3 ? Sentence 4");
		tp4.parseTextIntoWords();
		tp4.getWordCount("Sentence");
	}
	
	@Test(expected = wordNotExistException.class)
	public void wrodCountThrowsWordNotExistException() throws textNotParsedException, wordCountHasNotBeenConductedYetException, wordNotExistException{
		TextProcessor tp5 = new TextProcessor("Sentence 1. sentence 2 ! sentence 3 ? Sentence 4");
		tp5.parseTextIntoWords();
		tp5.countWordFrequencyAndPositions();
		assertEquals(2, tp5.getWordCount("word"));
	}
	
	@Test
	public void isCorrect_forWordPositions() throws textNotParsedException, wordCountHasNotBeenConductedYetException, wordNotExistException{
		TextProcessor tp6 = new TextProcessor("U.S. i.e. 44.5 is a country, this is sentence 1. Sentence 2, U.S. is ! Sentence 3 ? Sentence 4");
		tp6.parseTextIntoWords();
		tp6.countWordFrequencyAndPositions();
		String positionOfSentence = changePositionToString(tp6.getWordPositions("Sentence"));
		assertEquals("2, 3, 4, ", positionOfSentence);
		String positionOfUS = changePositionToString(tp6.getWordPositions("U.S."));
		assertEquals("1, 2, ", positionOfUS);
		String positionOfIs = changePositionToString(tp6.getWordPositions("is"));
		assertEquals("1, 1, 2, ", positionOfIs);
	}
	
	public static String changePositionToString(ArrayList<Integer> postion ){
		String s = "";
		for (Integer i :postion){
			s += String.valueOf(i);
			s += ", ";
		}
		return s;
	}
	
}
