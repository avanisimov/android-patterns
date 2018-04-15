package com.example.sdk.features.feature1.routing;


import com.example.sdk.commons.routing.BaseRouter;
import com.example.sdk.commons.routing.Screen;
import com.example.sdk.features.feature1.Feature1Fragment1;
import com.example.sdk.features.feature1.Feature1Fragment2;
import com.example.sdk.features.feature1.Feature1Fragment3;

import java.util.Map;

public class Feature1Router extends BaseRouter {

    @Override
    protected void initScreens(Map<String, Class<? extends Screen>> screenMap) {
        super.initScreens(screenMap);
        screenMap.put(Feature1Screens.SCREEN_1, Feature1Fragment1.class);
        screenMap.put(Feature1Screens.SCREEN_2, Feature1Fragment2.class);
        screenMap.put(Feature1Screens.SCREEN_3, Feature1Fragment3.class);
    }
}
