package test;

import static org.junit.Assert.*;

import java.io.File;

import loader.SubwayLoader;

import org.junit.Test;

import subway.Subway;

public class HasConnectionTest {

	@Test
	public void test() {
		try{
			SubwayLoader loader = new SubwayLoader();
	        Subway objectville = loader.loadFromFile(new File("src/ObjectvilleSubway.txt"));
	        
	        assertTrue(objectville.hasConnection("DRY Drive", "Head First Theater", "Meyer Line"));
	        assertTrue(objectville.hasConnection("LSP Lane", "JavaBeans Boulevard", "Booch Line"));
	        assertFalse(objectville.hasConnection("OOA&D Oval", "LSP Principles", "Gamma Line"));
	        
		} catch(Exception e){
			System.out.println(e);
		}
	}

}
