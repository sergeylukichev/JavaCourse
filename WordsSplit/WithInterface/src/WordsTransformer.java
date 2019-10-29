
public class WordsTransformer {
	
	public String transform(String sentence, WordsChecker wc, WordsTransformerInterface wti) {
		String [] words = sentence.split(" ");
		
		for(int i=0;i<words.length;i++) {
			if(wc.checkWord(words[i])) {
				words[i] = wti.transformWord(words[i]);
			} 
		}
		
		return String.join(" ", words);
	}


}
