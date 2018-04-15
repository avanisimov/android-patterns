package com.example.sdk.features.firstfeature.activities;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.sdk.commons.sys.ViewBinder;
import com.example.sdk.features.firstfeature.viewmodels.FirstFeatureDetailsViewModel;

import javax.inject.Inject;
import javax.inject.Named;

public class FirstFeatureDetailsActivity extends FirstFeatureBaseActivity {

    public static final String NAME = "first_feature_details";

    private static final String DETAILS_ID = "details_id";

    public static Intent createDetailsActivityIntent(Context context, int detailsId) {
        Intent intent = new Intent(context, FirstFeatureDetailsActivity.class);
        intent.putExtra(DETAILS_ID, detailsId);
        return intent;
    }

    @Inject
    @Named(NAME)
    ViewBinder viewBinder;

    @Inject
    FirstFeatureDetailsViewModel vm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        if (intent != null && intent.hasExtra(DETAILS_ID)) {
            int detailsId = intent.getIntExtra(DETAILS_ID, 0);

            vm.init(detailsId);

            viewBinder.setContentView(this);
            registerViewModel(viewBinder.getBaseViewModel());
        } else {
            finish();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
