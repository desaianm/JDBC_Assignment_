package Assignment;


import javafx.scene.control.TextArea;   

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;





public class BookController implements DB_Vars {
	
		Person p = new Person(); 
		static int id;
		private String Name;
		private String Address;
		private String Phone;
		private Connection con;
		private Statement st;
		ObservableList<Person> data = FXCollections.observableArrayList();
		private FXMLLoader fxmlLoader = null;
	    private Parent root1=null;
	    private Stage stage=null;

		
		
		@FXML
	    private Button Search_Button;

	    @FXML
	    private Button Modify_Button;

	    @FXML
	    private Button delete_Button;

	    @FXML
	    private Button Store_Button;

	    @FXML
	    private TextField Input;

	    @FXML
	    private TableView<Person> Display_Table;
	    
	    @FXML
	    private TableColumn<Person,Integer> id_column;

	    @FXML
	    private TableColumn<Person,String> name_column;

	    @FXML
	    private TableColumn<Person,String> address_column;

	    @FXML
	    private TableColumn<Person,String> phone_column;
	    
	    @FXML
	    private Button reset_btn;
	    
	    
	    @FXML
	    private Button exit_btn;

	    
	    
	    
	    @FXML
	    void exit_Button(ActionEvent event) {
	    	System.exit(0);
	    }

	    @FXML
	    void reset_button(ActionEvent event) {
	    	Display_Table.getItems().clear();
	    	
	    }
	    
	    
	    @FXML
	    void delete_Button(ActionEvent event)  {
	    	int input = Integer.parseInt(Input.getText());	
    	
    	try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, uname,upass);
			Statement st = null;
			st = con.createStatement();
			
			String sql = " delete  from addbook  "
					+ " where Id like '%"+input+"%'";
			
			int res = st.executeUpdate(sql);
			
			
			
		} catch ( SQLException | ClassNotFoundException e) {
			
			e.printStackTrace();
		}
    	
	    }
   
	    @FXML
	    void Modify_Button(ActionEvent event) {
	    	try {
	    		
	            fxmlLoader = new FXMLLoader(getClass().getResource("ModifyPersonfx.fxml"));
	            root1 = (Parent) fxmlLoader.load();
	            stage = new Stage();
	            stage.setTitle(" Update Data ");
	            stage.setScene(new Scene(root1));
	            stage.show();
	            
	        }catch (Exception e){
	            e.printStackTrace();
	        }
	    	
	    	
        
	    }

	    @FXML
	    void Search_Button(ActionEvent event) {
	    	
	    	Display_Table.getItems().clear();
	    	String input = Input.getText();	
	    	
	    	try {
				Class.forName(driver);
				Connection con = DriverManager.getConnection(url, uname,upass);
				Statement st = null;
				st = con.createStatement();
				
				String sql = " select * from addbook  "
						+ " where Name like '%"+input+"%' or Address like '%"+input+"%'";
				ResultSet rs = st.executeQuery(sql);
				
				while (rs.next()) {
	                data.add(new Person(rs.getInt(1), 
	                		rs.getString(2), rs.getString(3),rs.getString(4)));
	                
	            }
				
				
			} catch ( SQLException | ClassNotFoundException e) {
				
				e.printStackTrace();
			}
	    	Display_Table.setItems(null);
	    
	    	
    	id_column.setCellValueFactory(new PropertyValueFactory<>("id"));
    	name_column.setCellValueFactory(new PropertyValueFactory<>("name"));
        address_column.setCellValueFactory(new PropertyValueFactory<>("address"));
        phone_column.setCellValueFactory(new PropertyValueFactory<>("phone"));
        
        Display_Table.setItems(data);
    	
	    	
	    }

	    @FXML
	    void Store_Button(ActionEvent event) {
	    	
	    	try {
	    		
	            fxmlLoader = new FXMLLoader(getClass().getResource("AddPerson.fxml"));
	            root1 = (Parent) fxmlLoader.load();
	            stage = new Stage();
	            stage.setTitle(" Add New  Person ");
	            stage.setScene(new Scene(root1));
	            stage.show();
	            
	        }catch (Exception e){
	            e.printStackTrace();
	        }
	    	
	    	
	    }


	      public void initialize() {
	    	  try {
					Class.forName(driver);
					Connection con = DriverManager.getConnection(url, uname,upass);
					Statement st = null;
					st = con.createStatement();
					
					String sql = "select * from addbook";
					ResultSet rs = st.executeQuery(sql);
					
					while (rs.next()) {
		                data.add(new Person(rs.getInt(1), 
		                		rs.getString(2), rs.getString(3),rs.getString(4)));
		                
		            }
					
					
				} catch (SQLException | ClassNotFoundException e) {
					
					e.printStackTrace();
				}
	    	id_column.setCellValueFactory(new PropertyValueFactory<>("id"));
	    	name_column.setCellValueFactory(new PropertyValueFactory<>("name"));
	        address_column.setCellValueFactory(new PropertyValueFactory<>("address"));
	        phone_column.setCellValueFactory(new PropertyValueFactory<>("phone"));
	        Display_Table.setItems(null);
	        Display_Table.setItems(data);
	    	
	    	
	    }
	    
	    
		
	   
	    
}

	    
	    
	    
