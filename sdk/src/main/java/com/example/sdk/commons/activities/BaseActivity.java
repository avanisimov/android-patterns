package com.example.sdk.commons.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.sdk.R;
import com.example.sdk.commons.MyApplication;
import com.example.sdk.commons.routing.BaseRouter;
import com.example.sdk.commons.routing.Router;
import com.example.sdk.commons.routing.Screen;
import com.example.sdk.commons.sys.BaseViewModel;

import java.util.HashSet;
import java.util.Set;

import javax.inject.Inject;

import toothpick.Scope;
import toothpick.Toothpick;
import toothpick.config.Module;


public class BaseActivity extends AppCompatActivity implements Screen {

    @Inject
    BaseRouter router;

    private Set<BaseViewModel> viewModelSet = new HashSet<>();
    private Scope scope;

    public void registerViewModel(BaseViewModel baseViewModel) {
        viewModelSet.add(baseViewModel);
    }

    public Router getRouter() {
        return router;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        scope = Toothpick.openScopes(MyApplication.getApp(this), this);
        scope.installModules(createModule());

        Toothpick.inject(this, scope);

        router.connect(this, R.id.content);
    }

    public Scope getScope() {
        return scope;
    }

    protected Module createModule() {
        return null;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        router.disconnect();
        Toothpick.closeScope(this);
        clearViewModels();
    }

    private void clearViewModels() {
        for (BaseViewModel viewModel : viewModelSet) {
            viewModel.clear();
        }
        viewModelSet.clear();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //super.onActivityResult(requestCode, resultCode, data);
        router.onActivityResult(requestCode, resultCode, data);
    }
}
