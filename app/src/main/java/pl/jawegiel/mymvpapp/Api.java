package pl.jawegiel.mymvpapp;

import retrofit.RestAdapter;

public class Api {

    public static ApiInterface getClient() {

        RestAdapter adapter = new RestAdapter.Builder()
                .setEndpoint("https://jsonplaceholder.typicode.com/")
                .build();
        return adapter.create(ApiInterface.class);
    }
}