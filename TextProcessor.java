import java.util.ArrayList;
import java.util.TreeMap;


public class TextProcessor {
	private String textToBeProcessed;
	private TreeMap<String, Integer> wordCount;
	private TreeMap<String, ArrayList<Integer>> wordApperanceInSentence;
	
	public TextProcessor(String input){
		textToBeProcessed = input;
	}
	
	/**Define: A sentence is separated by one of the following punctuation: ". ? ! "*/
	public ArrayList<String[]> parseText(String text){
		ArrayList<String[]> parsedWordsInText = new ArrayList<String[]>();
		String[] parsedSentences = text.split("[?.!]");
		for (String s : parsedSentences){
			String[] words = s.split("\\s+");
			parsedWordsInText.add(words);
		}
		return parsedWordsInText;
	}
			
	public String[] splictSentenceIntoWords(String sentence){
		String[] parsedWords = sentence.trim().split("\\s+");
		return parsedWords;
	}
	
	public void countWordsInText(String text){
		wordCount = new TreeMap<String, Integer>(); 
		ArrayList<String[]> wordsInTheText = parseText(text);
		for (String[] sentence : wordsInTheText){
			for (String w : sentence){
				if (!(wordCount.containsKey(w))){
					wordCount.put(w, 0);
				}
				int count = wordCount.get(w);
				wordCount.put(w, ++count);
			}
		}
	}
	
	public void findWordInWhichSentence(String text){
		wordApperanceInSentence = new TreeMap<String, ArrayList<Integer>>();
		ArrayList<String[]> wordsInTheText = parseText(text);
		
		
	}
		
	public String getText(){
		return textToBeProcessed;
	}
	
	public int getWordCount(String word){
		return wordCount.get(word);
	}
}
