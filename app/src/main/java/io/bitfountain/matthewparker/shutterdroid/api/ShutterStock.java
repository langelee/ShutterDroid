package io.bitfountain.matthewparker.shutterdroid.api;

import android.util.Base64;

import retrofit.RequestInterceptor;
import retrofit.RestAdapter;

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
}
