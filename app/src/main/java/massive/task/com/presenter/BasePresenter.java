package massive.task.com.presenter;

import android.content.Intent;

import massive.task.com.presenter.ipresenter.IPresenter;
import massive.task.com.view.iview.IView;


abstract class BasePresenter implements IPresenter {

    protected String TAG = getClass().getSimpleName();

    private IView iView;

    BasePresenter(IView iView) {
        this.iView = iView;
        iView.bindPresenter(this);
    }

    @Override
    public void onStartPresenter() {

    }

    @Override
    public void onStopPresenter() {

    }

    @Override
    public void onPausePresenter() {

    }

    @Override
    public void onResumePresenter() {

    }

    @Override
    public void onDestroyPresenter() {

    }

    @Override
    public void onActivityResultPresenter(int requestCode, int resultCode, Intent data) {

    }
}
