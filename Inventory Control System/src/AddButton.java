import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Dimension;
import java.awt.Component;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;



public class AddButton extends JFrame {

	private JPanel contentPane;
	private JTextField textDisc;
	private JTextField textMrp;
	private JTextField textProName;
	private JTextField textQuan;
	private JButton btnAddBack;
	private JButton btnAddSave;

	/**
	 * Launch the application.
	 */
	private Statement myStmt;
	private Connection myCon;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddButton frame = new AddButton();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public AddButton() throws SQLException {
		setIconImage(Toolkit.getDefaultToolkit().getImage(AddButton.class.getResource("/box-icon.png")));
		setTitle("yourInventory  [Add Products]");
		myCon = DriverManager.getConnection("jdbc:mysql://123.0.0.1:3306/inventory","root","pass");
		myStmt = myCon.createStatement();
		addButtonInit();
		addButtonCreateEvents();
		
	}
	
	private void addButtonInit() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(370, 150, 605, 402);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Add New Products to Stock", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(50, 205, 50)));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 559, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 338, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		JLabel lblProductName = new JLabel("Product Name : ");
		lblProductName.setAlignmentX(Component.RIGHT_ALIGNMENT);
		
		JLabel lblQuantity = new JLabel("Quantity : ");
		
		JLabel lblNewLabel = new JLabel("Price (MRP.)");
		
		JLabel lblDiscountifApplicable = new JLabel("Discount (if applicable) : ");
		
		textProName = new JTextField();
		textProName.setColumns(10);
		
		textQuan = new JTextField();
		textQuan.setColumns(10);
		
		textMrp = new JTextField();
		textMrp.setColumns(10);
		
		textDisc = new JTextField();
		textDisc.setColumns(10);
		
		btnAddSave = new JButton("Save");
		
		btnAddBack = new JButton("<~~ Back");
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap(36, Short.MAX_VALUE)
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
									.addComponent(lblProductName, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblQuantity)
									.addComponent(lblNewLabel))
								.addComponent(lblDiscountifApplicable))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(textDisc)
								.addComponent(textProName, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)
								.addComponent(textQuan, Alignment.TRAILING)
								.addComponent(textMrp, Alignment.TRAILING)))
						.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
							.addGap(47)
							.addComponent(btnAddBack, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 240, Short.MAX_VALUE)
							.addComponent(btnAddSave, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)))
					.addGap(56))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(39)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblProductName, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
						.addComponent(textProName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblQuantity)
						.addComponent(textQuan, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(textMrp, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDiscountifApplicable)
						.addComponent(textDisc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(49)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAddSave)
						.addComponent(btnAddBack))
					.addContainerGap(55, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}
	
	

	private void addButtonCreateEvents() {
		btnAddBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Home.main(null);
				dispose();
			}
		});
		
		btnAddSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					String pro = textProName.getText();
					int disc = Integer.valueOf(textDisc.getText());
					Float mrp = Float.valueOf(textMrp.getText());
					int quan = Integer.valueOf(textQuan.getText());
					String check = "Select * from stock where Product_Name='"+pro+"'";
					ResultSet myRs = myStmt.executeQuery(check);
					
					while(myRs.next())
						quan+=myRs.getInt("Quantity");
					
					myStmt.executeUpdate("delete from stock where Product_Name='"+pro+"'");
					String last = "insert into stock (Product_Name, Discount, MRP, Quantity) values ('"+pro+"', '"+disc+"', '"+mrp+"', '"+quan+"')";
					myStmt.executeUpdate(last);
					dispose();				
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
				JOptionPane.showMessageDialog(null,"Product Added");
				Home.main(null);
				
				
		 	}
		});
	}
}