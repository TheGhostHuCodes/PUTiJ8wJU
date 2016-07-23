package iloveyouboss;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.*;

public class ScoreCollectionTest {
    private ScoreCollection collection;

    @Before
    public void setup() {
        collection = new ScoreCollection();
    }

    @Test
    public void answersArithmeticMeanOfTwoNumbers() {
        collection.add(() -> 5);
        collection.add(() -> 7);

        int actualResult = collection.arithmeticMean();

        assertThat(actualResult, is(equalTo(6)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwsExceptionWhenAddingNull() {
        collection.add(null);
    }

    @Test
    public void answersZeroWhenNoElementsAdded() {
        assertThat(collection.arithmeticMean(), equalTo(0));
    }

    @Test
    public void dealsWithIntegerOverflow() {
        collection.add(() -> Integer.MAX_VALUE);
        collection.add(() -> 1);

        assertThat(collection.arithmeticMean(), equalTo(1073741824));
    }
}
