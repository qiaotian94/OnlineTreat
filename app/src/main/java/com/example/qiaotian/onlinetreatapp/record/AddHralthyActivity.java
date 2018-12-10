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
import com.example.qiaotian.onlinetreatapp.sql.DBHelper;

import pl.com.salsoft.sqlitestudioremote.SQLiteStudioService;

import static com.example.qiaotian.onlinetreatapp.login.LoginActivity.userID;

public class AddHralthyActivity extends AppCompatActivity {
    private DBHelper dbHeldper;
    private EditText edit1,edit2, edit3,edit4,edit5;
    private Button helBtn;
    private String id,view1, view2,view3,view4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_hralthy);

           initData();
            initView();
            SQLiteStudioService.instance().start(this);
        }

        private void initData() {
            dbHeldper = new DBHelper(this, "UserStore.db", null, 1);
            edit1 = (EditText) findViewById(R.id.idedit1);
            edit2 = (EditText) findViewById(R.id.heledit1);
            edit3 = (EditText) findViewById(R.id.heledit2);
            edit4 = (EditText) findViewById(R.id.heledit3);
            edit5 = (EditText) findViewById(R.id.heledit4);
           helBtn = (Button) findViewById(R.id.helbtn);
        }

        private void initView() {
            helBtn.setOnClickListener(new View.OnClickListener() {
                @Override

                public void onClick(View view) {
                    id = edit1.getText().toString();
                    view1 = edit2.getText().toString();
                    view2 = edit3.getText().toString();
                    view3 = edit4.getText().toString();
                    view4 = edit5.getText().toString();
                    if (CheckIsDataAlreadyInDBOrNot(userID)) {
                        if (addill(id,view1,view2,view3,view4)) {
                            Toast.makeText(AddHralthyActivity.this, "已添加！", Toast.LENGTH_SHORT).show();

                        }
                    } else {
                        Toast.makeText(AddHralthyActivity.this, "用户不存在", Toast.LENGTH_SHORT).show();
                    }
                }

            });
        }

        public boolean addill(String id, String View1,String View2,String View3,String View4) {
            SQLiteDatabase db = dbHeldper.getWritableDatabase();
          // sql="insert into userData(name,password) value(?,?)"
             //    Object obj[]={username,password};
         // db.execSQL(sql,obj);
            ContentValues values = new ContentValues();
            values.put("id", id);
            values.put("view1", View1);
            values.put("view2", View2);
            values.put("view3", View3);
            values.put("view4", View4);
            db.insert("healthy", null, values);
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

