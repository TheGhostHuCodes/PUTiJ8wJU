package iloveyouboss;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static iloveyouboss.ConstrainsSidesTo.constrainsSidesTo;
import org.junit.*;

public class RectangleTest {
    private Rectangle rectangle;

    @After
    public void ensureInvariant() {
        assertThat(rectangle, constrainsSidesTo(100));
    }

    @Test
    public void answersArea() {
        rectangle = new Rectangle(new Point(5, 5), new Point(15, 10));
        assertThat(rectangle.area(), equalTo(50));
    }

    @Test
    public void allowsDynamicallyChangingSize() {
        rectangle = new Rectangle(new Point(5, 5));
        rectangle.setOppositeCorner(new Point(15, 10));
        assertThat(rectangle.area(), equalTo(50));
    }
}
