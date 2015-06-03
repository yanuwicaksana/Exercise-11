package subway;

import java.util.*;

public class Subway
{
    public List stations;
    public List connections;
    private Map network;
    
    public Subway() {
        this.stations = new LinkedList();
        this.connections = new LinkedList();
        this.network = new HashMap();
    }
    
    public void addStation(String stationName) {
        if (!this.hasStation(stationName)) {
            Station station = new Station(stationName);
            stations.add(station);
        }
    }
    
    public boolean hasStation(String stationName) {
        if(stations.contains(new Station(stationName))){
        	for (Iterator i = stations.iterator(); i.hasNext(); ){
        		Station newstation = (Station) i.next();
        		if (newstation.getName().equalsIgnoreCase(stationName) && newstation.getAvailable()){
        			return true;
        		}
        	}
        }
        return false;
    }
    
    // Method addConnection is missing
    // TODO: Create Method addConnection
    
    public Connection addConnection(String station1name, String station2name, String linename){
    	if((this.hasStation(station1name) && this.hasStation(station2name))){
    		Station stationone = new Station(station1name);
    		Station stationtwo = new Station(station2name);
    		Connection connection = new Connection(stationone,stationtwo,linename);
    		connections.add(connection);
    		connections.add(new Connection(stationtwo,stationone,linename));
    		
    		addToNetwork(stationone,stationtwo);
    		addToNetwork(stationtwo,stationone);
    		return connection;
    		
    	} else{
			throw new RuntimeException("Invalid connection!");
		}
    }
    
    private void addToNetwork(Station station1, Station station2) {
        if (network.keySet().contains(station1)) {
            List connectingStations = (List) network.get(station1);
            if (!connectingStations.contains(station2)) {
                connectingStations.add(station2);
            }
        } else {
            List connectingStations = new LinkedList();
            connectingStations.add(station2);
            network.put(station1, connectingStations);
        }
    }
    
    public List getDirections(String startStationName, String endStationName) {
        if (!this.hasStation(startStationName) || !this.hasStation(endStationName))
        {
            throw new RuntimeException("Stations entered do not exist on this subway");
        }
        
        Station start = new Station(startStationName);
        Station end = new Station(endStationName);
        List route = new LinkedList();
        List reachableStations = new LinkedList();
        Map previousStations = new HashMap();
        List neighbors = (List)network.get(start);
        
        for (Iterator i = neighbors.iterator(); i.hasNext(); ) {
            Station station = (Station) i.next();
            if (station.equals(end)) {
                route.add(getConnection(start, end));
                return route;
            } else {
                reachableStations.add(station);
                previousStations.put(station, start);
            }
        }
        
        List nextStations = new LinkedList();
        nextStations.addAll(neighbors);
        Station currentStation = start;
        
        searchLoop:
        for (int i = 1; i < stations.size(); i++) {
            List tmpNextStations = new LinkedList();
            secondLoop:
            for (Iterator j = nextStations.iterator(); j.hasNext(); ) {
                Station station = (Station) j.next();
                reachableStations.add(station);
                currentStation = station;
                List currentNeighbors = (List) network.get(currentStation);
                //System.out.println(currentNeighbors);
                if(currentNeighbors == null){
                	continue secondLoop;
                }
                for (Iterator k = currentNeighbors.iterator(); k.hasNext(); ) {
                    Station neighbor = (Station) k.next();
                    if (neighbor.equals(end)) {
                        reachableStations.add(neighbor);
                        previousStations.put(neighbor, currentStation);
                        break searchLoop;
                    } else if (!reachableStations.contains(neighbor)) {
                        reachableStations.add(neighbor);
                        tmpNextStations.add(neighbor);
                        previousStations.put(neighbor, currentStation);
                    }
                }
            }
            nextStations = tmpNextStations;
        }
        
        //We've found the path now!
        boolean keepLooping = true;
        Station keyStation = end;
        Station station;
        
        while (keepLooping) {
            station = (Station) previousStations.get(keyStation);
            route.add(0, getConnection(station, keyStation));
            
            if (start.equals(station)) {
                keepLooping = false;
            }
            keyStation = station;
        }
        
        return route;
    }
    
    private Connection getConnection(Station station1, Station station2) {
        for (Iterator i = connections.iterator(); i.hasNext(); ) {
            Connection connection = (Connection) i.next();
            Station one = connection.getStation1();
            Station two = connection.getStation2();
            if ((station1.equals(one)) && station2.equals(two)) {
                return connection;
            }
        }
        return null;
    }
    
    private Station getStation(String stationname){
    	for(Iterator i = stations.iterator(); i.hasNext();){
    		Station station = (Station) i.next();
    		if(station.getName().equals(stationname)){
    			return station;
    		}
    	}
    	return null;
    }
        
    
    public boolean hasConnection(String station1Name, String station2Name, String lineName) {
        Station station1 = new Station(station1Name);
        Station station2 = new Station(station2Name);
        for (Iterator i = connections.iterator(); i.hasNext(); ) {
            Connection connection = (Connection) i.next();
            if (connection.getAvailable()){
            	if (connection.getLineName().equalsIgnoreCase(lineName)) {
            		if ((connection.getStation1().equals(station1)) &&
            				(connection.getStation2().equals(station2)))
            		{
            			return true;
            		}
            	}
            }
        }
        return false;
    }
    
    public void setAvaStation(String stationname, boolean bool){
    	Station station = getStation(stationname);
    	if(station.getAvailable() == bool){
    		System.out.println("Change not necessary");
    		return;
    	}
    	if(!(station == null)){
    		station.setAvailable(bool);
    		if(!bool){
    			List constatlist = (List) network.get(station);
    			for(int i = 0; i < constatlist.size(); i++){
    				Station otherstation = (Station) constatlist.get(i);
    				setAvaConn(station,otherstation,bool);
    			}
    			network.remove(station);
    		} else{
    			for(Iterator i = connections.iterator(); i.hasNext();){
    				Connection conn = (Connection) i.next();
    				if(conn.getStation1().equals(station) || conn.getStation2().equals(station)){
    					conn.setAvailable(bool);
    					addToNetwork(conn.getStation1(),conn.getStation2());
    				}
    			}
    		}
    	} else{
    		System.out.println("No station");
    	}
    }
    
    public void setAvaConn(Station station1,Station station2, boolean bool){
    	Connection conn1 = getConnection(station1,station2);
    	Connection conn2 = getConnection(station2,station1);
    	if(!(conn1 == null || conn2 == null)){
    		conn1.setAvailable(bool);
    		conn2.setAvailable(bool);
    		List liststat1 = (List) network.get(station1);
    		List liststat2 = (List) network.get(station2);
    		liststat1.remove(station2);
    		liststat2.remove(station1);
    		//System.out.println("The availabity of connection " + conn.getLineName() + " is changed");
    	} else{
    		System.out.println("The station are not found!");
    	}
    }
}
