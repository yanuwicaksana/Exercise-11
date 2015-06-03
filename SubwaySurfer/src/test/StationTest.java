package test;

import static org.junit.Assert.*;

import org.junit.Test;

import subway.Station;

public class StationTest {

	@Test
	public void test() {
		Station station1 = new Station("Gambir");
		Station station2 = new Station("Gambir");
		
		station1.setAvailable(false);
		assertFalse(station1.getAvailable());
		assertEquals(station1,station2);
	}

}
