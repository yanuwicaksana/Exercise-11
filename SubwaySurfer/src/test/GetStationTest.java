package test;

import static org.junit.Assert.*;

import java.io.File;

import loader.SubwayLoader;

import org.junit.Test;

import subway.Station;
import subway.Subway;

public class GetStationTest {

	@Test
	public void test() {
		try{
			SubwayLoader loader = new SubwayLoader();
	        Subway objectville = loader.loadFromFile(new File("src/ObjectvilleSubway.txt"));
	        
	        Station station = new Station("DRY Drive");
	        
	        assertEquals(objectville.getStation("DRY Drive"),station);
	        
	        
		} catch(Exception e){
			System.out.println(e);
		}
	}

}
