package lab1;

	public class MethodOfThreadClass {

	    public static void main(String[] args) {
	        Chef chef1 = new Chef("Chef1", 1);
	        Chef chef2 = new Chef("Chef2", 1);
	        Waitstaff waitstaff1 = new Waitstaff("Waitstaff1", 1);
	        Waitstaff waitstaff2 = new Waitstaff("Waitstaff2", 1);

	        chef1.start();
	        chef2.start();
	        waitstaff1.start();
	        waitstaff2.start();
	    }
	}

	class Chef extends Thread {
	    static final Object kitchenLock = new Object();
	    static boolean mealReady = false;
	    private String name;
	    private int mealsToPrepare;

	    Chef(String name, int mealsToPrepare) {
	        this.name = name;
	        this.mealsToPrepare = mealsToPrepare;
	    }

	    @Override
	    public void run() {
	        int mealsPrepared = 0;
	        while (mealsPrepared < mealsToPrepare) {
	            try {
	                System.out.println(name + " is preparing a meal.");
	                Thread.sleep(5000);

	                synchronized (kitchenLock) {
	                    mealReady = true;
	                    System.out.println(name + " has prepared a meal.");
	                    kitchenLock.notify();
	                    mealsPrepared++;
	                }
	                Thread.sleep(1000);
	            } catch (InterruptedException e) {
	                System.out.println(name + " was interrupted.");
	                break;
	            }
	            Thread.yield();
	        }
	        System.out.println(name + " has finished preparing meals.");
	    }
	}

	class Waitstaff extends Thread {
	    private String name;
	    private int mealsToReceive;

	    Waitstaff(String name, int mealsToReceive) {
	        this.name = name;
	        this.mealsToReceive = mealsToReceive;
	    }

	    @Override
	    public void run() {
	        int mealsReceived = 0;
	        while (mealsReceived < mealsToReceive) {
	            synchronized (Chef.kitchenLock) {
	                try {
	                    while (!Chef.mealReady) {
	                        System.out.println(name + " is waiting for a meal.");
	                        Chef.kitchenLock.wait();
	                    }
	                    System.out.println(name + " received the meal.");
	                    Chef.mealReady = false; 
	                    mealsReceived++;

	                } catch (InterruptedException e) {
	                    System.out.println(name + " was interrupted.");
	                    break;
	                }
	            }
	        }
	        System.out.println(name + " has finished receiving meals.");
	    }
	}

