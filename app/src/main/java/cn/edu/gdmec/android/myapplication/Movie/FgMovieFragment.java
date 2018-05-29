package cn.edu.gdmec.android.myapplication.Movie;

import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.os.Bundle;
import android.widget.TextView;

import cn.edu.gdmec.android.myapplication.Bean.MovieBean;
import cn.edu.gdmec.android.myapplication.Bean.NewsBean;
import cn.edu.gdmec.android.myapplication.Movie.Presenter.MoviesPresenter;
import cn.edu.gdmec.android.myapplication.Movie.View.IMoviesView;
import cn.edu.gdmec.android.myapplication.News.View.INewsView;
import cn.edu.gdmec.android.myapplication.R;


public class FgMovieFragment extends Fragment  implements IMoviesView{

private SwipeRefreshLayout srl_movies;
private MoviesPresenter presenter;
private TextView tv;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fg_movie, null);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        srl_movies=view.findViewById(R.id.srl_movies);
        tv=view.findViewById(R.id.tv_movies);
        presenter=new MoviesPresenter(this);
        srl_movies.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                presenter.loadMovies("movie","in_theaters");
            }
        });
    }


    @Override
    public void showMovies(MovieBean movieBean) {
        tv.setText(movieBean.getSubjects().get(0).getTitle()+movieBean.getSubjects().get(0).getDirectors());
    }

    @Override
    public void hideDialog() {
          srl_movies.setRefreshing(false);
    }

    @Override
    public void showDialog() {
        srl_movies.setRefreshing(true);
    }

    @Override
    public void showErrorMsg(String error) {
      tv.setText("加载失败");
    }
}
