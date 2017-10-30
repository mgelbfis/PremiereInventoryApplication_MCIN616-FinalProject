package JavaPremiereDBSQLSecurityApp;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ModifySalesOrder extends JFrame {
	private final int WINDOW_WIDTH = 800;
	private final int WINDOW_HEIGHT = 800;
	private JPanel salesPanel;
	private Connection dbConnection;
	private JComboBox orderID;
	private JButton enter;
	private JTable table;

	public ModifySalesOrder(Connection dbConnection) {
		// store the reference to the database --- back end
		this.dbConnection = dbConnection;

		// verify that a database connection exists
		if (this.dbConnection == null) {
			JOptionPane.showMessageDialog(null, "missing database connection --- contact IT");

		} else { // continue with this process

			this.salesPanel = new JPanel();

			salesPanel.setLayout(new GridLayout(3, 2));

			setTitle("Modify Order Data");
			// set window size
			setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

			// Specify an action for the close button.
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			// set up layout of the window
			setLayout(new BorderLayout());

			salesPanel.add(new JLabel("Order ID: "));
			orderID = new JComboBox();

			// fill the combo box by querying for orderIDs
			String orderIDQuery = "select distinct order_num from salesreporderdata";
			Statement sqlStatement = null;
			try {
				sqlStatement = dbConnection.createStatement();
				// execute the query
				ResultSet rs = sqlStatement.executeQuery(orderIDQuery);

				// retrieve data from first column in the resultset
				// there should be only one column, a bunch of rows
				while (rs.next()) {
					orderID.addItem(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

			salesPanel.add(orderID);

			enter = new JButton("Get Order Information");
			enter.addActionListener(new GetOrderInfoListener());
			salesPanel.add(enter);

			add(salesPanel, BorderLayout.WEST);
			pack();
			setVisible(true);
			System.out.println(this.getClass());

		}

	}

	private class GetOrderInfoListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {

			try {
				PreparedStatement getOrderData = null;

				String getData = "select * from SalesRepOrderData where order_num = ?";

				getOrderData = dbConnection.prepareStatement(getData);

				getOrderData.setInt(1, Integer.parseInt(orderID.getSelectedItem().toString()));

				ResultSet rs = getOrderData.executeQuery();

				table = new JTable(buildTableModel(rs));

				JButton change = new JButton("Apply Changes");
				change.addActionListener(new ChangeInfoListener());
				add(change, BorderLayout.SOUTH);

				add(new JScrollPane(table));
				setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
				pack();
				setVisible(true);

			} catch (SQLException ex) {
				ex.printStackTrace();

			}

		}

	}

	public DefaultTableModel buildTableModel(ResultSet rs) throws SQLException {

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

		return new DefaultTableModel(data, columnNames) {
			@Override
			public boolean isCellEditable(int row, int col) {
				switch (col) {
				case 4:
				case 5:
					return true;
				default:
					return false;
				}
			}
		};

	}

	private class ChangeInfoListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			

				if(table.isEditing())
				{
					JOptionPane.showMessageDialog(null, "Sorry. Move the focus off the cell you are editing and press Apply Changes again.");
					return;
				}
				for (int i = 0; i < table.getRowCount(); i++) {

					try{
					PreparedStatement modifySalesData = null;
					String s = "update salesreporderdata set QTY_ORDERED = ?, QUOTED_PRICE = ? where Order_num = ? and Part_Num = ?";
					modifySalesData = dbConnection.prepareStatement(s);
					
					modifySalesData.setInt(1, Integer.parseInt(table.getValueAt(i, 4).toString()));
					System.out.println(table.getValueAt(i, 4).toString());

					modifySalesData.setBigDecimal(2, new BigDecimal(Double.parseDouble(table.getValueAt(i, 5).toString())));
					System.out.println(table.getValueAt(i, 5).toString());
					
					modifySalesData.setInt(3, Integer.parseInt(table.getValueAt(i, 1).toString()));
					System.out.println(table.getValueAt(i, 1).toString());
					
					modifySalesData.setString(4, table.getValueAt(i, 3).toString());
					System.out.println(table.getValueAt(i, 3).toString());
					int result = modifySalesData.executeUpdate();

					System.out.println(result);
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
		    	  
		    	  
				}
				
				dispose();

			}

		}
	}


