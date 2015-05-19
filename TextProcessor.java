import java.util.ArrayList;
import java.util.TreeMap;


public class TextProcessor {
	private String textToBeProcessed;
	private TreeMap<String, Integer> wordCount;
	private TreeMap<String, ArrayList<Integer>> wordAppearInSentence;
	
	public TextProcessor(String input){
		textToBeProcessed = input;
	}
	
	/**Define: A sentence is separated by one of the following punctuation: ". ? ! "*/
	public ArrayList<String[]> parseText(String text){
		ArrayList<String[]> parsedWordsInText = new ArrayList<String[]>();
		String[] parsedSentences = text.split("[?.!]");
		for (String s : parsedSentences){
			s = s.replace(arg0, " ");
			String[] words = s.split("\\s+");
			parsedWordsInText.add(words);
		}
		return parsedWordsInText;
	}
			
	public String[] splictSentenceIntoWords(String sentence){
		String[] parsedWords = sentence.trim().split("\\s+");
		return parsedWords;
	}
	
	public void countWordFrequency(String text){
		wordCount = new TreeMap<String, Integer>(); 
		wordAppearInSentence = new TreeMap<String, ArrayList<Integer>>();
		ArrayList<String[]> wordsInTheText = parseText(text);
		for (int i = 0; i < wordsInTheText.size(); i++){
			String[] wordsInASentence = wordsInTheText.get(i);
			
			for (String word : wordsInASentence){
				ArrayList<Integer> wordInSentences = new ArrayList<Integer>();
				if (!(wordCount.containsKey(word))){
					wordCount.put(word, 0);
					wordAppearInSentence.put(word, wordInSentences);
				}
				int count = wordCount.get(word);
				wordCount.put(word, ++count);
				wordInSentences.add(i);
				wordAppearInSentence.put(word, wordInSentences);
				
			}
		}
	}
	
	public String getText(){
		return textToBeProcessed;
	}
	
	public int getWordCount(String word){
		return wordCount.get(word);
	}
}
