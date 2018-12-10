package com.example.qiaotian.onlinetreatapp.record;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.qiaotian.onlinetreatapp.R;
import com.example.qiaotian.onlinetreatapp.sql.DBHelper;

import pl.com.salsoft.sqlitestudioremote.SQLiteStudioService;

import static com.example.qiaotian.onlinetreatapp.login.LoginActivity.userID;

public class LookIllActivity extends AppCompatActivity {
    private DBHelper dbHelper;
    private TextView tx1;
    String id,date,body;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_look_ill);

       SQLiteStudioService.instance().start(this);
            initData();
            initView();
        }

        private void initData() {
            dbHelper=new DBHelper(this,"UserStore.db",null,1);
            tx1=(TextView) findViewById(R.id.body1);
        }

        public boolean getMes(String UserId){
            //得到可读的SQLiteDatabase对象
            SQLiteDatabase db = dbHelper.getReadableDatabase();
            //参数1：表名
            //参数2：要想显示的列
            //参数3：where子句
            //参数4：where子句对应的条件值
            //参数5：分组方式
            //参数6：having条件
            //参数7：排序方式
            Cursor cursor = db.query("illRecord", new String[]{"id","date","body"}, "id=?", new String[]{UserId}, null, null, null);

            while(cursor.moveToNext()){
                id = cursor.getString(cursor.getColumnIndex("id"));
                date = cursor.getString(cursor.getColumnIndex("date"));
                body = cursor.getString(cursor.getColumnIndex("body"));
            }

            db.close();
            //db.execSQL("insert into userData (name,password) values (?,?)",new String[]{username,password});
            return true;
        }

        private void initView() {

            getMes(userID);
            tx1.setText(id+"      "+date+"     "+body);

        }
    }









