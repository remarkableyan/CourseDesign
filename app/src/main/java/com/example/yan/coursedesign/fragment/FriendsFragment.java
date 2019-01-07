package com.example.yan.coursedesign.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.example.yan.coursedesign.adapter.PeopleAdapter;
import com.example.yan.coursedesign.R;
import com.example.yan.coursedesign.VO.People;
import com.example.yan.coursedesign.activity.ChatActivity;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

import static android.app.Activity.RESULT_OK;


public class FriendsFragment extends Fragment {
    private static final String TAG = "FriendsFragment";
    List<People> peopleList;
    PeopleAdapter peopleAdapter;
    ListView listView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_friends, container, false);
        listView=view.findViewById(R.id.peoplelist);
        peopleList=new ArrayList<>();
        ImageButton imageButton=view.findViewById(R.id.addfriend);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                peopleList.add(new People("new","帅哥",R.mipmap.people3));
                listView.setAdapter(peopleAdapter);
            }
        });
        peopleList.add(new People("yan","帅哥",R.mipmap.people3));
        peopleList.add(new People("chen","帅哥",R.mipmap.people1));
        peopleList.add(new People("xi","帅哥",R.mipmap.people2));
        peopleAdapter=new PeopleAdapter(getActivity(),R.layout.people_item,peopleList);
        listView.setAdapter(peopleAdapter);
        listView.addFooterView(new TextView(getActivity()));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView textView=view.findViewById(R.id.people_name);
                CircleImageView circleImageView=view.findViewById(R.id.people_name);
                String name=textView.getText().toString();
                Intent intent=new Intent(getActivity(),ChatActivity.class);
                intent.putExtra("name",name);
                intent.putExtra("headPic",peopleList.get(position).getImage());
                startActivityForResult(intent,1);
            }
        });
        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode){
            case 1:
                if (resultCode==RESULT_OK){
                    String name=data.getStringExtra("name");
                    String content=data.getStringExtra("content");
                    if(!"".equals(content)&&content!=null){
                        Log.d(TAG, "onActivityResult:"+content);
                        for (People people:peopleList){
                            if(people.getName().equals(name)){
                                people.setSlabel(content);
                                listView.setAdapter(peopleAdapter);
                                break;
                            }
                        }
                    }
                }break;
            default:
        }

    }
}
