package com.example.yan.coursedesign.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.yan.coursedesign.adapter.MsgAdapter;
import com.example.yan.coursedesign.R;
import com.example.yan.coursedesign.VO.Msg;

import java.util.ArrayList;
import java.util.List;

public class ChatActivity extends AppCompatActivity {
    private List<Msg> msgList = new ArrayList<Msg>();

    private EditText inputText;

    private Button send;

    private RecyclerView msgRecyclerView;

    private MsgAdapter adapter;
    private ImageButton backbtn;
    private Intent resultIntent;
    private String name;
    private int headPic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat_layout);
        Intent intent=getIntent();
        name=intent.getStringExtra("name");
        headPic=intent.getIntExtra("headPic",R.mipmap.people1);
        initMsgs(); // 初始化消息数据
        backbtn=findViewById(R.id.backbtn);
        inputText =  findViewById(R.id.input_text);
        send =  findViewById(R.id.send);
        TextView textView=findViewById(R.id.chatWith);
        textView.setText(name);
        msgRecyclerView = findViewById(R.id.msg_recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        msgRecyclerView.setLayoutManager(layoutManager);
        adapter = new MsgAdapter(msgList,headPic);
        msgRecyclerView.setAdapter(adapter);
        ImageButton backbtn=findViewById(R.id.backbtn);
        resultIntent=new Intent();
        resultIntent.putExtra("name",name);
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = inputText.getText().toString();
                if (!"".equals(content)) {
                    resultIntent.putExtra("content",content);
                    Msg msg = new Msg(content, Msg.TYPE_SENT);
                    msgList.add(msg);
                    adapter.notifyItemInserted(msgList.size() - 1); // 当有新消息时，刷新ListView中的显示
                    msgRecyclerView.scrollToPosition(msgList.size() - 1); // 将ListView定位到最后一行
                    inputText.setText(""); // 清空输入框中的内容
                }
            }
        });
        setResult(RESULT_OK,resultIntent);
    }
    private void initMsgs() {
        Msg msg1 = new Msg("Hello guy.", Msg.TYPE_RECEIVED);
        msgList.add(msg1);
        Msg msg2 = new Msg("Hello. Who is that?", Msg.TYPE_SENT);
        msgList.add(msg2);
    }
}
