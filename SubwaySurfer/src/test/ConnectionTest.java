package test;

import static org.junit.Assert.*;

import org.junit.Test;

import subway.Connection;
import subway.Station;

public class ConnectionTest {

	@Test
	public void test() {
		Station station1 = new Station("Gambir");
		Station station2 = new Station("Cikini");
		
		Connection conn1 = new Connection(station1,station2,"KRL Line");
		Connection conn2 = new Connection(station2,station1,"KRL Line");
		conn1.setAvailable(false);
		assertFalse(conn1.getAvailable());
		assertEquals(conn1.getStation1(),station1);
		assertEquals(conn1.getStation2(),station2);
		
	}

}
