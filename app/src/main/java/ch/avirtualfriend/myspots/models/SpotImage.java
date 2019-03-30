package ch.avirtualfriend.myspots.models;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.Log;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

public class SpotImage implements Target {
    private String id;

    public Bitmap getContent() {
        return content;
    }

    private Bitmap content;
    private Spot spot;

    @Override
    public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
        content = bitmap;
        Log.d("DEBUG", "onBitmapLoaded");
    }

    @Override
    public void onBitmapFailed(Exception e, Drawable errorDrawable) {
        Log.d("DEBUG", "onBitmapFailed");
    }

    @Override
    public void onPrepareLoad(Drawable placeHolderDrawable) {

    }
}
