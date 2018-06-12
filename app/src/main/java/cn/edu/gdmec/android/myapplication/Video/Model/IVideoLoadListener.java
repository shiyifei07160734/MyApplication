package cn.edu.gdmec.android.myapplication.Video.Model;

import java.util.List;

import cn.edu.gdmec.android.myapplication.Bean.MoviesBean;
import cn.edu.gdmec.android.myapplication.Bean.TodayContentBean;
import cn.edu.gdmec.android.myapplication.Bean.VideoUrlBean;

/**
 * Created by apple on 18/5/22.
 */

public interface IVideoLoadListener {
void videoUrlSuccess(List<VideoUrlBean> videoUrlBeans, List<TodayContentBean> contentBeans);
void fail(Throwable throwable);
}
