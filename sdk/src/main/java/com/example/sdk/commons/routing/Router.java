package com.example.sdk.commons.routing;


import android.os.Bundle;

import io.reactivex.Single;

public interface Router {

    void goTo(String screenKey, Bundle args);

    Single<Bundle> goToWithResult(String screenKey, Bundle args);

    void replace(String screenKey, Bundle args);

    void back();

    void backWithResult(Bundle result);

}
