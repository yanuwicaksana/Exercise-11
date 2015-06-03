package test;

import static org.junit.Assert.*;

import java.io.File;

import loader.SubwayLoader;

import org.junit.Test;

import subway.Subway;

public class AddConnectionTest {

	@Test
	public void test() {
		try{
			SubwayLoader loader = new SubwayLoader();
	        Subway objectville = loader.loadFromFile(new File("src/ObjectvilleSubway.txt"));
	        objectville.addConnection("DRY Drive", "Head First Theater", "New Line");
	        
	        assertTrue(objectville.hasConnection("DRY Drive", "Head First Theater", "New Line"));
	        assertFalse(objectville.hasConnection("DRY Drive", "LSP Principles", "New Line"));
	        
		} catch(Exception e){
			System.out.println(e);
		}
	}

}
