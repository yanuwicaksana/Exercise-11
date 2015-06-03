package subway;

public class Connection {
	private Station station1,station2;
	private String linename;
	private boolean available;
	
	public Connection(Station station1, Station station2, String linename){
		this.station1 = station1;
		this.station2 = station2;
		this.linename = linename;
		this.available = true;
		
	}
	
	public Station getStation1(){
		return station1;
	}
	
	public Station getStation2(){
		return station2;
	}
	
	public String getLineName(){
		return linename;
	}
	
	public boolean getAvailable(){
		return available;
	}
	
	public void setAvailable(boolean bool){
		this.available = bool;
	}
}
