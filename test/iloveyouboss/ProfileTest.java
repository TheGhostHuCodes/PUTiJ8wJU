package iloveyouboss;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.*;

public class ProfileTest {

    private Profile profile;
    private BooleanQuestion question;
    private Criteria criteria;

    @Before
    public void setup() {
        profile = new Profile("Bull Hockey, Inc.");
        question = new BooleanQuestion(1, "Got bonuses?");
        criteria = new Criteria();
    }

    @Test
    public void matchAnswersFalseWhenMustMatchCriteriaNotMet() {
        profile.add(new Answer(question, Bool.FALSE));
        criteria.add(
            new Criterion(new Answer(question, Bool.TRUE), Weight.MustMatch));

        boolean matches = profile.matches(criteria);

        assertFalse(matches);
    }

    @Test
    public void matchAnswersTrueForAnyDontCareCriteria() {
        profile.add(new Answer(question, Bool.FALSE));
        criteria.add(
            new Criterion(new Answer(question, Bool.TRUE), Weight.DontCare));

        boolean matches = profile.matches(criteria);

        assertTrue(matches);
    }
}
