package test;

import static org.junit.Assert.*;

import java.io.File;

import loader.SubwayLoader;

import org.junit.Test;

import subway.Station;
import subway.Subway;

public class SetConnection {

	@Test
	public void test() {
		try{
			SubwayLoader loader = new SubwayLoader();
	        Subway objectville = loader.loadFromFile(new File("src/ObjectvilleSubway.txt"));
	        Station station1 = new Station("Head First Theater");
	        Station station2 = new Station("Infinite Circle");
	        
	        objectville.setAvaConn(station1, station2, false);
	        assertFalse(objectville.hasConnection("Head First Lounge", "Infinite Circle", "Rumbaugh Line"));
	        
		} catch(Exception e){
			System.out.println(e);
		}
	}

}
