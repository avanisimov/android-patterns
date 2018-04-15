package com.example.sdk.features.firstfeature.viewmodels;

import android.databinding.ObservableField;

import com.example.sdk.commons.activities.BaseActivity;
import com.example.sdk.features.firstfeature.models.ItemDetail;
import com.example.sdk.features.firstfeature.repositories.FirstFeatureRepository;
import com.example.sdk.commons.sys.BaseViewModel;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;


public class FirstFeatureDetailsViewModel extends BaseViewModel {

    private FirstFeatureRepository mainRepository;

    private ObservableField<ItemDetail> details = new ObservableField<>();

    @Inject
    public FirstFeatureDetailsViewModel(BaseActivity baseActivity, FirstFeatureRepository repository) {
        super(null);
        this.mainRepository = repository;
    }

    public void init(int id) {
        setLoading(true);
        regiserDisposables(
                mainRepository.getDetails(id)
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe((itemDetail, throwable) -> {
                            setLoading(false);
                            details.set(itemDetail);
                        })
        );

    }

    public ObservableField<ItemDetail> getDetails() {
        return details;
    }
}
