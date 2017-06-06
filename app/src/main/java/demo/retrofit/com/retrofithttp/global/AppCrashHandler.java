package demo.retrofit.com.retrofithttp.global;

import android.content.Context;

//import com.tencent.bugly.crashreport.CrashReport;

public class AppCrashHandler implements Thread.UncaughtExceptionHandler {
    public static final String TAG = "CrashHandler";

    private Thread.UncaughtExceptionHandler mDefaultHandler;
    private static AppCrashHandler INSTANCE = new AppCrashHandler();
    private Context mContext;

    private AppCrashHandler() {
    }

    public static AppCrashHandler getInstance() {
        return INSTANCE;
    }

    public void init(Context context) {
        mContext = context;
        mDefaultHandler = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    @Override
    public void uncaughtException(Thread thread, Throwable ex) {
        if (!handleException(ex) && mDefaultHandler != null) {
            mDefaultHandler.uncaughtException(thread, ex);
        } else {
            android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(1);
            //ex.printStackTrace();
        }
    }

    private boolean handleException(Throwable ex) {
        if (ex == null) {
            return false;
        }
//        CrashReport.postCatchedException(ex); // bugly会将这个throwable上报

        //重启android程序代码
//        if (false) {
//            Intent i = BaseUtils.getContext().getPackageManager()
//                    .getLaunchIntentForPackage(BaseUtils.getContext().getPackageName());
//            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//            BaseUtils.getContext().startActivity(i);
//            ex.printStackTrace();
//            try {
//                Thread.sleep(1200);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
        return true;
    }
}
