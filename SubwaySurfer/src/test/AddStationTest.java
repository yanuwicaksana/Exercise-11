package test;

import static org.junit.Assert.*;

import java.io.File;

import loader.SubwayLoader;

import org.junit.Test;

import subway.Subway;

public class AddStationTest {

	@Test
	public void test() {
		try{
			SubwayLoader loader = new SubwayLoader();
	        Subway objectville = loader.loadFromFile(new File("src/ObjectvilleSubway.txt"));
	        objectville.addStation("OOP Station");
	        
	        assertTrue(objectville.hasStation("OOP Station"));
	        assertFalse(objectville.hasStation("LSP Principles"));
	        
		} catch(Exception e){
			System.out.println(e);
		}
	}

}
