public class ThreadTester {
	public static void main(String[] args) {
		
		ThreadTest bank = new ThreadTest(1000);
		
		System.out.println("Starting Balance: " + bank.getBalance()); //prints 1000
		
		Runnable r1 = bank;
		Runnable r2 = bank;
		Runnable r3 = bank;
		
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		Thread t3 = new Thread(r3);
		
		t1.start();
		t2.start();
		t3.start();
		
		/*
		 * There will be 3 withdrawals of $50 each, -$150
		 * Then there will be 3 deposits of $100 each, +$300
		 * 
		 * The expected output should be: $1000 - $150 + $300 = $1150
		 */
		
		System.out.println("Ending Balance: " + bank.getBalance());  //prints 900
	}
}
