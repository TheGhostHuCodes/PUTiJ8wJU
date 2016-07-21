package iloveyouboss;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.*;
import org.junit.rules.ExpectedException;

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
        account.deposit(100);
        assertThat(account.getBalance(), equalTo(100));
    }

    @Test(expected = InsufficientFundsException.class)
    public void throwsWhenWithdrawingTooMuchSimple()
        throws InsufficientFundsException {

        account.withdraw(100);
    }

    @Test
    public void throwsWhenWithdrawingTooMuchOld() {
        try {
            account.withdraw(100);
            fail();
        } catch (InsufficientFundsException expected) {
        }
    }

    @Rule public ExpectedException thrown = ExpectedException.none();

    @Test
    public void throwsWhenWithdrawingTooMuchNew()
        throws InsufficientFundsException {
        thrown.expect(InsufficientFundsException.class);

        account.withdraw(100);
    }
}
