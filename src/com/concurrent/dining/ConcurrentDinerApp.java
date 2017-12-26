package com.concurrent.dining;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConcurrentDinerApp {
	 

	public static void main(String[] args) throws InterruptedException {
		ExecutorService executorService = null;
		Diner diners [] = null;
		
		try {
			executorService =  Executors.newFixedThreadPool(Constants.NUMBER_OF_DINERS);
			diners = new Diner[Constants.NUMBER_OF_DINERS];
			DinnerFork [] dinnerForks = new DinnerFork [Constants.NUMBER_OF_FORKS];
			
			for (int i = 0; i < Constants.NUMBER_OF_FORKS; i++) {
				dinnerForks[i] = new DinnerFork(i);
			}
			// see the table sitting with forks in the attached diagram DinersLayoutWithForks.jpg
			for (int i = 0; i < Constants.NUMBER_OF_DINERS; i++) {
				diners[i] = new Diner(i,dinnerForks[i] , dinnerForks[(i+1)%Constants.NUMBER_OF_FORKS]); // counter clock wise assingment
				executorService.execute(diners[i]);
			}
			
			
			
		} finally {
			executorService.shutdown();
			
			while(!executorService.isTerminated()){
				Thread.sleep(1000);
			}
			
			for(Diner diner : diners ){
				System.out.println(diner+" eat #"+diner.getEatingCounter());
			}
			

		}
		

	}

}
