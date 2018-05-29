package cn.edu.gdmec.android.myapplication.Http;

import java.util.concurrent.TimeUnit;

import cn.edu.gdmec.android.myapplication.Bean.MovieBean;
import cn.edu.gdmec.android.myapplication.Bean.NewsBean;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by apple on 18/5/22.
 */

public class RetrofitHelper {
    private static OkHttpClient okHttpClient;
    private RetrofitService retrofitService;
    private RetrofitServiceMovies retrofitServiceMovies;
    public RetrofitHelper(String host){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(host)
                .client(getOkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        retrofitService=retrofit.create(RetrofitService.class);
        retrofitServiceMovies=retrofit.create(RetrofitServiceMovies.class);
    }

    public Call<NewsBean> getNews(String type,String id, int startPage){
        return retrofitService.getNews(type, id, startPage);
    }
    public Call<MovieBean> getMovie(String movie,String type){
        return retrofitServiceMovies.getMovies(movie,type);
    }
    public OkHttpClient getOkHttpClient(){
        if (okHttpClient==null){
            okHttpClient=new OkHttpClient.Builder()
                    .retryOnConnectionFailure(true)
                    .connectTimeout(30, TimeUnit.SECONDS)
                    .build();
        }
        return okHttpClient;
    }
}
