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


public class ModifySalesRep extends JFrame{

	private final int WINDOW_WIDTH = 3200;
	private final int WINDOW_HEIGHT = 3200;
	private JPanel repPanel;
	private Connection dbConnection;
	private JComboBox repID;
	private JButton enter;
	private JTextField rate;

	public ModifySalesRep(Connection dbConnection) {
		// store the reference to the database --- back end
		this.dbConnection = dbConnection;

		// verify that a database connection exists
		if (this.dbConnection == null) {
			JOptionPane.showMessageDialog(null, "missing database connection --- contact IT");

		} else { // continue with this process

			this.repPanel = new JPanel();

			repPanel.setLayout(new GridLayout(2, 2));

			setTitle("Modify SalesRep Rate");
			// set window size
			setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

			// Specify an action for the close button.
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			// set up layout of the window
			setLayout(new BorderLayout());

			repPanel.add(new JLabel("Rep ID: "));
			repID = new JComboBox();

			// fill the combo box by querying for emp ids 
			String empIDQuery = "select rep_num from salesrep";
			Statement sqlStatement = null;
			try {
				sqlStatement = dbConnection.createStatement();
				// execute the query
				ResultSet rs = sqlStatement.executeQuery(empIDQuery);

				// retrieve data from first column in the resultset
				// there should be only one column, a bunch of rows
				while (rs.next()) {
					repID.addItem(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

			repPanel.add(repID);

			enter = new JButton("Get Current Rate");
			enter.addActionListener(new GetEmployeeInfoListener());
			repPanel.add(enter);

			add(repPanel, BorderLayout.WEST);
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
				String s = "Select rate from salesrep where rep_num = ?";
				modifyEmpData = dbConnection.prepareStatement(s);

				modifyEmpData.setString(1, repID.getSelectedItem().toString());

				ResultSet rs = modifyEmpData.executeQuery();

				rs.next();

				repPanel.add(new JLabel("Rate:"));
				rate = new JTextField();
				rate.setText(rs.getString(1));
				rate.setEditable(true);
				repPanel.add(rate);

				JButton change = new JButton("Apply Changes");
				change.addActionListener(new ChangeInfoListener());
				repPanel.add(change);
				
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
				String s = "update salesrep set rate = ? where rep_num = ?";
				modifyEmpData = dbConnection.prepareStatement(s);

				modifyEmpData.setDouble(1, Double.parseDouble(rate.getText()));
				
				modifyEmpData.setInt(2, Integer.parseInt(repID.getSelectedItem().toString()));
				
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
