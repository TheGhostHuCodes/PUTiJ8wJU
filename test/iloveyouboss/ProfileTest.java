package iloveyouboss;

import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ProfileTest {

    private Profile profile;
    private BooleanQuestion question;
    private Criteria criteria;

    private int[] ids(Collection<Answer> answers) {
        return answers.stream()
            .mapToInt(a -> a.getQuestion().getId())
            .toArray();
    }

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

    @Test
    public void findsAnswersBasedOnPredicate() {
        profile.add(new Answer(new BooleanQuestion(1, "1"), Bool.FALSE));
        profile.add(
            new Answer(new PercentileQuestion(2, "2", new String[] {}), 0));
        profile.add(
            new Answer(new PercentileQuestion(3, "3", new String[] {}), 0));

        List<Answer> answers = profile.find(
            a -> a.getQuestion().getClass() == PercentileQuestion.class);
        List<Answer> answersComplement = profile.find(
            a -> a.getQuestion().getClass() != PercentileQuestion.class);

        List<Answer> allAnswers = new ArrayList<>();
        allAnswers.addAll(answersComplement);
        allAnswers.addAll(answers);

        assertThat(ids(allAnswers), equalTo(new int[] {1, 2, 3}));
    }
}
