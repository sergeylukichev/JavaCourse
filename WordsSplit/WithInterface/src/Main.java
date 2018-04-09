
public class Main {
	public static void main (String[] args) {
		String input = "aaa BC de FGH bce EF";
		
		WordsTransformer wt = new WordsTransformer();
		
		WordsChecker wc1 = new ToUpperCaseChecker();
		System.out.println(wt.transform(input, wc1));
		
		WordsChecker wc2 = new ToLowerCaseChecker();
		System.out.println(wt.transform(input, wc2));		
	}
}
