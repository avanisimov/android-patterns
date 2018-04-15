package com.example.sdk.commons;

import android.app.Application;
import android.content.Context;

import com.example.sdk.commons.dimodules.ModulesProvider;

import toothpick.Scope;
import toothpick.Toothpick;


public class MyApplication extends Application {

    private ModulesProvider modulesProvider;

    @Override
    public void onCreate() {
        super.onCreate();

        modulesProvider = buildModulesProvider();

        Scope appScope = Toothpick.openScope(this);
        appScope.installModules(modulesProvider.createAppModule(this));
    }

    public static MyApplication getApp(Context context) {
        return (MyApplication) context.getApplicationContext();
    }

    protected ModulesProvider buildModulesProvider() {
        return new ModulesProvider();
    }

    public ModulesProvider getModulesProvider() {
        return modulesProvider;
    }
}
