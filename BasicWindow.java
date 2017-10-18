import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class BasicWindow extends JFrame {
	
	private JPanel panel;
	private JButton addItem;
	private JButton removeItem;
	private JButton viewItems;
	private JLabel tripsTakenLabel;
	private JTextField tripsTakenEntry;
	private JButton calculate;
	
	private final int WINDOW_WIDTH = 640;
	private final int WINDOW_HEIGHT = 480;
	
	ArrayList<Item> itemList = new ArrayList<Item>();
	
	/**Constructor*/
	
	public BasicWindow() {
		setTitle("Basic Window");
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		buildPanel();
		add(panel);
		
		setVisible(true);
	}
	
	/**The buildPanel method adds the elements to the panel*/
	
	public void buildPanel() {
		
		addItem = new JButton("Add Item");
		addItem.addActionListener(new AddItemListener());
		removeItem = new JButton("Remove Item");
		removeItem.addActionListener(new RemoveItemListener());
		viewItems = new JButton("View Items");
		viewItems.addActionListener(new ViewItemListener());
		tripsTakenLabel = new JLabel("Trips Taken");
		tripsTakenEntry = new JTextField(3);
		calculate = new JButton("Calculate");
		
		panel = new JPanel();
		
		panel.add(addItem);
		panel.add(removeItem);
		panel.add(viewItems);
		panel.add(tripsTakenLabel);
		panel.add(tripsTakenEntry);
		panel.add(calculate);
	}
	
	/**
	 * AddItemListener is an action listener class for the AddItem Button
	 */
	private class AddItemListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			String item = JOptionPane.showInputDialog("What is the name of the item?");
			double cost = Double.parseDouble(JOptionPane.showInputDialog("How much did " + item + " cost?"));
			Item newItem =  new Item(item, cost);
			itemList.add(newItem);
		}
	}
	
	private class RemoveItemListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			
			if (itemList.size() == 0) {
				JOptionPane.showMessageDialog(null, "There are no items to remove.");
			}
			else {
				for(int i = 0; i < itemList.size(); i++) {
					int reply = JOptionPane.showConfirmDialog(null, "Remove " + itemList.get(i));
					if (reply == JOptionPane.YES_OPTION) {
						JOptionPane.showMessageDialog(null, "Item removed (not just yet)");
					}
					else {
						JOptionPane.showMessageDialog(null, "Item remains");
					}
				}
			}
		}
	}
	
	public class ViewItemListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			
			if (itemList.size() == 0) {
				JOptionPane.showMessageDialog(null, "There are no items to view.");
			}
			else {
				for(int i = 0; i < itemList.size(); i++) {
					JOptionPane.showMessageDialog(null, itemList.get(i).toString());
				}
			}
		}
	}

	public static void main(String[] args) {
		
		new BasicWindow();

	}

}
