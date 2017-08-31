/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testWaitAccount;

public class Account {

    private double balance;

    Account() {
        balance = 0.0;
    }

    Account(double initialBalance) {
        balance = initialBalance;
    }

    double getBalance() {
        return balance;
    }

    synchronized double put(double amountAdd) {
        
        System.out.println("Amount of add " + amountAdd);
        balance = balance + amountAdd;
        System.out.println("Balance after add " + balance);
        return balance;
    }

    synchronized double withdraw(double amountWithdraw) {
        while (balance < amountWithdraw) {
            try {
                wait(50);
            } catch (InterruptedException e) {
            }
        }

        System.out.println("Amount of withdrawal " + amountWithdraw);
        balance = balance - amountWithdraw;
        System.out.println("Balance after withdrawal " + balance);
        return balance;
    }

}
