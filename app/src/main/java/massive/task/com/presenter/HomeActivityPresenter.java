package massive.task.com.presenter;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.view.View;

import java.io.Serializable;
import java.util.List;

import massive.task.com.Database.DatabaseHandler;
import massive.task.com.R;
import massive.task.com.adapter.DeliveryAdapter;
import massive.task.com.adapter.listener.BaseRecyclerAdapterListener;
import massive.task.com.library.Log;
import massive.task.com.model.pojo.Delivery;
import massive.task.com.model.webservice.DeliveryModel;
import massive.task.com.presenter.ipresenter.IHomeActivityPresenter;
import massive.task.com.retrofit.ResponseListener;
import massive.task.com.view.activity.DeliveryDetailsActivity;
import massive.task.com.view.iview.IHomeActivityView;


public class HomeActivityPresenter extends BasePresenter implements IHomeActivityPresenter, BaseRecyclerAdapterListener<Delivery> {
    DatabaseHandler db;
    private IHomeActivityView iHomeActivityView;
    private DeliveryAdapter deliveryAdapter;
    private ResponseListener<List<Delivery>> getDeliveriesListener = new ResponseListener<List<Delivery>>() {
        @Override
        public void onSuccess(List<Delivery> mResponse, long flag) {
            Log.e(TAG, "Deliveries" + mResponse.toString());
            iHomeActivityView.dismissProgressbar();
            createAdapter(mResponse);
            db.addDeliveryList(mResponse, iHomeActivityView.getActivity());

        }


        @Override
        public void onFailureApi(Throwable mThrowable) {
            iHomeActivityView.dismissProgressbar();
            iHomeActivityView.showMessage("Server error,try again!");

        }

        @Override
        public void showErrorDialog(List<Delivery> mResponse, long flag) {
            iHomeActivityView.dismissProgressbar();
            iHomeActivityView.showMessage("Server error, try again!");

        }
    };

    public HomeActivityPresenter(IHomeActivityView iHomeActivityView) {
        super(iHomeActivityView);
        this.iHomeActivityView = iHomeActivityView;

    }

    private void createAdapter(List<Delivery> mResponse) {
        deliveryAdapter = new DeliveryAdapter(mResponse, this);
        iHomeActivityView.setAdapter(deliveryAdapter);
    }

    @Override
    public void getDeliveriesAPI() {
        List<Delivery> deliveryList = db.getDeliveryList();
        if (deliveryList.size() > 0) {
            createAdapter(deliveryList);
        } else {
            if (iHomeActivityView.checkNetWork()) {
                iHomeActivityView.showProgressbar();
                DeliveryModel deliveryModel = new DeliveryModel(getDeliveriesListener);
                deliveryModel.getDeliveries(0);
            } else {
                iHomeActivityView.showMessage("No network");
            }
        }
    }

    @Override
    public void onCreatePresenter(Bundle bundle) {
        db = new DatabaseHandler(this.iHomeActivityView.getActivity());

    }

    @Override
    public void onClickItem(Delivery data) {

    }

    @Override
    public void onClickItem(View itemView, Delivery data) {
        Intent intent = new Intent(iHomeActivityView.getActivity(), DeliveryDetailsActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable(iHomeActivityView.getActivity().getString(R.string.data), (Serializable) data);
        intent.putExtras(bundle);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {


            //     Pair<View, String> pair1 = Pair.create(itemView.findViewById(R.id.image),iHomeActivityView.getActivity() .getString(R.string.activity_image_trans));
            //   Pair<View, String> pair2 = Pair.create( itemView.findViewById(R.id.delivery_point), iHomeActivityView.getActivity().getString(R.string.activity_text_trans));
            Pair<View, String> pair3 = Pair.create(itemView.findViewById(R.id.parent), iHomeActivityView.getActivity().getString(R.string.activity_parent_trans));
            ActivityOptionsCompat options = ActivityOptionsCompat.
                    makeSceneTransitionAnimation(iHomeActivityView.getActivity(), pair3);

            iHomeActivityView.getActivity().startActivity(intent, options.toBundle());
        } else {

            iHomeActivityView.getActivity().startActivity(intent);
        }
    }
}
