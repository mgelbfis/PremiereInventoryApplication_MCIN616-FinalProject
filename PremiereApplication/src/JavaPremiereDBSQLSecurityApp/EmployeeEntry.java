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



public class EmployeeEntry extends JFrame{
	 private final int WINDOW_WIDTH = 800;
	 private final int WINDOW_HEIGHT = 800;
	 private final DateFormat format = new SimpleDateFormat("MM/dd/yyyy");
     private JPanel empPanel;
     private JLabel empIDlbl;
 	 private JTextField empID;
 	 private JLabel empFirstNamelbl;
 	 private JTextField empFirstName;
 	 private JLabel empLastNamelbl;
 	 private JTextField empLastName;
 	 private JLabel empStreetlbl;
 	 private JTextField empStreet;
 	 private JLabel empCitylbl;
 	 private JTextField empCity;
 	 private JLabel empStatelbl;
 	 private JComboBox empState;
 	 private JLabel empZiplbl;
 	 private JTextField empZip;
 	 private JLabel empPhonelbl;
 	 private JTextField empPhone;
 	 private JLabel empBirthDatelbl;
 	 private JFormattedTextField empBirthDate;
 	 private JLabel empHireDatelbl;
 	 private JFormattedTextField empHireDate;
 	 private JLabel empTypeIDlbl;
 	 private JComboBox empType;
 	 private JLabel empLoginlbl;
 	 private JTextField empLogin;
 	
     private JPanel buttonPanel;
     private JButton insertButton;
     private JButton exitButton;
     private Connection dbConnection;
     
     private String[] states = {"AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE",
 			"FL", "GA", "HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME",
 			"MD", "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ", 
 			"NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA","RI", "SC", "SD", 
 			"TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY"};
     
	 public EmployeeEntry(Connection dbConnection){
		   //store the reference to the database --- back end
		   this.dbConnection = dbConnection;
		   
		   //verify that a database connection exists
		   if (this.dbConnection == null){
			   JOptionPane.showMessageDialog(null,"missing database connection --- contact IT");
			   
		   }
		   else{ //continue with this process		   
	 
			   	setTitle("Premiere New Employee Entry Form");
			   	//set window size
			   	setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

			   	// Specify an action for the close button.
			   	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			   	//set up layout of the window 
			   	setLayout(new BorderLayout());
			   	
			   	buildEmpPanel();
			   	add(empPanel,BorderLayout.WEST);
			   	
			   	buildButtonPanel();
			   	add(buttonPanel,BorderLayout.SOUTH);
			   	
			   	pack();
			   	setVisible(true);
			   	System.out.println(this.getClass());
		   }
  	
	   }

	
	   private boolean buildEmpPanel()
	   {
		   this.empPanel = new JPanel();
		   
		   empPanel.setLayout(new GridLayout(3,2));
		   
			//set up each text field and associated label
			empIDlbl = new JLabel("Employee ID: ");
			empID = new JTextField(5);
			empFirstNamelbl = new JLabel("First Name: ");
			empFirstName = new JTextField(10);
			empLastNamelbl = new JLabel("Last Name:");
			empLastName = new JTextField(10);
			empStreetlbl = new JLabel("Street Address:");
			empStreet = new JTextField(20);
			empCitylbl = new JLabel("City:");
			empCity = new JTextField(20);
			empStatelbl = new JLabel("State: ");
			empState = new JComboBox(this.states); 
			empZiplbl = new JLabel("Zip:");
			empZip = new JTextField(6);
			empPhonelbl = new JLabel("Phone Number:");
			empPhone = new JTextField(10);
			empBirthDatelbl = new JLabel("Birth Date:");
			empBirthDate = new JFormattedTextField(format);
			empHireDatelbl = new JLabel("Hire Date:");
			empHireDate = new JFormattedTextField(format);
			empTypeIDlbl = new JLabel("Employee Type:");
			empType = new JComboBox();
			
			//fill the combo box by querying for emp types -- querying from the view set up for this
			String empTypeQuery = "select empTypeDesc from EmpTypeData";
			Statement sqlStatement = null;
			try{
			sqlStatement = dbConnection.createStatement();
			//execute the query
			ResultSet rs = sqlStatement.executeQuery(empTypeQuery);
			
			//retrieve data from first column in the resultset
			//there should be only one column, a bunch of rows
			while(rs.next()){
				empType.addItem(rs.getString(1));
			}
			}
			catch(SQLException e)
			{
				System.out.println("There was a problem getting the Employee Types from the database.");
				return false;
			}
			
			empLoginlbl =  new JLabel("Employee Login:");
			empLogin = new JTextField(20);
			
			//add the objects to the panel
			//the layout manager will arrange them in the panel
			empPanel.add(this.empIDlbl);
			empPanel.add(this.empID);
			empPanel.add(this.empFirstNamelbl);
			empPanel.add(this.empFirstName);
			empPanel.add(this.empLastNamelbl);
			empPanel.add(this.empLastName);
			empPanel.add(this.empStreetlbl);
			empPanel.add(this.empStreet);
			empPanel.add(this.empCitylbl);
			empPanel.add(this.empCity);
			empPanel.add(this.empStatelbl);
			empPanel.add(this.empState);
			empPanel.add(this.empZiplbl);
			empPanel.add(this.empZip);
			empPanel.add(this.empPhonelbl);
			empPanel.add(this.empPhone);
			empPanel.add(this.empBirthDatelbl);
			empPanel.add(this.empBirthDate);
			empPanel.add(this.empHireDatelbl);
			empPanel.add(this.empHireDate);
			empPanel.add(this.empTypeIDlbl);
			empPanel.add(this.empType);
			empPanel.add(this.empLoginlbl);
			empPanel.add(this.empLogin);
			
		   return true;
	   }
	
