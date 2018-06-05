package cn.edu.gdmec.android.myapplication.Http;

import cn.edu.gdmec.android.myapplication.Bean.MoviesBean;
import cn.edu.gdmec.android.myapplication.Bean.NewsBean;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by apple on 18/5/22.
 */

public interface RetrofitService {

    @GET("nc/article/{type}/{id}/{startPage}-20.html")
    Observable<NewsBean> getNews(@Path("type") String type,
                                 @Path("id") String id,
                                 @Path("startPage") int startPage);
    @GET("/v2/movie/{total}")
    Observable<MoviesBean> getMovies(@Path("total") String total);
}