package com.example.sam.helloword;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends BaseActivity {
    MyDB myDB;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Intent inten=getIntent();
        Bundle User=inten.getBundleExtra("user");
        if(User!=null) {
            String name = User.getString("name");
            EditText nname = (EditText) findViewById(R.id.username);
            nname.setText(name);
        }
        Buttonn buttonn=new Buttonn();
        Button but_zhuce=(Button)findViewById(R.id.zhuce);
          but_zhuce.setOnClickListener(buttonn);
//          but_zhuce.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent=new Intent(LoginActivity.this,zhuceActivity.class);
//                startActivity(intent);
//            }
//        });
          Button but_login=(Button)findViewById(R.id.login);
          but_login.setOnClickListener(buttonn);
//        but_login.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent inten=getIntent();
//                Bundle User=inten.getBundleExtra("user");
//                if(User!=null){
//                    String name=User.getString("name");
//                    String password=User.getString("password");
//                    EditText nname=(EditText)findViewById(R.id.username);
//                    String name2=nname.getText().toString();
//                    EditText pwd=(EditText)findViewById(R.id.pwd);
//                    String password2=pwd.getText().toString();
//                    if(name.equals(name2)&&password.equals(password2)){
//                        Intent intent=new Intent(LoginActivity.this,WecomeActivity.class);
//                        startActivity(intent);
//                    }
//                    else
//                        Toast.makeText(LoginActivity.this,"用户名或密码不正确",Toast.LENGTH_LONG).show();
//
//                }
//                else
//                    Toast.makeText(LoginActivity.this,"请先注册",Toast.LENGTH_LONG).show();
//            }
//        });
    }
    //第二种Butten监听方法
    class Buttonn implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.login:
                    EditText name=(EditText)findViewById(R.id.username);
                    String username=name.getText().toString();
                    EditText pwd=(EditText)findViewById(R.id.pwd);
                    String password=pwd.getText().toString();
                    MyDB myDB=new MyDB(LoginActivity.this,"mydb.db",null,1);
                    db=myDB.getWritableDatabase();
                    String seleteall="select * from users";
                    Cursor cursor=db.rawQuery(seleteall,null);
                    if(cursor.moveToFirst()){
                        do{
                            String namedb=cursor.getString(cursor.getColumnIndex("username"));
                            String passworddb=cursor.getString(cursor.getColumnIndex("password"));
//                    Intent inten=getIntent();
//                    Bundle User=inten.getBundleExtra("user");
//                    String namedb=User.getString("name");
//                    String passworddb=User.getString("password");
                            if(namedb.equals(username)&&passworddb.equals(password)){
                                Intent intent=new Intent(LoginActivity.this,WecomeActivity.class);
                                startActivity(intent);
                            }
                            else
                                Toast.makeText(LoginActivity.this,"用户名或密码不正确",Toast.LENGTH_LONG).show();
                            cursor.close();
                        }while (cursor.moveToNext());
                    }
                    else
                        Toast.makeText(LoginActivity.this,"用户名,密码不正确",Toast.LENGTH_LONG).show();

                    break;
                case R.id.zhuce:
                    Intent intent=new Intent(LoginActivity.this,zhuceActivity.class);
                    startActivity(intent);
                    break;
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(Menu.NONE,1,1,"退出");
        menu.add(Menu.NONE,2,2,"帮助");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            //case R.id.exit_item:
            case 1:
                finish();
                break;
            //case R.id.help_item:
            case 2:
                Toast.makeText(this,"如果您未注册，请点击注册按钮前往注册界面",Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }
}
