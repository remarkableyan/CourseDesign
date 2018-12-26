package com.example.yan.coursedesign;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {
    private ImageButton good;
    private static final String TAG = "HomeFragment";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_home, container, false);
        ListView homeList=view.findViewById(R.id.homeList);
        List<Img> imgs=new ArrayList<Img>();
        imgs.add(new Img("leon",R.mipmap.people1,R.mipmap.pic1));
        imgs.add(new Img("leon",R.mipmap.people1,R.mipmap.iu1));
        imgs.add(new Img("leon",R.mipmap.people1,R.mipmap.iu2));
        ImgAdapter imgAdapter=new ImgAdapter(getActivity(),R.layout.listview_item,imgs);
        Log.d(TAG, "onCreateView: listview is ok");
        homeList.setAdapter(imgAdapter);
        return view;
    }
}
