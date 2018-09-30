/**
 * TestSmartFridge.java
 * 
 * Test program for SmartFridge class
 */
public class TestSmartFridge {

	public static void main(String [] args) {
		SmartFridge fridge = new SmartFridge();

		// Try things on empty fridge
		assert(fridge.isEmpty());

		// Add items to fridge
		String item1UUID = "ID1";
		String item2UUID = "ID2";
		String item3UUID = "ID3";
		long item1Type = 1;
		long item2Type = 2;
		long item3Type = 3;
		String item1Name = "Test Item 1";
		String item2Name = "Test Item 2";
		String item3Name = "Test Item 3";
		double item1Fill = 1.0;
		double item2Fill = 0.3;
		double item3Fill = 0.5;
		
		fridge.handleItemAdded(item1Type, item1UUID, item1Name, item1Fill);
		fridge.handleItemAdded(item2Type, item2UUID, item2Name, item2Fill);
		fridge.handleItemAdded(item3Type, item3UUID, item3Name, item3Fill);
		assert(!fridge.isEmpty());
		
		// Verify getItems
		Object [] items = fridge.getItems(0.1);
		assert(items.length == 0);
		items = fridge.getItems(0.3);
		assert(items.length == 1);
		items = fridge.getItems(0.5);
		assert(items.length == 2);
		items = fridge.getItems(1.0);
		assert(items.length == 3);
		
		// Verify get fillFactor
		double fillFactor = fridge.getFillFactor(item1Type);
		assert(fillFactor == item1Fill);
		fillFactor = fridge.getFillFactor(item2Type);
		assert(fillFactor == item2Fill);
		fillFactor = fridge.getFillFactor(item3Type);
		assert(fillFactor == item3Fill);
		fillFactor = fridge.getFillFactor(0);
		assert(fillFactor == 0.0);
		
		// Test handleItemRemoved
		fridge.handleItemRemoved(item3UUID);
		items = fridge.getItems(1.0);
		assert(items.length == 2);
		fillFactor = fridge.getFillFactor(item3Type);
		assert(fillFactor == 0.0);
		
		// Test forgetItem
		fridge.forgetItem(item2Type);
		items = fridge.getItems(1.0);
		assert(items.length == 1);
		fillFactor = fridge.getFillFactor(item2Type);
		assert(fillFactor == 0.0);
		
		System.out.println("All tests passed\n");
		
	}
	
}
