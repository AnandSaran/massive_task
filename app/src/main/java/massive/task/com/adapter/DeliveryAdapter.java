package massive.task.com.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import massive.task.com.R;
import massive.task.com.adapter.listener.BaseRecyclerAdapterListener;
import massive.task.com.adapter.viewholder.DeliveryViewHolder;
import massive.task.com.model.pojo.Delivery;


public class DeliveryAdapter extends BaseRecyclerAdapter<Delivery, DeliveryViewHolder> {
    private BaseRecyclerAdapterListener<Delivery> listener;

    public DeliveryAdapter(List<Delivery> data, BaseRecyclerAdapterListener<Delivery> listener) {
        super(data);
        this.listener = listener;

    }

    @Override
    public DeliveryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new DeliveryViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.inflate_delivery, parent, false), listener);

    }
}
