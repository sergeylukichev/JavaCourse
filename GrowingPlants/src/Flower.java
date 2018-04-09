public class Flower extends Plant {

	public Flower(String displayName, int height, int age) {
		super(displayName, height, age);
	}

	private static int FLOWER_GROW_PER_SEASON=2;
		
	@Override
	public void doSummer() {
		System.out.printf("%s is not growin in Summer, but flourishing %d\n", getDisplayName(), getHeight());
	}

	@Override
	public void doAutumn() {
		setHeight(0);
		System.out.printf("%s is cut to zero in Autumn %d\n", getDisplayName(), getHeight());
	}

	@Override
	public int getGrowPerSeason() {
		return FLOWER_GROW_PER_SEASON;
	}
}
