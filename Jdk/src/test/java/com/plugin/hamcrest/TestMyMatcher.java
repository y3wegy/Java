package com.plugin.hamcrest;

import org.junit.Test;

import static com.plugin.hamcrest.IsNotANumber.notANumber;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Rui on 1/24/14.
 */
public class TestMyMatcher {
    @Test
    public void testSquareRootOfMinusOneIsNotANumber() {
        assertThat(Math.sqrt(-1), is(notANumber()));
    }
}
