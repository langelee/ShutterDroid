package io.bitfountain.matthewparker.shutterdroid.api;

import android.util.Base64;

import java.util.List;

import retrofit.Callback;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.RetrofitError;

/**
 * Created by matthewparker on 1/20/15.
 */
public class ShutterStock {
    private static final RestAdapter ADAPTER = new RestAdapter.Builder()
            .setEndpoint("https://api.shutterstock.com/v2")
            .setRequestInterceptor(new RequestInterceptor() {
                @Override
                public void intercept(RequestFacade request) {
                    String authInfo = "6549ef1a7080487215ee:20003fc3afe517b2edd53e8b43441f9e4b9bd1e2";
                    String auth = "Basic "+ Base64.encodeToString(authInfo.getBytes(), Base64.NO_WRAP);
                    request.addHeader("Authorization", auth);
                }
            })
            .build();

    private static final ShutterStockService SERVICE = ADAPTER.create(ShutterStockService.class);

    public static void search(String query, Callback<List<Image>> cb){
        SERVICE.search(query, new ImageCallback(cb));
    }

    public static void getRecent(String date, Callback<List<Image>> cb){
        SERVICE.getRecent(date, new ImageCallback(cb));
    }

    private static class ImageCallback implements Callback<Response>{
        Callback<List<Image>> cb;
        ImageCallback(Callback<List<Image>> cb){
            this.cb = cb;
        }
        @Override
        public void success(Response response, retrofit.client.Response response2) {
            cb.success(response.data, response2);
        }

        @Override
        public void failure(RetrofitError error) {
            cb.failure(error);
        }
    }
}
