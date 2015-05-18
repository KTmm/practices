import static org.junit.Assert.*;

import org.junit.Test;


public class TextProcessorTest {

	@Test
	public void isCorrect_forSplittingSentences() {
		TextProcessor tp1 = new TextProcessor("Sentence 1. Sentence 2 ! Sentence 3 ? Sentence 4");
		assertEquals(4, tp1.parseText(tp1.getText()).length);
		assertEquals(" Sentence 4", tp1.parseText(tp1.getText())[3]);
	}
	
	@Test
	public void isCorrect_forWordCount(){
		TextProcessor tp1 = new TextProcessor("Sentence 1. Sentence 2 ! Sentence 3 ? Sentence 4");
		tp1.countWordsInText(tp1.getText());
		assertEquals(4,tp1.getWordCount("Sentence"));
	}

}
