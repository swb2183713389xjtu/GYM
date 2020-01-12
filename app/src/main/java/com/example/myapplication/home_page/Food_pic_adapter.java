package com.example.myapplication.home_page;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.myapplication.R;

import java.util.List;
import java.util.zip.Inflater;

public class Food_pic_adapter extends PagerAdapter {
    private Context context;
    private List<Bitmap> list;
    //private List<Integer> list;

    public Food_pic_adapter(Context context,List<Bitmap> list) {
        this.context=context;
        this.list=list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
        final View view= View.inflate(context, R.layout.food_pic,null);
        ImageView imageView=view.findViewById(R.id.pic_food);
        imageView.setImageBitmap(list.get(position));
        //imageView.setImageResource(list.get(position));
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(view.getContext(),"click it",Toast.LENGTH_SHORT).show();
            }
        });
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }
}
