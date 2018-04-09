public class WordsTransformer {
	
	public String transform(final String sentence) {
		final String[] words = sentence.split(" ");

        for (int i = 0; i < words.length; i++) {
	        if(words[i].length() == 2) {
	        	words[i] = words[i].toUpperCase();
	        } 
	    }
	    return String.join(" ", words);	    
	 }
	 
    public static void main (String[] args) {
    	String words = "aa bbb cc aaEE bbb";
    	System.out.println("Input " + words);
    	WordsTransformer transformer = new WordsTransformer();
    	System.out.println("Upper case " + transformer.transform(words));
    }
}
