package test;

import static org.junit.Assert.*;

import java.util.*;
import java.io.File;

import loader.SubwayLoader;

import org.junit.Test;

import subway.Connection;
import subway.Station;
import subway.Subway;

public class getDirectionTest {

	@Test
	public void test() {
		try{
			SubwayLoader loader = new SubwayLoader();
	        Subway objectville = loader.loadFromFile(new File("src/ObjectvilleSubway.txt"));
	        Station station1 = new Station("XHTML Expressway");
	        Station station2 = new Station("Infinite Circle");
	        Station station3 = new Station("Head First Theater");
	        List route = objectville.getDirections("XHTML Expressway", "Head First Theater");
	        Connection conn1 = (Connection) route.get(0);
	        Connection conn2 = (Connection) route.get(1);
	        
	        //System.out.println(route);
	        
	        
	        assertEquals(conn1.getStation1(),station1);
	        assertEquals(conn1.getStation2(),station2);
	        assertEquals(conn2.getStation2(),station3);
	        
	        
		} catch(Exception e){
			System.out.println(e);
		}
	}

}
