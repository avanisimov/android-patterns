package com.example.sdk.features.feature3.routing;


import com.example.sdk.commons.routing.BaseRouter;
import com.example.sdk.commons.routing.Screen;
import com.example.sdk.features.feature2.Feature2Fragment1;
import com.example.sdk.features.feature2.routing.Feature2Screens;
import com.example.sdk.features.feature3.Feature3Fragment1;

import java.util.Map;

public class Feature3Router extends BaseRouter {

    @Override
    protected void initScreens(Map<String, Class<? extends Screen>> screenMap) {
        super.initScreens(screenMap);
        screenMap.put(Feature3Screens.SCREEN_1, Feature3Fragment1.class);
    }
}
