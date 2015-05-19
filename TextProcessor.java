import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;


public class TextProcessor {
	private String rawText;
	private ArrayList<String[]> parsedWordsInText;
	private TreeMap<String, Integer> wordCount;
	private TreeMap<String, ArrayList<Integer>> wordApperanceInSentence;
	private HashMap<String, String> replacementMap;
	
	
	public TextProcessor(String input){
		rawText = input;
	}
	
	/***/
	public void parseTextIntoWords(){
		String preProcessedText = preProcessSepcialCases(rawText);
		
		String[] parsedSentences = splitIntoSentences(preProcessedText);
		for (String s : parsedSentences){
			System.out.println(s);
		}
		splitSentenceIntoWords(parsedSentences);
	}
	
	private String[] splitIntoSentences(String text) {
		String sentenceEnder = "[!?.]";
		String[] parsedSentences = text.split(sentenceEnder);
		for (int i = 0; i< parsedSentences.length; i++){
			parsedSentences[i] = parsedSentences[i].replaceAll("@#@#", ".");
			System.out.println("not working");
		}
		return parsedSentences;
	}
	
	private void splitSentenceIntoWords(String[] sentences) {
		parsedWordsInText = new ArrayList<String[]>();
		String midSentencePuctuation = "[:;()\\[\\]\"/,]";
		for (String s : sentences){
			s.replaceAll(midSentencePuctuation, " ");
			String[] words = s.trim().split("\\s+");
			parsedWordsInText.add(words);
		}// TODO Auto-generated method stub
		
	}
	
	public String preProcessSepcialCases(String text) {
		//System.out.println("text");
		collectSpecialCases();
		for(String s : replacementMap.keySet()){
			text = text.replaceAll(s, replacementMap.get(s));
		}
		String processedText = text;
		
		return processedText;
	}
	
	public void collectSpecialCases(){
		replacementMap = new HashMap<String, String>();
		String number = "(\\d+)(\\.)(\\d+)"; // for numbers like 44.56
		String abbreviationWithTwoDots = "(\\s?[a-zA-Z]{1,2})(\\.)([a-zA-Z])(\\.)";
		replacementMap.put(number, "$1@#@#$3");
		replacementMap.put(abbreviationWithTwoDots, "$1@#@#$3@#@#");
				
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
