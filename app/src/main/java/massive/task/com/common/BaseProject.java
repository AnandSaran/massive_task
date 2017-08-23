package massive.task.com.common;

import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;


public class BaseProject extends Application {

    private static BaseProject mAppController;

    public static BaseProject getInstance() {
        return mAppController;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mAppController = this;
    }

    public ConnectivityManager getConnectivityManager() {
        return (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
    }


    public String getStringFromRes(int resId) throws Exception{
        return getString(resId);
    }


}
