package com.abdul.telstraapp;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import junit.framework.TestCase;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import kotlin.jvm.JvmField;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MyMainActivityTest extends TestCase {

    @Rule
    @JvmField
    ActivityTestRule mActivityTestRule = new ActivityTestRule(MainActivity.class);

    @Test
    void mainActivityTest() {
        // 1. Find a View
        // 2. Perform an action
        // 3. Verify action was taken, assert result

        onView(withId(R.id.etName))
                .perform(typeText("telstra"), closeSoftKeyboard());
        onView(withId(R.id.btnText)).perform(click());
        onView(withId(R.id.tvResult))
                .check(matches(withText("telstra")));
    }
}
