package com.example.sdk.commons.activities;


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;

import com.example.sdk.commons.routing.Router;
import com.example.sdk.commons.routing.Screen;

import toothpick.Toothpick;

public class BaseFragment extends Fragment implements Screen {

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        BaseActivity baseActivity = (BaseActivity) activity;
        Toothpick.inject(this, baseActivity.getScope());
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d("ROUTING", this + "#onViewCreated");
    }

    public Router getRouter() {
        // todo move to ViewModel
        BaseActivity activity = (BaseActivity) getActivity();
        return activity.getRouter();
    }
}
