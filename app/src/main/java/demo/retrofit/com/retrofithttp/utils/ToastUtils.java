package demo.retrofit.com.retrofithttp.utils;

import android.text.TextUtils;
import android.widget.Toast;

import demo.retrofit.com.retrofithttp.global.LocalApplication;


/**
 * Toast处理类
 * Created by zhouyunfang on 17/6/1.
 */
public class ToastUtils {

    private static Toast mToast;
    public static void showToast(String text) {
        if(mToast == null) {
            mToast = Toast.makeText(LocalApplication.getContext(), text, Toast.LENGTH_SHORT);
        } else {
            mToast.setText(text);
            mToast.setDuration(Toast.LENGTH_SHORT);
        }
        if(!TextUtils.isEmpty(text)){
            mToast.show();
        }
    }

    public static void cancelToast() {
        if (mToast != null) {
            mToast.cancel();
        }
    }

    /**
     * 如何按返回键想让Toast立即不显示，执行该方法
     */
    public static void onBackPressed() {
        cancelToast();
    }
}
