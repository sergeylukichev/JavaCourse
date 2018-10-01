
public class Main {

	public static void main (String [] args) {
		System.out.println(diff(55));
	}
	
	public static int diff(int n) {
		if(n>21) {
			return n-1; 
		} else {
			return 2*(n-21);
		}
	}
}
