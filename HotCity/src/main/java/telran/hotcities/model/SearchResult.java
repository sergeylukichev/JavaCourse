package telran.hotcities.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class SearchResult {
	private String title;
	private String woeid;
	
	public SearchResult() {}
	
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
