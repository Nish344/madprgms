package com.example.wallpaper;

import android.app.WallpaperManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private Timer myTimer;
    private Drawable drawable;
    private WallpaperManager wpm;
    private int next = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        wpm = WallpaperManager.getInstance(this);
    }

    public void changeWallPaper(View v) {
        setWallPaper();
    }

    private void setWallPaper() {
        if (myTimer != null) {
            myTimer.cancel();
        }

        myTimer = new Timer();
        myTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (next == 1) {
                    drawable = getResources().getDrawable(R.drawable.one);
                    next = 2;
                } else {
                    drawable = getResources().getDrawable(R.drawable.two);
                    next = 1; // Reset to 1 for alternating behavior
                }

                Bitmap image = ((BitmapDrawable) drawable).getBitmap();

                runOnUiThread(() -> {
                    try {
                        wpm.setBitmap(image);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });
            }
        }, 30000, 5000); // Change wallpaper every 5 seconds after an initial delay of 30 seconds
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (myTimer != null) {
            myTimer.cancel();
        }
    }
}
