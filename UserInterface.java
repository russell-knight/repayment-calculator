import javax.swing.*;

public class UserInterface extends JFrame {
	
	private JPanel panel;
	private JLabel itemLabel;
	private JTextField itemNameField;
	private JButton itemAdd;
	
	final int WINDOW_WIDTH = 640;
	final int WINDOW_HEIGHT = 480;
	
	public UserInterface() {
		
		setTitle("Repayment Calculator");
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		buildPanel();
		add(panel);
		
		setVisible(true);
		

	}
	
	private void buildPanel() {
		
		itemLabel = new JLabel("Item");
		
		itemNameField =  new JTextField("Item", 3);
		
		itemAdd = new JButton("Add");
		
		panel = new JPanel();
		
		panel.add(itemLabel);
		panel.add(itemNameField);
		panel.add(itemAdd);
	}
	
}
