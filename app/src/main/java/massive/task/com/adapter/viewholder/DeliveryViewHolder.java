package massive.task.com.adapter.viewholder;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import massive.task.com.R;
import massive.task.com.adapter.listener.BaseRecyclerAdapterListener;
import massive.task.com.model.pojo.Delivery;

public class DeliveryViewHolder extends BaseViewHolder<Delivery> implements View.OnClickListener {
    private BaseRecyclerAdapterListener<Delivery> listener;
    private TextView tvDeliveryPoint;
    private ImageView ivImage;
    private LinearLayout cvParent;

    public DeliveryViewHolder(View itemView, BaseRecyclerAdapterListener<Delivery> listener) {
        super(itemView);
        this.listener = listener;

        bindHolder();

    }

    private void bindHolder() {
        tvDeliveryPoint = (TextView) itemView.findViewById(R.id.delivery_point);
        ivImage = (ImageView) itemView.findViewById(R.id.image);
        cvParent = (LinearLayout) itemView.findViewById(R.id.parent);
        cvParent.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.parent:
                listener.onClickItem(itemView, data);
                break;
            default:
                break;
        }
    }

    @Override
    void populateData(Delivery data) {
        tvDeliveryPoint.setText(data.getDescription() + " at " + data.getLocation().getAddress());
        Glide.with(itemView.getContext())
                .load(data.getImageUrl())
                .centerCrop()
                .into(ivImage);
    }


}
