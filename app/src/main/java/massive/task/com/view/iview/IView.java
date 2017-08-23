package massive.task.com.view.iview;

import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.view.View;

import massive.task.com.presenter.ipresenter.IPresenter;
import massive.task.com.util.CodeSnippet;


public interface IView {

    void showMessage(String message);

    void showMessage(int resId);


    void showProgressbar();

    void dismissProgressbar();

    FragmentActivity getActivity();

    void showSnackBar(String message);

    void showSnackBar(@NonNull View view, String message);

    void showNetworkMessage();

    CodeSnippet getCodeSnippet();

    void bindPresenter(IPresenter iPresenter);

    boolean checkNetWork();


}
