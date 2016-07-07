package com.plugin.hamcrest;

import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

/**
 * Created by a549238 on 1/24/14.
 */
public class IsNotANumber extends TypeSafeMatcher {

    @Factory
    public static Matcher notANumber() {
        return new IsNotANumber();
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("not a number");
    }

    @Override
    protected boolean matchesSafely(Object item) {
        return ((Double) item).isNaN();
    }
}
