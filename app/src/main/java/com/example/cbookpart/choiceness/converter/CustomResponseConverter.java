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
import com.example.cbookpart.choiceness.data.baseBean.BaseItemBean;
import com.example.cbookpart.choiceness.data.itemBean.BannerItemBean;
import com.example.cbookpart.choiceness.data.itemBean.BookItemBean;
import com.example.cbookpart.choiceness.data.itemBean.EntryItemBean;

import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Converter;

public class CustomResponseConverter implements Converter<ResponseBody, ResultBean> {

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

            ArrayList<ModuleBean> moduleBeans = resultBean.getValue().get(0).getModules();
            ArrayList<ModuleBean> replaceModules = new ArrayList<>();
            for (int i = 0; i < moduleBeans.size(); i++) {
                ModuleBean moduleBean = moduleBeans.get(i);
                ArrayList<BaseItemBean> baseItemBeans = moduleBean.getItems();
                ArrayList<BaseItemBean> replaceItems = new ArrayList<>();
                String type = moduleBean.getType();
                for (int j = 0; j < baseItemBeans.size(); j++) {
                    Object object = baseItemBeans.get(j);
                    JSONObject jsonObject = (JSONObject) object;
                    if (type.equals("banner")) {
                        BannerItemBean bannerItemBean = JSONObject.toJavaObject(jsonObject, BannerItemBean.class);
                        replaceItems.add(bannerItemBean);
                    }
                    if (type.equals("entry")) {
                        EntryItemBean entryItemBean = JSONObject.toJavaObject(jsonObject, EntryItemBean.class);
                        replaceItems.add(entryItemBean);
                    }
                    if (type.equals("booklist")) {
                        BookItemBean bookItemBean = JSONObject.toJavaObject(jsonObject, BookItemBean.class);
                        replaceItems.add(bookItemBean);
                    }


                }
                if (type.equals("banner")) {
                    BannerModuleBean bannerModuleBean = new BannerModuleBean(moduleBean.getId(), moduleBean.getType(), moduleBean.getTitle(), moduleBean.getChannel(), moduleBean.isShowMore(), moduleBean.getShowType(), moduleBean.getShowNum(),
                            moduleBean.getStartTime(), moduleBean.getEndTime(), moduleBean.getLinkUrl(), moduleBean.isCanDownload(), moduleBean.isCountDownNotShow(), moduleBean.getBtn(), moduleBean.getTargetType(),
                            replaceItems, moduleBean.getCanReceiveTimes());
                    replaceModules.add(bannerModuleBean);
                }
                if (type.equals("entry")) {
                    EntryModuleBean entryModuleBean = new EntryModuleBean(moduleBean.getId(), moduleBean.getType(), moduleBean.getTitle(), moduleBean.getChannel(), moduleBean.isShowMore(), moduleBean.getShowType(), moduleBean.getShowNum(),
                            moduleBean.getStartTime(), moduleBean.getEndTime(), moduleBean.getLinkUrl(), moduleBean.isCanDownload(), moduleBean.isCountDownNotShow(), moduleBean.getBtn(), moduleBean.getTargetType(),
                            replaceItems, moduleBean.getCanReceiveTimes());
                    replaceModules.add(entryModuleBean);
                }
                if (type.equals("booklist")) {
                    BookModuleBean bookModuleBean = new BookModuleBean(moduleBean.getId(), moduleBean.getType(), moduleBean.getTitle(), moduleBean.getChannel(), moduleBean.isShowMore(), moduleBean.getShowType(), moduleBean.getShowNum(),
                            moduleBean.getStartTime(), moduleBean.getEndTime(), moduleBean.getLinkUrl(), moduleBean.isCanDownload(), moduleBean.isCountDownNotShow(), moduleBean.getBtn(), moduleBean.getTargetType(),
                            replaceItems, moduleBean.getCanReceiveTimes());

                    replaceModules.add(bookModuleBean);
                }

            }
            resultBean.getValue().get(0).setModules(replaceModules);

            return resultBean;
        } finally {
            value.close();
        }
    }
}
