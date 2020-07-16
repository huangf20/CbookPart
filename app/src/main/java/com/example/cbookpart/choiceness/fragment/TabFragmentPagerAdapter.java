package com.example.cbookpart.choiceness.fragment;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.cbookpart.choiceness.data.ModuleBean.ModuleBean;
import com.example.cbookpart.choiceness.data.ValueBean;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class TabFragmentPagerAdapter extends FragmentStatePagerAdapter {

    ArrayList<ValueBean> mValueBeans=new ArrayList<>();

    public TabFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }
    public TabFragmentPagerAdapter(FragmentManager fm,ArrayList<ValueBean> valueBeans) {
        super(fm);
        mValueBeans=valueBeans;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        ArrayList<ModuleBean>moduleBeans=mValueBeans.get(position).getModules();
        if(moduleBeans!=null){
            ModulePageFragment fragment = new ModulePageFragment(mValueBeans.get(position).getModules());
            return fragment;
        }
        else{
            Fragment fragment=new Fragment();
            return fragment;
        }
    }

    @Override
    public int getCount() {
        return mValueBeans.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {

        return mValueBeans.get(position).getTitle();
    }
}
