package nl.hva.msi.bucketlist;

import android.content.Context;
import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

public class BucketListItemAdapter extends RecyclerView.Adapter<BucketListItemAdapter.ViewHolder> {

    private List<BucketListItem> bucketListItems;
    private LayoutInflater layoutInflater;
    private Context context;

    public BucketListItemAdapter(List<BucketListItem> bucketListItems, Context context) {
        this.bucketListItems = bucketListItems;
        this.layoutInflater = LayoutInflater.from(context);
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_listitem, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int i) {
        final BucketListItem bucketListItem = bucketListItems.get(i);
        viewHolder.bucketItemDescription.setText(bucketListItem.getDescription());
        viewHolder.bucketItemTitle.setText(bucketListItem.getTitle());

        viewHolder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    viewHolder.bucketItemTitle.setPaintFlags(viewHolder.bucketItemTitle.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                    viewHolder.bucketItemDescription.setPaintFlags(viewHolder.bucketItemDescription.getPaintFlags()| Paint.STRIKE_THRU_TEXT_FLAG);
                } else {
                    viewHolder.bucketItemTitle.setPaintFlags(viewHolder.bucketItemTitle.getPaintFlags()& ~Paint.STRIKE_THRU_TEXT_FLAG);
                    viewHolder.bucketItemDescription.setPaintFlags(viewHolder.bucketItemDescription.getPaintFlags()& ~Paint.STRIKE_THRU_TEXT_FLAG);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return bucketListItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView bucketItemTitle;
        TextView bucketItemDescription;
        CheckBox checkBox;
        LinearLayout linearLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            bucketItemTitle = itemView.findViewById(R.id.bucketItemTitle);
            bucketItemDescription = itemView.findViewById(R.id.bucketItemDescr);
            checkBox = itemView.findViewById(R.id.checkBox);
            linearLayout = itemView.findViewById(R.id.parentalLayout);
            linearLayout.setClickable(true);
        }
    }
}
