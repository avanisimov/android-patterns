package com.example.sdk.commons.sys;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.BindingAdapter;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.sdk.commons.activities.BaseActivity;
import com.example.sdk.commons.routing.BaseRouter;
import com.example.sdk.commons.routing.Router;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;


public class BaseViewModel extends BaseObservable {


    private BaseRouter router;

    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    private ObservableBoolean isLoading = new ObservableBoolean(false);

    public BaseViewModel(BaseRouter router) {
        this.router = router;
    }

    public Router getRouter() {
        return router;
    }

    public void setLoading(boolean loading) {
        this.isLoading.set(loading);
    }

    public ObservableBoolean getIsLoading() {
        return isLoading;
    }

    public void regiserDisposables(Disposable... disposables) {
        compositeDisposable.addAll(disposables);
    }

    public void clear() {
        compositeDisposable.clear();
    }

    @BindingAdapter("onClick")
    public static void bindOnClick(View view, final Runnable runnable) {
        view.setOnClickListener(v -> runnable.run());
    }

    @BindingAdapter("listConfig")
    public static void configRecyclerView(RecyclerView recyclerView, ListConfig config) {
        if (config != null)
            config.applyConfig(recyclerView.getContext(), recyclerView);
    }

    @BindingAdapter("visibility")
    public static void setVisibility(View view, boolean isVisible) {
        view.setVisibility(isVisible ? View.VISIBLE : View.GONE);
    }
}
