package JavaPremiereDBSQLSecurityApp;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ModifyEmployee extends JFrame {

	private final int WINDOW_WIDTH = 3200;
	private final int WINDOW_HEIGHT = 3200;
	private JPanel empPanel;
	private Connection dbConnection;
	private JComboBox empID;
	private JButton enter;
	private ArrayList<JTextField> data;

	public ModifyEmployee(Connection dbConnection) {
		// store the reference to the database --- back end
		this.dbConnection = dbConnection;

		// verify that a databse connection exists
		if (this.dbConnection == null) {
			JOptionPane.showMessageDialog(null, "missing database connection --- contact IT");

		} else { // continue with this process

			// to put the text fields in the order that the info came so that it
			// can be modified in the same order
			this.data = new ArrayList<JTextField>();

			this.empPanel = new JPanel();

			empPanel.setLayout(new GridLayout(2, 2));

			setTitle("Modify Employee Data");
			// set window size
			setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

			// Specify an action for the close button.
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			// set up layout of the window
			setLayout(new BorderLayout());

			empPanel.add(new JLabel("Employee ID: "));
			empID = new JComboBox();

			// fill the combo box by querying for emp types -- querying from the
			// view set up for this
			String empIDQuery = "select empID from Employee";
			Statement sqlStatement = null;
			try {
				sqlStatement = dbConnection.createStatement();
				// execute the query
				ResultSet rs = sqlStatement.executeQuery(empIDQuery);

				// retrieve data from first column in the resultset
				// there should be only one column, a bunch of rows
				while (rs.next()) {
					empID.addItem(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

			empPanel.add(empID);

			enter = new JButton("Get Employee Info");
			enter.addActionListener(new GetEmployeeInfoListener());
			empPanel.add(enter);

			add(empPanel, BorderLayout.WEST);
			pack();
			setVisible(true);
			System.out.println(this.getClass());

		}

	}

	private class GetEmployeeInfoListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {

			try {
				PreparedStatement modifyEmpData = null;
				String s = "Select FirstName, LastName, Street, City, EmpState, ZipCode, PhoneNumber from Employee where empID = ?";
				modifyEmpData = dbConnection.prepareStatement(s);

				modifyEmpData.setString(1, empID.getSelectedItem().toString());

				ResultSet rs = modifyEmpData.executeQuery();

				rs.next();

				for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
					JTextField temp = new JTextField();
					empPanel.add(new JLabel(rs.getMetaData().getColumnName(i)));
					temp.setText(rs.getString(i));
					temp.setEditable(true);
					data.add(temp);
					empPanel.add(temp);
				}

				JButton change = new JButton("Apply Changes");
				change.addActionListener(new ChangeInfoListener());
				empPanel.add(change);
				
				setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
				pack();
				setVisible(true);

			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}

	private class ChangeInfoListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {
				PreparedStatement modifyEmpData = null;
				String s = "update Employee set FirstName = ?, LastName = ?, Street = ?, City = ?, EmpState = ?, ZipCode = ?, PhoneNumber = ? where empID = ?";
				modifyEmpData = dbConnection.prepareStatement(s);

				int i;
				for (i = 0; i < data.size(); i++) {
					modifyEmpData.setString((i + 1), data.get(i).getText());
				}
				
				modifyEmpData.setInt((i+1), Integer.parseInt(empID.getSelectedItem().toString()));
				
				int result = modifyEmpData.executeUpdate();

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


