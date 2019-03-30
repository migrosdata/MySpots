package ch.avirtualfriend.myspots.activities.Splash;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.VideoView;

import ch.avirtualfriend.myspots.R;
import ch.avirtualfriend.myspots.activities.Main.MainActivity;
import ch.avirtualfriend.myspots.services.SpotService;

public class SplashActivity extends AppCompatActivity {
    VideoView videoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        SpotService.loadDefaultContent();
        startVideo();
    }

    private void startVideo() {
        videoView = (VideoView) findViewById(R.id.videoView);
        Uri video = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.splash);
        videoView.setVideoURI(video);
        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer mp) {
                startNextActivity();
            }
        });
        videoView.start();
    }

    private void startNextActivity() {
        if (isFinishing()) {
            return;
        }
        startActivity(new Intent(this, ch.avirtualfriend.myspots.activities.Main.MainActivity.class));
        finish();
    }
}
