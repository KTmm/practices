import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;


public class TextProcessorTest {

	@Test
	public void isCorrect_forTextParser() {
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
	
}
