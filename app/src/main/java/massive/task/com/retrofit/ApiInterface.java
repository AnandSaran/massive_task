package massive.task.com.retrofit;


import java.util.List;

import massive.task.com.model.pojo.Delivery;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;


public interface ApiInterface {


    @GET("/deliveries")
    Call<List<Delivery>> deliveries();


}
