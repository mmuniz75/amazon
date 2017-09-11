package test;

import static org.junit.Assert.*;

import org.junit.Test;

public class Challenge2 {

	@Test
	public void test() {
		assertEquals(2,minimumNumberOfTrips(100, new int[]{70,10,20}));
	}
	
	@Test
	public void test3() {
		assertEquals(4,minimumNumberOfTrips(100, new int[]{70,10,20,90,100}));
	}
	
	@Test
	public void test4() {
		assertEquals(2,minimumNumberOfTrips(70, new int[]{70,50,20}));
	}
	
	@Test
	public void test5() {
		assertEquals(0,minimumNumberOfTrips(100, new int[]{}));
	}
	
	
	@Test
	public void test6() {
		assertEquals(3,minimumNumberOfTrips(70, new int[]{70,50,20,10}));
	}
	
	@Test
	public void test7() {
		assertEquals(4,minimumNumberOfTrips(70, new int[]{10,70,70,70}));
	}
	
	@Test
	public void test8() {
		assertEquals(5,minimumNumberOfTrips(70, new int[]{10,70,70,10,70}));
	}
	
	@Test
	public void test9() {
		assertEquals(2,minimumNumberOfTrips(70, new int[]{10,10,10}));
	}
	
	@Test
	public void test10() {
		assertEquals(1,minimumNumberOfTrips(70, new int[]{10}));
	}
	
	@Test
	public void test11() {
		assertEquals(1,minimumNumberOfTrips(70, new int[]{70}));
	}
	
	@Test
	public void test12() {
		assertEquals(2,minimumNumberOfTrips(70, new int[]{71}));
	}

	
	 static int minimumNumberOfTrips(int tripMaxWeight, int[] packagesWeight) {
		 
		 if(packagesWeight.length==0) return 0;
		 
         int countTrip = 1;
         int countPackages = 0;
         int remainWeight = tripMaxWeight;
         for(int i=0;i<packagesWeight.length;i++){
        	 countPackages++;
        	 if(countPackages>2)
        		 remainWeight = 0;
        	 
        	 remainWeight -= packagesWeight[i];
             if(remainWeight<0){
                 countTrip++;
                 remainWeight=tripMaxWeight-packagesWeight[i];
                 countPackages = 0;
             }
         }

      return countTrip;
  }
}
