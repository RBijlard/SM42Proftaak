package com.example.roel.qstudent.Models.NavBar;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.roel.qstudent.Activitys.MainActivity;
import com.example.roel.qstudent.Activitys.ProfileActivity;
import com.example.roel.qstudent.R;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.BottomBarTab;
import com.roughike.bottombar.OnMenuTabClickListener;
import com.roughike.bottombar.OnTabClickListener;

import java.util.ArrayList;
import java.util.List;

public class NavBar extends AppCompatActivity {

    private BottomBar bar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MenuItems menu = new MenuItems();
        //setContentView(R.layout.activity_nav_bar)
    }

    public void setupBar(Activity act) {
        bar = bar.attach(act, null);
        //bar.useFixedMode(); //Display titles
        bar.setItemsFromMenu(R.menu.bottombar_menu, new OnMenuTabClickListener() {
            @Override
            public void onMenuTabSelected(@IdRes int menuItemId) {
                if (menuItemId == R.id.bottomBarItemOne) { //Home
                    //launchScreen(MainActivity.class);
                }

                if(menuItemId == R.id.bottomBarItemFour && getApplicationContext().getClass() != ProfileActivity.class) { //Profile
                    launchScreen(ProfileActivity.class);
                }
            }

            @Override
            public void onMenuTabReSelected(@IdRes int menuItemId) {
                if (menuItemId == R.id.bottomBarItemOne) {
                    // The user reselected item number one, scroll your content to top.
                }
            }
        });
    }

    public void launchScreen(Class scr) {
        Intent i = new Intent(this, scr);
        startActivity(i);
        finish();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        // Necessary to restore the BottomBar's state, otherwise we would
        // lose the current tab on orientation change.
        bar.onSaveInstanceState(outState);
    }
}
