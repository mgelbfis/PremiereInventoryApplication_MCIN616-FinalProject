package JavaPremiereDBSQLSecurityApp;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalTime;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CustomerEntry extends JFrame{

	 private final int WINDOW_WIDTH = 800;
	 private final int WINDOW_HEIGHT = 800;
     private JPanel custPanel;
     private JLabel custNumlbl;
 	 private JTextField custNum;
 	 private JLabel custNamelbl;
 	 private JTextField custName;
 	 private JLabel custStreetlbl;
 	 private JTextField custStreet;
 	 private JLabel custCitylbl;
 	 private JTextField custCity;
 	 private JLabel custStatelbl;
 	 private JComboBox custState;
 	 private JLabel custZiplbl;
 	 private JTextField custZip;
 	 private JLabel custBalancelbl;
 	 private JTextField custBalance;
 	 private JLabel custCreditLimitlbl;
 	 private JTextField custCreditLimit;
 	 private JLabel custRepNumlbl;
 	 private JComboBox custRepNum;
 	 private JLabel custPhonelbl;
 	 private JTextField custPhone;
 	 /*
 	 private JLabel custBeginDatelbl;
 	 private JTextField custBeginDate;
 	 */
 	 private JLabel custLoginlbl;
 	 private JTextField custLogin;
     private JPanel buttonPanel;
     private JButton insertButton;
     private JButton exitButton;
     private Connection dbConnection;
     
     private String[] states = {"AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE",
 			"FL", "GA", "HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME",
 			"MD", "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ", 
 			"NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA","RI", "SC", "SD", 
 			"TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY"};
     
	 public CustomerEntry(Connection dbConnection){
		   //store the reference to the database --- back end
		   this.dbConnection = dbConnection;
		   
		   //verify that a databse connection exists
		   if (this.dbConnection == null){
			   JOptionPane.showMessageDialog(null,"missing database connection --- contact IT");
			   
		   }
		   else{ //continue with this process
			   
			   
	 
			   	setTitle("Premiere New Customer Entry Form");
			   	//set window size
			   	setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

			   	// Specify an action for the close button.
			   	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			   	//set up layout of the window 
			   	setLayout(new BorderLayout());
			   	
			   	buildCustPanel();
			   	add(custPanel,BorderLayout.WEST);
			   	
			   	buildButtonPanel();
			   	add(buttonPanel,BorderLayout.SOUTH);
			   	
			   	pack();
			   	setVisible(true);
			   	System.out.println(this.getClass());
		   }
  	
	   }

	
	   private boolean buildCustPanel()
	   {
		   this.custPanel = new JPanel();
		   
		   custPanel.setLayout(new GridLayout(3,2));
		   
			//set up each text field and associated label
			custNumlbl = new JLabel("Customer ID: ");
			custNum = new JTextField(5);
			custNamelbl = new JLabel("Name: ");
			custName = new JTextField(10);
			custStreetlbl = new JLabel("Street Address:");
			custStreet = new JTextField(20);
			custCitylbl = new JLabel("City:");
			custCity = new JTextField(20);
			custStatelbl = new JLabel("State: ");
			custState = new JComboBox(this.states); 
			custZiplbl = new JLabel("Zip:");
			custZip = new JTextField(6);
			custBalancelbl = new JLabel("Customer Balance:");
			custBalance = new JTextField(10);
			custCreditLimitlbl = new JLabel("Credit Limit:");
			custCreditLimit = new JTextField(10);
			custRepNumlbl = new JLabel("Rep ID:");
			 
			custRepNum = new JComboBox();
			//fill the combo box by querying for rep nums -- querying from the view set up for the office role
			String repNumQuery = "select * from SalesRepNumbers";
			Statement sqlStatement = null;
			try{
			sqlStatement = dbConnection.createStatement();
			//execute the query
			ResultSet rs = sqlStatement.executeQuery(repNumQuery);
			
			//retrieve data from first column in the resultset
			//there should be only one column, a bunch of rows
			while(rs.next()){
				custRepNum.addItem(rs.getString(1));
			}
			}
			catch(SQLException e)
			{
				System.out.println("There was a problem getting the Sales Rep numbers from the database.");
				return false;
			}
			custPhonelbl = new JLabel("Phone Number:");
			custPhone = new JTextField(10);
			/*
			custBeginDatelbl = new JLabel("Begin Date:");
			custBeginDate = new JTextField(10);
			*/
			custLoginlbl =  new JLabel("Customer Login:");
			custLogin = new JTextField(20);
			
			//add the objects to the panel
			//the layout manager will arrange them in the panel
			custPanel.add(this.custNumlbl);
			custPanel.add(this.custNum);
			custPanel.add(this.custNamelbl);
			custPanel.add(this.custName);
			custPanel.add(this.custStreetlbl);
			custPanel.add(this.custStreet);
			custPanel.add(this.custCitylbl);
			custPanel.add(this.custCity);
			custPanel.add(this.custStatelbl);
			custPanel.add(this.custState);
			custPanel.add(this.custZiplbl);
			custPanel.add(this.custZip);
			custPanel.add(this.custBalancelbl);
			custPanel.add(this.custBalance);
			custPanel.add(this.custCreditLimitlbl);
			custPanel.add(this.custCreditLimit);
			custPanel.add(this.custRepNumlbl);
			custPanel.add(this.custRepNum);
			custPanel.add(this.custPhonelbl);
			custPanel.add(this.custPhone);
			/*
			custPanel.add(this.custBeginDatelbl);
			custPanel.add(this.custBeginDate);
			*/
			custPanel.add(this.custLoginlbl);
			custPanel.add(this.custLogin);
		   return true;
	   }
	
	   private boolean buildButtonPanel()
	   {
		   buttonPanel = new JPanel();
		   buttonPanel.setLayout(new FlowLayout());
		   
		   insertButton = new JButton("Insert Customer");
		   exitButton = new JButton("Exit");
		   
		   buttonPanel.add(insertButton);
		   buttonPanel.add(exitButton);
		   
		   //System.out.println(this.getClass());
		   
		   insertButton.addActionListener(new InsertButtonListener());
		   exitButton.addActionListener(new ExitListener());
		   
		   return true;
	   }
	   
	   private class ExitListener implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
	   }
	   
	   private class InsertButtonListener implements ActionListener{
		   
		   private PreparedStatement insertCustomer;
		   
		   public void actionPerformed(ActionEvent e)
		   {
			   System.out.println("Ready to process the Insert Customer Button");
			   
			   insertCustomer = null;
			   
			   ResultSet rs = null;
			   try{
				   
				   insertCustomer = dbConnection.prepareStatement("Insert into Customer "
				   		+ "(Cust_NUM, Cust_Name, Cust_Street, CUst_City, Cust_State, Cust_Zip,"
				   		+ "Cust_Balance, Credit_Limit, Rep_Num, Phone, Cust_Login) Values(?,?,?,?,?,?,?,?,?,?,?)");
			   }
			   catch(SQLException ex)
			   {
				   System.out.println("Could not prepare the statement to insert customer");
			   }
			   
			   try{
				   insertCustomer.setInt(1, Integer.parseInt(custNum.getText()));
				   insertCustomer.setString(2, custName.getText());
				   insertCustomer.setString(3, custStreet.getText());
				   insertCustomer.setString(4, custCity.getText());
				   insertCustomer.setString(5, custState.getSelectedItem().toString());
				   insertCustomer.setString(6, custZip.getText());
				   insertCustomer.setBigDecimal(7, new BigDecimal(Double.parseDouble(custBalance.getText())));
				   insertCustomer.setDouble(8, Double.parseDouble(custCreditLimit.getText()));
				   insertCustomer.setInt(9, Integer.parseInt(custRepNum.getSelectedItem().toString()));
				   insertCustomer.setString(10, custPhone.getText());
				   insertCustomer.setString(11, custLogin.getText());
				   
				   int result = insertCustomer.executeUpdate();
			   }
			   catch(SQLException ex){
		    		  ex.printStackTrace();
		    		  try{
		    		  dbConnection.rollback();}
		    		  catch(SQLException sqlE){
		    			  sqlE.printStackTrace();
		    			  
		    		  }
		    	  }
			   
			   
		    	  try{
		    	  dbConnection.commit();}
		    	  catch(SQLException except){
		    		  except.printStackTrace();
		    		  try{
		    			  dbConnection.rollback();
		    			  
		    		  }
		    		  catch(SQLException sqle){
		    			  sqle.printStackTrace();
		    			  
		    		  }
		    	  }
				   
				   dispose();
			   }
		   }
	   }
	   

