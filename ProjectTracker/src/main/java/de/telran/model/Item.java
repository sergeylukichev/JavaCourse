package de.telran.model;

public class Item {
	
	String itemName;
	String itemType;
	
	public Item() {}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	@Override
	public String toString() {
		return "Item [itemName=" + itemName + ", itemType=" + itemType + "]";
	}
}
