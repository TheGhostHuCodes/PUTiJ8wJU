package iloveyouboss;

import org.hamcrest.*;

public class ConstrainsSidesTo extends TypeSafeMatcher<Rectangle> {
    private int length;

    public ConstrainsSidesTo(int length) { this.length = length; }

    @Override
    protected boolean matchesSafely(Rectangle r) {
        return Math.abs(r.origin().x - r.opposite().x) <= length &&
            Math.abs(r.origin().y - r.opposite().y) <= length;
    }
    @Override
    public void describeTo(Description description) {
        description.appendText("both sides must be <= " + length);
    }

    @Factory
    public static Matcher<Rectangle> constrainsSidesTo(int length) {
        return new ConstrainsSidesTo(length);
    }
}
