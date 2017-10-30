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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SalesRepEntry extends JFrame {

	 private final int WINDOW_WIDTH = 800;
	 private final int WINDOW_HEIGHT = 800;
	 
     private JPanel repPanel;
     
     private JLabel repNumlbl;
     private JComboBox repNum;
     private JLabel repCommissionlbl;
     private JTextField repCommission;
 	 private JLabel repRatelbl;
 	 private JTextField repRate;
	
    private JPanel buttonPanel;
    private JButton insertButton;
    private JButton exitButton;
    private Connection dbConnection;
   
    
	 public SalesRepEntry(Connection dbConnection){
		   //store the reference to the database --- back end
		   this.dbConnection = dbConnection;
		   
		   //verify that a database connection exists
		   if (this.dbConnection == null){
			   JOptionPane.showMessageDialog(null,"missing database connection --- contact IT");
			   
		   }
		   else{ //continue with this process		   
	 
			   	setTitle("Premiere New SalesRep Entry Form");
			   	//set window size
			   	setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

			   	// Specify an action for the close button.
			   	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			   	//set up layout of the window 
			   	setLayout(new BorderLayout());
			   	
			   	buildRepPanel();
			   	add(repPanel,BorderLayout.WEST);
			   	
			   	buildButtonPanel();
			   	add(buttonPanel,BorderLayout.SOUTH);
			   	
			   	pack();
			   	setVisible(true);
			   	System.out.println(this.getClass());
		   }
 	
	   }

	
	   private boolean buildRepPanel()
	   {
		   this.repPanel = new JPanel();
		   
		   repPanel.setLayout(new GridLayout(3,2));
		   
			//set up each text field and associated label
		   	repCommissionlbl = new JLabel("Commission:");
		   	repCommission = new JTextField(8);
		   	repRatelbl = new JLabel("Rate:");
		   	repRate = new JTextField(8);
			repNumlbl = new JLabel("Sales Rep Number: ");
			repNum = new JComboBox();
			
			
			//fill the combo box by querying for emp numbers that are salesreps  
			//you have to first set up an employee as a salesrep and then you can add to salesrep table
			//querying from the table because accountants have direct access to employee
			String salesRepsQuery = "select empID from employee where empTypeID = 1";
			Statement sqlStatement = null;
			try{
			sqlStatement = dbConnection.createStatement();
			//execute the query
			ResultSet rs = sqlStatement.executeQuery(salesRepsQuery);
			
			//retrieve data from first column in the resultset
			//there should be only one column, a bunch of rows
			while(rs.next()){
				repNum.addItem(rs.getString(1));
			}
			}
			catch(SQLException e)
			{
				System.out.println("There was a problem getting the Employee Numbers from the database.");
				return false;
			}
			
			
			//add the objects to the panel
			//the layout manager will arrange them in the panel
			repPanel.add(this.repNumlbl);
			repPanel.add(this.repNum);
			repPanel.add(this.repCommissionlbl);
			repPanel.add(this.repCommission);
			repPanel.add(this.repRatelbl);
			repPanel.add(this.repRate);
			
		   return true;
	   }
	
	   private boolean buildButtonPanel()
	   {
		   buttonPanel = new JPanel();
		   buttonPanel.setLayout(new FlowLayout());
		   
		   insertButton = new JButton("Insert Sales Rep");
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
		   
		   private PreparedStatement insertSalesRep;
		   
		   public void actionPerformed(ActionEvent e)
		   {
			   System.out.println("Ready to process the Insert Sales Rep Button");
			   
			   insertSalesRep = null;
			   
			   ResultSet rs = null;
			   try{
				   
				   insertSalesRep = dbConnection.prepareStatement("Insert into SalesRep "
				   		+ "(Rep_Num, Commission, Rate) Values(?,?,?)");
			   }
			   catch(SQLException ex)
			   {
				   System.out.println("Could not prepare the statement to insert sales rep");
			   }
			   
			   try{
						  
				   insertSalesRep.setInt(1, Integer.parseInt(repNum.getSelectedItem().toString()));
				   insertSalesRep.setBigDecimal(2, new BigDecimal(Double.parseDouble(repCommission.getText())));
				   insertSalesRep.setDouble(3, Double.parseDouble(repRate.getText()));
				   
				   int result = insertSalesRep.executeUpdate();
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
