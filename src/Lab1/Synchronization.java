package lab1;


class BankAccount {
    private int balance = 1000;
   
    //Synchronized Method
    synchronized public void withdraw(int amount) {
        if (balance >= amount) {
            System.out.println("Withdrawing " + amount);
            balance -= amount;
            System.out.println("New balance after withdrawal: " + balance);
        } else {
            System.out.println("Insufficient funds for withdrawal of " + amount);
            System.out.println("Current balance: " + balance);
        }
    }

    //Synchronized block
    public void deposit(int amount) {
        synchronized (this) {
            System.out.println("Depositing " + amount);
            balance += amount;
            System.out.println("New balance after deposit: " + balance);
        }
    }
}

public class Synchronization extends Thread {
    static BankAccount account;
    int amount;
    boolean isDeposit;

    public void run() {
        if (isDeposit) {
            account.deposit(amount);
        } else {
            account.withdraw(amount);
        }
    }

    public static void main(String[] args) {
        account = new BankAccount();
        Synchronization thread1 = new Synchronization();
        thread1.amount = 500;
        thread1.isDeposit = true;
        thread1.start();

        Synchronization thread2 = new Synchronization();
        thread2.amount = 300;
        thread2.isDeposit = false;
        thread2.start();

        Synchronization thread3 = new Synchronization();
        thread3.amount = 200;
        thread3.isDeposit = true;
        thread3.start();

        Synchronization thread4 = new Synchronization();
        thread4.amount = 100;
        thread4.isDeposit = false;
        thread4.start();
    }
}
