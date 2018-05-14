package com.android.mediumclone;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by kamalshree on 5/13/2018.
 */

public class ViewPagerAdapter extends PagerAdapter {
    // Declare Variables
    Context context;
    String[] date;
    String[] time;
    String[] title;
    String[] author;
    int[] bannerimages;
    LayoutInflater inflater;

    public ViewPagerAdapter(Context context, String[] date, String[] time,
                            String[] author,String[] title, int[] bannerimages) {
        this.context = context;
        this.date = date;
        this.time = time;
        this.title = title;
        this.author = author;
        this.bannerimages = bannerimages;
    }

    @Override
    public int getCount() {
        return date.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((CardView) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        // Declare Variables
        TextView txtdate;
        TextView txttime;
        TextView txttitle;
        TextView txtauthor;
        ImageView imgbanner;

        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.text_layout, container,
                false);

        // Locate the TextViews in viewpager_item.xml
        txtdate = (TextView) itemView.findViewById(R.id.date);
        txttime = (TextView) itemView.findViewById(R.id.time);
        txttitle = (TextView) itemView.findViewById(R.id.title);
        txtauthor = (TextView) itemView.findViewById(R.id.author);


        // Capture position and set to the TextViews
        txtdate.setText(date[position]);
        txttime.setText(time[position]);
        txttitle.setText(title[position]);
        txtauthor.setText(author[position]);

        // Locate the ImageView in viewpager_item.xml
        imgbanner = (ImageView) itemView.findViewById(R.id.bannerimage);
        // Capture position and set to the ImageView
        imgbanner.setImageResource(bannerimages[position]);

        // Add viewpager_item.xml to ViewPager
        ((ViewPager) container).addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        // Remove viewpager_item.xml from ViewPager
        ((ViewPager) container).removeView((CardView) object);

    }
}