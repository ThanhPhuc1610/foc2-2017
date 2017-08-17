package dataobject;

public class Brand {
	public Brand(int id, String brandName) {
		super();
		this.id = id;
		this.brandName = brandName;
	}
	private int id;
	private String brandName;
	
	public int getId() {
		return id;
	} 
	public void setId(int id) {
		this.id = id;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	@Override
	public String toString() {
		return brandName;
	}
	
}
