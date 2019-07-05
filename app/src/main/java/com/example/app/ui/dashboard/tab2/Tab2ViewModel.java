package com.example.app.ui.dashboard.tab2;

import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableList;

import com.example.app.data.model.DummyModel;
import com.example.app.ui.base.BaseViewModel;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Tab2ViewModel extends BaseViewModel<Tab2Navigator> {

    public ObservableList<DummyModel> dummyList = new ObservableArrayList<>();


    void getTypes() {
        setIsLoading(true);
        getCompositeDisposable().add(Single.create(new SingleOnSubscribe<List<DummyModel>>() {
            @Override
            public void subscribe(SingleEmitter<List<DummyModel>> emitter) {
                List<DummyModel> list = new ObservableArrayList<>();
                list.add(new DummyModel(1, "Fashion Lounge"));
                list.add(new DummyModel(2, "The List"));
                list.add(new DummyModel(3, "Emaar VIP Pass"));
                list.add(new DummyModel(4, "Emaar Special Pass"));

                list.add(new DummyModel(5, "Mashreq Soliatire"));
                list.add(new DummyModel(6, "BloomingDales"));
                list.add(new DummyModel(7, "U by Emaar Signature"));
                list.add(new DummyModel(8, "Peacock Conceirge"));

                emitter.onSuccess(list);
            }
        }).delay(2000, TimeUnit.MILLISECONDS).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<DummyModel>>() {
                    @Override
                    public void accept(List<DummyModel> list) {
                        setIsLoading(false);
                        dummyList.clear();
                        dummyList.addAll(list);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) {
                        setIsLoading(false);
                    }
                }));
    }
}
