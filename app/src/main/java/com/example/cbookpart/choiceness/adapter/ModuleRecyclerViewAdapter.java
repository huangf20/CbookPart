package com.example.cbookpart.choiceness.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cbookpart.R;
import com.example.cbookpart.choiceness.adapter.holder.AbsModuleHolder;
import com.example.cbookpart.choiceness.adapter.holder.BannerModuleHolder;
import com.example.cbookpart.choiceness.adapter.holder.BookModuleHolder;
import com.example.cbookpart.choiceness.adapter.holder.EntryModuleHolder;
import com.example.cbookpart.choiceness.adapter.holder.RankListModuleHolder;
import com.example.cbookpart.choiceness.data.ModuleBean.BannerModuleBean;
import com.example.cbookpart.choiceness.data.ModuleBean.BookModuleBean;
import com.example.cbookpart.choiceness.data.ModuleBean.EntryModuleBean;
import com.example.cbookpart.choiceness.data.ModuleBean.ModuleBean;
import com.example.cbookpart.choiceness.data.ModuleBean.RankListModuleBean;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class ModuleRecyclerViewAdapter extends RecyclerView.Adapter<AbsModuleHolder> {
    private ArrayList<ModuleBean> mModuleBeans = new ArrayList<>();
    private Context mContext;

    public ModuleRecyclerViewAdapter(Context context) {
        mContext = context;
    }

    public void setModuleBeans(ArrayList<ModuleBean> moduleBeans) {
        mModuleBeans = moduleBeans;
        notifyDataSetChanged();

    }

    private List<Class<? extends ModuleBean>> mModuleTypes = new ArrayList<>();
    private List<Class<? extends AbsModuleHolder>> mHolderTypes = new ArrayList<>();
    private List<Integer> mViewTypes = new ArrayList<>();

    {
        registerModule(BannerModuleBean.class, BannerModuleHolder.class, R.layout.layout_banner_module);
        registerModule(EntryModuleBean.class, EntryModuleHolder.class, R.layout.layout_entry_module);
        registerModule(BookModuleBean.class, BookModuleHolder.class, R.layout.layout_booklist_module);
        registerModule(RankListModuleBean.class, RankListModuleHolder.class, R.layout.layout_ranklist_module);
    }

    private void registerModule(Class<? extends ModuleBean> dataClass, Class<? extends AbsModuleHolder> holderClass, int layoutId) {
        mModuleTypes.add(dataClass);
        mHolderTypes.add(holderClass);
        mViewTypes.add(layoutId);
    }


    @NonNull
    @Override
    public AbsModuleHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(mViewTypes.get(viewType), parent, false);
        Class holder = mHolderTypes.get(viewType);

        try {
            Constructor constructor = holder.getConstructor(View.class, ModuleRecyclerViewAdapter.class);
            Object absHolder = constructor.newInstance(view, ModuleRecyclerViewAdapter.this);
            return (AbsModuleHolder) absHolder;
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull AbsModuleHolder holder, int position) {
        holder.bindData(mModuleBeans.get(position), position);
    }

    @Override
    public int getItemViewType(int position) {
        return mModuleTypes.indexOf(mModuleBeans.get(position).getClass());
    }

    @Override
    public int getItemCount() {
        return mModuleBeans.size();
    }

    public Context getContext() {
        return mContext;
    }
}
