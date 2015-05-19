import java.util.ArrayList;
import java.util.TreeMap;


public class TextProcessor {
	private String rawText;
	private ArrayList<String[]> parsedWordsInText;
	private TreeMap<String, Integer> wordCount;
	private TreeMap<String, ArrayList<Integer>> wordApperanceInSentence;
	
	
	public TextProcessor(String input){
		rawText = input;
	}
	
	/***/
	public void parseTextIntoWords(){
		parsedWordsInText = new ArrayList<String[]>();
		String[] parsedSentences = rawText.split("[?.!]");
		for (String s : parsedSentences){
			String[] words = s.split("\\s+");
			for (String w : words){
			}
			parsedWordsInText.add(words);
		}
		
	}
			
	
	/**This method traverses the parsed text list and updates the word counts and word position
	 * @throws textNotParsedException */
	public void countWordFrequencyAndPositions() throws textNotParsedException{
		wordCount = new TreeMap<String, Integer>(); 
		wordApperanceInSentence = new TreeMap<String, ArrayList<Integer>>();
		validateTextIsParsed();
		for (int i = 0; i < parsedWordsInText.size(); i++){
			String[] wordsInASentence = parsedWordsInText.get(i);
			for (String word : wordsInASentence){
				ArrayList<Integer> wordPositions = new ArrayList<Integer>();
				if (!(wordCount.containsKey(word))){
					wordCount.put(word, 0);
					wordApperanceInSentence.put(word, wordPositions);
				}
				int count = wordCount.get(word);
				wordCount.put(word, ++count);
				wordPositions = wordApperanceInSentence.get(word);
				wordPositions.add(i);
				wordApperanceInSentence.put(word, wordPositions);
			}
		}
	}
	
	public void findWordInWhichSentence(String text){
		
		ArrayList<String[]> wordsInTheText = parseTextIntoWords(text);
		for (int i = 0; i < wordsInTheText.size(); i++){
			String[] wordsInASentence = wordsInTheText.get(i);
			for (String word : wordsInASentence){
				ArrayList<Integer> sentenceCount = new ArrayList<Integer>();
				if (!wordApperanceInSentence.containsKey(word)) {
					wordApperanceInSentence.put(word, sentenceCount);
				}
				sentenceCount.add(i);
				wordApperanceInSentence.put(word, sentenceCount);
			}
		}
		
	}
	public void validateTextIsParsed() throws textNotParsedException{
		if (parsedWordsInText == null){
			throw new textNotParsedException("Raw input has not been parsed into words yet!");
		}
	}
	
	public String getText(){
		return rawText;
	}
	
	public int getWordCount(String word){
		return wordCount.get(word);
	}
	
	public ArrayList<String[]> getParsedText(){
		return parsedWordsInText;
	}
}
