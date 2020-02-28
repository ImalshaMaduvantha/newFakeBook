package com.example.newfakebook;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class MyFragmentAdapter extends FragmentPagerAdapter {

    public MyFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new BlueFragment();
            case 1:
                return new RedFragment();
            case 2:
                return new BlackFragment();
            case 3:
                return new GreenFragment();
            default:
                return new BlueFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Nullable
    @Override
    public String getPageTitle(int position) {
        String name="";



        switch (position){
            case 0 :
                name = "ADD";
                break;
            case  1 :
                name = "SEARCH";
                break;
            case  2 :
                name = "ALL";
                break;
            case  3 :
                name = "OTHERS";
                break;
        }

        return name;
    }
}
