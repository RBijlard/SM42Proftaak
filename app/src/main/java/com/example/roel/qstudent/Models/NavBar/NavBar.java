package com.example.roel.qstudent.Models.NavBar;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
<<<<<<< HEAD
import android.util.Log;
import android.view.View;
=======
>>>>>>> sync

import com.example.roel.qstudent.Activitys.ProfileActivity;
import com.example.roel.qstudent.R;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnMenuTabClickListener;

public class NavBar extends AppCompatActivity implements OnMenuTabClickListener {

    private static BottomBar bar;
    private boolean init=false;
    private Context con;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void setupBar(Activity act, Bundle savedInstanceState) {
        bar =BottomBar.attach(act, savedInstanceState);
        //bar.useFixedMode();

        bar.setItemsFromMenu(R.menu.bottombar_menu, this);
        //bar.setTextAppearance(R.style.tabTitle);
    }

    public void barLoaded(Activity act) {
        if(act instanceof MainActivity) {
            bar.selectTabAtPosition(0, false);
            init=true;
        } else if(act instanceof ProfileActivity) {
            bar.selectTabAtPosition(3, false);
            init=true;
        }
    }

    public void launchScreen(Class scr) {
        if(this.getClass() == scr) {
            Log.d("[BAR]", "Same screen!");
            return;
        }
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

    @Override
    public void onMenuTabSelected(@IdRes int menuItemId) {
        if(!init) {
            Log.d("[BAR]:", "init false");
            return;
        } else {
            if(menuItemId == R.id.bottomBarItemOne) {
                launchScreen(MainActivity.class);
            }else if(menuItemId == R.id.bottomBarItemFour) {
                launchScreen(ProfileActivity.class);
            }
        }
        Log.d("[BAR]:", "menu selected");
    }

    @Override
    public void onMenuTabReSelected(@IdRes int menuItemId) {
        Log.d("[BAR]:", "menu reselected");
    }
}
