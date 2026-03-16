package com.byreytiz.launcher.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.byreytiz.game.R;
import com.bumptech.glide.Glide;

import java.util.List;

public class SliderStoriesAdapter extends PagerAdapter {
    private Context context;
    private List<String> imageUrls;
    private List<String> titles;

    public SliderStoriesAdapter(Context context, List<String> imageUrls, List<String> titles) {
        this.context = context;
        this.imageUrls = imageUrls;
        this.titles = titles;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.slider_item, container, false);
        
        ImageView imageView = view.findViewById(R.id.image_slider);
        TextView textView = view.findViewById(R.id.text_slider);
        
        Glide.with(context).load(imageUrls.get(position)).into(imageView);
        textView.setText(titles.get(position));
        
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return imageUrls.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }
    }
