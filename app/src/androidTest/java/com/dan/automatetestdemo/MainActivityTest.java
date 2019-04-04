package com.dan.automatetestdemo;

import android.widget.Button;
import android.widget.EditText;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.rule.ActivityTestRule;

import static org.junit.Assert.*;

/**
 * Created by Dan Kim on 2019-04-03
 */
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mainActivityActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    private MainActivity mainActivity;

    @Before
    public void setUp() throws Exception {
        mainActivity = mainActivityActivityTestRule.getActivity();

    }

    @Test
    public void testLaunchMainActivity(){

        EditText etLogin = mainActivity.findViewById(R.id.username);
        assertNotNull(etLogin);

        EditText etPassword = mainActivity.findViewById(R.id.password);
        assertNotNull(etPassword);

        Button btnLogin = mainActivity.findViewById(R.id.login);
        assertNotNull(btnLogin);

        Espresso.onView(ViewMatchers.withId(etLogin.getId())).perform(ViewActions.typeText("dan"));
        Espresso.onView(ViewMatchers.withId(etPassword.getId())).perform(ViewActions.typeText("password"));
        Espresso.onView(ViewMatchers.withId(btnLogin.getId())).perform(ViewActions.click());


    }

    @After
    public void tearDown() throws Exception {

        mainActivity = null;
    }
}