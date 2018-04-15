package com.example.sdk.commons.sys;

import android.content.Context;
import android.support.annotation.IntRange;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.helper.ItemTouchHelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by ruslan
 * on 20.10.17.
 */

public class ListConfig {
    private final RecyclerView.Adapter mAdapter;
    private final LayoutManagerProvider mLayoutManagerProvider;
    private final RecyclerView.ItemAnimator mItemAnimator;
    private final List<RecyclerView.ItemDecoration> mItemDecorations;
    private final List<RecyclerView.OnScrollListener> mScrollListeners;
    private final ItemTouchHelper mItemTouchHelper;
    private final boolean mHasFixedSize;
    private int mItemViewCacheSize;
    private boolean mDrawingCacheEnabled;
    private int mDrawingCacheQuality;

    private ListConfig(final RecyclerView.Adapter adapter,
                       final LayoutManagerProvider layoutManagerProvider,
                       final RecyclerView.ItemAnimator itemAnimator, final List<RecyclerView.ItemDecoration> itemDecorations,
                       final List<RecyclerView.OnScrollListener> scrollListeners,
                       final ItemTouchHelper itemTouchHelper,
                       final boolean hasFixedSize,
                       final int itemViewCacheSize,
                       final boolean drawingCacheEnabled,
                       final int drawingCacheQuality) {

        mAdapter = adapter;
        mLayoutManagerProvider = layoutManagerProvider;
        mItemAnimator = itemAnimator;
        mItemDecorations = itemDecorations != null ? itemDecorations : Collections.<RecyclerView.ItemDecoration>emptyList();
        mScrollListeners = scrollListeners != null ? scrollListeners : Collections.<RecyclerView.OnScrollListener>emptyList();
        mItemTouchHelper = itemTouchHelper;
        mHasFixedSize = hasFixedSize;
        mItemViewCacheSize = itemViewCacheSize;
        mDrawingCacheEnabled = drawingCacheEnabled;
        mDrawingCacheQuality = drawingCacheQuality;
    }

    /**
     * Applies defined configuration for RecyclerView
     *
     * @param context      the baseActivity
     * @param recyclerView the target recycler view for applying the configuration
     */
    public void applyConfig(final Context context, final RecyclerView recyclerView) {
        final LayoutManager layoutManager;
        if (mAdapter == null || mLayoutManagerProvider == null || (layoutManager = mLayoutManagerProvider.get(context)) == null)
            return;
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(mHasFixedSize);
        recyclerView.setDrawingCacheEnabled(mDrawingCacheEnabled);
        recyclerView.setAdapter(mAdapter);
        for (RecyclerView.ItemDecoration itemDecoration : mItemDecorations) {
            recyclerView.addItemDecoration(itemDecoration);
        }
        for (RecyclerView.OnScrollListener scrollListener : mScrollListeners) {
            recyclerView.addOnScrollListener(scrollListener);
        }
        if (mItemAnimator != null) {
            recyclerView.setItemAnimator(mItemAnimator);
        }
        if (mItemTouchHelper != null) {
            mItemTouchHelper.attachToRecyclerView(recyclerView);
        }
        if (mItemViewCacheSize != -1) {
            recyclerView.setItemViewCacheSize(mItemViewCacheSize);
        }
        if (mDrawingCacheQuality != -1) {
            recyclerView.setDrawingCacheQuality(mDrawingCacheQuality);
        }
    }

