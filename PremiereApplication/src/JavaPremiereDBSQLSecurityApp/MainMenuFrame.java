package JavaPremiereDBSQLSecurityApp;

import javax.security.auth.*;
import javax.security.auth.login.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class MainMenuFrame extends JFrame implements WindowListener {

	private JMenuBar premiereMenuBar;

	private JMenu salesMenu, employeeMenu, customerMenu, purchaseMenu;
	private JMenuItem addSalesItem, modifySalesItem, cancelSalesItem, viewSalesItem;// viewSalesOrdersItem;
	private JMenuItem addEmployeeMenuItem, modifyEmployeeMenuItem, modifySalesRepMenuItem, addSalesRepMenuItem,
			viewEmployeeMenuItem, listEmployeesMenuItem;
	private JMenuItem addcustomerMenuItem, modifyCustomerMenuItem, listCustomersMenuItem, viewMyAccountMenuItem;
	private JMenuItem viewPurchasesMenuItem;
	private Connection dbConnection;

	private Roles allRoles;

	public MainMenuFrame(Connection dbConnection) {

		this.setSize(1500, 1500);
		this.setTitle("Premiere Application");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		// first display LoginFrame

		this.dbConnection = dbConnection;
		ArrayList<String> databaseRoles;
		databaseRoles = getDatabaseRoles();
		setUpMenuBar(databaseRoles);
		this.setJMenuBar(premiereMenuBar); // add menu bar to the window
		pack();
		this.setVisible(true);
	}

	private ArrayList<String> getDatabaseRoles() {
		/*
		 * USER_NAME() - database username - a.k.a USER and CURRENT_USER
		 * 
		 * SUSER_SNAME() - login identification name - supersedes SUSER_NAME()
		 */

		ArrayList<String> databaseRoles = new ArrayList<String>(); // to store
																	// the roles
																	// that the
																	// current
																	// Login has
																	// been
																	// assigned
		String currentLogin;
		// set up a Statement that can query the sql server
		Statement sqlStatement = null;

		// set up the query to get the SQL Server login if using SQL Server
		// authentication
		String query = "select suser_sname()";
		// now create an instance of Statement
		// and use it to execute the query
		try {
			sqlStatement = dbConnection.createStatement();
			// execute the query
			ResultSet rs = sqlStatement.executeQuery(query);
			// move to first record in the resultset
			rs.next();
			// retrieve data from first column in the resultset
			// there should be only one row and one column
			currentLogin = rs.getString(1);

			System.out.println("current login " + currentLogin);

			// now get the user and the role(s) associated with the
			// user that is associated with this sql server login
			query =

					"select u.name, r.name " + "from [PREMIERE].sys.database_role_members as m "
							+ "inner join [PREMIERE].sys.database_principals r "
							+ "on m.role_principal_id = r.principal_id "
							+ "inner join [PREMIERE].sys.database_principals as u "
							+ "on u.principal_id = m.member_principal_id " + "where u.name = " +
							// access sql logins instead of windows logins
							"(select u.name from [PREMIERE].sys.sql_logins  l "
							+ "inner join [PREMIERE].sys.sysusers  u " + "on l.sid = u.sid " + "where l.name = " + "'"
							+ currentLogin + "')";

			// now execute this query
			rs = sqlStatement.executeQuery(query);
			// now check the results that came back
			if (!rs.next()) {
				return null; // no database roles were assigned
			} else {
				// iterate through the resultset
				do {
					// get the data from the first row
					String currentUser = rs.getString(1);
					String currentDBRole = rs.getString(2);
					if (!(currentDBRole == null)) {

						System.out.println("current user" + currentUser + " current role" + currentDBRole);
						databaseRoles.add(currentDBRole);
					}
				} while (rs.next()); // go to next row
			}
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "couldnt retrieve data");
			ex.printStackTrace();
			return null;
		}

		return databaseRoles; // if no roles were assigned to this particular
								// login
		// it must be a guest
	}

	private void setUpMenuBar(ArrayList<String> databaseRoles) {
		// set up the menu bar
		this.premiereMenuBar = new JMenuBar();
		// set up and add the main menus to the menu bar
		if (databaseRoles != null && databaseRoles.isEmpty() || databaseRoles == null) {
			// no roles were assigned to user that is currently logged in
			System.out.println("not authorized to use this system.... contact IT");
			this.dispose(); // close this window
			System.exit(1); // end the application
		}
		// Buyer Menu
		if (databaseRoles.contains(Roles.PR_BuyerRole.name())) {
			this.purchaseMenu = new JMenu("Purchases");
			premiereMenuBar.add(purchaseMenu);

			this.viewPurchasesMenuItem = new JMenuItem("View Purchases");
			this.purchaseMenu.add(viewPurchasesMenuItem);
			this.viewPurchasesMenuItem.addActionListener(new ViewPurchasesListener());
		}
		// Sales Menu
		if (databaseRoles.contains(Roles.PR_SalesRole.name())) {
			// current user was assigned SalesRole
			this.salesMenu = new JMenu("Sales");
			premiereMenuBar.add(salesMenu);
			// set up each menu item and add the item to the menu on the menu
			// bar
			this.addSalesItem = new JMenuItem("Add Sales Order");
			this.modifySalesItem = new JMenuItem("Modify Sales Order");
			this.cancelSalesItem = new JMenuItem("Cancel Sales Order");
			this.viewSalesItem = new JMenuItem("View Sales Order");

			this.salesMenu.add(addSalesItem);
			this.salesMenu.add(modifySalesItem);
			this.salesMenu.add(cancelSalesItem);
			this.salesMenu.addSeparator(); // add separate between modify
											// operations and list operations

			// according to the permissions, a salesRep should not be able to
			// view all orders
			// this.viewSalesOrdersItem = new JMenuItem("View All Sales
			// Orders");

			this.salesMenu.add(viewSalesItem);
			// this.salesMenu.add(viewSalesOrdersItem);

			// connect each menu item to the appropriate action listener
			this.addSalesItem.addActionListener(new AddSalesOrderListener());
			
			this.modifySalesItem.addActionListener(new ModifySalesListener());
			this.cancelSalesItem.addActionListener(new CancelSalesListener());
			this.viewSalesItem.addActionListener(new ViewSalesItemListener());

		}
		
		if(databaseRoles.contains(Roles.PR_CustomerRole.name()))
		{
			this.salesMenu = new JMenu("Sales");
			premiereMenuBar.add(salesMenu);
			this.viewSalesItem = new JMenuItem("View My Sales Orders");
			this.salesMenu.add(this.viewSalesItem);
			this.viewSalesItem.addActionListener(new ViewCustomerSalesItemListener());
		}

		// Customer Menu
		if (databaseRoles.contains(Roles.PR_CustomerRole.name()) || databaseRoles.contains(Roles.PR_OfficeRole.name())
				|| databaseRoles.contains(Roles.PR_AccountantRole.name())

		) {
			this.customerMenu = new JMenu("Customer");
			premiereMenuBar.add(customerMenu);

			if (databaseRoles.contains(Roles.PR_OfficeRole.name())) {
				this.addcustomerMenuItem = new JMenuItem("Add Customer");
				this.customerMenu.add(addcustomerMenuItem);
				this.addcustomerMenuItem.addActionListener(new AddCustomerListener());
			}
			if (databaseRoles.contains(Roles.PR_AccountantRole.name())||databaseRoles.contains(Roles.PR_OfficeRole.name()))
			{
				this.modifyCustomerMenuItem = new JMenuItem("Modify Customer");
				this.customerMenu.add(modifyCustomerMenuItem);
				this.modifyCustomerMenuItem.addActionListener(new ModifyCustomerListener(databaseRoles.contains(Roles.PR_AccountantRole.name())));
				this.customerMenu.addSeparator(); // add separate between modify
													// operations and list
													// operations
				this.listCustomersMenuItem = new JMenuItem("List Customers");
				this.customerMenu.add(listCustomersMenuItem);
				// connect menu item to the appropriate ActionListener
				this.listCustomersMenuItem.addActionListener(new ListCustomersListener());
				
			}
			
			if(databaseRoles.contains(Roles.PR_CustomerRole.name())){
			this.viewMyAccountMenuItem = new JMenuItem("Veiw My Customer Account");
			this.customerMenu.add(viewMyAccountMenuItem);
			this.viewMyAccountMenuItem.addActionListener(new ViewMyCustomerAccountListener());
			
			
			}

		}

		// Employee Menu
		if (!databaseRoles.contains(Roles.PR_CustomerRole.name())) {
			// display employee related menu
			this.employeeMenu = new JMenu("Employee");
			premiereMenuBar.add(employeeMenu);
			if (databaseRoles.contains(Roles.PR_OfficeRole.name())) {
				this.addEmployeeMenuItem = new JMenuItem("Add Employee");
				this.employeeMenu.add(addEmployeeMenuItem);
				this.addEmployeeMenuItem.addActionListener(new AddEmployeeActionListener());
				this.listEmployeesMenuItem = new JMenuItem("List Employees");
				this.employeeMenu.add(listEmployeesMenuItem);
				this.listEmployeesMenuItem.addActionListener(new ListEmployeesActionListener());

				this.modifyEmployeeMenuItem = new JMenuItem("Modify Employee");
				this.employeeMenu.add(modifyEmployeeMenuItem);
				this.modifyEmployeeMenuItem.addActionListener(new ModifyEmployeeListener());
			}

			if (databaseRoles.contains(Roles.PR_AccountantRole.name())) {
				// Accountant can modify the commission rate
				this.addSalesRepMenuItem = new JMenuItem("Add SalesRep");
				this.employeeMenu.add(addSalesRepMenuItem);
				this.addSalesRepMenuItem.addActionListener(new AddSalesRepActionListener());
				this.modifySalesRepMenuItem = new JMenuItem("Modify SalesRep Data");
				this.employeeMenu.add(modifySalesRepMenuItem);
				this.modifySalesRepMenuItem.addActionListener(new ModifySalesRepListener());
				this.addEmployeeMenuItem = new JMenuItem("Add Employee");
				this.employeeMenu.add(addEmployeeMenuItem);
				this.addEmployeeMenuItem.addActionListener(new AddEmployeeActionListener());
				this.listEmployeesMenuItem = new JMenuItem("List Employees");
				this.employeeMenu.add(listEmployeesMenuItem);
				this.listEmployeesMenuItem.addActionListener(new ListEmployeesActionListener());
			}

			// employees can view data about themselves

			this.employeeMenu.addSeparator(); // add separate between modify
												// operations and list
												// operations
			this.viewEmployeeMenuItem = new JMenuItem("View Employee Data");
			this.employeeMenu.add(viewEmployeeMenuItem);
			this.viewEmployeeMenuItem.addActionListener(new ViewMyEmployeeDataListener());

		}

	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosed(WindowEvent e) {
		System.exit(0); // window close , exit the application
	}

	@Override
	public void windowClosing(WindowEvent e) {
		try {
			dbConnection.close(); // close connection to database
			dispose(); // close and dispose of this window
		} catch (SQLException sqlexception) {
			JOptionPane.showMessageDialog(null, "couldn't close connection to database");
		}

	}

	@Override
	public void windowDeactivated(WindowEvent e) {

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	private class ListCustomersListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			new ListCustomers(dbConnection);

		}

	}

	private class AddCustomerListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			new CustomerEntry(dbConnection);
		}
	}

	private class AddSalesOrderListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {

			new OrderEntry(dbConnection);

		}

	}

	private class ListEmployeesActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			new ListEmployees(dbConnection);

		}

	}
	
	private class ViewPurchasesListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			new ListPurchases(dbConnection);
		}
	}

	private class ViewMyEmployeeDataListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			new ViewEmployeeData(dbConnection);

		}

	}
	
	private class ViewMyCustomerAccountListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			new ViewMyCustomerData(dbConnection);

		}

	}
	
	private class ModifyEmployeeListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			new ModifyEmployee(dbConnection);

		}

	}
	
	private class ModifyCustomerListener implements ActionListener {

		private boolean accountant;
		
		public ModifyCustomerListener(boolean a)
		{
			this.accountant = a;
		}
		@Override
		public void actionPerformed(ActionEvent e) {

			new ModifyCustomer(dbConnection, accountant);

		}

	}
	
	private class ModifySalesRepListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			new ModifySalesRep(dbConnection);

		}

	}
	
	private class ViewCustomerSalesItemListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			new ViewCustomerSalesOrder(dbConnection);

		}

	}
	
	private class ViewSalesItemListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			new ViewSalesOrder(dbConnection);

		}

	}
	
	private class ModifySalesListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			new ModifySalesOrder(dbConnection);

		}

	}
	
	private class CancelSalesListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			new CancelSalesOrder(dbConnection);

		}

	}
	
	private class AddEmployeeActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			new EmployeeEntry(dbConnection);
		}
	}

	private class AddSalesRepActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			new SalesRepEntry(dbConnection);
		}
	}

}
