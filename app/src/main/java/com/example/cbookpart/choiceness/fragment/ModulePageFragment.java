package com.example.cbookpart.choiceness.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cbookpart.R;
import com.example.cbookpart.choiceness.data.ModuleBean.ModuleBean;
import com.example.cbookpart.choiceness.adapter.ModuleRecyclerViewAdapter;

import java.util.ArrayList;

public class ModulePageFragment extends Fragment {
    private ArrayList<ModuleBean> mModuleBeans =new ArrayList<>();
    private View mView;
    private RecyclerView mRecyclerView;
    private ModuleRecyclerViewAdapter mModuleRecyclerViewAdapter;


    public ModulePageFragment(ArrayList<ModuleBean> moduleBeans) {
        mModuleBeans = moduleBeans;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView=inflater.inflate(R.layout.module_fragment, container, false);
        init();
        return mView;
    }

    private void init() {
        mRecyclerView=mView.findViewById(R.id.module_recyclerview);
        mModuleRecyclerViewAdapter =new ModuleRecyclerViewAdapter(getContext());
        LinearLayoutManager managerVertical = new LinearLayoutManager(getContext());
        managerVertical.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(managerVertical);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setAdapter(mModuleRecyclerViewAdapter);
        mModuleRecyclerViewAdapter.setModuleBeans(mModuleBeans);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {


    }
}
