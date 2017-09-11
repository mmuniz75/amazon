package test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class Challenge1 {
	
	private static class Drone {
        private int id;
        private int flightRange;

        public Drone(int id, int flightRange) {

            this.id = id;
            this.flightRange = flightRange;
        }

        public int getId() {
            return id;
        }

        public int getFlightRange() {
            return flightRange;
        }
    }

	@Test
	public void test() {
		List<Drone> drones = Arrays.asList( new Drone(4,11),
											new Drone(2,15),
											new Drone(5,16),
											new Drone(3,40),
											new Drone(1,20),
											new Drone(9,60),
											new Drone(6,22)
											);
											
		List<Integer> inMaintenanceDrones = Arrays.asList(1,5,9);
		
		List<Integer> resultDrones = Arrays.asList(3,6,2);
		
		assertEquals(resultDrones,greatestFlightRangeDrones(3, drones, inMaintenanceDrones));
		
	}
	
	@Test
	public void test2() {
		List<Drone> drones = Arrays.asList( new Drone(4,11),
											new Drone(2,15)
											);
											
		List<Integer> inMaintenanceDrones = Arrays.asList();
		
		List<Integer> resultDrones = Arrays.asList(2,4);
		
		assertEquals(resultDrones,greatestFlightRangeDrones(3, drones, inMaintenanceDrones));
		
	}
	
	
	static List<Integer> greatestFlightRangeDrones(Integer numberOfRequiredDrones, List<Drone> drones, List<Integer> inMaintenanceDrones) {
				
		List<Drone> dronesWorking = drones.parallelStream().filter(d -> !inMaintenanceDrones.contains(d.id)).collect(java.util.stream.Collectors.toList());
		
		Collections.sort(dronesWorking,(d1,d2) -> Integer.compare(d2.flightRange,d1.flightRange));
		
		dronesWorking = dronesWorking.size()>numberOfRequiredDrones?dronesWorking.subList(0,numberOfRequiredDrones):dronesWorking;
				
		List<Integer> dronesChoose = dronesWorking.parallelStream().map(d -> d.id).collect(java.util.stream.Collectors.toList());
						
		return dronesChoose;

    }

}
