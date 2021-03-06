import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Test;


public class TextProcessorTest {
	
	@Test
	public void isCorrect_forTextParser() throws textNotParsedException {
		TextProcessor tp1 = new TextProcessor(" Mr. Ms. U.S.A. Ph.D. Given an arbitrary text document written in English, write a program that will"
				+ " generate a concordance, i.e. an alphabetical list of all word occurrences! "
				+ "labeled with word frequencies. Bonus: label 88.56 word with the sentence numbers in which each occurrence appeared.");
		tp1.parseTextIntoWords();
		assertEquals(3, tp1.getParsedText().size());
		assertEquals("mr.", tp1.getParsedText().get(0)[0]);
		assertEquals("ms.", tp1.getParsedText().get(0)[1]);
		assertEquals("i.e.", tp1.getParsedText().get(0)[20]);
		assertEquals("88.56", tp1.getParsedText().get(2)[2]);
		assertEquals("u.s.a.", tp1.getParsedText().get(0)[2]);
	}

	@Test(expected = textNotParsedException.class)
	public void wordCountThrowsExceptionIfTextNotParsed() throws textNotParsedException{
		TextProcessor tp2 = new TextProcessor("U.S. i.e. 44.5 is a country, this is sentence 1. Sentence 2 ! Sentence 3 ? Sentence 4");
		tp2.countWordFrequencyAndPositions();
	}
	
	@Test
	public void isCorrect_forWordCounts() throws textNotParsedException, wordCountHasNotBeenConductedYetException, wordNotExistException{
		TextProcessor tp3 = new TextProcessor(" Given an arbitrary text document written in English, write a program that will"
				+ " generate a concordance, i.e. an alphabetical list of all word occurrences, "
				+ "labeled with word frequencies. Bonus: label each word with the sentence numbers in which each occurrence appeared. That"
				+ "elephant is 1000.455 kilograms");
		tp3.parseTextIntoWords();
		tp3.countWordFrequencyAndPositions();
		assertEquals(1, tp3.getWordCount("occurrences"));
		assertEquals(3, tp3.getWordCount("word"));
		assertEquals(2, tp3.getWordCount("a"));
		assertEquals(1, tp3.getWordCount("1000.455"));
	}
	
	@Test(expected = wordCountHasNotBeenConductedYetException.class)
	public void wordCountThrowsWordCountHasNotBeenConductedException() throws wordCountHasNotBeenConductedYetException, wordNotExistException{
		TextProcessor tp4 = new TextProcessor("Sentence 1. sentence 2 ! sentence 3 ? Sentence 4");
		tp4.parseTextIntoWords();
		tp4.getWordCount("sentence");
	}
	
	@Test(expected = wordNotExistException.class)
	public void wrodCountThrowsWordNotExistException() throws textNotParsedException, wordCountHasNotBeenConductedYetException, wordNotExistException{
		TextProcessor tp5 = new TextProcessor("Sentence 1. sentence 2 ! sentence 3 ? Sentence 4");
		tp5.parseTextIntoWords();
		tp5.countWordFrequencyAndPositions();
		assertEquals(2, tp5.getWordCount("Sentence"));
	}
	
	@Test
	public void isCorrect_forWordPositions() throws textNotParsedException, wordCountHasNotBeenConductedYetException, wordNotExistException{
		TextProcessor tp6 = new TextProcessor("Given an arbitrary text document written in English, write a program that will"
				+ " generate a concordance, i.e. an alphabetical list of all word occurrences, "
				+ "labeled with word frequencies. Bonus: label each word with the sentence numbers in which each occurrence appeared.");
		tp6.parseTextIntoWords();
		tp6.countWordFrequencyAndPositions();
		assertEquals("1, 1, ", changePositionToString(tp6.getWordPositions("a")));
		assertEquals("1, 2, ", changePositionToString(tp6.getWordPositions("in")));
		assertEquals("1, ", changePositionToString(tp6.getWordPositions("i.e.")));
		assertEquals("1, 1, 2, ", changePositionToString(tp6.getWordPositions("word")));
		assertEquals("2, 2, ", changePositionToString(tp6.getWordPositions("each")));
	}
	
	private static String changePositionToString(ArrayList<Integer> postion ){
		String s = "";
		for (Integer i :postion){
			s += String.valueOf(i);
			s += ", ";
		}
		return s;
	}
	
	@Test
	public void isCorrect_forGenerateConcordance() throws textNotParsedException, IOException{
		TextProcessor tp7 = new TextProcessor("Given an arbitrary text document written in English, write a program that will"
				+ " generate a concordance, i.e. an alphabetical list of all word occurrences, "
				+ "labeled with word frequencies. Bonus: label each word with the sentence numbers in which each occurrence appeared.");
		String producedConcordance = tp7.generateConcordanceString();
		String expectedConcordance = "a              {2:1,1}\n"
				+ "all            {1:1}\n"
				+ "alphabetical   {1:1}\n"
				+ "an             {2:1,1}\n"
				+ "appeared       {1:2}\n"
				+ "arbitrary      {1:1}\n"
				+ "bonus          {1:2}\n"
				+ "concordance    {1:1}\n"
				+ "document       {1:1}\n"
				+ "each           {2:2,2}\n"
				+ "english        {1:1}\n"
				+ "frequencies    {1:1}\n"
				+ "generate       {1:1}\n"
				+ "given          {1:1}\n"
				+ "i.e.           {1:1}\n"
				+ "in             {2:1,2}\n"
				+ "label          {1:2}\n"
				+ "labeled        {1:1}\n"
				+ "list           {1:1}\n"
				+ "numbers        {1:2}\n"
				+ "occurrence     {1:2}\n"
				+ "occurrences    {1:1}\n"
				+ "of             {1:1}\n"
				+ "program        {1:1}\n"
				+ "sentence       {1:2}\n"
				+ "text           {1:1}\n"
				+ "that           {1:1}\n"
				+ "the            {1:2}\n"
				+ "which          {1:2}\n"
				+ "will           {1:1}\n"
				+ "with           {2:1,2}\n"
				+ "word           {3:1,1,2}\n"
				+ "write          {1:1}\n"
				+ "written        {1:1}\n";
		assertEquals(expectedConcordance, producedConcordance);
	}
}
