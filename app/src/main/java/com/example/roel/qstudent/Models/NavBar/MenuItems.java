package com.example.roel.qstudent.Models.NavBar;

import android.content.Context;
import android.content.Intent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Robin on 2-6-2016.
 */
public class MenuItems {
    List<MenuItem> menuItems;

    MenuItem defaultPage;

    private enum ITEM {
        Home,
        Forum,
        Klas,
        Profiel
    }
    public MenuItems() {
        menuItems = new ArrayList<>();
        //menuItems.add(new MenuItem(ITEM.Profiel, profileActivity.class));
        //menuItems.add(new MenuItem(ITEM.Hosting, hostingActivity.class));
        //menuItems.add(new MenuItem(ITEM.Looking, lookingActivity.class));
        //defaultPage = new MenuItem(ITEM.Profiel, loginActivity.class);
        menuItems.add(defaultPage);
    }

    private class MenuItem {
        public ITEM item;
        public Class referral;
        public MenuItem(ITEM item, Class referral) {
            this.item=item;
            this.referral = referral;
        }
    }

    public String[] getMenuItems(){
        String[] items = new String[menuItems.size()];
        for(int i=0; i<menuItems.size(); i++) {
            items[i]= ITEM.values()[i].toString();
        }
        return items;
    }

    public void OpenMenu(Context context, int position) {
        Intent i= new Intent(context, menuItems.get(position).referral);
        context.startActivity(i);
    }

    public void openLogin(Context context) {
        Intent i = new Intent(context, defaultPage.referral);
        context.startActivity(i);
    }
}
