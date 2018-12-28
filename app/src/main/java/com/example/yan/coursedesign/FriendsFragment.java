package com.example.yan.coursedesign;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;


public class FriendsFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_friends, container, false);
        ListView listView=view.findViewById(R.id.peoplelist);
        List<People> peopleList=new ArrayList<>();
        peopleList.add(new People("yan","帅哥",R.mipmap.people3));
        peopleList.add(new People("chen","帅哥",R.mipmap.people1));
        peopleList.add(new People("xi","帅哥",R.mipmap.people2));
        listView.setAdapter(new PeopleAdapter(getActivity(),R.layout.people_item,peopleList));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView textView=view.findViewById(R.id.people_name);
                String name=textView.getText().toString();
                Intent intent=new Intent(getActivity(),ChatActivity.class);
                intent.putExtra("name",name);
                startActivity(intent);
            }
        });
        return view;
    }

}