    /**
     * Builder for setting ListConfig
     * Sample:
     * <pre>
     * {@code
     *      ListConfig listConfig = new ListConfig.Builder(mAdapter)
     *          .setLayoutManagerProvider(new SimpleGridLayoutManagerProvider(mSpanCount, getSpanSizeLookup()))
     *          .addItemDecoration(new ColorDividerItemDecoration(color, spacing, SPACE_LEFT|SPACE_TOP, false))
     *          .setDefaultDividerEnabled(true)
     *          .addOnScrollListener(new OnLoadMoreScrollListener(mCallback))
     *          .setItemAnimator(getItemAnimator())
     *          .setHasFixedSize(true)
     *          .setItemTouchHelper(getItemTouchHelper())
     *          .build(baseActivity);
     * }
     * </pre>
     * If LinearLayoutManager will be used by default
     */
    public static class Builder {
        private final RecyclerView.Adapter mAdapter;
        private LayoutManagerProvider mLayoutManagerProvider;
        private RecyclerView.ItemAnimator mItemAnimator;
        private List<RecyclerView.ItemDecoration> mItemDecorations;
        private List<RecyclerView.OnScrollListener> mOnScrollListeners;
        private ItemTouchHelper mItemTouchHelper;
        private boolean mHasFixedSize;
        private int mItemViewCacheSize;
        private boolean mDrawingCacheEnabled;
        private int mDrawingCacheQuality;
        private int mDefaultDividerSize = -1;

        /**
         * Creates new Builder for config RecyclerView with the adapter
         *
         * @param adapter the adapter, which will be set to the RecyclerView
         */
        public Builder(RecyclerView.Adapter adapter) {
            mAdapter = adapter;
        }

        /**
         * Set Layout manager provider. If not set default {@link LinearLayoutManager} will be applied
         *
         * @param layoutManagerProvider the layout manager provider. Can be custom or one of
         *                              simple: {@link SimpleLinearLayoutManagerProvider},
         *                              {@link SimpleGridLayoutManagerProvider} or
         *                              {@link SimpleStaggeredGridLayoutManagerProvider}.
         * @return the builder
         */
        public Builder setLayoutManagerProvider(LayoutManagerProvider layoutManagerProvider) {
            mLayoutManagerProvider = layoutManagerProvider;
            return this;
        }

        /**
         * Set {@link android.support.v7.widget.RecyclerView.ItemAnimator}
         *
         * @param itemAnimator the item animator
         * @return the builder
         */
        public Builder setItemAnimator(RecyclerView.ItemAnimator itemAnimator) {
            mItemAnimator = itemAnimator;
            return this;
        }

        /**
         * Set {@link android.support.v7.widget.RecyclerView.ItemDecoration}
         *
         * @param itemDecoration the item decoration.
         * @return the builder
         */
        public Builder addItemDecoration(RecyclerView.ItemDecoration itemDecoration) {
            if (mItemDecorations == null) {
                mItemDecorations = new ArrayList<>();
            }
            mItemDecorations.add(itemDecoration);
            return this;
        }

        /**
         * Set {@link android.support.v7.widget.RecyclerView.OnScrollListener}
         *
         * @param onScrollListener the scroll listener.
         * @return the builder
         */
        public Builder addOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
            if (mOnScrollListeners == null) {
                mOnScrollListeners = new ArrayList<>();
            }
            mOnScrollListeners.add(onScrollListener);
            return this;
        }

        /**
         * Set true if adapter changes cannot affect the size of the RecyclerView.
         * Applied to {@link RecyclerView#setHasFixedSize(boolean)}
         *
         * @param isFixedSize true if RecyclerView items have fixed size
         * @return the builder
         */
        public Builder setHasFixedSize(boolean isFixedSize) {
            mHasFixedSize = isFixedSize;
            return this;
        }

        /**
         * Set the number of offscreen views to retain before adding them to the potentially shared.
         *
         * <p>The offscreen view cache stays aware of changes in the attached adapter, allowing
         * a LayoutManager to reuse those views unmodified without needing to return to the adapter
         * to rebind them.</p>
         *
         * @param size Number of views to cache offscreen before returning them to the general
         *             recycled view pool
         * @return the builder
         */
        public Builder setItemViewCacheSize(int size) {
            mItemViewCacheSize = size;
            return this;
        }

        public Builder setDrawingCacheEnabled(boolean isEnable) {
            mDrawingCacheEnabled = isEnable;
            return this;
        }

