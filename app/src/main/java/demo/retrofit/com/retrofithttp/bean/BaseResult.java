package demo.retrofit.com.retrofithttp.bean;

/**
 * Created by zhouyunfang on 17/6/6.
 */

public class BaseResult {

    private String Code;

    private String Message;

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }
}
