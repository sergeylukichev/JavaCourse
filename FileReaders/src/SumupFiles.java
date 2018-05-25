import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SumupFiles {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("numbers.txt"));
		
		//reading and summing integers from file, ignoring non-integers
		String st;
		int a = 0;
		while((st = br.readLine()) != null) {
			try {
				a += Integer.parseInt(st);
			} catch (Exception ex) {
				
			}		
		}
		
		System.out.println("sum " + a);
	
		//reading file using try with resources and stream API
		try(BufferedReader br1 = new BufferedReader(new FileReader("numbers"))) {
			System.out.println("Sum "+sumUp(br1));
		} catch (Exception ex) {
			
		}
	
	}
	
	public static int sumUp(BufferedReader br) {
		return br.lines().filter(s -> isDigit(s)).mapToInt(Integer::parseInt).sum();
	}
	
	public static boolean isDigit(String s) {
		try {
			Integer.parseInt(s);		
		} catch (Exception ex) {
			return false;
		}
		return true;
	}
}
