package cn.edu.gdmec.android.myapplication.Movie.Presenter;

import cn.edu.gdmec.android.myapplication.Bean.MoviesBean;
import cn.edu.gdmec.android.myapplication.Movie.Model.IMoviesModel;
import cn.edu.gdmec.android.myapplication.Movie.Model.IOnLoadListener;
import cn.edu.gdmec.android.myapplication.Movie.Model.MoviesModel;
import cn.edu.gdmec.android.myapplication.Movie.View.IMoviesView;

/**
 * Created by apple on 18/5/22.
 */

public class MoviesPresenter implements IMoviesPresenter,IOnLoadListener {

    private IMoviesModel iMoviesModel;
    private IMoviesView iMoviesView;

    public MoviesPresenter(IMoviesView iMoviesView){
        this.iMoviesView = iMoviesView;
        this.iMoviesModel =new MoviesModel();
    }

    @Override
    public void success(MoviesBean movieBean) {

        iMoviesView.hideDialog();
        if (movieBean!=null){
            iMoviesView.showMovies(movieBean);
        }
    }

    @Override
    public void fail(String error) {
        iMoviesView.hideDialog();
        iMoviesView.showErrorMsg(error);
    }

    @Override
    public void loadMovies(String total) {
        iMoviesView.showDialog();
        iMoviesModel.loadMovies(total,this);
    }
}
