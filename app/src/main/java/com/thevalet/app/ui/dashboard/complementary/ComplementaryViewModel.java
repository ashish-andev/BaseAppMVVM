package com.thevalet.app.ui.dashboard.complementary;

import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;
import com.thevalet.app.data.model.CompTypesOption;
import com.thevalet.app.ui.base.BaseViewModel;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ComplementaryViewModel extends BaseViewModel<ComplementaryNavigator> {

    public ObservableList<CompTypesOption> compTypesOptions = new ObservableArrayList<>();


    void getTypes() {
        setIsLoading(true);
        getCompositeDisposable().add(Single.create(new SingleOnSubscribe<List<CompTypesOption>>() {
            @Override
            public void subscribe(SingleEmitter<List<CompTypesOption>> emitter) {
                List<CompTypesOption> list = new ObservableArrayList<>();
                list.add(new CompTypesOption(1, "Fashion Lounge"));
                list.add(new CompTypesOption(2, "The List"));
                list.add(new CompTypesOption(3, "Emaar VIP Pass"));
                list.add(new CompTypesOption(4, "Emaar Special Pass"));

                list.add(new CompTypesOption(5, "Mashreq Soliatire"));
                list.add(new CompTypesOption(6, "BloomingDales"));
                list.add(new CompTypesOption(7, "U by Emaar Signature"));
                list.add(new CompTypesOption(8, "Peacock Conceirge"));

                emitter.onSuccess(list);
            }
        }).delay(1000, TimeUnit.MILLISECONDS).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<CompTypesOption>>() {
                    @Override
                    public void accept(List<CompTypesOption> list) {
                        setIsLoading(false);
                        compTypesOptions.clear();
                        compTypesOptions.addAll(list);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) {
                        setIsLoading(false);
                    }
                }));
    }
}
