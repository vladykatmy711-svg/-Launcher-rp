package com.byreytiz.launcher.activity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.byreytiz.game.R;
import com.byreytiz.launcher.adapter.SliderStoriesAdapter;
import com.akexorcist.roundcornerprogressbar.RoundCornerProgressBar;

import java.util.ArrayList;
import java.util.List;

public class StoryActivity extends AppCompatActivity {
    private RoundCornerProgressBar progressStory;
    private ViewPager viewPager;
    private SliderStoriesAdapter adapter;
    private List<String> imageUrls;
    private List<String> titles;
    private Handler handler = new Handler();
    private int currentPosition = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        progressStory = findViewById(R.id.progress_story);
        viewPager = findViewById(R.id.viewpager_story);

        imageUrls = new ArrayList<>();
        titles = new ArrayList<>();
        
        imageUrls.add("https://example.com/image1.jpg");
        imageUrls.add("https://example.com/image2.jpg");
        imageUrls.add("https://example.com/image3.jpg");
        
        titles.add("Story 1");
        titles.add("Story 2");
        titles.add("Story 3");

        adapter = new SliderStoriesAdapter(this, imageUrls, titles);
        viewPager.setAdapter(adapter);

        progressStory.setMax(imageUrls.size());
        progressStory.setProgress(1);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}

            @Override
            public void onPageSelected(int position) {
                currentPosition = position;
                progressStory.setProgress(position + 1);
            }

            @Override
            public void onPageScrollStateChanged(int state) {}
        });

        startAutoSlide();
    }

    private void startAutoSlide() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (currentPosition < imageUrls.size() - 1) {
                    currentPosition++;
                    viewPager.setCurrentItem(currentPosition, true);
                } else {
                    finish();
                }
                handler.postDelayed(this, 3000);
            }
        }, 3000);
    }

    @Override
    protected void onDestroy() {
        handler.removeCallbacksAndMessages(null);
        super.onDestroy();
    }
}
