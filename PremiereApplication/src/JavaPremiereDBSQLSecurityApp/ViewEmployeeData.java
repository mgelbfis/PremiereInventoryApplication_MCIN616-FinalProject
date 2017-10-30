package JavaPremiereDBSQLSecurityApp;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ViewEmployeeData extends JFrame {

	private final int WINDOW_WIDTH = 800;
	private final int WINDOW_HEIGHT = 800;
	private JPanel empPanel;
	private Connection dbConnection;
	

	public ViewEmployeeData(Connection dbConnection) {
		// store the reference to the database --- back end
		this.dbConnection = dbConnection;

		// verify that a databse connection exists
		if (this.dbConnection == null) {
			JOptionPane.showMessageDialog(null, "missing database connection --- contact IT");

		} else { // continue with this process

			this.empPanel = new JPanel();
			   
			empPanel.setLayout(new GridLayout(3,2));
			
			setTitle("Veiw Employee Data");
			// set window size
			setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

			// Specify an action for the close button.
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			// set up layout of the window
			setLayout(new BorderLayout());

			String getEmpData = "select * from EmployeeData";
			Statement sqlStatement = null;
			try{
			sqlStatement = dbConnection.createStatement();
			//execute the query
			ResultSet rs = sqlStatement.executeQuery(getEmpData);
			
			rs.next();
			
			for(int i = 1; i < rs.getMetaData().getColumnCount(); i++)
			{
				JTextField temp = new JTextField();
				this.empPanel.add(new JLabel(rs.getMetaData().getColumnName(i)));
				temp.setText(rs.getString(i));
				temp.setEditable(false);
				this.empPanel.add(temp);
			}
			
			add(empPanel, BorderLayout.WEST);
			pack();
			setVisible(true);
			System.out.println(this.getClass());
		
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			
			
			

			
		}

	}
}
