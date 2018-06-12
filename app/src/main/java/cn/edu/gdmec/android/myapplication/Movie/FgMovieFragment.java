package cn.edu.gdmec.android.myapplication.Movie;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import cn.edu.gdmec.android.myapplication.Bean.MoviesBean;
import cn.edu.gdmec.android.myapplication.Movie.Presenter.MoviesPresenter;
import cn.edu.gdmec.android.myapplication.Movie.View.IMoviesView;
import cn.edu.gdmec.android.myapplication.R;

public class FgMovieFragment extends Fragment implements IMoviesView {

    private MoviesPresenter moviesPresenter;
    private RecyclerView rv_movie_on;
    private SwipeRefreshLayout srl_movie;
    private ItemMovieOnAdapter movieOnAdapter;
    private ItemMovieTopOnAdapter movieTopOnAdapter;
    private RecyclerView rv_movie_on1;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fg_movie, null);
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        moviesPresenter = new MoviesPresenter(this);
        srl_movie = view.findViewById(R.id.srl_movie);
        rv_movie_on = view.findViewById(R.id.rv_movie_on);
        rv_movie_on1=view.findViewById(R.id.rv_movie_on1);
        movieTopOnAdapter=new ItemMovieTopOnAdapter(getActivity());
        movieOnAdapter = new ItemMovieOnAdapter(getActivity());
        srl_movie.setColorSchemeColors(Color.parseColor("#ffce3d3a"));
        moviesPresenter.loadMovies("in_theaters");
        srl_movie.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                moviesPresenter.loadMovies("in_theaters");
                moviesPresenter.loadMovies("top250");
            }
        });
    }


    @Override
    public void showMovies(MoviesBean moviesBean) {
        if (moviesBean.getTotal()==250){
            movieTopOnAdapter.setData(moviesBean.getSubjects());
            LinearLayoutManager mliner=new LinearLayoutManager(getActivity(), LinearLayout.HORIZONTAL,false);
            rv_movie_on1.setLayoutManager(mliner);
            rv_movie_on1.setAdapter(movieTopOnAdapter);}
        else {

            movieOnAdapter.setData(moviesBean.getSubjects());
            rv_movie_on.setLayoutManager(new LinearLayoutManager(getActivity()));
            rv_movie_on.setAdapter(movieOnAdapter);
        }
    }

    @Override
    public void hideDialog() {
        srl_movie.setRefreshing(false);
    }

    @Override
    public void showDialog() {
        srl_movie.setRefreshing(true);
    }

    @Override
    public void showErrorMsg(String error) {
        Toast.makeText(getContext(), "加载出错:"+error.toString(), Toast.LENGTH_SHORT).show();
    }
}