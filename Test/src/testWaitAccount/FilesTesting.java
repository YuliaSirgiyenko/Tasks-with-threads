package testWaitAccount;

public class FilesTesting {

    void testMethod() {
        Account account = new Account(50.0);
        Increaser increaser = new Increaser(account);
        Decreaser decreaser = new Decreaser(account);
        new Thread(decreaser).start();
        new Thread(increaser).start();
    }

}
