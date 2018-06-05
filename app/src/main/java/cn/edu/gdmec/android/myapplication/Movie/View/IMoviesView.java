package cn.edu.gdmec.android.myapplication.Movie.View;

import cn.edu.gdmec.android.myapplication.Bean.MoviesBean;

/**
 * Created by apple on 18/5/22.
 */

public interface IMoviesView {
    void showMovies(MoviesBean moviesBean);
    void hideDialog();
    void showDialog();
    void showErrorMsg(String error);
}
