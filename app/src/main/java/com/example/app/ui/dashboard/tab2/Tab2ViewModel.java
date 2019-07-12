package com.example.app.ui.dashboard.tab2;

import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableList;

import com.example.app.data.model.Repository;
import com.example.app.ui.base.BaseViewModel;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class Tab2ViewModel extends BaseViewModel<Tab2Navigator> {

    public ObservableList<Repository> repoList = new ObservableArrayList<>();


    void getRepositories() {
        setIsLoading(true);
        getCompositeDisposable().add(getDataManager().getRepositories()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<Repository>>() {
                    @Override
                    public void accept(List<Repository> repositories) {
                        setIsLoading(false);
                        repoList.clear();
                        repoList.addAll(repositories);

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) {
                        setIsLoading(false);
                    }
                }));
    }
}
