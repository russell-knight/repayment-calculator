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
	
	final static double CONCESSION_FARE = 2.05;
	final static double FULL_FARE = 4.10;
	static DecimalFormat price = new DecimalFormat("#0.00");

	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		String item;
		double cost;
		int menuNumber = -1;
		int tripsTaken = 0;
		ArrayList<Item> itemList = new ArrayList<Item>();
		
		
		//UserInterface ui = new UserInterface();
		
		
		
		while (menuNumber != 7) {
			
			menuNumber = displayMenu();
			
			switch(menuNumber) {
			
			case 1:
				item = JOptionPane.showInputDialog("What is the name of the item?");
				cost = Double.parseDouble(JOptionPane.showInputDialog("How much did " + item + " cost?"));
				
				Item newItem =  new Item(item, cost);
				itemList.add(newItem);
				
				break;
				
			case 2:
				JOptionPane.showMessageDialog(null, "To be added");
				break;
				
			case 3:
				for(int i = 0; i < itemList.size(); i++) {
					JOptionPane.showMessageDialog(null, itemList.get(i).toString());
				}
				break;
				
			case 4:
				tripsTaken = Integer.parseInt(JOptionPane.showInputDialog("How many trips have you taken?"));
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
		
		int menuNumber = -1;
		
		menuNumber = Integer.parseInt(JOptionPane.showInputDialog("Please select one of the following options:"
				+ "\n1) Add Item"
				+ "\n2) Remove Item"
				+ "\n3) View Items"
				+ "\n4) Enter Trips Taken"
				+ "\n5) View Trips Taken"
				+ "\n6) View Cost Remaining"
				+ "\n7) Exit"));
		
		return menuNumber;
	}

}
