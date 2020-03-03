
public class Person {
	
	String name;
	
	public Person (String name) {
		this.name = name;
	}
		
	public synchronized void  howAreYouDoing(Person person) throws InterruptedException {
		System.out.println("How are you doing, "+person.name + "?");
			
		Thread.sleep(1000);
		
		person.iAmFineThanksAndYou(this);
	}
	
	public synchronized void iAmFineThanksAndYou(Person person) {
		System.out.println("I am fine, "+ person.name + ", thanks, and you?");
	}
	
	
	//We have 2 persons who greet each other and respond to greeting at the same time.
	//We have a deadlock in most of the runs. 
	//The reason is that we lock (obtain monitors) of 2 objects at the same time
	//and both locked objects are waiting for each other locks to be release, which never happens
	
	public static void main(String[] args) throws InterruptedException {
		Person ivan = new Person("Ivan");
		Person piotr = new Person("Piotr");
		
		Thread thread = new Thread(new Runnable() {
			public void run() {
				try {
					ivan.howAreYouDoing(piotr);
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
				
			}
		});
		thread.start();
		
		//as a possible solution to avoid deadlock is to uncomment next line
		//thread.join();
		
		new Thread(new Runnable() {
			public void run() {
				try {
					piotr.howAreYouDoing(ivan);
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
				
			}
		}).start();
	}
}
