package com.example.lianxi1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.lianxi1.adapter.ListAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText searchbox;
    private ListView list;
    List<Person> list11 = new ArrayList<>();

    private ListAdapter listAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initData() {


        for (int i = 1; i < 6; i++) {
            list11.add(new Person("xiao" + i, "wwwww", 23));
            list11.add(new Person("aaaaa" + i, "bbbbbb", 24));
            list11.add(new Person("xiaoli" + i, "dddddd", 23));
        }
        listAdapter = new ListAdapter(list11, MainActivity.this);
        list.setAdapter(listAdapter);
    }

    private void initView() {
        searchbox = (EditText) findViewById(R.id.searchbox);
        list = (ListView) findViewById(R.id.list);

        searchbox.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String s = searchbox.getText().toString();
                //调用编辑框对象监听器方法
                filterTextWatcher.onTextChanged(s, 0, s.length(), s.length());
            }
        });
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,list11.get(position).getFirstname(), Toast.LENGTH_SHORT).show();
            }
        });
    }


     //TextWatcher编辑框监听器!!!!!!!!!
    private TextWatcher filterTextWatcher = new TextWatcher() {

        @Override
        public void afterTextChanged(Editable s) {
            //表示最终内容
            Log.d("filterTextWatcher", s.toString());
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count,
                                      int after) {
          //  int start/*开始的位置*/,
            // int count/*被改变的旧内容数*/,
            // int after/*改变后的内容数量*/) {
            //这里的s表示改变之前的内容，通常start和count组合，
            // 可以在s中读取本次改变字段中被改变的内容。而after表示改变后新的内容的数量。

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before,
                                  int count) {
            listAdapter.getFilter().filter(s); //这里传入数据就可以了
            /*
            *  int start开始位置,
            int before改变前的内容数量,
            int count新增数) {
          //这里的s表示改变之后的内容，通常start和count组合，
          可以在s中读取本次改变字段中新的内容。而before表示被改变的内容的数量。

            */
        }

    };


}
