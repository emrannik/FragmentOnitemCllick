package com.emran.example.fragmentonitemcllick;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private final List<Fragment> listFragment=new ArrayList<>();
    private  final List<String> listTitles=new ArrayList<>();

    //
    private int numOfTabs;

    public ViewPagerAdapter(FragmentManager fm, int numOfTabs) {
        super(fm);
        this.numOfTabs=numOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new InfoFragment();
            case 1:
                return new Detail_Fragment();
            case 2:
                return new FavFragment();
            default:
                return null;
        }
        //return listFragment.get(position);
    }

    @Override
    public int getCount() {
        return numOfTabs;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return listTitles.get(position);
    }

    public void AddFragment(Fragment fragment,String title) {
        listFragment.add(fragment);
        listTitles.add(title);
    }
}