        public Builder setDrawingCacheQuality(int quality) {
            mDrawingCacheQuality = quality;
            return this;
        }

        /**
         * Set true to apply default divider with default size of 4dp.
         *
         * @param isEnabled set true to apply default divider.
         * @return the builder
         */
        public Builder setDefaultDividerEnabled(boolean isEnabled) {
            mDefaultDividerSize = isEnabled ? 0 : -1;
            return this;
        }

        /**
         * Enables defoult divider with custom size
         *
         * @param size
         * @return the builder
         */
        public Builder setDefaultDividerSize(int size) {
            mDefaultDividerSize = size;
            return this;
        }

        /**
         * Set {@link ItemTouchHelper}
         *
         * @param itemTouchHelper the ItemTouchHelper to apply for RecyclerView
         * @return the builder
         */
        public Builder setItemTouchHelper(ItemTouchHelper itemTouchHelper) {
            mItemTouchHelper = itemTouchHelper;
            return this;
        }

        /**
         * Creates new {@link ListConfig} with defined configuration
         * If LayoutManagerProvider is not set, the {@link SimpleLinearLayoutManagerProvider}
         * will be used.
         *
         * @param context the baseActivity
         * @return the new ListConfig
         */
        public ListConfig build(Context context) {
            if (mLayoutManagerProvider == null)
                mLayoutManagerProvider = new SimpleLinearLayoutManagerProvider();

            return new ListConfig(
                    mAdapter,
                    mLayoutManagerProvider,
                    mItemAnimator, mItemDecorations,
                    mOnScrollListeners,
                    mItemTouchHelper,
                    mHasFixedSize,
                    mItemViewCacheSize,
                    mDrawingCacheEnabled,
                    mDrawingCacheQuality);
        }
    }

    /**
     * The provider of LayoutManager for RecyclerView
     */
    public interface LayoutManagerProvider {
        LayoutManager get(Context context);
    }

    /**
     * The simple LayoutManager provider for {@link LinearLayoutManager}
     */
    public static class SimpleLinearLayoutManagerProvider implements LayoutManagerProvider {
        @Override
        public LayoutManager get(Context context) {
            return new LinearLayoutManager(context);
        }
    }

    /**
     * The simple LayoutManager provider for {@link GridLayoutManager}
     */
    public static class SimpleGridLayoutManagerProvider implements LayoutManagerProvider {
        private final int mSpanCount;
        private GridLayoutManager.SpanSizeLookup mSpanSizeLookup;

        public SimpleGridLayoutManagerProvider(@IntRange(from = 1) int mSpanCount) {
            this.mSpanCount = mSpanCount;
        }

        public SimpleGridLayoutManagerProvider(int spanCount, GridLayoutManager.SpanSizeLookup spanSizeLookup) {
            mSpanCount = spanCount;
            mSpanSizeLookup = spanSizeLookup;
        }

        @Override
        public LayoutManager get(Context context) {
            GridLayoutManager layoutManager = new GridLayoutManager(context, mSpanCount);
            if (mSpanSizeLookup != null) layoutManager.setSpanSizeLookup(mSpanSizeLookup);
            return layoutManager;
        }
    }

    /**
     * The simple LayoutManager provider for {@link StaggeredGridLayoutManager}
     */
    public static class SimpleStaggeredGridLayoutManagerProvider implements LayoutManagerProvider {
        private final int mSpanCount;
        private final int mOrientation;

        public SimpleStaggeredGridLayoutManagerProvider(@IntRange(from = 1) int spanCount) {
            this(spanCount, StaggeredGridLayoutManager.VERTICAL);
        }

        public SimpleStaggeredGridLayoutManagerProvider(@IntRange(from = 1) int spanCount, final int orientation) {
            this.mSpanCount = spanCount;
            this.mOrientation = orientation;
        }

        @Override
        public LayoutManager get(Context context) {
            return new StaggeredGridLayoutManager(mSpanCount, mOrientation);
        }
    }
}