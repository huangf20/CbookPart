package com.example.cbookpart.choiceness.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import com.example.cbookpart.R;
import com.example.cbookpart.tool.ImageLoader;
import com.example.cbookpart.tool.PageJump;
import com.example.cbookpart.choiceness.adapter.BookListRecyclerViewAdapter;
import com.example.cbookpart.choiceness.data.ModuleBean.BookModuleBean;
import com.example.cbookpart.choiceness.data.itemBean.BookItemBean;

import java.util.ArrayList;


public class BookListView extends FrameLayout implements View.OnClickListener {
    Context mContext;
    BookModuleBean mModuleBean;
    ArrayList<String> mshowTypes =new ArrayList<>();
    public BookListView(@NonNull Context context) {
        super(context);
        init(context);
    }


    public BookListView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public BookListView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public BookListView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    private void init(Context context) {
        mContext = context;
        View view = LayoutInflater.from(mContext).inflate(R.layout.layout_booklist_view, this, false);
        addView(view);
        mshowTypes.add("img_row");
        mshowTypes.add("column");
        mshowTypes.add("row");


    }

    public void setModuleBean(BookModuleBean moduleBean) {
        mModuleBean = moduleBean;
        String showType = mModuleBean.getShowType();

        if (showType.equals("one_plus_four")) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.layout_booklist_one_plus_four, this, false);
            removeAllViews();
            setOnePlusFour(view);
        }
        for(String type : mshowTypes) {
            if(showType.equals(type)){
                int index=mshowTypes.indexOf(type);
                View view = LayoutInflater.from(mContext).inflate(R.layout.layout_booklist_common, this, false);
                removeAllViews();
                setBookListCommon(view,index,getManagers().get(index));
            }
        }


    }

    private void setOnePlusFour(View view) {
        TextView tvTitle, tvMore,tvBigName, tvAuthor, tvShortDesc, tvCategory, tvWordCount, tvReadingCount, tvSmallName1, tvSmallName2, tvSmallName3, tvSmallName4;
        ImageView ivBigIcon, ivMore,ivSmallIcon1, ivSmallIcon2, ivSmallIcon3, ivSmallIcon4, ivFree;
        {
            tvTitle = view.findViewById(R.id.title_one_plus_four);
            tvMore=view.findViewById(R.id.one_plus_bt_more);
            tvMore.setOnClickListener(this);
            tvBigName = view.findViewById(R.id.tv_big_name_one_plus);
            tvAuthor = view.findViewById(R.id.tv_author_one_plus);
            tvShortDesc = view.findViewById(R.id.tv_shortDesc_one_plus);
            tvCategory = view.findViewById(R.id.tv_category_one_plus);
            tvWordCount = view.findViewById(R.id.tv_wordCount_one_plus);
            tvReadingCount = view.findViewById(R.id.tv_readingCount_one_plus);
            ivBigIcon = view.findViewById(R.id.big_icon_one_plus);
            ivBigIcon.setOnClickListener(this);
            ivMore=view.findViewById(R.id.one_plus_iv_more);
            ivMore.setOnClickListener(this);
            ivFree = view.findViewById(R.id.bt_free_read_one_plus);
            ivFree.setOnClickListener(this);
            ivSmallIcon1 = view.findViewById(R.id.small_icon1_one_plus);
            ivSmallIcon2 = view.findViewById(R.id.small_icon2_one_plus);
            ivSmallIcon3 = view.findViewById(R.id.small_icon3_one_plus);
            ivSmallIcon4 = view.findViewById(R.id.small_icon4_one_plus);
            tvSmallName1 = view.findViewById(R.id.tv_name1_small_one_plus);
            tvSmallName2 = view.findViewById(R.id.tv_name2_small_one_plus);
            tvSmallName3 = view.findViewById(R.id.tv_name3_small_one_plus);
            tvSmallName4 = view.findViewById(R.id.tv_name4_small_one_plus);
            ivSmallIcon1.setOnClickListener(this);
            ivSmallIcon2.setOnClickListener(this);
            ivSmallIcon3.setOnClickListener(this);
            ivSmallIcon4.setOnClickListener(this);
            tvSmallName1.setOnClickListener(this);
            tvSmallName2.setOnClickListener(this);
            tvSmallName3.setOnClickListener(this);
            tvSmallName4.setOnClickListener(this);
            LinearLayout linearLayout = view.findViewById(R.id.one_plus_linear);
            linearLayout.setOnClickListener(this);
        }
        tvTitle.setText(mModuleBean.getTitle());

        BookItemBean bigBookItemBean = mModuleBean.getItems().get(0);
        tvBigName.setText(bigBookItemBean.getName());
        tvAuthor.setText(bigBookItemBean.getAuthor());
        tvShortDesc.setText(bigBookItemBean.getShortDesc());
        tvCategory.setText(bigBookItemBean.getCategory());
        tvWordCount.setText(bigBookItemBean.getWordCount() / 10000 + "万字");
        tvReadingCount.setText(bigBookItemBean.getReadingCount());

        ImageLoader.setImageToView(mContext,bigBookItemBean.getCoverUrl().replace("http://", "https://"),ivBigIcon);
        ImageLoader.setImageToView(mContext,mModuleBean.getItems().get(1).getCoverUrl(),ivSmallIcon1);
        ImageLoader.setImageToView(mContext,mModuleBean.getItems().get(2).getCoverUrl(),ivSmallIcon2);
        ImageLoader.setImageToView(mContext,mModuleBean.getItems().get(3).getCoverUrl(),ivSmallIcon3);
        ImageLoader.setImageToView(mContext,mModuleBean.getItems().get(4).getCoverUrl(),ivSmallIcon4);

        tvSmallName1.setText(mModuleBean.getItems().get(1).getName());
        tvSmallName2.setText(mModuleBean.getItems().get(2).getName());
        tvSmallName3.setText(mModuleBean.getItems().get(3).getName());
        tvSmallName4.setText(mModuleBean.getItems().get(4).getName());
        addView(view);
    }


    private void setBookListCommon(View view,int type,LinearLayoutManager linearLayoutManager){
        RecyclerView recyclerView;
        TextView tvTitle, tvMore;
        ImageView ivMore;
        recyclerView = view.findViewById(R.id.img_row_recyclerview);
        tvTitle = view.findViewById(R.id.img_row_title);
        tvMore = view.findViewById(R.id.img_row_bt_more);
        ivMore=view.findViewById(R.id.img_row_iv_more);
        tvMore.setOnClickListener(this);
        ivMore.setOnClickListener(this);
        tvTitle.setText(mModuleBean.getTitle());
        BookListRecyclerViewAdapter bookListRecyclerViewAdapter = new BookListRecyclerViewAdapter(mModuleBean.getItems(), mContext, type);

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(bookListRecyclerViewAdapter);
        addView(view);
    }





    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.big_icon_one_plus || view.getId() == R.id.one_plus_linear) {
            PageJump.jumpToDetailById(mModuleBean.getItems().get(0).getBookId(),  mContext);
        }
        if (view.getId() == R.id.small_icon1_one_plus || view.getId() == R.id.small_icon1_one_plus) {
            PageJump.jumpToDetailById(mModuleBean.getItems().get(1).getBookId(),  mContext);
        }
        if (view.getId() == R.id.small_icon2_one_plus || view.getId() == R.id.small_icon2_one_plus) {
            PageJump.jumpToDetailById(mModuleBean.getItems().get(2).getBookId(),  mContext);
        }
        if (view.getId() == R.id.small_icon3_one_plus || view.getId() == R.id.small_icon3_one_plus) {
            PageJump.jumpToDetailById(mModuleBean.getItems().get(3).getBookId(),  mContext);
        }
        if (view.getId() == R.id.small_icon4_one_plus || view.getId() == R.id.small_icon4_one_plus) {
            PageJump.jumpToDetailById(mModuleBean.getItems().get(4).getBookId(),  mContext);
        }
        if (view.getId() == R.id.bt_free_read_one_plus) {
            PageJump.jumpToReaderById(mModuleBean.getItems().get(0).getBookId(),  mContext);
        }
        if(view.getId()==R.id.one_plus_bt_more||view.getId()==R.id.one_plus_iv_more)
        {
            PageJump.jumpTo(mModuleBean.getLinkUrl(),mContext);
        }
        if(view.getId()==R.id.img_row_bt_more||view.getId()==R.id.img_row_iv_more){
            PageJump.jumpTo(mModuleBean.getLinkUrl(),mContext);
        }
    }

    private ArrayList<LinearLayoutManager>getManagers()
    {
        ArrayList<LinearLayoutManager> layoutManagers=new ArrayList<>();
        LinearLayoutManager managerHorizontal = new LinearLayoutManager(mContext);
        managerHorizontal.setOrientation(LinearLayoutManager.HORIZONTAL);
        layoutManagers.add(managerHorizontal);
        LinearLayoutManager managerVertical = new LinearLayoutManager(mContext);
        managerVertical.setOrientation(LinearLayoutManager.VERTICAL);
        layoutManagers.add(managerVertical);
        GridLayoutManager managerGrid = new GridLayoutManager(mContext, 4);
        layoutManagers.add(managerGrid);
        return layoutManagers;
    }
}
