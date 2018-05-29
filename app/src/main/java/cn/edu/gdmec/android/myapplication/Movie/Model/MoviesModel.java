package cn.edu.gdmec.android.myapplication.Movie.Model;

import cn.edu.gdmec.android.myapplication.Bean.MovieBean;
import cn.edu.gdmec.android.myapplication.Bean.NewsBean;
import cn.edu.gdmec.android.myapplication.Http.Api;
import cn.edu.gdmec.android.myapplication.Http.RetrofitHelper;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by apple on 18/5/22.
 */

public class MoviesModel implements IMoviesModel {
    @Override
    public void loadMovies(final String movie,final String type,
                         final IOnLoadListener iOnLoadListener) {
        RetrofitHelper retrofitHelper=new RetrofitHelper(Api.Movie);
        retrofitHelper.getMovie(movie,type).enqueue(new Callback<MovieBean>() {
            @Override
            public void onResponse(Call<MovieBean> call, Response<MovieBean> response) {
                if (response.isSuccessful()){
                    iOnLoadListener.success(response.body());
                }else {
                    iOnLoadListener.fail("");
                }
            }

            @Override
            public void onFailure(Call<MovieBean> call, Throwable t) {
                iOnLoadListener.fail(t.toString());
            }
        });
    }
}
