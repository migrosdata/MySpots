package ch.avirtualfriend.myspots.activities.Main;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import ch.avirtualfriend.myspots.R;

public class SpotViewHolder extends RecyclerView.ViewHolder {
    private TextView spotTitleText;
    private TextView spotDetailsText;
    private ImageView spotImageView;

    public SpotViewHolder(@NonNull View itemView) {
        super(itemView);
        if(itemView != null) {
            spotTitleText = (TextView)itemView.findViewById(R.id.card_view_image_title);
            spotDetailsText = (TextView)itemView.findViewById(R.id.card_view_image_details);
            spotImageView = (ImageView)itemView.findViewById(R.id.card_view_image);
        }
    }

    public TextView getSpotTitleText() {
        return spotTitleText;
    }

    public ImageView getSpotImageView() {
        return spotImageView;
    }

    public TextView getSpotDetailsText() { return spotDetailsText; }
}
