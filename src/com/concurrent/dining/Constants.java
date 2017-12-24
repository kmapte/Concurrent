package com.concurrent.dining;
/**
 * Welcome to Concurrent Restaurant!
 
This restaurant serves a special kind of dish that requires two forks to eat, no exceptions. A group of five friends go to Concurrent Restaurant for dinner and are seated at a circular table. When their food arrives, a fork is placed on the table between each friend and they are instructed to eat. Given that there are only five forks placed on the table and that each friend needs at least two forks to eat, an “eating strategy” must be developed such that the friends can eat concurrently. E.g. A simple strategy could be to have the friends take turns in a pre-defined order and eat for a fixed amount of time during their turn.
 
Write a program that implements your strategy demonstrating how the five friends can cooperate and eat together. Explain the terms “deadlock” and “starvation” and highlight the design decisions made in your solution that prevent these unwanted scenarios. Additionally, highlight the pros and cons of your solution touching briefly on ideas that might address those cons. The program must be written in Java on the master branch of a Git repository and must consist of production-grade code. At minimum, it must abide by the following rules beyond which, you are free to use your artistic liberty for all other aspects of the solution.
 
1.       Each friend should be “eating” in its own thread
2.       Friends can only use the forks adjacent to them
3.       Only friends with two forks are eating at any given time
 
You will not meet the minimal requirements for selection if:
1.       Your code does not compile
2.       You implemented the simple strategy mentioned above
 
Your deliverable will be the zipped Git repository which can be attached to your submission email. The program should be executable by running the command 'java -jar <some-name>.jar' and the validity of its operation will be determined by its console logs. The sample log below should give you an idea of what is expected.
 
Sample Output:
> Diner1 picks up left fork
> Diner 3 picks up left fork
> Diner 1 picks up right fork
> Diner1 is eating
> Diner3 picks up right fork
> Diner3 is eating
> Diner1 ate for 23ms. Pausing to digest…
> Diner1 puts down left fork
> Diner2 picks up right fork
> Diner3 ate for 56ms. Pausing to digest…
> Diner1 puts down right fork
> Diner3 puts down right fork
> Diner2 picks up left fork
> Diner2 is eating
.
 * @author Kedar
 *
 */

public class Constants {
	private Constants() {

	}

	public static final int NUMBER_OF_DINERS = 5;
	public static final int NUMBER_OF_FORKS = NUMBER_OF_DINERS;
	public static final int SIMULATION_EATING_COUNT_MAX = 20;

}
