public class Lane {
	
	private static Lane INSTANCE = new Lane();
	
	public static Lane getInstance() {
		return INSTANCE;
	}
	
	private Lane() {}
	
	public void use(String name) {
		System.out.println("The lane is used by "+name);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}		
	}

}
