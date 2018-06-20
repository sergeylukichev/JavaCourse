package de.telran.prodline;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import de.telran.model.parts.Car;
import de.telran.model.parts.Component;

public class AssemblyLine implements Runnable {
	
	private static int MAX_CAPACITY = 3;
	
	private boolean isRunning = false;
	
	LinkedList<Component> queue = new LinkedList<>();
	List<Component> currentLane = new ArrayList<>();
	List<Car> carsBuilt = new LinkedList<>();
	
	private static AssemblyLine INSTANCE = new AssemblyLine();
	
	private AssemblyLine() {}
	
	public static AssemblyLine getInstance() {
		return INSTANCE;
	}
	
	@Override
	public void run() {
		isRunning = true;
		Car car = new Car();
		car.build();
		while(!car.isBuilt()) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}			
		}
		isRunning = false;
	}

	public boolean isRunning() {
		return isRunning;
	}
	
	public void addToProduction(Component component) {
		
	}
	
	public void notifyComponentIsBuilt(Component component) {
		
	}
	
	public void buildCar() {
		new Thread(this).start();
	}
}
