package testWaitAccount;

public class Increaser implements Runnable {

    Account account;
    Increaser(Account account){
        this.account = account;
    }
    
    public void run() {
        for (int i = 1; i < 20; i++) {
            account.put(10.0);
        }
    }
    
}
