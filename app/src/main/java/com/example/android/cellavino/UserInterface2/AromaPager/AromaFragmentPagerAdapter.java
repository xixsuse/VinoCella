package com.example.android.cellavino.UserInterface2.AromaPager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

/**
 * Created by Andrew on 18/07/2017.
 */

public class AromaFragmentPagerAdapter extends android.support.v4.app.FragmentPagerAdapter {

    public AromaFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    private String tabTitles[] = new String[]{"Fruit", "Earthy", "Floral", "Spicy", "Woody", "Other"};


    @Override
    public Fragment getItem(int position) {

        if (position == 0) {
            return new FruitFragment();
        } else if (position == 1) {
            return new EarthyFragment();
        } else if (position == 2) {
            return new FloralFragment();
        } else if (position == 3) {
            return new SpicyFragment();
        } else if (position == 4) {
            return new WoodyFragment();
        } else {
            return new OtherFragment();
        }
    }

    @Override
    public int getCount() {
        return 6;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return tabTitles[position];
    }
}
