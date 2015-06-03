package test;

import static org.junit.Assert.*;


import java.io.File;

import loader.SubwayLoader;

import org.junit.Test;

import subway.Subway;

public class HasStationTest {

	@Test
	public void test() {
		try{
			SubwayLoader loader = new SubwayLoader();
	        Subway objectville = loader.loadFromFile(new File("src/ObjectvilleSubway.txt"));
	        
	        assertTrue(objectville.hasStation("DRY Drive"));
	        assertTrue(objectville.hasStation("Weather-O-Rama, Inc."));
	        assertFalse(objectville.hasStation("LSP Principles"));
	        
		} catch(Exception e){
			System.out.println(e);
		}
        
	}

}
