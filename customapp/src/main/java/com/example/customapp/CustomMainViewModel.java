package com.example.customapp;

import android.content.Context;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.sdk.commons.Screens;
import com.example.sdk.commons.activities.BaseActivity;
import com.example.sdk.commons.sys.DataBindingRenderer;
import com.example.sdk.commons.sys.ListConfig;
import com.example.sdk.commons.sys.RecyclerViewHolder;
import com.example.sdk.databinding.LayoutListItemBinding;
import com.example.sdk.features.firstfeature.models.ListItem;
import com.example.sdk.features.firstfeature.repositories.FirstFeatureRepository;
import com.example.sdk.features.firstfeature.viewmodels.FirstFeatureListViewModel;
import com.github.vivchar.rendererrecyclerviewadapter.RendererRecyclerViewAdapter;


public class CustomMainViewModel extends FirstFeatureListViewModel {

    private ObservableField<String> scrolledPosition = new ObservableField<String>("0");

    CustomMainViewModel(BaseActivity baseActivity, FirstFeatureRepository repository) {
        super(baseActivity, repository);
    }

    @Override
    protected void createAdapter() {
//        rendererRecyclerViewAdapter = new RendererRecyclerViewAdapter();
//        rendererRecyclerViewAdapter.registerRenderer(
//                new ListItemRenderer(ListItem.class, getContext(), com.example.sdk.R.layout.layout_list_item,
//                        item -> Screens.showDetails(getContext(), item.getId())));
//
//        final LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
//
//        listConfig = new ListConfig.Builder(rendererRecyclerViewAdapter)
//                .setHasFixedSize(true)
//                .setLayoutManagerProvider(context -> layoutManager)
//                .addOnScrollListener(new RecyclerView.OnScrollListener() {
//                    @Override
//                    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
//                        super.onScrolled(recyclerView, dx, dy);
//
//                        scrolledPosition.set(String.valueOf(layoutManager.findFirstVisibleItemPosition()));
//                    }
//                })
//                .build(getContext());
    }

    public ObservableField<String> getScrolledPosition() {
        return scrolledPosition;
    }

    public class ListItemRenderer extends DataBindingRenderer<ListItem> {

        public ListItemRenderer(@NonNull Class<ListItem> type, @NonNull Context context, int resId, OnItemClickListener<ListItem> clickListener) {
            super(type, context, resId, clickListener);
        }

        @Override
        public void bindView(@NonNull ListItem model, @NonNull RecyclerViewHolder holder) {
            super.bindView(model, holder);

            ((LayoutListItemBinding) holder.getBinding()).name.setTextColor(
                    getContext().getResources().getColor(
                            model.getId()%2 == 0 ? R.color.colorAccent : R.color.colorPrimary
                    )
            );
        }
    }
}
