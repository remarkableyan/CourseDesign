package com.example.yan.coursedesign;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by ACM-Yan on 2018/3/15.
 */

public class ImgAdapter extends ArrayAdapter<Img> {
    private int resourceId;
    ImageButton good;
    public ImgAdapter(Context context, int resourceId, List<Img> objects) {
        super(context, resourceId, objects);
        this.resourceId=resourceId;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Img people=getItem(position);
        View view = null;
        ViewHolder viewHolder;
        if(convertView==null){
            view=LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
            viewHolder = new ViewHolder();
            viewHolder.name = view.findViewById (R.id.name);
            viewHolder.headPic = view.findViewById (R.id.headPic);
            viewHolder.imgcontent = view.findViewById (R.id.imgcontent);
            viewHolder.good = view.findViewById (R.id.like);
            view.setTag(viewHolder);
        }else{
            view=convertView;
            viewHolder= (ViewHolder) view.getTag();
        }
        TextView name=viewHolder.name;
        ImageView  headPic=viewHolder.headPic;
        ImageView imgContent=viewHolder.imgcontent;
        name.setText(people.getName());
        good= viewHolder.good;
        good.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(good.isSelected()){
                    good.setSelected(false);
                }else{
                    good.setSelected(true);
                }
            }
        });
        headPic.setImageDrawable(MyApplication.getContext().getResources().getDrawable(people.getHeadPic()));
        imgContent.setImageDrawable(MyApplication.getContext().getResources().getDrawable(people.getImgContent()));
        return view;
    }
    class ViewHolder {

        TextView name;
        ImageView headPic;
        ImageView imgcontent;
        ImageButton good;
    }
}
