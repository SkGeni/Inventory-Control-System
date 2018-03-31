import java.awt.BorderLayout;
import java.awt.EventQueue;

import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSplitPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.Font;
import java.util.Date;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLayeredPane;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import java.awt.Component;

import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.JInternalFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import javax.swing.DefaultListModel;

import java.awt.event.ActionListener;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import javax.swing.AbstractListModel;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;

public class Home extends AddButton {
	
	private JPanel contentPane;
	private JButton btnMainBack;
	private JButton btnMainExit;
	private JButton btnMainDone;
	private JList listMain;
	private JButton btnStockInfo;
	private JButton btnBlinkOut;
	private JButton btnBlinkVlnr;
	private JButton btnRemove;
	private JButton btnUpdate;
	private JButton btnAdd;
	private JButton btnSell;
	
	DefaultListModel productModel = new DefaultListModel();
	private ResultSet myRs;
	private Statement myStmt;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 *  
	 */
	public Home() throws SQLException {
			Connection myCon = DriverManager.getConnection("jdbc:mysql://123.0.0.1:3306/inventory","root","pass");
			myStmt = myCon.createStatement();		
			
		setTitle("yourInventory - Door to Stock .....     [HOME]");
		homeInitComp();
		homeCreateEvents();
	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//Initials.....
	/////////////////////////////////////////////////////////////////////////////////////////
	
	
	private void homeInitComp() {
		// TODO Auto-generated method stub
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(350, 120, 683, 469);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		
		JLabel lblNewJgoodiesTitle = DefaultComponentFactory.getInstance().createTitle("Welcome !");
		lblNewJgoodiesTitle.setFont(new Font("Wide Latin", Font.ITALIC, 14));
		
		JLabel lblMrShubham = new JLabel("Mr. Shubham");
		lblMrShubham.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 11));
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Main Menu", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		Date date = new Date();
	
		JLabel lblNewLabel = new JLabel(date.getDate()+"/" +date.getMonth()+"/" +date.getYear()+"  " +date.getHours()+":" +date.getMinutes());
		
		btnMainExit = new JButton("Exit");
		
		btnMainDone = new JButton("Done");
		
		btnMainBack = new JButton("<~~  Back");
		
