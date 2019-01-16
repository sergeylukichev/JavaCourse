
public class Main {
	
	public static void main(String[] args) {
		String input = "abbbcc";
		
		System.out.println(getLongestSubstringLength(input));
	}
	public static int getLongestSubstringLength(String input) {
		int count = 1;
		int max = 1;
		for (int i=0;i<input.length()-1;i++) {
			if(input.substring(i, i+1).equals(input.substring(i+1, i+2))) {
				count ++ ;
			} else {
				count = 1;
			}
			if(count > max) {
				max = count;
			}	
		}
		return max;
	}

}
