package com.example.sdk.features.feature3.vm;


import android.databinding.ObservableField;
import android.os.Bundle;

import com.example.sdk.commons.routing.BaseRouter;
import com.example.sdk.commons.sys.BaseViewModel;
import com.example.sdk.features.feature3.routing.Feature3Screens;

public class Feature3ViewModel1 extends BaseViewModel {

    public final ObservableField<String> name = new ObservableField<>();
    public final ObservableField<String> result = new ObservableField<>();

    public Feature3ViewModel1(BaseRouter router) {
        super(router);
        name.set(getClass().getSimpleName() + " " + hashCode());
    }

    public void setResult1() {
        Bundle args = new Bundle();
        args.putString(Feature3Screens.ARG_ITEM, "result1");
        getRouter().backWithResult(args);
    }

    public void setResult2() {
        Bundle args = new Bundle();
        args.putString(Feature3Screens.ARG_ITEM, "result2");
        getRouter().backWithResult(args);
    }

    public void setResult3() {
        Bundle args = new Bundle();
        args.putString(Feature3Screens.ARG_ITEM, "result3");
        getRouter().backWithResult(args);
    }

}
