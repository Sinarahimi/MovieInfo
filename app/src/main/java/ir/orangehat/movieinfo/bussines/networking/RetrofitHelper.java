package ir.orangehat.movieinfo.bussines.networking;

import ir.orangehat.movieinfo.BuildConfig;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * RetrofitHelper
 */

public class RetrofitHelper {

    private Retrofit.Builder retrofit;

    public RetrofitHelper() {

        retrofit = new Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .client(new OkHttpClient().newBuilder().addNetworkInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)).build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create());
    }

    public <T> T getService(Class<T> tService) {
        return retrofit.build().create(tService);
    }

    public interface ApiListener<T> {

        void onSuccess(T t);

        void onError(Throwable throwable);
    }
}
