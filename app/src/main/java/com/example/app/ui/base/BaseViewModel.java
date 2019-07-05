package com.example.app.ui.base;


import androidx.databinding.ObservableBoolean;

import com.example.app.data.AppDataManager;
import com.example.app.events.DummyEvent;
import io.reactivex.disposables.CompositeDisposable;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.lang.ref.WeakReference;


public abstract class BaseViewModel<N> /*extends ViewModel */ {

    private final AppDataManager mDataManager;

    private final ObservableBoolean mIsLoading = new ObservableBoolean(false);
    public final ObservableBoolean mShowError = new ObservableBoolean(false);

    private CompositeDisposable mCompositeDisposable;

    private WeakReference<N> mNavigator;

    public BaseViewModel() {
        EventBus.getDefault().register(this);
        this.mDataManager = AppDataManager.getInstance();
        this.mCompositeDisposable = new CompositeDisposable();
    }


    public void destroy() {
        EventBus.getDefault().unregister(this);
        mCompositeDisposable.dispose();
    }

    public CompositeDisposable getCompositeDisposable() {
        return mCompositeDisposable;
    }

    public AppDataManager getDataManager() {
        return mDataManager;
    }

    public ObservableBoolean getIsLoading() {
        return mIsLoading;
    }

    public ObservableBoolean getShowError() {
        return mShowError;
    }

    public void setShowError(boolean isError) {
        mShowError.set(isError);
    }

    public void setIsLoading(boolean isLoading) {
        mIsLoading.set(isLoading);
        if (isLoading) {
            setShowError(false);
        }
    }

    public N getNavigator() {
        return mNavigator.get();
    }

    public void setNavigator(N navigator) {
        this.mNavigator = new WeakReference<>(navigator);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(DummyEvent obj) {
    }
}
