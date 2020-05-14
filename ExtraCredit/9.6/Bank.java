public class Thread implements Runnable {
	private int balance;

	public exercise1(int balance) { 
		this.balance = balance;
	}
	
	public int getBalance() {
		return balance;
	}

	@Override
	public void run() {
		try {
			// Make 3 withdrawals of $50 each (-$150)
			for (int i = 0; i < 3; i++) {
				balance -= 50;
				Thread.sleep(500); 
			}
			
			// Make 3 deposits of $100 each (+$300)
			for (int i = 0; i < 3; i++) {
				balance += 100;
				Thread.sleep(500); 
			}
		} catch (InterruptedException exception) {
			System.out.print(exception);
		}
	}
}
