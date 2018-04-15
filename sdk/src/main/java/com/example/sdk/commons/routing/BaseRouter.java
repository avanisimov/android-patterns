package com.example.sdk.commons.routing;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;

import com.example.sdk.commons.activities.BaseActivity;
import com.example.sdk.commons.activities.BaseFragment;
import com.example.sdk.features.feature1.Feature1Activity1;
import com.example.sdk.features.feature1.routing.Feature1Screens;
import com.example.sdk.features.feature2.Feature2Activity1;
import com.example.sdk.features.feature2.routing.Feature2Screens;
import com.example.sdk.features.feature3.Feature3Activity1;
import com.example.sdk.features.feature3.routing.Feature3Screens;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Single;
import io.reactivex.subjects.PublishSubject;

public class BaseRouter implements Router {

    private final Map<String, Class<? extends Screen>> screenMap = new HashMap<>();
    private BaseActivity activity;
    private int contentId;

    PublishSubject<Bundle> resultSubject = PublishSubject.create();
    int requestCode = 555;

    public BaseRouter() {
        initScreens(screenMap);
    }

    protected void initScreens(Map<String, Class<? extends Screen>> screenMap) {
        screenMap.put(Feature1Screens.SCREEN_1, Feature1Activity1.class);
        screenMap.put(Feature2Screens.SCREEN_1, Feature2Activity1.class);
        screenMap.put(Feature3Screens.SCREEN_1, Feature3Activity1.class);
    }

    public void connect(BaseActivity activity, @IdRes int contentId) {
        this.activity = activity;
        this.contentId = contentId;
    }

    public void disconnect() {
        this.activity = null;
        this.contentId = 0;
    }

    @Override
    public void goTo(String screenKey, Bundle args) {
        // TODO fix this adhoc
        if (args == null) {
            args = new Bundle();
        }
        if (screenMap.containsKey(screenKey)) {
            if (activity != null) {
                Class<? extends Screen> screenClass = screenMap.get(screenKey);
                if (BaseFragment.class.isAssignableFrom(screenClass)) {
                    try {
                        BaseFragment fragment = (BaseFragment) screenClass.newInstance();
                        fragment.setArguments(args);
                        activity
                                .getSupportFragmentManager()
                                .beginTransaction()
                                .addToBackStack(screenClass.getCanonicalName())
                                .add(contentId, fragment, screenClass.getCanonicalName())
                                .commit();
                    } catch (Exception e) {
                        e.printStackTrace();
                        throw new RuntimeException(e);
                    }
                } else if (BaseActivity.class.isAssignableFrom(screenClass)) {
                    Intent intent = new Intent(activity, screenClass).putExtras(args);
                    activity.startActivity(intent);
                }
            } else {
                throw new IllegalArgumentException("No connected activity for key=" + screenKey + " in " + this);
            }
        } else {
            throw new IllegalArgumentException("No screen for key=" + screenKey + " in " + this);
        }
    }

    @Override
    public Single<Bundle> goToWithResult(String screenKey, Bundle args) {
        if (screenMap.containsKey(screenKey)) {
            if (activity != null) {
                Class<? extends Screen> screenClass = screenMap.get(screenKey);
                if (BaseFragment.class.isAssignableFrom(screenClass)) {
                    try {
                        BaseFragment fragment = (BaseFragment) screenClass.newInstance();
                        fragment.setArguments(args);
                        activity
                                .getSupportFragmentManager()
                                .beginTransaction()
                                .addToBackStack(screenClass.getCanonicalName())
                                .add(contentId, fragment, screenClass.getCanonicalName())
                                .commit();
                    } catch (Exception e) {
                        e.printStackTrace();
                        throw new RuntimeException(e);
                    }
                } else if (BaseActivity.class.isAssignableFrom(screenClass)) {
                    Intent intent = new Intent(activity, screenClass).putExtras(args);
                    activity.startActivityForResult(intent, requestCode);
                }
            } else {
                throw new IllegalArgumentException("No connected activity for key=" + screenKey + " in " + this);
            }
        } else {
            throw new IllegalArgumentException("No screen for key=" + screenKey + " in " + this);
        }

        return resultSubject.firstOrError();
    }

    @Override
    public void replace(String screenKey, Bundle args) {

    }

    @Override
    public void back() {

    }

    @Override
    public void backWithResult(Bundle result) {
        activity.setResult(Activity.RESULT_OK, new Intent().putExtras(result));
        activity.finish();
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        Bundle extras = data.getExtras();
        if (extras == null) {
            extras = new Bundle();
        }
        resultSubject.onNext(extras);
    }
}
