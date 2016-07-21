package iloveyouboss;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.*;

public class AssertTest {

    private Account account;

    @Before
    public void setup() {
        account = new Account("an account name");
    }

    @Test
    public void hasPositiveBalance() {
        account.deposit(50);
        assertTrue(account.hasPositiveBalance());
    }

    @Test
    public void depositIncreasesBalance() {
        int initialBalance = account.getBalance();
        account.deposit(100);
        assertTrue(account.getBalance() > initialBalance);
    }
}