		btnSell = new JButton("Sell");
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(46)
							.addComponent(lblNewJgoodiesTitle, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblMrShubham)
							.addPreferredGap(ComponentPlacement.RELATED, 273, Short.MAX_VALUE)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(52)
							.addComponent(btnMainBack)
							.addPreferredGap(ComponentPlacement.RELATED, 141, Short.MAX_VALUE)
							.addComponent(btnSell)
							.addGap(116)
							.addComponent(btnMainExit)
							.addGap(44)
							.addComponent(btnMainDone)
							.addGap(33)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(6)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewJgoodiesTitle, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblMrShubham)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnMainDone)
						.addComponent(btnMainExit)
						.addComponent(btnMainBack)
						.addComponent(btnSell))
					.addContainerGap())
		);
		
		JInternalFrame mainButtons = new JInternalFrame("Your Stock Handler");
		mainButtons.getContentPane().setBackground(new Color(255, 240, 245));
		
		btnAdd = new JButton("Add New Product");		
		btnRemove = new JButton("Remove Product from Stock");
		btnUpdate = new JButton("Upadte Stock");
		btnStockInfo = new JButton("Stock Info");
				
		btnBlinkOut = new JButton("Out of Stock");		
		btnBlinkVlnr = new JButton("On Eve of Extintion");
		
		GroupLayout groupLayout = new GroupLayout(mainButtons.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(21)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnBlinkVlnr, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnBlinkOut, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnRemove, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnUpdate, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnAdd, GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
						.addComponent(btnStockInfo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(24))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(24)
					.addComponent(btnAdd)
					.addGap(18)
					.addComponent(btnUpdate)
					.addGap(18)
					.addComponent(btnRemove)
					.addGap(18)
					.addComponent(btnStockInfo)
					.addPreferredGap(ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
					.addComponent(btnBlinkOut)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnBlinkVlnr)
					.addGap(20))
		);
		mainButtons.getContentPane().setLayout(groupLayout);
		mainButtons.setBorder(new CompoundBorder());
		mainButtons.setVisible(true);
		
		JScrollPane spMainList = new JScrollPane();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(6)
					.addComponent(mainButtons, GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(spMainList, GroupLayout.PREFERRED_SIZE, 259, GroupLayout.PREFERRED_SIZE)
					.addGap(6))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(mainButtons, GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(spMainList, GroupLayout.PREFERRED_SIZE, 291, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		
		
		//////////////////////////////////////////list/////////...creation..............................................................
		
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		listMain = new JList(productModel);
	
		listMain.setFont(new Font("Comic Sans MS", Font.ITALIC, 13));
		spMainList.setViewportView(listMain);
		listMain.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listMain.setBorder(new TitledBorder(null, "Product List", TitledBorder.LEADING, TitledBorder.TOP, null, null));
	
		//	productModel.addElement("Nothing to Display");
	
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);	
		
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//Creating  Events ....................
	//////////////////////////////////////////////////////////////////////////////////////////////////////
	private void homeCreateEvents() {
		
		btnMainBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SP_Inventory_Control.main(null);;
				dispose();
			}
		});
		
		btnMainExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		
		btnMainDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				JOptionPane.showMessageDialog(null, "Good Day !!");
			}
		});
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		//Stock List
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		try {
			productModel.clear();
			myRs = myStmt.executeQuery("Select * from stock");	
			while(myRs.next()){
				productModel.addElement(myRs.getString("Product_Name"));
				}
		} catch (SQLException e) {
				e.printStackTrace();
		}

			listMain.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent arg0) {
		btnStockInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String remS = (String) listMain.getSelectedValue();
				try {
					myRs=myStmt.executeQuery("Select * from stock where Product_Name = '"+remS+"'");
					while(myRs.next()){
						JOptionPane.showMessageDialog(null, "\nProduct                : "+
								myRs.getString("Product_Name")+"\nMRP                      : "+myRs.getString("MRP")+"\nQuantity               : "+
								myRs.getString("Quantity")+"\nDiscount(if any)  : "+myRs.getString("Discount"));
						Home.main(null);
						dispose();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}
});
		
		
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			AddButton.main(null);
			dispose();
			}
		});
		
			listMain.addMouseListener(new MouseAdapter() {
			    public void mouseClicked(MouseEvent arg0) {
		btnRemove.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {

						String remS = (String) listMain.getSelectedValue();
						try {
							myStmt.executeUpdate("delete from stock where Product_Name = '"+remS+"'");
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						JOptionPane.showMessageDialog(null, "Deteted Product "+remS+" from stock.");
						Home.main(null);
						dispose();
					}
				});
			}
		});

			listMain.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent arg0) {
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {				
						AddButton.main(null);
						dispose();
					}
				});
			}
		});
			
			listMain.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent arg0) {
		btnBlinkOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					myRs = myStmt.executeQuery("select Product_Name from stock where Quantity = 0");
					while(myRs.next()){
						JOptionPane.showMessageDialog(null,"\n"+myRs.getString("Product_Name"));
					}
					main(null);
					dispose();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}
});

			listMain.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent arg0) {
		btnBlinkVlnr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					myRs = myStmt.executeQuery("select Product_Name from stock where Quantity < 10");
					while(myRs.next()){
						JOptionPane.showMessageDialog(null,"\n"+myRs.getString("Product_Name"));
					}
					main(null);
					dispose();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}
});			
		
			listMain.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent arg0) {
		btnSell.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String remS = (String) listMain.getSelectedValue();
				try {
					int val=0;
					myRs=myStmt.executeQuery("Select Quantity from stock where Product_Name = '"+remS+"'");
					while(myRs.next()){
						val= myRs.getInt("Quantity");
					}
					int sold = Integer.parseInt(JOptionPane.showInputDialog("Number of "+remS+" Sold."));
					val-=sold;
					myStmt.executeUpdate("update stock set Quantity ='"+val+"' where Product_Name = '"+remS+"'");
					JOptionPane.showMessageDialog(null, "Sold Out!!\n"+val+" "+remS+" left in stock.");
					main(null);
					dispose();
					
				}catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
	}
});	
	
	
	}
}