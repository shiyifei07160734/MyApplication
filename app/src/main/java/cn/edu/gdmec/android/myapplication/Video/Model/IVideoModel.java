package cn.edu.gdmec.android.myapplication.Video.Model;

/**
 * Created by apple on 18/5/22.
 */

public interface IVideoModel {
    void loadVideo(String category,IVideoLoadListener iVideoLoadListener);
    void loadWeather();
}
