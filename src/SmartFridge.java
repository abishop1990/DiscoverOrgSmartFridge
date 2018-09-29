/**
 * SmartFridge class
 * 
 * I could probably improve this with a database
 * Ultimately I'm keeping track of UUID and ItemType
 * Due to the interface requiring multiple lookups, I'm using two hashmaps.
 * 
 * Assumptions: 
 *  Items unique by ItemType
 *  Returning 0 for getFillFactor acceptable on empty/item not found
 *  Data attempted to insert will be sane
 *  Not intended to be thread-safe
 */

import java.util.*;

public class SmartFridge  implements SmartFridgeManager{
	// Data structures to hold by UUID and ItemType
	private HashMap<String, FridgeItem> itemsByUUID;
	private HashMap<Long, FridgeItem> itemsByItemType;
	
	/**
	 * Handle an item being removed from the fridge
	 */
	public void handleItemRemoved(String itemUUID) {
		FridgeItem fi = itemsByUUID.get(itemUUID);
		if(fi == null) return;
		itemsByUUID.remove(itemUUID);
		itemsByItemType.remove(fi.getItemType());
	}

	/**
	 * Handle item added to fridge
	 * TODO: We could overload this with a FridgeItem param object
	 */
	public void handleItemAdded(long itemType, String itemUUID, String name, Double fillFactor) {
		FridgeItem fi = new FridgeItem(itemType, itemUUID, name, fillFactor);
		itemsByUUID.put(itemUUID, fi);
		itemsByItemType.put(itemType, fi);
	}

	/**
	 * Gets an array of items with fillFactor less than or equal to provided param
	 * Perhaps a database implementation or having a kept-sorted DS would improve this
	 * But I didn't think it necessary
     * This will be an O(N) operation though
	 */
	public Object[] getItems(Double fillFactor) {
		ArrayList<Object> lowItems = new ArrayList<Object>();
		for(FridgeItem item: itemsByUUID.values()) {
			if(item.getFillFactor() <= fillFactor) {
				lowItems.add(item);
			}
		}
		return lowItems.toArray();
	}

	/**
	 * Returns the fill factor for an item
	 */
	public Double getFillFactor(long itemType) {
		FridgeItem fi= itemsByItemType.get(itemType);
		return fi.getFillFactor();
	}

	/**
	 * Forget an item in the fridge
	 */
	public void forgetItem(long itemType) {
		FridgeItem fi = itemsByItemType.get(itemType);
		itemsByUUID.remove(fi.getUUID());
		itemsByItemType.remove(itemType);
	}
	
	/**
	 * Simple check if fridge is empty
	 * @return Boolean if fridge is empty
	 */
	public boolean isEmpty() {
		return itemsByUUID.isEmpty();
	}

}
