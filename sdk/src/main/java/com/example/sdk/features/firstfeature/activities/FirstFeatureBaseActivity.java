package com.example.sdk.features.firstfeature.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.sdk.commons.MyApplication;
import com.example.sdk.commons.activities.BaseActivity;

import toothpick.Scope;
import toothpick.Toothpick;


public class FirstFeatureBaseActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Scope scope = Toothpick.openScopes(MyApplication.getApp(this), this);
        scope.installModules(MyApplication.getApp(this).getModulesProvider().createFirstFeatureModule(this, scope));
        Toothpick.inject(this, scope);
        Toothpick.closeScope(this);
    }
}
