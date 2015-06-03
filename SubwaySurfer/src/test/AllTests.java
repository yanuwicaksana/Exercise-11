package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AddConnectionTest.class, AddStationTest.class,
		ConnectionTest.class, getDirectionTest.class, GetStationTest.class,
		HasConnectionTest.class, HasStationTest.class, SetConnection.class,
		SetStation.class, StationTest.class })
public class AllTests {

}
