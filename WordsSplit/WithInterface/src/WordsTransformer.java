
public class WordsTransformer {
	
	public String transform(String sentence, WordsChecker wc) {
		String [] words = sentence.split(" ");
		
		for(int i=0;i<words.length;i++) {
			if(wc.checkWord(words[i])) {
				words[i] = wc.transformWord(words[i]);
			} 
		}
		
		return String.join(" ", words);
	}
}
