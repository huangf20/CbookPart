package com.example.cbookpart.choiceness.converter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.ParserConfig;
import com.example.cbookpart.choiceness.data.ModuleBean.BannerModuleBean;
import com.example.cbookpart.choiceness.data.ModuleBean.BookModuleBean;
import com.example.cbookpart.choiceness.data.ModuleBean.EntryModuleBean;
import com.example.cbookpart.choiceness.data.ModuleBean.ModuleBean;
import com.example.cbookpart.choiceness.data.ResultBean;

import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Converter;

public class CustomResponseConverter<T> implements Converter<ResponseBody, ResultBean> {

    private static final Feature[] EMPTY_SERIALIZER_FEATURES = new Feature[0];

    private Type mType;

    private ParserConfig config;
    private int featureValues;
    private Feature[] features;

    CustomResponseConverter(Type type, ParserConfig config, int featureValues,
                                  Feature... features) {
        mType = type;
        this.config = config;
        this.featureValues = featureValues;
        this.features = features;
    }

    @Override
    public ResultBean convert(ResponseBody value) throws IOException {
        try {
            ResultBean resultBean = JSON.parseObject(value.string(), mType, config, featureValues,
                    features != null ? features : EMPTY_SERIALIZER_FEATURES);

            ArrayList<ModuleBean>moduleBeans=resultBean.getValue().get(0).getModules();
            ArrayList<ModuleBean>replaceBeans=new ArrayList<>();
            for(ModuleBean moduleBean : moduleBeans){
                if(moduleBean.getType()=="banner"){

//                    replaceBeans.add(new BannerModuleBean(moduleBean.getId(),moduleBean.getType(),moduleBean.getTitle(),));
                }
                else if(moduleBean.getType()=="entry"){
                    EntryModuleBean entryModuleBean= (EntryModuleBean) moduleBean;
                    replaceBeans.add(entryModuleBean);
                }else if(moduleBean.getType()=="booklist")
                {
                    BookModuleBean bookModuleBean= (BookModuleBean) moduleBean;
                    replaceBeans.add(bookModuleBean);
                }

            }
            resultBean.getValue().get(0).setModules(replaceBeans);

            return resultBean;
        } finally {
            value.close();
        }
    }
}
