package com.byreytiz.launcher.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.byreytiz.game.R;
import com.bumptech.glide.Glide;
import com.denzcoskun.imageslideshow.models.SlideModel;
import com.denzcoskun.imageslideshow.adapters.ImageSliderAdapter;

import java.util.List;

public class SliderStoriesAdapter extends ImageSliderAdapter {
    private Context context;
    private List<SlideModel> slideModels;

    public SliderStoriesAdapter(Context context, List<SlideModel> slideModels) {
        this.context = context;
        this.slideModels = slideModels;
    }

    @Override
    public int getCount() {
        return slideModels.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.slider_item, parent, false);
        }

        ImageView imageView = view.findViewById(R.id.image_slider);
        TextView textView = view.findViewById(R.id.text_slider);

        SlideModel slideModel = slideModels.get(position);
        
        if (slideModel.getImageUrl() != null) {
            Glide.with(context).load(slideModel.getImageUrl()).into(imageView);
        }
        
        if (slideModel.getTitle() != null) {
            textView.setText(slideModel.getTitle());
            textView.setVisibility(View.VISIBLE);
        } else {
            textView.setVisibility(View.GONE);
        }

        return view;
    }
              }
