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
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
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

    private ArrayList<String> mTypes = new ArrayList<>();
    private ArrayList<Class<? extends BaseItemBean>> mItemClasses = new ArrayList<>();
    private ArrayList<Class<? extends ModuleBean>> mModuleClasses = new ArrayList<>();

    CustomResponseConverter(Type type, ParserConfig config, int featureValues,
                            Feature... features) {
        mType = type;
        this.config = config;
        this.featureValues = featureValues;
        this.features = features;
        mTypes.add("banner");
        mTypes.add("entry");
        mTypes.add("booklist");
        mItemClasses.add(BannerItemBean.class);
        mItemClasses.add(EntryItemBean.class);
        mItemClasses.add(BookItemBean.class);
        mModuleClasses.add(BannerModuleBean.class);
        mModuleClasses.add(EntryModuleBean.class);
        mModuleClasses.add(BookModuleBean.class);
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
                for (String mtype : mTypes) {
                    if (type.equals(mtype)) {
                        int index = mTypes.indexOf(mtype);
                        for (int j = 0; j < baseItemBeans.size(); j++) {
                            Object object = baseItemBeans.get(j);
                            JSONObject jsonObject = (JSONObject) object;
                            replaceItems.add(JSONObject.toJavaObject(jsonObject, mItemClasses.get(index)));
                        }
                        moduleBean.setItems(replaceItems);
                        Constructor constructor = mModuleClasses.get(index).getConstructor(ModuleBean.class);
                        replaceModules.add((ModuleBean) constructor.newInstance(moduleBean));
                    }
                }


            }
            resultBean.getValue().get(0).setModules(replaceModules);

            return resultBean;
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } finally {
            value.close();
        }
        return null;
    }
}
