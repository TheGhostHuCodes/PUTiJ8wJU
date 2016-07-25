package iloveyouboss;

import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import java.util.List;

public class ProfilePoolTest {

    private ProfilePool pool;
    private Profile smeltInc;
    private Profile langrsoft;
    private Question doTheyReimburseTuition;

    private Criteria soleNeed(Question question, Bool value, Weight weight) {
        Criteria criteria = new Criteria();
        criteria.add(new Criterion(new Answer(question, value), weight));
        return criteria;
    }

    @Before
    public void setup() {
        pool = new ProfilePool();
        smeltInc = new Profile("Smelt Inc.");
        langrsoft = new Profile("LangrSoft");
        doTheyReimburseTuition = new BooleanQuestion(1, "Do they Reimburse?");
    }

    @Test
    public void answersResultsInScoredOrder() {
        smeltInc.add(new Answer(doTheyReimburseTuition, Bool.FALSE));
        pool.add(smeltInc);
        langrsoft.add(new Answer(doTheyReimburseTuition, Bool.TRUE));
        pool.add(langrsoft);

        pool.score(
            soleNeed(doTheyReimburseTuition, Bool.TRUE, Weight.Important));
        List<Profile> ranked = pool.ranked();

        assertThat(ranked.toArray(),
                   equalTo(new Profile[] {langrsoft, smeltInc}));
    }
}
