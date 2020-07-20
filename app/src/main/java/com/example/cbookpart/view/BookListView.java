package com.example.cbookpart.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;

import com.example.cbookpart.R;
import com.example.cbookpart.choiceness.data.ModuleBean.BookModuleBean;
import com.example.cbookpart.choiceness.data.itemBean.BookItemBean;


public class BookListView extends FrameLayout {
    Context mContext;
    BookModuleBean mModuleBean;
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
        mContext=context;
        View view= LayoutInflater.from(mContext).inflate(R.layout.layout_booklist_view,this,false);
        addView(view);
    }


    public void setModuleBean(BookModuleBean moduleBean) {
        mModuleBean = moduleBean;
        String showType = mModuleBean.getShowType();

        if(showType.equals("one_plus_four")){
            View view=LayoutInflater.from(mContext).inflate(R.layout.layout_booklist_one_plus_four,this,false);
            removeAllViews();
            setOnePlusFour(view);
        }
        if(showType.equals("row")){
            View view=LayoutInflater.from(mContext).inflate(R.layout.layout_booklist_row,this,false);
            removeAllViews();
            setRow(view);
        }

        if(showType.equals("img_row")){
            View view=LayoutInflater.from(mContext).inflate(R.layout.layout_booklist_img_row,this,false);
            removeAllViews();
            setImgRow(view);

        }

        if(showType.equals("column")){
            View view=LayoutInflater.from(mContext).inflate(R.layout.layout_booklist_column,this,false);
            removeAllViews();
            setColumn(view);
        }

    }

    private void setOnePlusFour(View view) {
        TextView tvTitle,tvBigName,tvAuthor,tvShortDesc,tvCategory,tvWordCount,tvReadingCount,tvSmallName1,tvSmallName2,tvSmallName3,tvSmallName4;
        ImageView ivBigIcon,ivSmallIcon1,ivSmallIcon2,ivSmallIcon3,ivSmallIcon4;
        {
            tvTitle=view.findViewById(R.id.title_one_plus_four);
            tvBigName=view.findViewById(R.id.tv_big_name_one_plus);
            tvAuthor=view.findViewById(R.id.tv_author_one_plus);
            tvShortDesc=view.findViewById(R.id.tv_shortDesc_one_plus);
            tvCategory=view.findViewById(R.id.tv_category_one_plus);
            tvWordCount=view.findViewById(R.id.tv_wordCount_one_plus);
            tvReadingCount=view.findViewById(R.id.tv_readingCount_one_plus);
            ivBigIcon=view.findViewById(R.id.big_icon_one_plus);
            ivSmallIcon1=view.findViewById(R.id.small_icon1_one_plus);
            ivSmallIcon2=view.findViewById(R.id.small_icon2_one_plus);
            ivSmallIcon3=view.findViewById(R.id.small_icon3_one_plus);
            ivSmallIcon4=view.findViewById(R.id.small_icon4_one_plus);
            tvSmallName1=view.findViewById(R.id.tv_name1_small_one_plus);
            tvSmallName2=view.findViewById(R.id.tv_name2_small_one_plus);
            tvSmallName3=view.findViewById(R.id.tv_name3_small_one_plus);
            tvSmallName4=view.findViewById(R.id.tv_name4_small_one_plus);
        }
        tvTitle.setText(mModuleBean.getTitle());

        BookItemBean bigBookItemBean = mModuleBean.getItems().get(0);
        tvBigName.setText(bigBookItemBean.getName());
        tvAuthor.setText(bigBookItemBean.getAuthor());
        tvShortDesc.setText(bigBookItemBean.getShortDesc());
        tvCategory.setText(bigBookItemBean.getCategory());
        tvWordCount.setText(bigBookItemBean.getWordCount()+"");
        tvReadingCount.setText(bigBookItemBean.getReadingCount());
        Glide.with(mContext)
                .load(bigBookItemBean.getCoverUrl().replace("http://","https://"))
                .into(ivBigIcon);
        Glide.with(mContext)
                .load(mModuleBean.getItems().get(1).getCoverUrl())
                .into(ivSmallIcon1);
        Glide.with(mContext)
                .load(mModuleBean.getItems().get(2).getCoverUrl())
                .into(ivSmallIcon2);
        Glide.with(mContext)
                .load(mModuleBean.getItems().get(3).getCoverUrl())
                .into(ivSmallIcon3);
        Glide.with(mContext)
                .load(mModuleBean.getItems().get(4).getCoverUrl())
                .into(ivSmallIcon4);
        tvSmallName1.setText(mModuleBean.getItems().get(1).getName());
        tvSmallName2.setText(mModuleBean.getItems().get(2).getName());
        tvSmallName3.setText(mModuleBean.getItems().get(3).getName());
        tvSmallName4.setText(mModuleBean.getItems().get(4).getName());
        addView(view);
    }
    private void setRow(View view) {
        addView(view);
    }
    private void setImgRow(View view) {
        addView(view);
    }
    private void setColumn(View view) {
        addView(view);
    }






}
