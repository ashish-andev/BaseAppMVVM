package com.thevalet.app.ui.splash;

import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;
import com.thevalet.app.data.model.LocationOption;
import com.thevalet.app.ui.base.BaseViewModel;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SplashViewModel extends BaseViewModel<SplashNavigator> {

    public ObservableList<LocationOption> locationOptions = new ObservableArrayList<>();


    void getLocations() {
        setIsLoading(true);
        getCompositeDisposable().add(Single.create(new SingleOnSubscribe<List<LocationOption>>() {
            @Override
            public void subscribe(SingleEmitter<List<LocationOption>> emitter) {
                List<LocationOption> list = new ObservableArrayList<>();
                list.add(new LocationOption(1, "Bloomingdales"));
                list.add(new LocationOption(2, "Gallery Lafayette"));
                list.add(new LocationOption(3, "Emaar VIP Pass"));
                list.add(new LocationOption(4, "Emaar Special Pass"));

                emitter.onSuccess(list);
            }
        }).delay(1000, TimeUnit.MILLISECONDS).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<LocationOption>>() {
                    @Override
                    public void accept(List<LocationOption> list) {
                        setIsLoading(false);
                        locationOptions.clear();
                        locationOptions.addAll(list);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) {
                        setIsLoading(false);
                    }
                }));
    }

    public void submitLocation() {
        getNavigator().onSubmit();
    }
}
