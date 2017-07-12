package com.example.administrator.kaoshia;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity implements View.OnClickListener {

    private EditText ed1;
    private EditText ed2;
    private EditText ed3;
    private Button queding;
    private Button quxiao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        initView();
    }

    private void initView() {
        ed1 = (EditText) findViewById(R.id.ed1);
        ed2 = (EditText) findViewById(R.id.ed2);
        ed3 = (EditText) findViewById(R.id.ed3);
        queding = (Button) findViewById(R.id.queding);
        quxiao = (Button) findViewById(R.id.quxiao);

        queding.setOnClickListener(this);
        quxiao.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String ed1String = ed1.getText().toString().trim();
        String ed2String = ed2.getText().toString().trim();
        String ed3String = ed3.getText().toString().trim();
        switch (v.getId()) {
            case R.id.queding:
                if (!TextUtils.isEmpty(ed1String)&&!TextUtils.isEmpty(ed2String)&&!TextUtils.isEmpty(ed3String)) {
                    Intent intent=getIntent();
                    intent.putExtra("name1",ed1String);
                    intent.putExtra("name2",ed2String);
                    intent.putExtra("name3",ed3String);
                    setResult(30,intent);
                    finish();
                    
                }else {
                    Toast.makeText(this, "请填写完整信息", Toast.LENGTH_SHORT).show();
                }




                break;
            case R.id.quxiao:
                finish();
                break;
        }
    }

 
      
       
      
}
