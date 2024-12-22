package lab1;

public class TwoApproachOfMultithreading {
public static void main(String[] args) {
	ApproachOne a1 = new ApproachOne();
	a1.start();
	
	ApproachTwo a2 = new ApproachTwo();
	Thread t1 = new Thread(a2);
	t1.start();
}
}

class ApproachOne extends Thread{
	public void run() {
		for (int i = 1; i <= 2; i++) {
            System.out.println("Thread from ApproachOne class: " + i);
        }
	}
}

class ApproachTwo implements Runnable{
	public void run() {
		for (int i = 1; i <= 2; i++) {
            System.out.println("Thread from ApproachTwo class: " + i);
        }
	}
}
