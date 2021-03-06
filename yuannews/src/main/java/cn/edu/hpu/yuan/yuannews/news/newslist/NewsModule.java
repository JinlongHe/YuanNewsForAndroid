package cn.edu.hpu.yuan.yuannews.news.newslist;

import android.content.Context;

import cn.edu.hpu.yuan.yuannews.news.newslist.adapter.CustomRecyclerViewAdapter;
import dagger.Module;
import dagger.Provides;

/**
 * Created by yuan on 16-5-9.
 * 新闻modlue类
 */
@Module
public class NewsModule {


    private NewsContract.View newsView;
    public NewsModule(){}

    private Context context;
    private CustomRecyclerViewAdapter.NewsListItemClick newsListItemClick;


    public NewsModule(NewsContract.View newsView, Context context,CustomRecyclerViewAdapter.NewsListItemClick newsListItemClick) {
        this.newsView = newsView;
        this.context=context;
        this.newsListItemClick=newsListItemClick;
    }

    @Provides
    NewsFragment provideNewsFragment(){
        return new NewsFragment();
    }

    @Provides
    NewsContract.View provideNewsView(){
        return newsView;
    }

    @Provides
    NewsContract.Presenter provideNewsPresenter(){
        return new MewsPresenter(newsView);
    }

    @Provides
    CustomRecyclerViewAdapter provideCustomRecyclerViewAdapter(){
        return new CustomRecyclerViewAdapter(context,newsListItemClick);
    }


}
