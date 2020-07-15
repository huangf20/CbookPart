package com.example.cbookpart.choiceness.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cbookpart.R;
import com.example.cbookpart.choiceness.data.ModuleBean.ModuleBean;

import java.util.ArrayList;

public class ModulePageFragment extends Fragment {
    private ArrayList<ModuleBean> mModuleBeans =new ArrayList<>();
    private View mView;
    private RecyclerView mRecyclerView;

    public ModulePageFragment(ArrayList<ModuleBean> moduleBeans) {
        mModuleBeans = moduleBeans;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView=inflater.inflate(R.layout.module_fragment, container, false);
        return mView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {


    }
}
