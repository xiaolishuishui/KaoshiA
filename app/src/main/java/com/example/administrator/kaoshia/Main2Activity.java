package com.example.administrator.kaoshia;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.greendao1.DaoMaster;
import com.example.greendao1.DaoSession;
import com.example.greendao1.StudentsDao;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {

    private Button tianjia;
    private ListView lv;
    private ProgressDialog dialog;
    private StudentsDao studentsDao;
    ArrayList<Students> list = new ArrayList<>();
    private Myadapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
        initProgress();
    }

    private void initView() {
        tianjia = (Button) findViewById(R.id.tianjia);
        lv = (ListView) findViewById(R.id.lv);

        tianjia.setOnClickListener(this);
    }

    private void initProgress() {
        dialog = new ProgressDialog(Main2Activity.this);
        dialog.setMax(100);

        dialog.setCancelable(false);
        // dialog.setMessage("正在加载...");
        dialog.show();
        Timer time = new Timer();
        time.schedule(new MyTask(), 2000);
    }

    class MyTask extends TimerTask {

        @Override
        public void run() {
            dialog.dismiss();
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    initData();
                }
            });

        }
    }

    private void initData() {
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(Main2Activity.this, "students11.db", null);

        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getReadableDb());

        DaoSession daoSession = daoMaster.newSession();

        studentsDao = daoSession.getStudentsDao();


        List<Students> list1 = studentsDao.queryBuilder().build().list();
        if (list1.size() == 0) {
            for (int i = 1; i < 6; i++) {
                studentsDao.insert(new Students(null, "张三" + i, "11111111" + i, "北京" + i));
            }
        }
        List<Students> lists = studentsDao.queryBuilder().build().list();//查询所有
        list.addAll(lists);
        adapter = new Myadapter(Main2Activity.this, list);
        lv.setAdapter(adapter);

       lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

               Students stu1 = studentsDao.queryBuilder().where(StudentsDao.Properties.Id.eq(list.get(position).getId())).build().unique();//查询单

                   studentsDao.delete(stu1);
             list.clear();
               List<Students> list2222 = studentsDao.queryBuilder().build().list();
               list.addAll(list2222);
               adapter.notifyDataSetChanged();

               Toast.makeText(Main2Activity.this, "已删除", Toast.LENGTH_SHORT).show();
           }
       });
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tianjia:
                Intent in = new Intent(Main2Activity.this, Main3Activity.class);
                startActivityForResult(in, 1000);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1000 && resultCode == 30) {
            String name1 = data.getStringExtra("name1");
            String name2 = data.getStringExtra("name2");
            String name3 = data.getStringExtra("name3");
            studentsDao.insert(new Students(null, name1, name2, name3));
            list.clear();
            List<Students> list22 = studentsDao.queryBuilder().build().list();
            list.addAll(list22);
            adapter.notifyDataSetChanged();

        }

    }
}
