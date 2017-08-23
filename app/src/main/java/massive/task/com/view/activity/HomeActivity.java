package massive.task.com.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import massive.task.com.R;
import massive.task.com.adapter.DeliveryAdapter;
import massive.task.com.presenter.HomeActivityPresenter;
import massive.task.com.presenter.ipresenter.IHomeActivityPresenter;
import massive.task.com.view.iview.IHomeActivityView;

public class HomeActivity extends BaseActivity implements IHomeActivityView {
private IHomeActivityPresenter iHomeActivityPresenter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        getSupportActionBar().setTitle(R.string.things_to_deliver);
        iHomeActivityPresenter=new HomeActivityPresenter(this);
        iHomeActivityPresenter.onCreatePresenter(getIntent().getExtras());
        iHomeActivityPresenter.getDeliveriesAPI();
    }

    @Override
    public void setAdapter(DeliveryAdapter deliveryAdapter) {
        recyclerView.setAdapter(deliveryAdapter);

    }
}
