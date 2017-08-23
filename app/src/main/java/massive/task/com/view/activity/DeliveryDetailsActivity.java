package massive.task.com.view.activity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import massive.task.com.R;
import massive.task.com.library.Log;
import massive.task.com.model.pojo.Delivery;

public class DeliveryDetailsActivity extends BaseActivity implements OnMapReadyCallback {
    private GoogleMap mGoogleMap;
    private Delivery data;
    private TextView tvDeliveryPoint;
    private ImageView ivImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery_details);
        getSupportActionBar().setTitle(R.string.delivery_details);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        data = (Delivery) getIntent().getExtras().getSerializable(getString(R.string.data));
        tvDeliveryPoint = (TextView) findViewById(R.id.delivery_point);
        ivImage = (ImageView) findViewById(R.id.image);
        Log.e(TAG, "data: " + data.getLocation());
        initializeMap();

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void initializeMap() {
        if (mGoogleMap == null) {
            // android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
            SupportMapFragment googleMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.maps));
            googleMap.getMapAsync(this);


        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mGoogleMap = googleMap;
        LatLng latLng = new LatLng(data.getLocation().getLat(), data.getLocation().getLng());
        mGoogleMap.addMarker(new MarkerOptions()
                .position(latLng));

        CameraPosition cameraPosition = new CameraPosition.Builder().target(latLng).zoom(14.0f).build();
        CameraUpdate cameraUpdate = CameraUpdateFactory.newCameraPosition(cameraPosition);
        mGoogleMap.moveCamera(cameraUpdate);

        tvDeliveryPoint.setText(data.getDescription() + " at " + data.getLocation().getAddress());
        Glide.with(getActivity())
                .load(data.getImageUrl())
                .centerCrop()
                .into(ivImage);


    }
}
