package com.example.sdk.commons;


import android.content.Context;

import com.example.sdk.features.firstfeature.activities.FirstFeatureDetailsActivity;

public class Screens {

    public static void showDetails(Context context, int detailsId) {
        context.startActivity(FirstFeatureDetailsActivity.createDetailsActivityIntent(context, detailsId));
    }

}
