/*
 * SmartFridge class
 * 
 * I could probably improve this with a database
 * Ultimately I'm keeping track of UUID and ItemType
 * Due to the interface, I'm using two hashmaps.
 * 
 * Assumptions: 
 *  Items unique by ItemType
 *  Returning 0 for getFillFactor acceptable on empty/item not found
 *  Data attempted to insert will be sane
 *  Not intended to be thread-safe
 */

import java.util.*;

public class SmartFridge  implements SmartFridgeManager{
	private HashMap<String, FridgeItem> itemsByUUID;
	private HashMap<Long, FridgeItem> itemsByItemType;
	
	public void handleItemRemoved(String itemUUID) {
		if(isEmpty()) return;
		FridgeItem fi = itemsByUUID.get(itemUUID);
		itemsByUUID.remove(itemUUID);
		itemsByItemType.remove(fi.getItemType());
	}

	public void handleItemAdded(long itemType, String itemUUID, String name, Double fillFactor) {
		FridgeItem fi = new FridgeItem(itemType, itemUUID, name, fillFactor);
		itemsByUUID.put(itemUUID, fi);
		itemsByItemType.put(itemType, fi);
		
	}

	public Object[] getItems(Double fillFactor) {
		ArrayList<Object> lowItems = new ArrayList<Object>();
		for(FridgeItem item: itemsByUUID.values()) {
			if(item.getFillFactor() <= fillFactor) {
				lowItems.add(item);
			}
		}
		return lowItems.toArray();
	}

	public Double getFillFactor(long itemType) {
		FridgeItem fi= itemsByItemType.get(itemType);
		return fi.getFillFactor();
	}

	public void forgetItem(long itemType) {
		FridgeItem fi = itemsByItemType.get(itemType);
		itemsByUUID.remove(fi.getUUID());
		itemsByItemType.remove(itemType);
	}
	
	public boolean isEmpty() {
		return itemsByUUID.isEmpty();
	}

}
