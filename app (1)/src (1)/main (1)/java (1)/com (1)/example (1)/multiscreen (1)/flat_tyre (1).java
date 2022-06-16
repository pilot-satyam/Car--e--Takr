package com.example.multiscreen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

public class flat_tyre extends AppCompatActivity {

    private Button button24;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flat_tyre);
        Intent intent8 = getIntent();
        YouTubePlayerView youTubePlayerView = findViewById(R.id.youtube_player_view0);
        getLifecycle().addObserver(youTubePlayerView);

        youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                String videoId = "6T-rmhXUR8o";
                youTubePlayer.loadVideo(videoId, 0);
            }
        });

    }
    public void Location_pune(View view){
        Intent intent24 = new Intent(this, Location_pune.class);
        startActivity(intent24);
    }
}
