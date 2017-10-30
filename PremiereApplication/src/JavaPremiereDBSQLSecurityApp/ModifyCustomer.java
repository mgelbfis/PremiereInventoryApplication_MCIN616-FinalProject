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

public class ModifyCustomer extends JFrame {

	private final int WINDOW_WIDTH = 800;
	private final int WINDOW_HEIGHT = 800;
	private JPanel custPanel;
	private Connection dbConnection;
	private boolean accountant;
	private JComboBox custID;
	private JLabel custIDlbl;
	private JButton enter;
	private JTable table;

	public ModifyCustomer(Connection dbConnection, boolean a) {
		// store the reference to the database --- back end
		this.dbConnection = dbConnection;

		this.accountant = a;
		// verify that a databse connection exists
		if (this.dbConnection == null) {
			JOptionPane.showMessageDialog(null, "missing database connection --- contact IT");

		} else { // continue with this process

			this.custPanel = new JPanel();

			custPanel.setLayout(new GridLayout(3, 2));

			setTitle("Modify Customer Data");
			// set window size
			setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

			// Specify an action for the close button.
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			// set up layout of the window
			setLayout(new BorderLayout());

			custIDlbl = new JLabel("Customer ID");
			custPanel.add(custIDlbl);
			custID = new JComboBox();

			// fill the combo box by querying for custIDs
			String custIDQuery = "select cust_num from customer";
			Statement sqlStatement = null;
			try {
				sqlStatement = dbConnection.createStatement();
				// execute the query
				ResultSet rs = sqlStatement.executeQuery(custIDQuery);

				// retrieve data from first column in the resultset
				// there should be only one column, a bunch of rows
				while (rs.next()) {
					custID.addItem(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

			custPanel.add(custID);

			enter = new JButton("Get Customer Information");
			enter.addActionListener(new GetCustInfoListener());
			custPanel.add(enter);

			add(custPanel, BorderLayout.WEST);
			pack();
			setVisible(true);
			System.out.println(this.getClass());

		}

	}

	private class GetCustInfoListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {

			try {
				PreparedStatement getOrderData = null;

				String getData = "select * from Customer where cust_num = ?";

				getOrderData = dbConnection.prepareStatement(getData);

				getOrderData.setInt(1, Integer.parseInt(custID.getSelectedItem().toString()));

				ResultSet rs = getOrderData.executeQuery();

				table = new JTable(buildTableModel(rs));

				JButton change = new JButton("Apply Changes");
				change.addActionListener(new ChangeInfoListener());
				add(change, BorderLayout.SOUTH);

				enter.setVisible(false);
				custID.setVisible(false);
				custIDlbl.setVisible(false);
				
				add(new JScrollPane(table));
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

			if (table.isEditing()) {
				JOptionPane.showMessageDialog(null,
						"Sorry. Move the focus off the cell you are editing and press Apply Changes again.");
				return;
			}

			try {
				PreparedStatement modifySalesData = null;

				if (accountant) {
					String s = "update customer set credit_limit = ?, rep_num = ? where cust_num = ?";
					modifySalesData = dbConnection.prepareStatement(s);

					modifySalesData.setDouble(1, Double.parseDouble(table.getValueAt(0, 7).toString()));

					modifySalesData.setInt(2,
							Integer.parseInt(table.getValueAt(0, 8).toString()));

					modifySalesData.setInt(3, Integer.parseInt(table.getValueAt(0, 0).toString()));

					int result = modifySalesData.executeUpdate();

				}
				else{
					String s = "update customer set cust_name = ?, cust_street = ?, cust_city = ?, cust_state = ?, cust_zip = ?, cust_balance = ?, phone = ? where cust_num = ?";
					modifySalesData = dbConnection.prepareStatement(s);

					modifySalesData.setString(1, table.getValueAt(0, 1).toString());

					modifySalesData.setString(2, table.getValueAt(0, 2).toString());

					modifySalesData.setString(3, table.getValueAt(0, 3).toString());
					
					modifySalesData.setString(4, table.getValueAt(0, 4).toString());
					
					modifySalesData.setString(5, table.getValueAt(0, 5).toString());
					
					modifySalesData.setBigDecimal(6, new BigDecimal(Double.parseDouble(table.getValueAt(0, 6).toString())));
					
					modifySalesData.setString(7, table.getValueAt(0, 9).toString());
					
					modifySalesData.setInt(8, Integer.parseInt(table.getValueAt(0,0).toString()));

					int result = modifySalesData.executeUpdate();
				}
			}

			catch (SQLException ex) {
				ex.printStackTrace();
				try {
					dbConnection.rollback();
				} catch (SQLException sqlE) {
					sqlE.printStackTrace();

				}
			}

			try {
				dbConnection.commit();
			} catch (SQLException except) {
				except.printStackTrace();
				try {
					dbConnection.rollback();

				} catch (SQLException sqle) {
					sqle.printStackTrace();

				}
			}

			dispose();

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
				if (!accountant) {
					switch (col) {
					case 1:
					case 2:
					case 3:
					case 4:
					case 5:
					case 6:
					case 9:
						return true;
					default:
						return false;
					}
				} else {
					switch (col) {
					case 7:
					case 8:
						return true;
					default:
						return false;
					}
				}

			}
		};

	}
}
