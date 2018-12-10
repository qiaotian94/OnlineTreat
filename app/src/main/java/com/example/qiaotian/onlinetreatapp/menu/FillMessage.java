package com.example.qiaotian.onlinetreatapp.menu;

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

public class FillMessage extends AppCompatActivity {

    private DBHelper dbHeldper;
    private EditText edit1,edit2,edit3,edit4,edit5;
    private Button mesBtn;
    public static String name,id,sex,age,email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill_message);
        SQLiteStudioService.instance().start(this);
        initData();
        initView();
    }

    private void initData() {
        dbHeldper=new DBHelper(this,"UserStore.db",null,1);
        edit1=(EditText) findViewById(R.id.mesedt1);
        edit2=(EditText) findViewById(R.id.mesedt2);
        edit3=(EditText) findViewById(R.id.mesedt3);
        edit4=(EditText) findViewById(R.id.mesedt4);
        edit5=(EditText) findViewById(R.id.mesedt5);
        mesBtn=(Button)findViewById(R.id.mesbtn);
    }

    private void initView() {
        mesBtn.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                id=edit1.getText().toString();
                name=edit2.getText().toString();
                sex=edit3.getText().toString();
                age=edit4.getText().toString();
                email=edit5.getText().toString();

                    if(fillMessage(id,name,sex,age,email)){
                        Toast.makeText(FillMessage.this,"完善信息成功！",Toast.LENGTH_SHORT).show();

                    }
                    else{
                        Toast.makeText(FillMessage.this,"完善信息失败！",Toast.LENGTH_SHORT).show();

                    }


            }
        });
    }

    public  boolean fillMessage(String userId,String userName,String sex,String age,String email){
        SQLiteDatabase db=dbHeldper.getWritableDatabase();
          /* sql="insert into userData(name,password) value(?,?)"
                 Object obj[]={username,password};
          db.execSQL(sql,obj);*/
        ContentValues values=new ContentValues();
        values.put("id",userId);
        values.put("name",userName);
        values.put("sex",sex);
        values.put("age",age);
        values.put("email",email);
        db.insert("userMes",null,values);
        db.close();
        //db.execSQL("insert into userData (name,password) values (?,?)",new String[]{username,password});
        return true;
    }


}

