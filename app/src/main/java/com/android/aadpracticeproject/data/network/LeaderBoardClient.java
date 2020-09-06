package com.android.aadpracticeproject.data.network;

import android.os.Build;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.ConnectionSpec;
import okhttp3.OkHttpClient;
import okhttp3.TlsVersion;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LeaderBoardClient {

    private static Retrofit retrofit;
    static HttpLoggingInterceptor interceptor;
    static OkHttpClient okHttpClient;

    public static Retrofit getClient() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        okHttpClient = getNewHttpClient();
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(LeaderBoardApi.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .client(okHttpClient)
                    .build();
        }
        return retrofit;
    }

    private static OkHttpClient.Builder enableTls12OnPreLollipop(OkHttpClient.Builder client) {
        if (Build.VERSION.SDK_INT >= 19 && Build.VERSION.SDK_INT < 22) {
            try {
//                SSLContext sc = SSLContext.getInstance("TLSv1.2");
//                sc.init(null, null, null);
//                client.sslSocketFactory(new TLS12SocketFactory(sc.getSocketFactory()));

                ConnectionSpec cs = new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS)
                        .tlsVersions(TlsVersion.TLS_1_2)
                        .build();

                List<ConnectionSpec> specs = new ArrayList<>();
                specs.add(cs);
                specs.add(ConnectionSpec.COMPATIBLE_TLS);
                specs.add(ConnectionSpec.CLEARTEXT);

                client.connectionSpecs(specs);
                Log.e("OkHttpTLSCompat", "success");

            } catch (Exception exc) {
                Log.e("OkHttpTLSCompat", "Error while setting TLS 1.2", exc);
            }
        }

        return client;
    }
    private static OkHttpClient getNewHttpClient() {
        OkHttpClient.Builder client = new OkHttpClient.Builder()
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS).addInterceptor(interceptor);

        return client.build();//enableTls12OnPreLollipop(client).build();
    }
}
