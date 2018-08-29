package com.test.exam.ocjp.threads.syncronized;

/**
 * 
 * @author eroman
 *The logic in our code example is as follows:
	1. The Runnable object holds a reference to a single account.
	2. Two threads are started, representing Lucy and Fred, and each thread is
		given a reference to the same Runnable (which holds a reference to the
		actual account)
	3. The initial balance on the account is 50, and each withdrawal is exactly 10.
	4. In the run() method, we loop 5 times, and in each loop we
		- Make a withdrawal (if there's enough in the account).
		- Print a statement if the account is overdrawn (which it should never be, 
		  since we check the balance before making a withdrawal).
	5. The makeWithdrawal() method in the test class (representing the behavior of Fred or Lucy) will do the following:
		- Check the balance to see if there's enough for the withdrawal.
		- If there is enough, print out the name of the one making the withdrawal.
		- Go to sleep for 500 milliseconds—just long enough to give the other partner a chance to get in before you actually make the withdrawal.
		- Upon waking up, complete the withdrawal and print that fact.
		- If there wasn't enough in the first place, print a statement showing who you are and the fact that there wasn't enough.
 */
public class AccountDanger implements Runnable {
	private Account acct = new Account();

	public static void main(String[] args) {
		AccountDanger r = new AccountDanger();
		Thread one = new Thread(r);
		Thread two = new Thread(r);
		one.setName("Fred");
		two.setName("Lucy");
		one.start();
		two.start();
	}

	public void run() {
		for (int x = 0; x < 5; x++) {
			makeWithdrawal(10);
			if (acct.getBalance() < 0) {
				System.out.println("account is overdrawn!");
			}
		}
	}
	
	//Para resolver este problema de que los dos threads acceden a la misma instancia
	//solo debemos agregar la palabta synchronized
	//De esta manera los threads deben esperar a que termine el que lo esta usando
	//Despues se libera el monitor y otro thread ya puede tomarlo
	//Comentamos la palabra synchronized para ver el ejemplo y ver como corrompe la 
	//variable balance.
	private synchronized  void makeWithdrawal(int amt) {
		if (acct.getBalance() >= amt) {
			System.out.println(Thread.currentThread().getName() + " is going to withdraw");
			try {
				Thread.sleep(500);
			} catch (InterruptedException ex) {
			}
			acct.withdraw(amt);
			System.out.println(Thread.currentThread().getName() + " completes the withdrawal");
		} else {
			System.out.println("Not enough in account for " + Thread.currentThread().getName() + " to withdraw "
					+ acct.getBalance());
		}
	}
}

class Account {
	private int balance = 50;

	public int getBalance() {
		return balance;
	}

	public void withdraw(int amount) {
		balance = balance - amount;
	}
}
