/* 
 * FridgeItem.java
 * 
 * Bare bones class to represent items in a smart fridge
 */

public class FridgeItem {
	private double fillFactor;
	private long itemType;
	private String name;
	private String UUID;
	
	public FridgeItem(long itemType, String itemUUID, String name, Double fillFactor) {
		this.setFillFactor(fillFactor);
		this.itemType = itemType;
		this.setName(name);
		this.UUID = itemUUID;
	}

	public double getFillFactor() {
		return fillFactor;
	}

	public void setFillFactor(double fillFactor) {
		this.fillFactor = fillFactor;
	}

	public long getItemType() {
		return itemType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUUID() {
		return UUID;
	}

	public String toString() {
		return "Name: " + getName() + "\n" +
			   "Item Type: " + getItemType() + "\n" +
			   "Fill Factor: " + getFillFactor() + "\n" +
			   "UUID: " + getUUID() + "\n";
	}
}
