package demo.retrofit.com.retrofithttp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import demo.retrofit.com.retrofithttp.bean.BaseResult;
import demo.retrofit.com.retrofithttp.net.RetrofitHelper;
import demo.retrofit.com.retrofithttp.utils.ToastUtils;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button id_net_bu = (Button) findViewById(R.id.id_net_bu);
        id_net_bu.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.id_net_bu:
                RetrofitHelper.getBaseApis().getData("jsondemo.json",1,1,3).enqueue(new Callback<BaseResult>() {
                    @Override
                    public void onResponse(Call<BaseResult> call, Response<BaseResult> response) {
                        ToastUtils.showToast(response.body().getMessage());
                    }


                    @Override
                    public void onFailure(Call<BaseResult> call, Throwable t) {
                        ToastUtils.showToast(t.getMessage());
                    }
                });

                break;
        }
    }
}
