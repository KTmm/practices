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
			s.replaceAll("[:;()[]\"/,\\]", " ");
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
				System.out.println(word + " count = "+ count);
				wordPositions = wordApperanceInSentence.get(word);
				wordPositions.add(i + 1);
				wordApperanceInSentence.put(word, wordPositions);
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
	
	public ArrayList<String[]> getParsedText() throws textNotParsedException{
		validateTextIsParsed();
		return parsedWordsInText;
	}
	
	public int getWordCount(String word) throws wordCountHasNotBeenConductedYetException, wordNotExistException{
		if (wordCount == null){
			throw new wordCountHasNotBeenConductedYetException("word count has not been conducted!");
		}
		if (!wordCount.containsKey(word)){
			throw new wordNotExistException("This word does not exist in the text!");
		}
		return wordCount.get(word);
	}
	
	public ArrayList<Integer> getWordPositions(String word) throws wordCountHasNotBeenConductedYetException, wordNotExistException{
		if (wordApperanceInSentence == null){
			throw new wordCountHasNotBeenConductedYetException("word count has not been conducted!");
		}
		if (!wordApperanceInSentence.containsKey(word)){
			throw new wordNotExistException("This word does not exist in the text!");
		}
		return wordApperanceInSentence.get(word);
	}
	
}
