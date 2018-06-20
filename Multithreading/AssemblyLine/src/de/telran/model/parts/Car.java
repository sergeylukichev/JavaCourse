package de.telran.model.parts;

public class Car {
	
	private Frame frame;
	private Engine engine;
	//Tires
	//Seats
	
	public void build() {
		frame = new Frame();
		engine = new Engine();
	}
	
	public boolean isBuilt() {
		boolean isBuild = frame.isBuilt();
		isBuild &= engine.isBuilt();
	
		return isBuild;
	}

}
