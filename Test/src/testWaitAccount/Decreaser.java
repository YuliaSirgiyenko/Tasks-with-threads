/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testWaitAccount;

public class Decreaser implements Runnable {
    
    Account account;
    Decreaser(Account account) {
        this.account = account;
    }
    
    public void run() {
        for (int i = 1; i < 6; i++) {
            account.withdraw(25.0);
        }
    }
    
}
