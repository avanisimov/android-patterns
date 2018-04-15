package com.example.sdk.features.firstfeature.viewmodels;

import com.example.sdk.R;
import com.example.sdk.commons.Screens;
import com.example.sdk.commons.activities.BaseActivity;
import com.example.sdk.features.firstfeature.models.ListItem;
import com.example.sdk.features.firstfeature.repositories.FirstFeatureRepository;
import com.example.sdk.commons.sys.BaseViewModel;
import com.example.sdk.commons.sys.DataBindingRenderer;
import com.example.sdk.commons.sys.ListConfig;
import com.github.vivchar.rendererrecyclerviewadapter.RendererRecyclerViewAdapter;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;


public class FirstFeatureListViewModel extends BaseViewModel {

    protected FirstFeatureRepository mainRepository;

    protected RendererRecyclerViewAdapter rendererRecyclerViewAdapter;
    protected ListConfig listConfig;

    @Inject
    public FirstFeatureListViewModel(BaseActivity baseActivity, FirstFeatureRepository repository) {
        super(null);
        setLoading(true);

        this.mainRepository = repository;

        createAdapter();

        regiserDisposables(
                mainRepository.getItems()
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe((listItems, throwable) -> {
                        rendererRecyclerViewAdapter.setItems(listItems);
                        setLoading(false);
                    })
        );
    }

    protected void createAdapter() {
//        rendererRecyclerViewAdapter = new RendererRecyclerViewAdapter();
//        rendererRecyclerViewAdapter.registerRenderer(
//                new DataBindingRenderer<>(ListItem.class, getContext(), R.layout.layout_list_item,
//                        item -> Screens.showDetails(getContext(), item.getId())));
//
//        listConfig = new ListConfig.Builder(rendererRecyclerViewAdapter)
//                .setHasFixedSize(true)
//                .build(getContext());
    }

    public ListConfig getListConfig() {
        return listConfig;
    }

}
