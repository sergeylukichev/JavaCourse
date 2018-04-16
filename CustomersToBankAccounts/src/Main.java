import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
	public static void main(String[] args) {
		//there is a list of bank accounts, which refer to customer. 
		//a customer has no reference to the bank account
		//we need a map, which maps customers by name to their bank accounts. 
		
		Customer c1 = new Customer("Piotr", "Ivanov");
		Customer c2 = new Customer("Ivan", "Petrov");
		
		BankAccount b1 = new BankAccount("DE123", "321", c1);
		BankAccount b2 = new BankAccount("ES456", "352", c1);
		BankAccount b3 = new BankAccount("PL254", "234", c2);
		BankAccount b4 = new BankAccount("FR856", "321", c2);
		BankAccount b5 = new BankAccount("NL999", "321", c2);
		BankAccount[] ba = {b1, b2, b3, b4, b5};
		
		List<BankAccount> bankAccounts = new ArrayList<>(Arrays.asList(ba));
		
		Map<String, List<BankAccount>> map = new HashMap<>();
		for(BankAccount account:bankAccounts) {
			String key = account.getCustomer().getFname()+" "+account.getCustomer().getLname();
			if(map.containsKey(key)) {
				List<BankAccount> baccounts = map.get(key);
				baccounts.add(account);
			} else {
				List<BankAccount> baccounts = new ArrayList<>();
				baccounts.add(account);
				map.put(key, baccounts);
			}
		}
		
		map.forEach((k, v) -> System.out.println(k+" "+v));
	}
}
