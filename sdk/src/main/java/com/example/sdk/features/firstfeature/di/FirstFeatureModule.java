package com.example.sdk.features.firstfeature.di;

import com.example.sdk.R;
import com.example.sdk.commons.activities.BaseActivity;
import com.example.sdk.commons.di.ActivityModule;
import com.example.sdk.commons.sys.ViewBinder;
import com.example.sdk.features.firstfeature.activities.FirstFeatureDetailsActivity;
import com.example.sdk.features.firstfeature.activities.FirstFeatureListActivity;
import com.example.sdk.features.firstfeature.viewmodels.FirstFeatureDetailsViewModel;
import com.example.sdk.features.firstfeature.viewmodels.FirstFeatureListViewModel;


public class FirstFeatureModule extends ActivityModule {

    public FirstFeatureModule(BaseActivity baseActivity, toothpick.Scope scope) {
        super(baseActivity, scope);

        bindList();

        bind(FirstFeatureDetailsViewModel.class).singletonInScope();
        bind(ViewBinder.class).withName(FirstFeatureDetailsActivity.NAME).toProviderInstance(() ->
                new ViewBinder(R.layout.activity_details, getScope().getInstance(FirstFeatureDetailsViewModel.class)));
    }

    protected void bindList() {
        bind(FirstFeatureListViewModel.class).singletonInScope();
        bind(ViewBinder.class).withName(FirstFeatureListActivity.NAME).toProviderInstance(() ->
                new ViewBinder(R.layout.activity_main, getScope().getInstance(FirstFeatureListViewModel.class)));
    }

}
