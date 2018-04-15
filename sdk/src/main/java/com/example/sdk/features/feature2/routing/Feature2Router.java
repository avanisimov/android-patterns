package com.example.sdk.features.feature2.routing;


import com.example.sdk.commons.routing.BaseRouter;
import com.example.sdk.commons.routing.Screen;
import com.example.sdk.features.feature2.Feature2Fragment1;

import java.util.Map;

public class Feature2Router extends BaseRouter {

    @Override
    protected void initScreens(Map<String, Class<? extends Screen>> screenMap) {
        super.initScreens(screenMap);
        screenMap.put(Feature2Screens.SCREEN_1, Feature2Fragment1.class);
    }
}
