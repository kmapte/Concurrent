package com.concurrent.dining;

import java.util.Random;

public class Diner implements Runnable {
	private int id;
	private DinnerFork leftDinnerFork;
	private DinnerFork rightDinnerFork;
	private Random random;
	private int eatingCounter;

	public Diner(int id, DinnerFork leftDinnerFork, DinnerFork rightDinnerFork) {
		this.id = id;
		this.leftDinnerFork = leftDinnerFork;
		this.rightDinnerFork = rightDinnerFork;
		this.random = new Random();
		this.eatingCounter = 0;
	}

	@Override
	public void run() {
		try {
			while (!isFull()) {
				if (this.leftDinnerFork.pickupFork(this, State.LEFT)) {
					if (this.rightDinnerFork.pickupFork(this, State.RIGHT)) {
						eat();
						this.rightDinnerFork.putDownForks(this, State.RIGHT);
					}
					this.leftDinnerFork.putDownForks(this, State.LEFT);
					digest();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void digest() throws InterruptedException {
		System.out.println(this + "ate:"+this.eatingCounter+" times. Pausing to digest ...");
		Thread.sleep(this.random.nextInt(1000));

	}

	private void eat() throws InterruptedException {
		System.out.println(this + " is eating ....");
		this.eatingCounter++;
		Thread.sleep(this.random.nextInt(1000));
	}

	public boolean isFull() {
		if (this.eatingCounter == Constants.SIMULATION_EATING_COUNT_MAX) {
			return true;
		}
		return false;
	}

	public int getEatingCounter() {
		return eatingCounter;
	}

	public void setEatingCounter(int eatingCounter) {
		this.eatingCounter = eatingCounter;
	}

	@Override
	public String toString() {
		return "Diner-" + this.id;
	}

}
