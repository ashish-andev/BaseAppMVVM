package com.example.app.data.remote;


import com.example.app.data.model.Repository;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface ApiService {

    @GET("ashish-andev/repos")
    Single<List<Repository>> getRepositories();
}
