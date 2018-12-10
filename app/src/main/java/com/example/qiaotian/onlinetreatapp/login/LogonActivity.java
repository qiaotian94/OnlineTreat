package com.example.qiaotian.onlinetreatapp.login;

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
import com.example.qiaotian.onlinetreatapp.sql.DBHelper;

import pl.com.salsoft.sqlitestudioremote.SQLiteStudioService;

public class LogonActivity extends AppCompatActivity {

    private DBHelper dbHeldper;
    private EditText edit1,edit2;
    private Button logonBtn;
    private String id,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logon);
        initData();
        initView();
        SQLiteStudioService.instance().start(this);
    }

    private void initData() {
        dbHeldper=new DBHelper(this,"UserStore.db",null,1);
        edit1=(EditText) findViewById(R.id.et_1);
        edit2=(EditText) findViewById(R.id.et_2);
        logonBtn=(Button)findViewById(R.id.logonbtn);
    }

    private void initView() {
        logonBtn.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                id=edit1.getText().toString();
                password=edit2.getText().toString();

                if(id !=null && password!=null) {
                    if (CheckIsDataAlreadyInDBOrNot(id)) {
                        Toast.makeText(LogonActivity.this, "该用户已被注册", Toast.LENGTH_SHORT).show();
                    } else {
                        if (register(id, password)) {
                            Toast.makeText(LogonActivity.this, "注册用户成功！", Toast.LENGTH_SHORT).show();

                        }
                    }
                }
                else{
                    Toast.makeText(LogonActivity.this, "账号或用户名不能为空！", Toast.LENGTH_SHORT).show();
                    }
            }
        });
    }

    public  boolean register(String id,String password){
        SQLiteDatabase db=dbHeldper.getWritableDatabase();
          /* sql="insert into userData(name,password) value(?,?)"
                 Object obj[]={username,password};
          db.execSQL(sql,obj);*/
        ContentValues values=new ContentValues();
        values.put("id",id);
        values.put("password",password);
        db.insert("userData",null,values);
        db.close();
        //db.execSQL("insert into userData (name,password) values (?,?)",new String[]{username,password});
        return true;
    }
    //检验用户名是否存在
    public boolean CheckIsDataAlreadyInDBOrNot(String value){
        SQLiteDatabase db=dbHeldper.getWritableDatabase();
        String Query = "select * from userData where id=?";
        Cursor cursor=db.rawQuery(Query,new String[]{value});
        if(cursor.getCount()>0){
            cursor.close();
            return true;
        }
        cursor.close();
        return false;
    }

}
