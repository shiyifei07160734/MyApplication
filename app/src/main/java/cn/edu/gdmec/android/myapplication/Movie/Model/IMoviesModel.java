package cn.edu.gdmec.android.myapplication.Movie.Model;

/**
 * Created by apple on 18/5/22.
 */

public interface IMoviesModel {
    void loadMovies(String movie,
                  String type,
                  IOnLoadListener iOnLoadListener);
}
