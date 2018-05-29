package cn.edu.gdmec.android.myapplication.Movie.View;

import cn.edu.gdmec.android.myapplication.Bean.MovieBean;
import cn.edu.gdmec.android.myapplication.Bean.NewsBean;

/**
 * Created by apple on 18/5/22.
 */

public interface IMoviesView {
    void showMovies(MovieBean movieBean);
    void hideDialog();
    void showDialog();
    void showErrorMsg(String error);
}
