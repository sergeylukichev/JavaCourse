package telran.weather;

public class SearchResult {
	String title;
	String woeid;

	public SearchResult(String title, String woeid) {
		super();
		this.title = title;
		this.woeid = woeid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWoeid() {
		return woeid;
	}

	public void setWoeid(String woeid) {
		this.woeid = woeid;
	}

	@Override
	public String toString() {
		return "SearchResult [title=" + title + ", woeid=" + woeid + "]";
	}

}
