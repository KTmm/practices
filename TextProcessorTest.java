import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;


public class TextProcessorTest {

	@Test
	public void isCorrect_forTextParser() throws textNotParsedException {
		TextProcessor tp1 = new TextProcessor("Sentence 1. Sentence 2 ! Sentence 3 ? Sentence 4");
		tp1.parseTextIntoWords();
		assertEquals(4, tp1.getParsedText().size());
		assertEquals("Sentence", tp1.getParsedText().get(0)[0]);
		
	}
	@Test(expected = textNotParsedException.class)
	public void wordCountThrowsExceptionIfTextNotParsed() throws textNotParsedException{
		TextProcessor tp2 = new TextProcessor("Sentence 1. Sentence 2 ! Sentence 3 ? Sentence 4");
		tp2.countWordFrequencyAndPositions();
	}
	
	@Test
	public void isCorrect_forWordCounts() throws textNotParsedException, wordCountHasNotBeenConductedYetException, wordNotExistException{
		TextProcessor tp3 = new TextProcessor("Sentence 1. sentence 2 ! sentence 3 ? Sentence 4");
		tp3.parseTextIntoWords();
		tp3.countWordFrequencyAndPositions();
		assertEquals(2, tp3.getWordCount("Sentence"));
		assertEquals(1, tp3.getWordCount("1"));
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
		TextProcessor tp6 = new TextProcessor("Sentence 1. sentence 2 ! sentence 3 ? Sentence 4");
		tp6.parseTextIntoWords();
		tp6.countWordFrequencyAndPositions();
		String position = changePositionToString(tp6.getWordPositions("Sentence"));
		assertEquals("1, 4, ", position);
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
