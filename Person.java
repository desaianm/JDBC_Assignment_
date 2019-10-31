package Assignment;


public class Person {
	private int id;
	private String name;
	private String Address;
	private String Phone;
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int Id) {
		this.id = id ;
	}
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	public void setAddress(String Address) {
		this.Address = Address;
	}
	public String getAddress() {
		return Address;
	}
	
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String Phone) {
		this.Phone = Phone;
	}
	
	public Person(int id,String name,String address,String phone) {
		super();
		this.id = id;
		this.name = name;
		this.Address = address;
		this.Phone = phone;
	
	}

	public Person() {
		
	}
	 
}
