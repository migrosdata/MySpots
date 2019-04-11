package ch.avirtualfriend.myspots.activities.Main;

import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.Collection;
import java.util.List;

import ch.avirtualfriend.myspots.R;
import ch.avirtualfriend.myspots.models.Spot;

public class SpotAdapter extends RecyclerView.Adapter<SpotViewHolder> {
    private List<Spot> spots;

    public SpotAdapter(List<Spot> spots) {
        this.spots = spots;
    }

    @NonNull
    @Override
    public SpotViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_main_card_view, parent, false);
        final ImageView spotImageView = (ImageView)v.findViewById(R.id.card_view_image);
        // When click the image.
        spotImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar snackbar = Snackbar.make(spotImageView, "You click", Snackbar.LENGTH_LONG);
                snackbar.show();
            }
        });
        SpotViewHolder viewHolder = new SpotViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SpotViewHolder holder, int position) {
        Log.d("DEBUG", "position " + Integer.toString(position));
        Spot currentSpot = spots.get(position);
        holder.getSpotTitleText().setText(currentSpot.getName());
        if (currentSpot.getImages().size() > 0) {
            //holder.getSpotImageView().setImageBitmap(spots.get(position).getImages().get(0).getContent());
            holder.getSpotImageView().setImageBitmap(currentSpot.getImages().get(0).getContent());
        } else {
            Log.d("DEBUG", "no image");
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Longitude: ");
        sb.append(currentSpot.getLongitude());
        sb.append(" Lattitude:");
        sb.append(currentSpot.getLatitude());
        sb.append(" Altitude: ");
        sb.append(currentSpot.getAltitude());
        holder.getSpotDetailsText().setText(sb.toString());
    }

    @Override
    public int getItemCount() {
        return spots.size();
    }
}
