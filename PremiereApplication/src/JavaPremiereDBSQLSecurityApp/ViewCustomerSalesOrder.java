package JavaPremiereDBSQLSecurityApp;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class ViewCustomerSalesOrder extends JFrame{

	private final int WINDOW_WIDTH = 800;
	private final int WINDOW_HEIGHT = 800;
	private JPanel salesPanel;
	private Connection dbConnection;
	

	public ViewCustomerSalesOrder(Connection dbConnection) {
		// store the reference to the database --- back end
		this.dbConnection = dbConnection;

		// verify that a database connection exists
		if (this.dbConnection == null) {
			JOptionPane.showMessageDialog(null, "missing database connection --- contact IT");

		} else { // continue with this process

			this.salesPanel = new JPanel();
			   
			salesPanel.setLayout(new GridLayout(3,2));
			
			setTitle("Veiw My Sales Orders");
			// set window size
			setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

			// Specify an action for the close button.
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			// set up layout of the window
			setLayout(new BorderLayout());

			String getData = "select * from CustomerOrderData";
			Statement sqlStatement = null;
			try{
			sqlStatement = dbConnection.createStatement();
			//execute the query
			ResultSet rs = sqlStatement.executeQuery(getData);
			
			JTable table = new JTable(buildTableModel(rs));
			   
			add(new JScrollPane(table));
			setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
			pack();
			setVisible(true);
			
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			
			
			

			
		}

	}
	
	public DefaultTableModel buildTableModel(ResultSet rs)
	        throws SQLException {

	    ResultSetMetaData metaData = rs.getMetaData();

	    // names of columns
	    Vector<String> columnNames = new Vector<String>();
	    int columnCount = metaData.getColumnCount();
	    for (int column = 1; column <= columnCount; column++) {
	        columnNames.add(metaData.getColumnName(column));
	    }

	    // data of the table
	    Vector<Vector<Object>> data = new Vector<Vector<Object>>();
	    while (rs.next()) {
	        Vector<Object> vector = new Vector<Object>();
	        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
	            vector.add(rs.getObject(columnIndex));
	        }
	        data.add(vector);
	    }

	    return new DefaultTableModel(data, columnNames);

	}
}
