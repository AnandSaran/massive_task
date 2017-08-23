package massive.task.com.model.webservice;


import java.util.List;

import massive.task.com.library.Log;
import massive.task.com.model.dto.response.BaseResponse;
import massive.task.com.retrofit.ResponseListener;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public  class BaseModel {
    protected String TAG = this.getClass().getSimpleName();
    protected long mCurrentTaskId = -1;
    ResponseListener IResponseListener;

    public BaseModel(ResponseListener listener) {
        IResponseListener = listener;
    }

   /* protected void enQueueTask(long taskId, Call<T> tCall) {
        this.mCurrentTaskId = taskId;
        tCall.enqueue(baseModelCallBackListener);
    }
*/

    protected <T> void validateBaseResponseList(Call<List<T>> mNativeRegisterResponseCall) {
        mNativeRegisterResponseCall.enqueue(new Callback<List<T>>() {
            @Override
            public void onResponse(Call<List<T>> call, Response<List<T>> response) {
                Log.e(TAG, "response.code(): " + response.code());
                Log.e(TAG, "response.code(): " + response.raw().code());


                switch (response.code()) {
                    case 200://success response
/*                        if (response.body().getSuccess()) {*/
                        Log.e(TAG, "response.body(): " + response.body());

                            IResponseListener.onSuccess(response.body(), mCurrentTaskId);
                      /*  }else {
                            IResponseListener.showErrorDialog(response.body(),mCurrentTaskId);

                        }
                      */  break;

                    default://Request error

                        IResponseListener.showErrorDialog(response.body(),mCurrentTaskId);


                        break;
                  /*  case 401://ERROR
                        IResponseListener.showDialog(response.body().getMessage());

                        break;*/

                }
            }

            @Override
            public void onFailure(Call<List<T>> call, Throwable t) {
                IResponseListener.onFailureApi(t);

            }
        });


    }

    protected <T> void validateBaseResponse(Call<BaseResponse<T>> mNativeRegisterResponseCall) {
        mNativeRegisterResponseCall.enqueue(new Callback<BaseResponse<T>>() {
            @Override
            public void onResponse(Call<BaseResponse<T>> call, Response<BaseResponse<T>> response) {
                Log.e(TAG, "response.code(): " + response.code());
                Log.e(TAG, "response.code(): " + response.raw().code());


                switch (response.code()) {
                    case 200://success response
/*                        if (response.body().getSuccess()) {*/

                            IResponseListener.onSuccess(response.body(), mCurrentTaskId);
                      /*  }else {
                            IResponseListener.showErrorDialog(response.body(),mCurrentTaskId);

                        }
                      */  break;

                    default://Request error

                        IResponseListener.showErrorDialog(response.body(),mCurrentTaskId);


                        break;
                  /*  case 401://ERROR
                        IResponseListener.showDialog(response.body().getMessage());

                        break;*/

                }
            }

            @Override
            public void onFailure(Call<BaseResponse<T>> call, Throwable t) {
                IResponseListener.onFailureApi(t);

            }
        });


    }

}
