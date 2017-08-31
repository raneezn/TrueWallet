package com.raneez.truewallet;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.raneez.truewallet.main.ExpenseActivity;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.not;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by raneezahmed on 27/08/17.
 */

@RunWith(AndroidJUnit4.class)
@LargeTest
public class AddNewExpenseTest {

    @Rule public final ActivityTestRule<ExpenseActivity> expenseActivityTestRule
            = new ActivityTestRule<>(ExpenseActivity.class);

    @Test
    public void shouldAbleToAddNewExpenseAndEditTheExpense(){
        // check for fab button
        onView(withId(R.id.fab)).check(matches(isDisplayed()));

        // perform click
        onView(withId(R.id.fab)).perform(click());

        //make sure fab is not visible
        onView(withText("AddExpenseActivity")).check(matches(isDisplayed()));

        // type description
        onView(withId(R.id.edit_expense_desc)).perform(typeText("New LP shirt"));

        //type some value in amount
        onView(withId(R.id.edit_expense_amount)).perform(typeText("1000"));

        //click on save
        onView(withId(R.id.save_expense)).perform(click());
    }

}