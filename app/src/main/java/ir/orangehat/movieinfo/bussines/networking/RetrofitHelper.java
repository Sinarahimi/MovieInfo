package ir.orangehat.movieinfo.bussines.networking;

import android.support.annotation.Nullable;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import ir.orangehat.movieinfo.BuildConfig;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * RetrofitHelper
 */

public class RetrofitHelper {

    private Retrofit.Builder retrofit;

    public RetrofitHelper() {

        retrofit = new Retrofit.Builder().baseUrl(BuildConfig.BASE_URL).client(new OkHttpClient().newBuilder().addNetworkInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)).build())
                .addConverterFactory(new Converter.Factory() {
                    @Nullable
                    @Override
                    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
                        return super.responseBodyConverter(type, annotations, retrofit);
                    }
                }).addConverterFactory(GsonConverterFactory.create());
        retrofit.build();
    }

    public <T> T getService(Class<T> tService){
       return retrofit.build().create(tService);
    }



}
