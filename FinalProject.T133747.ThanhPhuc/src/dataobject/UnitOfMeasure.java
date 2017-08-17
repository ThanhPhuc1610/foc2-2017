package dataobject;

public class UnitOfMeasure {
	public UnitOfMeasure(int id, String Name) {
		super();
		this.id = id;
		this.Name = Name;
	}
	private int id;
	private String Name;
	
	public int getId() {
		return id;
	} 
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setBrandName(String Name) {
		this.Name = Name;
	}
	@Override
	public String toString() {
		return Name;
	}
	
}
