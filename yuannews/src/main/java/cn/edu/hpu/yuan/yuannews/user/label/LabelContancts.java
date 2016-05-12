package cn.edu.hpu.yuan.yuannews.user.label;

/**
 * Created by yuan on 16-5-12.
 */
public interface LabelContancts {

    interface LabelContanctsPresenter{

        int postDeleteLabel(Integer tid);

        void postAddLabel(Integer id,String label);

    }

    interface LabelContanctsView{

        void showDialog();

        void showMsg(String msg);

    }

}