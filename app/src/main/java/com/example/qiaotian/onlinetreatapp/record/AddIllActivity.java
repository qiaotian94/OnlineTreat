package com.example.qiaotian.onlinetreatapp.record;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.qiaotian.onlinetreatapp.R;
import com.example.qiaotian.onlinetreatapp.login.LogonActivity;
import com.example.qiaotian.onlinetreatapp.sql.DBHelper;

import pl.com.salsoft.sqlitestudioremote.SQLiteStudioService;

import static com.example.qiaotian.onlinetreatapp.login.LoginActivity.userID;

public class AddIllActivity extends AppCompatActivity {

    private DBHelper dbHeldper;
    private EditText edit1, edit2, edit3;
    private Button illBtn;
    private String id, date, body;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_ill);
      initData();
        initView();
        SQLiteStudioService.instance().start(this);
    }

    private void initData() {
        dbHeldper = new DBHelper(this, "UserStore.db", null, 1);
        edit1 = (EditText) findViewById(R.id.illedit1);
        edit2 = (EditText) findViewById(R.id.illedit2);
        edit3 = (EditText) findViewById(R.id.illedit3);
        illBtn = (Button) findViewById(R.id.illbtn);
    }

    private void initView() {
        illBtn.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                id = edit1.getText().toString();
                date = edit2.getText().toString();
                body = edit3.getText().toString();
                if (CheckIsDataAlreadyInDBOrNot(userID)) {
                    if (addill(id, date, body)) {
                        Toast.makeText(AddIllActivity.this, "已添加！", Toast.LENGTH_SHORT).show();

                    }
                } else {
                    Toast.makeText(AddIllActivity.this, "用户不正确！", Toast.LENGTH_SHORT).show();
                }
            }

        });
    }

    public boolean addill(String id, String date, String body) {
        SQLiteDatabase db = dbHeldper.getWritableDatabase();
       // sql="insert into userData(name,password) value(?,?)"
            //     Object obj[]={username,password};
        //  db.execSQL(sql,obj);
        ContentValues values = new ContentValues();
        values.put("id", id);
        values.put("date", date);
        values.put("body", body);
        db.insert("illRecord", null, values);
        db.close();
        //db.execSQL("insert into userData (name,password) values (?,?)",new String[]{username,password});
        return true;
    }

    //检验用户名是否存在
    public boolean CheckIsDataAlreadyInDBOrNot(String value) {
        SQLiteDatabase db = dbHeldper.getWritableDatabase();
        String Query = "select * from userData where id=?";
        Cursor cursor = db.rawQuery(Query, new String[]{value});
        if (cursor.getCount() > 0) {
            cursor.close();
            return true;
        }
        cursor.close();
        return false;
    }
}