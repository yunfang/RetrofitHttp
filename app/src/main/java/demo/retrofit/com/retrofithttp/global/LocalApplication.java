package demo.retrofit.com.retrofithttp.global;

import android.app.Application;
import android.content.Context;

import com.orhanobut.logger.Logger;

public class LocalApplication extends Application {
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        LocalApplication.mContext = getApplicationContext();
//        initAppCrashHelper();
        initLogger();
    }

    private void initAppCrashHelper() {
        AppCrashHandler handler = AppCrashHandler.getInstance();
        handler.init(this);
    }


    private void initLogger() {
        //初始化日志打印器
        Logger.init("tzy_custom__");
    }


    public static synchronized Context getContext() {
        return LocalApplication.mContext;
    }
}
