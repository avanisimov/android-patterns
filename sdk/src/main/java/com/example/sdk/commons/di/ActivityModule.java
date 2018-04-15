package com.example.sdk.commons.di;

import com.example.sdk.commons.activities.BaseActivity;

import toothpick.Scope;
import toothpick.config.Module;


public class ActivityModule extends Module {

    private Scope scope;

    public ActivityModule(BaseActivity baseActivity, Scope scope) {
        this.scope = scope;
        bind(BaseActivity.class).toInstance(baseActivity);
    }

    public Scope getScope() {
        return scope;
    }

}
