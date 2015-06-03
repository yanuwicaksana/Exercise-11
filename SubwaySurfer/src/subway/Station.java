package subway;

public class Station {
	private String name;
	private boolean available;
	
	
	public Station(String name){
		this.name = name;
		this.available = true;
	}
	
	public String getName(){
		return name;
	}
	
	@Override
	public boolean equals(Object otherobj){
		if (otherobj instanceof Station){
			Station otherstation = (Station) otherobj;
			if(otherstation.getName().equalsIgnoreCase(name)) return true;
		}
		return false;
	}
	
	public int hashCode(){
		return name.toLowerCase().hashCode();
	}
	
	public boolean getAvailable(){
		return available;
	}
	
	public void setAvailable(boolean bool){
		this.available = bool;
	}
}
