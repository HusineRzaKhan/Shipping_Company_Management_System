import javax.swing.*;
import org.bson.Document;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GUI {
    private static DatabaseManager dbManager;
    private static JFrame mainFrame;
    public static void java() {
        JFrame f = new JFrame("Frame");
        f.setTitle("Database Operations");
        f.setSize(500, 200);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.setLayout(new FlowLayout());

        String selected[] = {"Accounting_Department","Product", "Container",
                "Shipper", "Manager", "Driver", "Supervisor", "Customer",
                "Warehouses", "Shipment","Shipping_Department" };
        // Create drop-down box
        JComboBox cb = new JComboBox(selected);

        // Create buttons
        JButton insertButton = new JButton("Insert");
        JButton updateButton = new JButton("Update");
        JButton deleteButton = new JButton("Delete");
        JButton viewButton = new JButton("View");

        // Add action listeners to buttons
        insertButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Insert logic
                String selectedTable = (String) cb.getSelectedItem();

                // Perform the insert operation for the selected table
                switch (selectedTable) {
                    case "Accounting_Department":
                        String dname = JOptionPane.showInputDialog("Enter Department Name");
                        int did = Integer.parseInt(JOptionPane.showInputDialog("Enter Department ID:"));
                        int Managerid = Integer.parseInt(JOptionPane.showInputDialog("Enter Manager ID:"));
                        int totalpayments = Integer.parseInt(JOptionPane.showInputDialog("Enter Total Payment:"));
                        int totalcosts = Integer.parseInt(JOptionPane.showInputDialog("Enter Total Costs:"));
                        int totalprofit = Integer.parseInt(JOptionPane.showInputDialog("Enter Total Profit"));
                        String coordinates = JOptionPane.showInputDialog("Enter Address Coordinates:");

                        org.bson.Document document = new org.bson.Document("Name", dname)
                        .append("Department ID", did)
                        .append("Manager ID", Managerid)
                        .append("Total Payments", totalpayments)
                        .append("Total Costs", totalcosts)
                        .append("Total Profit", totalprofit)
                        .append("Coordinates",coordinates) ;
                        
                        AccountingDepartment.add(document);
                        break;

                    case "Product":
                        int pid = Integer.parseInt(JOptionPane.showInputDialog("Enter Product ID"));
                        String pname = JOptionPane.showInputDialog("Enter Product Name:");
                        int TrackingId = Integer.parseInt(JOptionPane.showInputDialog("Enter Tracking ID:"));
                        String description = JOptionPane.showInputDialog("Enter Description:");

                        org.bson.Document doc = new org.bson.Document("Product ID", pid)
                        .append("Name", pname)
                        .append("Tracking ID", TrackingId)
                        .append("Description", description);

                        Product.add(doc);
                        break;


                    case "Container":
                        int regno = Integer.parseInt(JOptionPane.showInputDialog("Enter Registration no"));
                        int noofboxes = Integer.parseInt(JOptionPane.showInputDialog("Enter Number of Boxes:"));
                        int size = Integer.parseInt(JOptionPane.showInputDialog("Enter Registration Number:"));
                        int license= Integer.parseInt(JOptionPane.showInputDialog("Enter Driver Licence Number:"));

                        Document documented = new Document("Reg No", regno)
                        .append("Number of Boxes", noofboxes)
                        .append("Size", size)
                        .append("License", license); 
                        Container.add(documented);

                        break;

                    case "Shipper":
                        int cnic = Integer.parseInt(JOptionPane.showInputDialog("Enter CNIC"));
                        String name = JOptionPane.showInputDialog("Enter Name:");
                        int age = Integer.parseInt(JOptionPane.showInputDialog("Enter Age:"));
                        String designation = JOptionPane.showInputDialog("Enter designation");
                        int salary = Integer.parseInt(JOptionPane.showInputDialog("Enter salary:"));
                        int contact = Integer.parseInt(JOptionPane.showInputDialog("Enter contact:"));
                        int shipperid = Integer.parseInt(JOptionPane.showInputDialog("Enter Shipper ID"));
                        int totaldeliveries = Integer.parseInt(JOptionPane.showInputDialog("Enter total Deliveries:"));
                        int eid = Integer.parseInt(JOptionPane.showInputDialog("Enter Employee ID"));
                        int reamaining = Integer.parseInt(JOptionPane.showInputDialog("Enter remaining deliveries"));
                        int trackingid = Integer.parseInt(JOptionPane.showInputDialog("Enter Tracking Id of Shipment:"));

                        org.bson.Document documentshipper = new org.bson.Document("CNIC",cnic)
                        .append("Name", name)
                        .append("Age", age)
                        .append("Designation", designation)
                        .append("Salary", salary)
                        .append("Contact", contact)
                        .append("Shipper ID", shipperid)
                        .append("Total Deliveries", totaldeliveries)
                        .append("Employee ID", eid)
                        .append("Remaining", reamaining)
                        .append("Tracking ID", trackingid);

                        ShipperEmp.add(documentshipper);

                        break;

                    case "Manager":
                        int Eid = Integer.parseInt(JOptionPane.showInputDialog("Enter Employee ID:"));
                        int Cnic = Integer.parseInt(JOptionPane.showInputDialog("Enter CNIC"));
                        String Name = JOptionPane.showInputDialog("Enter Name:");
                        int Age = Integer.parseInt(JOptionPane.showInputDialog("Enter Age:"));
                        String Designation = JOptionPane.showInputDialog("Enter designation");
                        int Salary = Integer.parseInt(JOptionPane.showInputDialog("Enter salary:"));
                        int Contact = Integer.parseInt(JOptionPane.showInputDialog("Enter contact:"));
                        int mid = Integer.parseInt(JOptionPane.showInputDialog("Enter Manager ID"));
                        int bonus = Integer.parseInt(JOptionPane.showInputDialog("Enter bonus payment:"));
                        String Coordinates = JOptionPane.showInputDialog("Enter Address Coordinates");

                        org.bson.Document Document = new org.bson.Document("CNIC",Cnic)
                        .append("Name", Name)
                        .append("Age", Age)
                        .append("Designation", Designation)
                        .append("Salary", Salary)
                        .append("Contact", Contact)
                        .append("ManagerID", mid)
                        .append("Bonus", bonus)
                        .append("Employee ID", Eid)
                        .append("Coordinates",Coordinates);

                        Manager.add(Document);
                        break;

                    case "Shipment":
                        int tid = Integer.parseInt(JOptionPane.showInputDialog("Enter Tracking id"));
                        int weight = Integer.parseInt(JOptionPane.showInputDialog("Enter Weight in kg:"));
                        int charges = Integer.parseInt(JOptionPane.showInputDialog("Enter Charges:"));
                        int cid = Integer.parseInt(JOptionPane.showInputDialog("Enter Customer Id"));
                        int wno = Integer.parseInt(JOptionPane.showInputDialog("Enter Warehouse number"));
                        int Regno= Integer.parseInt(JOptionPane.showInputDialog("Enter Container Reg Number"));
                        int sid = Integer.parseInt(JOptionPane.showInputDialog("Enter Shipper Id"));
                        int Pid = Integer.parseInt(JOptionPane.showInputDialog("Enter Product ID:"));

                        org.bson.Document docum = new org.bson.Document("Tracking ID",tid)
                        .append("Weight", weight)
                        .append("Charges", charges)
                        .append("Customer ID",cid)
                        .append("Warehouse Num",wno)
                        .append("Shipper ID", sid)
                        .append("Product ID", Pid)
                                .append("Registration Number",Regno);

                        Shipment.add(docum);

                        break;

                    case "Driver":
                        int EId = Integer.parseInt(JOptionPane.showInputDialog("Enter Employee ID:"));
                        int CNic = Integer.parseInt(JOptionPane.showInputDialog("Enter CNIC"));
                        String NAme = JOptionPane.showInputDialog("Enter Name:");
                        int AGe = Integer.parseInt(JOptionPane.showInputDialog("Enter Age:"));
                        String DEsignation = JOptionPane.showInputDialog("Enter designation");
                        int SAlary = Integer.parseInt(JOptionPane.showInputDialog("Enter salary:"));
                        int COntact = Integer.parseInt(JOptionPane.showInputDialog("Enter contact:"));
                        int Licenseno = Integer.parseInt(JOptionPane.showInputDialog("Enter license number"));
                        
                        org.bson.Document Docum = new org.bson.Document("CNIC", CNic)
                        .append("Name", NAme)
                        .append("Employee ID", EId)
                        .append("Age", AGe)
                        .append("Designation", DEsignation)
                        .append("Salary", SAlary)
                        .append("Contact",COntact)
                        .append("License", Licenseno);

                        Driver.add(Docum);

                        break;

                    case "Supervisor":
                        int EID = Integer.parseInt(JOptionPane.showInputDialog("Enter Eomplyee ID:"));
                        int CNIc = Integer.parseInt(JOptionPane.showInputDialog("Enter CNIC"));
                        String NAMe = JOptionPane.showInputDialog("Enter Name:");
                        int AGE = Integer.parseInt(JOptionPane.showInputDialog("Enter Age:"));
                        String DESignation = JOptionPane.showInputDialog("Enter designation");
                        int SALary = Integer.parseInt(JOptionPane.showInputDialog("Enter salary:"));
                        int CONtact = Integer.parseInt(JOptionPane.showInputDialog("Enter contact:"));
                        String supid = JOptionPane.showInputDialog("Enter supervisor ID");
                        int Wno = Integer.parseInt(JOptionPane.showInputDialog("Enter bWarehouse Number:"));
                        int Bonus = Integer.parseInt(JOptionPane.showInputDialog("Enter Bonus Amount:"));

                        org.bson.Document documen = new org.bson.Document("Employee ID",EID)
                                .append("CNIC",CNIc)
                                .append("Name",NAMe)
                                .append("Age",AGE)
                                .append("Designation",DESignation)
                                .append("Salary",SALary)
                                .append("Contact",CONtact)
                                .append("Supervisor ID",supid)
                                .append("Warehouse Number",Wno)
                                .append("Bonus",Bonus);

                        Supervisor.add(documen);
                        break;

                    case "Warehouses":
                        int WNo = Integer.parseInt(JOptionPane.showInputDialog("Enter ware house no"));
                        int Did = Integer.parseInt(JOptionPane.showInputDialog("Enter Shipping Department Id"));
                        String openingtime = JOptionPane.showInputDialog("Enter opening time:");
                        String closingtime = JOptionPane.showInputDialog("Enter closing time:");
                        int cord = Integer.parseInt(JOptionPane.showInputDialog("Enter Address Coordinates:"));
                        int supID = Integer.parseInt(JOptionPane.showInputDialog("Enter Supervisor ID:"));

                        org.bson.Document Documen = new org.bson.Document("Warehouse Number",WNo)
                                .append("Department ID",Did)
                                .append("Opening Time",openingtime)
                                .append("Closing Time",closingtime)
                                .append("Coordinates",cord)
                                .append("Supervisor ID",supID);

                        Warehouse.add(Documen);
                        
                        break;

                    case "Customer":
                        int CNIC = Integer.parseInt(JOptionPane.showInputDialog("Enter CNIC"));
                        String NAME = JOptionPane.showInputDialog("Enter Name:");
                        int cAGE = Integer.parseInt(JOptionPane.showInputDialog("Enter Age:"));
                        int CONTact = Integer.parseInt(JOptionPane.showInputDialog("Enter Contact:"));
                        int CID = Integer.parseInt(JOptionPane.showInputDialog("Enter Customer id"));

                        org.bson.Document DocumenT = new org.bson.Document("CNIC",CNIC)
                                .append("Name",NAME)
                                .append("Age",cAGE)
                                .append("Contact",CONTact)
                                .append("Customer ID",CID);

                        Customer.add(DocumenT);
                        break;

                    case "Shipping_Department":
                        String NAME1 = JOptionPane.showInputDialog("Enter Name:");
                        int depid = Integer.parseInt(JOptionPane.showInputDialog("Enter Department ID:"));
                        int totalofficeS = Integer.parseInt(JOptionPane.showInputDialog("Enter Total Offices:"));
                        int supervisorid = Integer.parseInt(JOptionPane.showInputDialog("Enter Supervisor ID"));
                        int warehouseno = Integer.parseInt(JOptionPane.showInputDialog("Enter Warehouse Number"));

                        org.bson.Document DocumenT1 = new org.bson.Document("Name",NAME1)
                                .append("Department ID",depid)
                                .append("Total Offices",totalofficeS)
                                .append("Supervisor ID", supervisorid)
                                .append("Warehouse Number", warehouseno);

                        ShippingDept.add(DocumenT1);
                        break;

                }
            }
        });
                

        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Insert logic
                String selectedTable = (String) cb.getSelectedItem();

                // Perform the insert operation for the selected table
                switch (selectedTable) {
                    case "Accounting_Department":
                        int did = Integer.parseInt(JOptionPane.showInputDialog("Enter Department ID of which details are to update"));
                        String dname = JOptionPane.showInputDialog("Enter Department Name");
                        int mID = Integer.parseInt(JOptionPane.showInputDialog("Enter Manager ID"));
                        int totalpayments = Integer.parseInt(JOptionPane.showInputDialog("Enter Total Payment:"));
                        int totalcosts = Integer.parseInt(JOptionPane.showInputDialog("Enter Total Costs:"));
                        int totalprofit = Integer.parseInt(JOptionPane.showInputDialog("Enter Total Profit"));
                        String coordinates = JOptionPane.showInputDialog("Enter Address Coordinates:");

                        Document filter1 = new Document("Department ID", did);
                        Document update1 = new Document("$set", new Document("Name", dname)
                        .append("Manager ID", mID)
                        .append("Total Payments", totalpayments)
                        .append("Total Costs", totalcosts)
                        .append("Total Profit", totalprofit)
                        .append("Coordinates", coordinates));
                        
                        AccountingDepartment.update(filter1, update1);
                        break;

                    case "Customer":
                        int CNIC = Integer.parseInt(JOptionPane.showInputDialog("Enter CNIC of Customer whose details are to change"));
                        String NAME = JOptionPane.showInputDialog("Enter Name:");
                        int cAGE = Integer.parseInt(JOptionPane.showInputDialog("Enter Age:"));
                        int CONTact = Integer.parseInt(JOptionPane.showInputDialog("Enter Contact:"));

                        Document filter2 = new Document("CNIC",CNIC);
                        Document update2 = new Document("$set",new Document("Name", NAME)
                        .append("Age", cAGE)
                        .append("Contact", CONTact));

                        Customer.update(filter2, update2);
                        break;

                    case "Warehouses":
                        int WNo = Integer.parseInt(JOptionPane.showInputDialog("Enter warehouse no of which details are to change"));
                        String openingtime = JOptionPane.showInputDialog("Enter opening time:");
                        String closingtime = JOptionPane.showInputDialog("Enter closing time:");
                        int Coordinates = Integer.parseInt(JOptionPane.showInputDialog("Enter Coordinates"));
                        int supervisorID = Integer.parseInt(JOptionPane.showInputDialog("Enter Supervisor ID"));
                        
                        Document filter3 = new Document("Warehouse Number", WNo);
                        Document update3 = new Document("$set", new Document("Opening Time", openingtime)
                        .append("Closing Time", closingtime)
                        .append("Coordinates", Coordinates)
                        .append("Supervisor ID", supervisorID));

                        Warehouse.update(filter3, update3);
                        break;

                    case "Supervisor":
                        int EID = Integer.parseInt(JOptionPane.showInputDialog("Enter Eomplyee ID whose details are to change"));
                        String NAMe = JOptionPane.showInputDialog("Enter Name:");
                        int AGE = Integer.parseInt(JOptionPane.showInputDialog("Enter Age:"));
                        String DESignation = JOptionPane.showInputDialog("Enter designation");
                        int SALary = Integer.parseInt(JOptionPane.showInputDialog("Enter salary:"));
                        int CONtact = Integer.parseInt(JOptionPane.showInputDialog("Enter contact:"));
                        int warehousenum = Integer.parseInt(JOptionPane.showInputDialog("Enter Warehouse Number"));
                        int bonus = Integer.parseInt(JOptionPane.showInputDialog("Enter Bonus"));

                        Document filter4 = new Document("Employee ID",EID);
                        Document update4 = new Document("$set", new Document("Name", NAMe)
                        .append("Age", AGE)
                        .append("Designation", DESignation)
                        .append("Salary", SALary)
                        .append("Contact", CONtact)
                        .append("Warehouse Number", warehousenum)
                        .append("Bonus", bonus));
                        

                        Supervisor.update(filter4, update4);
                        break;

                    case "Driver":
                        int EId = Integer.parseInt(JOptionPane.showInputDialog("Enter Employee ID whose information is to change"));
                        String NAme = JOptionPane.showInputDialog("Enter Name:");
                        int AGe = Integer.parseInt(JOptionPane.showInputDialog("Enter Age:"));
                        String DEsignation = JOptionPane.showInputDialog("Enter designation");
                        int SAlary = Integer.parseInt(JOptionPane.showInputDialog("Enter salary:"));
                        int COntact = Integer.parseInt(JOptionPane.showInputDialog("Enter contact:"));
                        
                        Document filter5 = new Document("Employee ID",EId);
                        Document update5 = new Document("$set", new Document("Name", NAme)
                        .append("Age", AGe)
                        .append("Designation", DEsignation)
                        .append("Salary", SAlary)
                        .append("Contact", COntact));

                        Driver.update(filter5, update5);
                        break;
                    
                    case "Shipment":
                        int tid = Integer.parseInt(JOptionPane.showInputDialog("Enter Tracking id of shipment of which information is to change"));
                        int weight = Integer.parseInt(JOptionPane.showInputDialog("Enter Weight in kg:"));
                        int charges = Integer.parseInt(JOptionPane.showInputDialog("Enter Charges:"));
                        int cid = Integer.parseInt(JOptionPane.showInputDialog("Enter Customer Id"));
                        int wno = Integer.parseInt(JOptionPane.showInputDialog("Enter Warehouse number"));
                        int Regno= Integer.parseInt(JOptionPane.showInputDialog("Enter Container Reg Number"));
                        int sid = Integer.parseInt(JOptionPane.showInputDialog("Enter Shipper Id"));
                        int Pid = Integer.parseInt(JOptionPane.showInputDialog("Enter Product ID:"));

                        Document filter6 = new Document("Tracking ID", tid);
                        Document update6 = new Document("$set", new Document("Weight", weight)
                        .append("Charges", charges)
                        .append("Customer ID", cid)
                        .append("Warehouse Number", wno)
                        .append("Container Registration Number", Regno)
                        .append("Shipper ID", sid)
                        .append("Product ID", Pid));

                        Shipment.update(filter6, update6);
                        break;
                    
                     case "Manager":
                        int Eid = Integer.parseInt(JOptionPane.showInputDialog("Enter Employee ID whose information is to change:"));
                        String Name = JOptionPane.showInputDialog("Enter Name:");
                        int Age = Integer.parseInt(JOptionPane.showInputDialog("Enter Age:"));
                        String Designation = JOptionPane.showInputDialog("Enter designation");
                        int Salary = Integer.parseInt(JOptionPane.showInputDialog("Enter salary:"));
                        int Contact = Integer.parseInt(JOptionPane.showInputDialog("Enter contact:"));
                        int Bonus = Integer.parseInt(JOptionPane.showInputDialog("Enter bonus payment:"));
                        String COordinates = JOptionPane.showInputDialog("Enter Address Coordinates");

                        Document filter7 = new Document("Employee ID", Eid);
                        Document update7 = new Document("$set",new Document("Name", Name)
                        .append("Age", Age)
                        .append("Designation", Designation)
                        .append("Salary",Salary)
                        .append("Contact", Contact)
                        .append("Bonus", Bonus)
                        .append("Coordinates", COordinates));

                        Manager.update(filter7, update7);
                        break;

                    case "Shipper":
                        int eid = Integer.parseInt(JOptionPane.showInputDialog("Enter Employee ID whose information is to change"));
                        String name = JOptionPane.showInputDialog("Enter Name:");
                        int age = Integer.parseInt(JOptionPane.showInputDialog("Enter Age:"));
                        String designation = JOptionPane.showInputDialog("Enter designation");
                        int salary = Integer.parseInt(JOptionPane.showInputDialog("Enter salary:"));
                        int contact = Integer.parseInt(JOptionPane.showInputDialog("Enter contact:"));
                        int totaldeliveries = Integer.parseInt(JOptionPane.showInputDialog("Enter total Deliveries:"));
                        int remainingDeleveries = Integer.parseInt(JOptionPane.showInputDialog("Enter remaining deliveries"));
                        int trackingid = Integer.parseInt(JOptionPane.showInputDialog("Enter Tracking Id of Shipment:"));

                        Document filter8 = new Document("Employee ID", eid);
                        Document update8 = new Document("$set", new Document("Name", name)
                        .append("Age", age)
                        .append("Designation", designation)
                        .append("Salary", salary)
                        .append("Contact", contact)
                        .append("Total Deliveries", totaldeliveries)
                        .append("Remaining Deliveries", remainingDeleveries)
                        .append("Tracking ID", trackingid));

                        ShipperEmp.update(filter8,update8);
                        break;

                    case "Container":
                        int regno = Integer.parseInt(JOptionPane.showInputDialog("Enter Registration no of Container of which information is to change"));
                        int noofboxes = Integer.parseInt(JOptionPane.showInputDialog("Enter Number of Boxes:"));
                        int size = Integer.parseInt(JOptionPane.showInputDialog("Enter Size:"));
                        int license= Integer.parseInt(JOptionPane.showInputDialog("Enter Driver Licence Number:"));

                        Document filter9 = new Document("Reg No", regno);
                        Document update9 = new Document("$set", new Document("Number of Boxes", noofboxes)
                        .append("Size", size)
                        .append("License", license));
                        
                        Container.update(filter9, update9);
                        break;

                    case "Product":
                        int pid = Integer.parseInt(JOptionPane.showInputDialog("Enter Product ID of which information is to change"));
                        String pname = JOptionPane.showInputDialog("Enter Product Name:");
                        int TrackingId = Integer.parseInt(JOptionPane.showInputDialog("Enter Tracking ID:"));
                        String description = JOptionPane.showInputDialog("Enter Description:");

                        Document filter10 = new Document("Product ID", pid);
                        Document update10 = new Document("$set", new Document("Name", pname)
                        .append("Tracking ID", TrackingId)
                        .append("Description", description));
                        
                        Product.update(filter10, update10);
                        break;

                    case "Shipping_Department":
                        int depid = Integer.parseInt(JOptionPane.showInputDialog("Enter Department ID of which information is to change:"));
                        String NAME1 = JOptionPane.showInputDialog("Enter Name:");
                        int totalofficeS = Integer.parseInt(JOptionPane.showInputDialog("Enter Total Offices:"));
                        int supervisorid = Integer.parseInt(JOptionPane.showInputDialog("Enter Supervisor ID"));
                        int warehouseno = Integer.parseInt(JOptionPane.showInputDialog("Enter Warehouse Number"));

                        Document filter11 = new Document("Department ID",depid);
                        Document update11 = new Document("$set", new Document("Name", NAME1)
                        .append("Department ID", depid)
                        .append("Total Offices", totalofficeS)
                        .append("Supervisor ID", supervisorid)
                        .append("Warehouse Number", warehouseno));

                        ShippingDept.update(filter11, update11);
                }
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Update logic
                String selectedTable = (String) cb.getSelectedItem();

                // Perform the update operation for the selected table
                switch (selectedTable) {
                    case "Accounting_Department":
                        int did = Integer.parseInt(JOptionPane.showInputDialog("Enter Department ID that is to be deleted:"));
                       
                        Document filter1 = new Document("Department ID", did);
                        AccountingDepartment.delete(filter1);
                        break;

                     case "Shipping_Department":
                        int Sid = Integer.parseInt(JOptionPane.showInputDialog("Enter Department ID that is to be deleted:"));
                       
                        Document filter2 = new Document("Department ID", Sid);
                        ShippingDept.delete(filter2);
                        break;

                    case "Product":
                        int pid = Integer.parseInt(JOptionPane.showInputDialog("Enter Product ID that is to be deleted"));
                         
                        Document filter3 = new Document("Product ID", pid);
                        Product.delete(filter3);
                        break;

                    case "Container":
                        int regno = Integer.parseInt(JOptionPane.showInputDialog("Enter Reg no of container that is to be deleted"));
                        
                        Document filter4 = new Document("Registration Number", regno);
                        Container.delete(filter4);
                        break;

                    case "Shipper":
                        int sid = Integer.parseInt(JOptionPane.showInputDialog("Enter Shipper ID who is to be deleted:"));
                        
                        Document filter5 = new Document("Shipper ID", sid);
                        ShipperEmp.delete(filter5);
                        break;

                    case "Manager":
                        int mid = Integer.parseInt(JOptionPane.showInputDialog("Enter Manager ID who is to be deleted:"));
                        
                        Document filter6 = new Document("Manager ID", mid);
                        Manager.delete(filter6);
                        break;

                    case "Shipment":
                        int tid = Integer.parseInt(JOptionPane.showInputDialog("Enter tracking ID of shipment that is to be deleted"));
                        
                        Document filter7 = new Document("Tracking ID", tid);
                        Shipment.delete(filter7);
                        break;

                    case "Driver":
                        int licenseno = Integer.parseInt(JOptionPane.showInputDialog("Enter license number of driver that is to be deleted"));
                        
                        Document filter8 = new Document("License Number", licenseno);
                        Driver.delete(filter8);
                        break;

                    case "Supervisor":
                        int supid = Integer.parseInt(JOptionPane.showInputDialog("Enter supervisor ID who is to be deleted:"));
                        
                        Document filter9 = new Document("Supervisor ID", supid);
                        Supervisor.delete(filter9);
                        break;

                    case "Warehouses":
                        int wno = Integer.parseInt(JOptionPane.showInputDialog("Enter ware house no that is to be deleted"));
                        
                        Document filter10 = new Document("Warehouse Number", wno);
                        Warehouse.delete(filter10);
                        break;

                    case "Customer":
                        int cid = Integer.parseInt(JOptionPane.showInputDialog("Enter customer ID who is to be deleted:"));
                        
                        Document filter11 = new Document("Customer ID", cid);
                        Customer.delete(filter11);
                        break;

                    // Add cases for other tables as needed
                    default:
                        break;
                }
            }
        });

        viewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Update logic
                String selectedTable = (String) cb.getSelectedItem();

                // Perform the update operation for the selected table
                switch (selectedTable) {
                    case "Accounting_Department":
                    int did = Integer.parseInt(JOptionPane.showInputDialog("Enter Department ID"));
                       
                        Document filter1 = new Document("Department ID", did);
                        AccountingDepartment.view(filter1);
                        break;

                     case "Shipping_Department":
                        int Sid = Integer.parseInt(JOptionPane.showInputDialog("Enter Department ID"));
                       
                        Document filter2 = new Document("Department ID", Sid);
                        ShippingDept.view(filter2);
                        break;

                    case "Product":
                        int pid = Integer.parseInt(JOptionPane.showInputDialog("Enter Product ID"));
                         
                        Document filter3 = new Document("Product ID", pid);
                        Product.view(filter3);
                        break;

                    case "Container":
                        int regno = Integer.parseInt(JOptionPane.showInputDialog("Enter Reg no of container"));
                        
                        Document filter4 = new Document("Registration Number", regno);
                        Container.view(filter4);
                        break;

                    case "Shipper":
                        int sid = Integer.parseInt(JOptionPane.showInputDialog("Enter Shipper ID"));
                        
                        Document filter5 = new Document("Shipper ID", sid);
                        ShipperEmp.view(filter5);
                        break;

                    case "Manager":
                        int mid = Integer.parseInt(JOptionPane.showInputDialog("Enter Manager ID"));
                        
                        Document filter6 = new Document("Manager ID", mid);
                        Manager.view(filter6);
                        break;

                    case "Shipment":
                        int tid = Integer.parseInt(JOptionPane.showInputDialog("Enter tracking ID"));
                        
                        Document filter7 = new Document("Tracking ID", tid);
                        Shipment.view(filter7);
                        break;

                    case "Driver":
                        int licenseno = Integer.parseInt(JOptionPane.showInputDialog("Enter license number of driver"));
                        
                        Document filter8 = new Document("License Number", licenseno);
                        Driver.view(filter8);
                        break;

                    case "Supervisor":
                        int supid = Integer.parseInt(JOptionPane.showInputDialog("Enter supervisor ID"));
                        
                        Document filter9 = new Document("Supervisor ID", supid);
                        Supervisor.view(filter9);
                        break;

                    case "Warehouses":
                        int wno = Integer.parseInt(JOptionPane.showInputDialog("Enter warehouse no"));
                        
                        Document filter10 = new Document("Warehouse Number", wno);
                        Warehouse.view(filter10);
                        break;

                    case "Customer":
                        int cid = Integer.parseInt(JOptionPane.showInputDialog("Enter Customer ID"));
                        
                        Document filter11 = new Document("Customer ID", cid);
                        Customer.view(filter11);
                        break;
                    default:
                        break;
                }
            }
        });


        // Add components to the frame
        f.add(cb);
        f.add(insertButton);
        f.add(updateButton);
        f.add(deleteButton);
        f.add(viewButton);
        f.setVisible(true);
    }
}