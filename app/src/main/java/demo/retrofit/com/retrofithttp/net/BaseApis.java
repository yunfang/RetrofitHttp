package demo.retrofit.com.retrofithttp.net;


import demo.retrofit.com.retrofithttp.bean.BaseResult;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface BaseApis {

    // tms 物流管理系统

    /**　正式　**/
    String HOST = "http://www.yunfangjsj.com/";//http://www.yunfangjsj.com/json/jsondemo.json        http://www.baidu.com/
//    String HOST = BuildConfig.ROOT;

    /**　测试　**/
//    String HOST = "sdx.uqiauto.com/sdx/interface/";


//    /**
//     *
//     * @param user
//     * @return
//     */
//    @GET("users/{user}/repos")
//    Call<List<TestBean>> listRepos(@Path("user") String user);
//
//
//    @FormUrlEncoded
//    @POST("user/edit")
//    Call<TestBean> updateUser(@Field("first_name") String first, @Field("last_name") String last);


    @GET("/api/{category}/list")
    Call<String> getCookList(@Path("category") String category, @Query("id") int id, @Query("page") int page, @Query("rows") int rows);

    @POST("/api/{category}/list")
    @FormUrlEncoded
    Call<String> getCookListByPost(@Path("category") String category, @Field("id") int id, @Field("page") int page, @Field("rows") int rows);

    @GET("/json/{category}")
    Call<BaseResult> getData(@Path("category") String category, @Query("id") int id, @Query("page") int page, @Query("rows") int rows);









}
