package com.example.sdk.features.firstfeature.repositories;


import com.example.sdk.features.firstfeature.models.ItemDetail;
import com.example.sdk.features.firstfeature.models.ListItem;

import java.util.List;

import io.reactivex.Single;

public interface FirstFeatureRepository {
    Single<List<ListItem>> getItems();
    Single<ItemDetail> getDetails(int id);
}
