package com.example.yan.coursedesign;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by ACM-Yan on 2018/3/15.
 */

public class PeopleAdapter extends ArrayAdapter<People> {
    private int resourceId;

    public PeopleAdapter(Context context, int resourceId, List<People> objects) {
        super(context, resourceId, objects);
        this.resourceId=resourceId;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        People people=getItem(position);
        View view = null;
        ViewHolder viewHolder;
        if(convertView==null){
            view=LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
            viewHolder = new ViewHolder();
            viewHolder.name = view.findViewById (R.id.people_name);
            viewHolder.slabel = view.findViewById (R.id.label);
            viewHolder.imageView = view.findViewById (R.id.imgpeo);
            view.setTag(viewHolder);
        }else{
            view=convertView;
            viewHolder= (ViewHolder) view.getTag();
        }
        TextView name=viewHolder.name;
        TextView slabel=viewHolder.slabel;
        ImageView imageView=viewHolder.imageView;
        name.setText(people.getName());
        imageView.setImageDrawable(MyApplication.getContext().getResources().getDrawable(people.getImage()));
        slabel.setText(people.getSlabel());
        return view;
    }
    class ViewHolder {

        TextView name;
        TextView slabel;
        ImageView imageView;
    }
}
