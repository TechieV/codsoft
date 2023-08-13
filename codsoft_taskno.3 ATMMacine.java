import java.util.Scanner;

class ATM {
    float balance;
    int PIN = 1234;
    int maxAttempts = 3;
    int attempts = 0;

    public void checkpin() {
        if (attempts >= maxAttempts) {
            System.out.println("Too many incorrect PIN attempts. Exiting...");
            return;
        }

        System.out.println("Enter your PIN: ");
        Scanner sc = new Scanner(System.in);
        int enteredpin = sc.nextInt();

        if (enteredpin == PIN) {
            menu();
        } else {
            attempts++;
            System.out.println("Incorrect PIN. Please try again.");
            checkpin();
        }
    }

    public void menu() {
        System.out.println("Enter Your Choice");
        System.out.println("1. Check A/C Balance");
        System.out.println("2. Withdraw Amount");
        System.out.println("3. Deposit Amount");
        System.out.println("4. Exit");

        Scanner sc = new Scanner(System.in);
        int opt = sc.nextInt();

        if (opt == 1) {
            checkbalance();
        } else if (opt == 2) {
            withdrawMoney();
        } else if (opt == 3) {
            depositMoney();
        } else if (opt == 4) {
            System.out.println("Thank you for using our ATM. Goodbye!");
            return;
        } else {
            System.out.println("Enter a Valid Choice");
        }
    }

    public void checkbalance(){
        System.out.println("Balance: "+ balance);
        menu();
    }

    public void withdrawMoney(){
        System.out.println("Enter the Amount to Withdraw: ");
        Scanner sc = new Scanner(System.in);
        float amount = sc.nextFloat();
        if (amount > balance){
            System.out.println("Insufficient Balance");
        } else {
            balance = balance - amount;
            System.out.println("Money Withdrawn Successfully");
        }
        menu();
    }

    public void depositMoney(){
        System.out.println("Enter the Amount to Deposit: ");
        Scanner sc = new Scanner(System.in);
        float amount = sc.nextFloat();
        balance = balance + amount;
        System.out.println("Money Deposited Successfully");
        menu();
    }
}

public class ATMMacine {
    public static void main(String[] args) {
        ATM obj = new ATM();
        obj.checkpin();
    }
}
