package com.example.qiaotian.onlinetreatapp.login;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.qiaotian.onlinetreatapp.MainActivity;
import com.example.qiaotian.onlinetreatapp.R;
import com.example.qiaotian.onlinetreatapp.sql.DBHelper;

import pl.com.salsoft.sqlitestudioremote.SQLiteStudioService;

public class LoginActivity extends AppCompatActivity {
    private Button mLogin;
    private Button mLogon;
    private DBHelper dbHeldper;
    EditText userid;
    EditText password;
    String passWord;
     public static String userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        SQLiteStudioService.instance().start(this);
        initData();
        initView();
    }

    private void initData() {
        mLogin=(Button) findViewById(R.id.btn_1);
        mLogon=(Button) findViewById(R.id.btn_2);
        dbHeldper=new DBHelper(this,"UserStore.db",null,1);
        userid=(EditText)findViewById(R.id.et_1);
        password=(EditText)findViewById(R.id.et_2);
    }

    private void initView() {
        mLogon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(LoginActivity.this,LogonActivity.class);
                startActivity(intent);

            }
        });
        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userID=userid.getText().toString();
                passWord=password.getText().toString();
                if (login(userID,passWord)&&userID!=null&&passWord!=null) {
                    Toast.makeText(LoginActivity.this, "登陆成功", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(LoginActivity.this, "登陆失败", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
    public boolean login(String id,String password) {
        SQLiteDatabase db = dbHeldper.getWritableDatabase();
        String sql = "select * from userData where id=? and password=?";
        Cursor cursor = db.rawQuery(sql, new String[] {id, password});
        if (cursor.moveToFirst()) {
            cursor.close();
            return true;
        }
        return false;
    }
}


