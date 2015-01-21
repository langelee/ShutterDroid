package io.bitfountain.matthewparker.shutterdroid.api;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by matthewparker on 1/20/15.
 */
interface ShutterStockService {
    @GET("/images/search")
    public void search(@Query("query") String query, Callback<Response> cb);

    @GET("/images/search")
    public void getRecent(@Query("added_date_start") String date, Callback<Response> cb);

}
