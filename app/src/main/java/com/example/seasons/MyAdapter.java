package com.example.seasons;

import android.content.Context;
import android.content.Intent;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class MyAdapter extends FragmentPagerAdapter {

    private Context myContext;
    int totalTabs;
    Favourites fav;
    winter Winter;
    autumn Autumn;
    rainy Rainy;
    summer Summer;

    public MyAdapter(Context context, FragmentManager fm, int totalTabs) {
        super(fm);
        fav = new Favourites();
        Winter = new winter();
        Autumn = new autumn();
        Rainy = new rainy();
        Summer = new summer();
        myContext = context;
        this.totalTabs = totalTabs;
    }

    // this is for fragment tabs
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                //return new summer();
                return Summer;
            case 1:
                //return new autumn();
                return Autumn;
            case 2:
                //return new rainy();
                return Rainy;
            case 3:
                //winter Winter = new winter();
                return Winter;
            case 4:
                return fav;
                //return new Favourites();
            default:
                return null;
        }
    }

    // this counts total number of tabs
    @Override
    public int getCount() {
        return totalTabs;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        super.destroyItem(container, position, object);
    }
}
