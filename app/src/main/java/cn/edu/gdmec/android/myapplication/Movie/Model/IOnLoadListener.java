package cn.edu.gdmec.android.myapplication.Movie.Model;

import cn.edu.gdmec.android.myapplication.Bean.MoviesBean;

/**
 * Created by apple on 18/5/22.
 */

public interface IOnLoadListener {
    void success(MoviesBean moviesBean);
    void fail(String error);
}
