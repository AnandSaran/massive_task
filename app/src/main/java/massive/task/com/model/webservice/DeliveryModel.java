package massive.task.com.model.webservice;


import massive.task.com.retrofit.ApiClient;
import massive.task.com.retrofit.ApiInterface;
import massive.task.com.retrofit.ResponseListener;

/**
 * Created by Anand on 3/11/2017.
 */

public class DeliveryModel extends BaseModel{

    public DeliveryModel(ResponseListener iResponseListener) {
        super(iResponseListener);

    }
    public void getDeliveries(long taskId) {
        this.mCurrentTaskId = taskId;
        validateBaseResponseList(ApiClient.getClient().create(ApiInterface.class).deliveries());
    }


}
