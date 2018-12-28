package com.example.yan.coursedesign;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.cjj.MaterialRefreshLayout;
import com.cjj.MaterialRefreshListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


public class HomeFragment extends Fragment {
    List<Img> imgs;
    ImgAdapter imgAdapter;
    MaterialRefreshLayout materialRefreshLayout;
    private static final String TAG = "HomeFragment";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_home, container, false);
        final ListView homeList=view.findViewById(R.id.homeList);
        ImageButton camera=view.findViewById(R.id.camera);
        imgs=new ArrayList<Img>();
        imgs.add(new Img("leon",R.mipmap.people1,R.mipmap.pic1));
        imgs.add(new Img("leon",R.mipmap.people1,R.mipmap.iu1));
        imgs.add(new Img("leon",R.mipmap.people1,R.mipmap.iu2));
        imgAdapter=new ImgAdapter(getActivity(),R.layout.listview_item,imgs);
        materialRefreshLayout=view.findViewById(R.id.refresh);
        materialRefreshLayout.setMaterialRefreshListener(new MaterialRefreshListener() {
            @Override
            public void onRefresh(final MaterialRefreshLayout materialRefreshLayout) {
                Toast.makeText(MyApplication.getContext(), "更新成功!", Toast.LENGTH_SHORT).show();
                imgs.add(new Img("new",R.mipmap.people2,R.mipmap.iu2));
                homeList.setAdapter(imgAdapter);
                TimerTask timerTask=new TimerTask() {
                    @Override
                    public void run() {
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                materialRefreshLayout.finishRefresh();
                            }
                        });
                    }
                };
                Timer timer = new Timer();
                timer.schedule(timerTask, 2000);
            }
        });
        homeList.setAdapter(imgAdapter);
        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MyApplication.getContext(), "添加成功!", Toast.LENGTH_LONG).show();
                imgs.add(new Img("new",R.mipmap.people3,R.mipmap.iu2));
                homeList.setAdapter(imgAdapter);
            }
        });
        return view;
    }
}
