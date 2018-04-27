import java.io.*;
import javax.swing.JOptionPane;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

 /** This program compares the cost of a bicycle to how much money is saved by
  *  not spending money on Public Transport and tracks the progress of how long
  *  the bike will take to be repaid.
  *  */

public class RepaymentCalculator {
	
	final static double CONCESSION_FARE = 2.15;
	final static double FULL_FARE = 4.30;
	static DecimalFormat price = new DecimalFormat("#0.00");

	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		int menuNumber = -1;
		int tripsTaken = 0;
		ArrayList<Item> itemList = new ArrayList<Item>();
		
		while (menuNumber != 7) {
			
			StringBuffer sb = new StringBuffer();
			menuNumber = displayMenu();
			
			switch(menuNumber) {
			
			case 1:	// Add Item
				addItem(itemList);
				break;
					
			case 2: // Remove Item
				removeItem(itemList);
				break;
				
			case 3: // View Items
				viewItems(itemList);
				break;

			case 4:
          		try {
            		tripsTaken = Integer.parseInt(JOptionPane.showInputDialog("How many trips have you taken?"));
          		}
          		catch (Exception NumberFormatException) {
            		JOptionPane.showMessageDialog(null, "Trips must be entered as a positive whole integer.", "Error", JOptionPane.ERROR_MESSAGE);
          		}
				if (tripsTaken < 0) {
					JOptionPane.showMessageDialog(null, "You cannot enter a negative number.");
						tripsTaken = 0;
				}
				break;
				
			case 5:
				JOptionPane.showMessageDialog(null, "You have taken " + tripsTaken + " trips on the bike.");
				break;
				
			case 6:
				double totalCost = 0;
				for (int i = 0; i < itemList.size(); i++) {
					Item currentItem = new Item(itemList.get(i));
					totalCost += currentItem.getItemCost();
				}
				JOptionPane.showMessageDialog(null, "Your total savings for a concession fare are: $" + price.format(tripsTaken*CONCESSION_FARE) +
													"\nYour total savings for a full fare are: $" + price.format(tripsTaken*FULL_FARE) +
													"\nTotal cost of items: $" + price.format(totalCost) +
													"\nPrice remaining with concession fare: $" + price.format(totalCost-(tripsTaken*CONCESSION_FARE)) +
													"\nPrice remaining with full fare: $" + price.format(totalCost-(tripsTaken*FULL_FARE)));

				break;
				
			case 7:
				JOptionPane.showMessageDialog(null, "Thanks for using the program!");
				break;
			}	
		}
	}
	
	/**
	 * displayMenu displays a window of menu options
	 * 
	 * @return int - the menu number*/
	
	public static int displayMenu(){
		
		String input = "";
		int menuNumber = -1;
		
		input = JOptionPane.showInputDialog("Please select one of the following options:"
				+ "\n1) Add Item"
				+ "\n2) Remove Item"
				+ "\n3) View Items"
				+ "\n4) Enter Trips Taken"
				+ "\n5) View Trips Taken"
				+ "\n6) View Cost Remaining"
				+ "\n7) Exit");
		
		if (input == null) {
			return 7;
		}
		else {
			try {
				menuNumber = Integer.parseInt(input);
			}
		
			catch (NumberFormatException n) {
				JOptionPane.showMessageDialog(null, "Please select a number from 1 to 7", "Error", JOptionPane.ERROR_MESSAGE);
			
			}
		}
				return menuNumber;
	}
	
	/**
	* addItem allows adding of items that have contributed to the cost of riding
			e.g bike, service, mud-guards etc.
	**/
	
	public static void addItem(ArrayList<Item> itemList){
		
		String itemName;
		double cost = 0;
		
		itemName = JOptionPane.showInputDialog("What is the name of the item?");
				if (itemName.length() == 0) {
					JOptionPane.showMessageDialog(null, "Item name cannot be blank");
				}
				else {
					try {
						cost = Double.parseDouble(JOptionPane.showInputDialog("How much did " + itemName + " cost?"));
					}
					catch (Exception NumberFormatException) {
						JOptionPane.showMessageDialog(null, "The cost must be entered as a number without characters or symbols. " +
													  "e.g 340.70 (which would represent $340.70)", "Error", JOptionPane.ERROR_MESSAGE);
						return;
					}
					Item newItem =  new Item(itemName, cost);
					itemList.add(newItem);
				}
		}
	
	/**
	* removeItem allows items to be removed from the list.
	**/
	
	public static void removeItem(ArrayList<Item> itemList){
		
		int itemNumber = 0;
		StringBuffer sb = new StringBuffer();
		
		if(itemList.size() == 0) {
			JOptionPane.showMessageDialog(null, "There are no items to remove. To add an item select Option 1 from the menu.");
		}
		else {
			sb.append("Enter the Item Number of the item you wish to remove.\n\n");
			for (int i = 0; i < itemList.size(); i++){
				sb.append("Item Number: " + (i+1) + "\n"
						  + itemList.get(i).toString() + "\n\n");
			}
			try {
				itemNumber = (Integer.parseInt(JOptionPane.showInputDialog(null, sb)) -1);
			}
			catch (NumberFormatException e){
				JOptionPane.showMessageDialog(null, "You must enter a number between 1 & " + itemList.size(), "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			try {
				int reply = JOptionPane.showConfirmDialog(null, "Do you wish to remove the following item?\n\n", "Confirm" + itemList.get(itemNumber), JOptionPane.YES_NO_OPTION);
				
				if (reply == JOptionPane.YES_OPTION) {
					itemList.remove(itemNumber);
					JOptionPane.showMessageDialog(null, "Item removed." );
				}
				else if (reply == JOptionPane.NO_OPTION) {
					JOptionPane.showMessageDialog(null, "Item not removed." );
				}
			}
			catch (IndexOutOfBoundsException e) {
				JOptionPane.showMessageDialog(null, "The value you entered doesn't exist, please enter a item number listed.", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
		}		
	}
	
	/**
	*	viewItems displays a window of all the items listed.
	* */
	
	public static void viewItems(ArrayList<Item> itemList) {
		
		StringBuffer sb = new StringBuffer();
		
		if(itemList.size() == 0) {
			JOptionPane.showMessageDialog(null, "There are no items to display. To add an item select Option 1 from the menu.");
		}
		else {
			for (int i = 0; i < itemList.size(); i++){
				sb.append("Item Number: " + (i+1) + "\n"
						+ itemList.get(i).toString() + "\n\n");
			}
			JOptionPane.showMessageDialog(null, sb);
		}
	}
}
