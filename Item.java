import java.text.DecimalFormat;

public class Item {
	
	DecimalFormat df = new DecimalFormat("#0.00");
	
	private String itemName;
	private double itemCost;
	
	public Item(String name, double cost) {
		
		itemName = name;
		itemCost = cost;
		
	}
	
	public Item(Item copyItem) {
		itemName = copyItem.getItemName();
		itemCost = copyItem.getItemCost();
	}
	
	public String getItemName() {
		return itemName;
	}
	
	public double getItemCost() {
		return itemCost;
	}
	
	public void setItemName(String name) {
		itemName = name;
	}
	
	public void setItemCost(double cost) {
		itemCost = cost;
	}
	
	public String toString() {
		 String str = ("Name: " + itemName +
				 		"\nCost: " + df.format(itemCost));
		 return str;
	}

}
