package Assignment;

import javafx.collections.FXCollections; 
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.net.URL;
import java.sql.*;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class ModifyPerson implements DB_Vars{
	private Connection con;
	private Statement st;
	private String name;
	private String address;
	private String phone;
	ObservableList<Person> data = FXCollections.observableArrayList();
	private Alert ual = new Alert(Alert.AlertType.INFORMATION);
		


    @FXML
    private Button PersonID;

    @FXML
    private TextField PersonName;

    @FXML
    private TextField PersonAddress;

    @FXML
    private TextField Phone;

    @FXML
    private Button submit;
    
    @FXML
    private Label result;

    public void getPersonDetails(){
    	
    	
         name = PersonName.getText();
         address = PersonAddress.getText();
         phone = Phone.getText();
        
    }
    
         
         
    
    
    @FXML
    void Submit_Button(ActionEvent event) {
    	
    	
    	try {
    		
    		getPersonDetails();
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, uname,upass);
			
			String sql = "select Id, Name, Address, Phone from "
					+ "addbook where Name like '%"+name+"%'";
			
			Statement st = null;
			st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			
			
			ResultSet rs = st.executeQuery(sql);
			
		if(ValidateDetails()) {
			getPersonDetails();
			Person p1 = new Person(); 

	         p1.setName(name);
	         p1.setAddress(address);
	         p1.setPhone(phone);
			
	         
			
			while(rs.next()) {
				rs.updateString(2,p1.getName());
				rs.updateString(3,p1.getAddress());
				rs.updateString(4,p1.getPhone());
				rs.updateRow();
			
		    	result.setText(" Inserted Succesful ");
		    	
			}
}
    	}
    	catch(SQLException | ClassNotFoundException e) {
    		e.printStackTrace();
    	}
			
    }

    

	private void start(Stage primaryStage) throws Exception {
		
		URL res = this.getClass().getResource("ModifyPersonfx.fxml");
		Parent root = FXMLLoader.load(res);
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.sizeToScene();
		primaryStage.setTitle("Modify Person");
		primaryStage.show();
		
	}
	private  boolean ValidateDetails() {
		getPersonDetails();
		boolean success = true;
		
		
		if(name.contains(" ") | name.contains("1") | name.contains("2") |
				name.contains("3") | name.contains("4") | name.contains("5")
				| name.contains("5") | name.contains("6") | name.contains("7")
				| name.contains("8") |  name.contains("9") | name.contains("0")
				| name.contains("!@#$%^|*()_+:;'?/|.<,")
				
				) {
			
		 ual.setTitle("Incomplete Data Input");
         
		 ual.setHeaderText(null);
         
         ual.setContentText("Please fill valid data in Name field");
         
         ual.showAndWait();
         success =  false;
         
		}
		
		else if(address.contains(" ") | address.contains("!@#$%^|*()_+:;'?/|.<,") ) {
				 
				 ual.setTitle("Incomplete Address Input");
				 ual.setHeaderText(null);
		         ual.setContentText("Please enter valid  data in Address field");
		         ual.showAndWait();
		         success = false;
		         
				}
		else if(phone.contains(" ") | phone.contains("!@#$%^|*()_+:;'?/|.<,") | phone.length() < 10  | phone.length() > 10) {
			
			 ual.setTitle("Incomplete Phone Input");
			 ual.setHeaderText(null);
	         ual.setContentText("Please Enter Valid data in Phone field");
	         ual.showAndWait();
	         success = false;
	        }
	
		
		
		else {
		
			success = true;
		}
		
		return success;
			
		
		}
		
		
		
		
		
	}
	
	
	
	
   


