package de.telran.model.parts;

import de.telran.prodline.AssemblyLine;

public class Engine implements Component, Runnable {

	private long timeToBuild = 7000;
	private boolean isBuilt = false;
	
	public Engine() {
		AssemblyLine.getInstance().addToProduction(this);
	}

	@Override
	public void run() {
		try {
			Thread.sleep(timeToBuild);
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
		isBuilt = true;		
		AssemblyLine.getInstance().notifyComponentIsBuilt(this);
	}

	@Override
	public void build() {
		new Thread(this).start();
	}

	@Override
	public boolean isBuilt() {
		return isBuilt;
	}

}
