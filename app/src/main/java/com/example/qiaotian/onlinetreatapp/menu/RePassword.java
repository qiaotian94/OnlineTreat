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
import com.example.qiaotian.onlinetreatapp.sql.DBHelper;

import pl.com.salsoft.sqlitestudioremote.SQLiteStudioService;

public class RePassword extends AppCompatActivity {

    private DBHelper dbHeldper;
    private EditText edit1,edit2,edit3;
    private Button repasBtn;
    private String id,password,newpassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_re_password);
        SQLiteStudioService.instance().start(this);
           initData();
          initView();
}

private void initData() {
        dbHeldper=new DBHelper(this,"UserStore.db",null,1);
        edit1=(EditText) findViewById(R.id.repasedt1);
        edit2=(EditText) findViewById(R.id.repasedt2);
        edit3=(EditText) findViewById(R.id.repasedt3);
        repasBtn=(Button)findViewById(R.id.repasbtn);
        }

private void initView() {
        repasBtn.setOnClickListener(new View.OnClickListener() {
@Override

public void onClick(View view) {
        id=edit1.getText().toString();
        password=edit2.getText().toString();
        newpassword=edit3.getText().toString();
        if(isUser(id,password)){

        if(repassword(id,newpassword)){
        Toast.makeText(RePassword.this,"修改密码成功！",Toast.LENGTH_SHORT).show();

        }
        else{
        Toast.makeText(RePassword.this,"修改密码失败！",Toast.LENGTH_SHORT).show();

        }
        }
        else{
        Toast.makeText(RePassword.this,"用户或密码输入错误！",Toast.LENGTH_SHORT).show();
        }


        }
        });
        }

public  boolean repassword(String id,String newpassword){
        SQLiteDatabase db=dbHeldper.getWritableDatabase();
          /* sql="insert into userData(name,password) value(?,?)"
                 Object obj[]={username,password};
          db.execSQL(sql,obj);*/
        ContentValues values=new ContentValues();
        values.put("password",newpassword);
        db.update("userData",values,"id=?",new String[]{id});
        db.close();
        //db.execSQL("insert into userData (name,password) values (?,?)",new String[]{username,password});
        return true;
        }
//检验用户名是否存在
public boolean isUser(String id,String password) {
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