	   private boolean buildButtonPanel()
	   {
		   buttonPanel = new JPanel();
		   buttonPanel.setLayout(new FlowLayout());
		   
		   insertButton = new JButton("Insert Employee");
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
		   
		   private PreparedStatement insertEmployee;
		   private PreparedStatement findEmpTypeID;
		   private int empTypeID;
		   
		   public void actionPerformed(ActionEvent e)
		   {
			   System.out.println("Ready to process the Insert Employee Button");
			   
			   insertEmployee = null;
			   findEmpTypeID = null;
			   
			   ResultSet rs = null;
			   try{
				   
				   insertEmployee = dbConnection.prepareStatement("Insert into Employee "
				   		+ "(EmpID, FirstName, LastName, Street, City, EmpState, ZipCode,"
				   		+ "PhoneNumber, BirthDate, HireDate, EmpTypeID, EmpLogin) Values(?,?,?,?,?,?,?,?,?,?,?,?)");
			   }
			   catch(SQLException ex)
			   {
				   System.out.println("Could not prepare the statement to insert employee");
			   }
			   
			   try{
				   
				   try{
					   
					   String s = "Select empTypeID from EmpTypeData where empTypeDesc = ?";
					   findEmpTypeID = dbConnection.prepareStatement(s);
					   
					  findEmpTypeID.setString(1, empType.getSelectedItem().toString()); 
					  
					  rs = findEmpTypeID.executeQuery();
					  
					  while (rs.next()) {
					  	empTypeID = rs.getInt("empTypeID");
					  	System.out.println("Got empID: " + empTypeID);
					  }
					  
				   }
				   
				   catch(SQLException ex)
				   {
					   System.out.println("There was a problem retrieving the employee type ID from the database.");
				   }
				   
				   
				   String date1 = empBirthDate.getText();
				   java.sql.Date sqlDate1 = null;
				   String[] dateParts = date1.split("/");
					  if (dateParts.length !=3){
						  //user made an error entering the date
						  JOptionPane.showMessageDialog(null,"incorrect date format");
						  return;
					  }
					  else
					  { int month;
					    int day;
					    int year;
						month = Integer.parseInt(dateParts[0]);
						day = Integer.parseInt(dateParts[1]);
						year = Integer.parseInt(dateParts[2]);
						System.out.println(month + " " + day + " " + year);
						//convert LocalDate to sql.Date
						sqlDate1 =  java.sql.Date.valueOf(LocalDate.of(year,month,day));
					  }
					  
					  String date2 = empHireDate.getText();
					   java.sql.Date sqlDate2 = null;
					   dateParts = date2.split("/");
						  if (dateParts.length !=3){
							  //user made an error entering the date
							  JOptionPane.showMessageDialog(null,"incorrect date format");
							  return;
						  }
						  else
						  { int month;
						    int day;
						    int year;
							month = Integer.parseInt(dateParts[0]);
							day = Integer.parseInt(dateParts[1]);
							year = Integer.parseInt(dateParts[2]);
							System.out.println(month + " " + day + " " + year);
							//convert LocalDate to sql.Date
							sqlDate2 =  java.sql.Date.valueOf(LocalDate.of(year,month,day));
						  }
						  
						  
				   insertEmployee.setInt(1, Integer.parseInt(empID.getText()));
				   insertEmployee.setString(2, empFirstName.getText());
				   insertEmployee.setString(3, empLastName.getText());
				   insertEmployee.setString(4, empStreet.getText());
				   insertEmployee.setString(5, empCity.getText());
				   insertEmployee.setString(6, empState.getSelectedItem().toString());
				   insertEmployee.setString(7, empZip.getText());
				   insertEmployee.setString(8, empPhone.getText());
				   insertEmployee.setDate(9, sqlDate1);
				   insertEmployee.setDate(10, sqlDate2);
				   insertEmployee.setInt(11, empTypeID);
				   insertEmployee.setString(12, empLogin.getText());
				   
				   
				   
				   int result = insertEmployee.executeUpdate();
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
