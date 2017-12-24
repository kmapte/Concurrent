package com.concurrent.dining;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DinnerFork {
	private Lock lock;
	private int id;

	public DinnerFork(int id) {
		this.id = id;
		this.lock = new ReentrantLock(true);
	}

	public boolean pickupFork(Diner diner, State state) throws InterruptedException {
		// using trylock with timeout to honor the fairness flag so that no single
		// thread will experience starvation.

		if (this.lock.tryLock(10, TimeUnit.MILLISECONDS)) {
			System.out.println(diner + " picked up " + state.toString() + " " + this);
			return true;
		}

		return false;
	}

	public void putDownForks(Diner diner, State state) {
		this.lock.unlock();
		System.out.println(diner+ " put down "+ state.toString() + " "+ this);

	}

	@Override
	public String toString() {
		return "DinnerFork-" + this.id;
	}

}
