package cn.edu.hpu.yuan.yuannews.main.app;

import android.app.Application;

import javax.inject.Inject;

import cn.edu.hpu.yuan.yuancore.util.CrashHandler;
import cn.edu.hpu.yuan.yuannews.main.data.Local.NewsAPIShared;
import cn.edu.hpu.yuan.yuannews.main.data.NewsAPI;
import cn.edu.hpu.yuan.yuannews.main.data.NewsAPIModule;
import cn.edu.hpu.yuan.yuannews.main.data.remote.NewsAPIService;
import cn.edu.hpu.yuan.yuannews.main.util.NotificationUtil;
import retrofit2.Retrofit;

/**
 * Created by yuan on 16-5-9.
 * BaseApplication
 * 1.初始化CrashHandler
 * 2.
 */
public class BaseApplication extends Application{


    @Inject
    protected CrashHandler crashHandler;
    //Application的注入器
    private ApplicationComponent applicationComponent;

    @Inject
    public static NewsAPIService newsAPIService;

    @Inject
    public static Retrofit retrofit;

    @Inject
    public static NewsAPIShared newsAPIShared;

    @Inject
    public static NotificationUtil notificationUtil;

    @Override
    public void onCreate() {
        super.onCreate();
        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(getApplicationContext()))
                .newsAPIModule(new NewsAPIModule(NewsAPI.BASE_URL,this))
                .build();
        applicationComponent.injectBaseApplication(this);

        //初始化crashHandler
        crashHandler.init(getApplicationContext());
    }

    public ApplicationComponent getApplicationComponent(){
        return applicationComponent;
    }

    public  NewsAPIService getNewsAPIService(){
        return newsAPIService;
    }


}
