package cn.edu.gdmec.android.myapplication.Video.View;

import java.util.List;
import cn.edu.gdmec.android.myapplication.Bean.TodayContentBean;

/**
 * Created by apple on 18/5/22.
 */

public interface IVideoView {
    void showVideo(List<TodayContentBean> todayContentBeans,List<String> videoList);
    void hideDialog();
    void showDialog();
    void showErrorMsg(Throwable throwable);
}
