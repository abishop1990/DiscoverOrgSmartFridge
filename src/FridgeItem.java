/**
 * FridgeItem.java
 * 
 * Bare bones class to represent items in a smart fridge
 */

public class FridgeItem {
	// Data members
	private double fillFactor;
	private long itemType;
	private String name;
	private String UUID;
	
	/**
	 * FridgeItem constructor
	 * @param itemType
	 * @param itemUUID
	 * @param name
	 * @param fillFactor
	 */
	public FridgeItem(long itemType, String itemUUID, String name, Double fillFactor) {
		this.setFillFactor(fillFactor);
		this.itemType = itemType;
		this.setName(name);
		this.UUID = itemUUID;
	}

	/**
	 * Fill factor accessory
	 * @return The fill factor
	 */
	public double getFillFactor() {
		return fillFactor;
	}

	/**
	 * Fill factor mutator
	 * @param fillFactor
	 */
	public void setFillFactor(double fillFactor) {
		this.fillFactor = fillFactor;
	}

	/**
	 * Item type accessory
	 * @return Item Type numeric value
	 */
	public long getItemType() {
		return itemType;
	}

	/**
	 * Name accessory
	 * @return Name of the item in the fridge
	 */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Unique ID accessory
	 * @return The UUID
	 */
	public String getUUID() {
		return UUID;
	}

	/**
	 * toString method primarily for debugging/logging
	 * @return String representation of a FridgeItem
	 */
	public String toString() {
		return "Name: " + getName() + "\n" +
			   "Item Type: " + getItemType() + "\n" +
			   "Fill Factor: " + getFillFactor() + "\n" +
			   "UUID: " + getUUID() + "\n";
	}
}
