package com.example.sam.helloword;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.SharedMemory;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.support.v7.view.menu.ShowableListMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class zhuceActivity extends BaseActivity {
    public static final int TAKE_PHOTO=1;
    private ImageView picture;
    private Uri imageUri;
    MyDB myDB;
    SQLiteDatabase db;
    String sex=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhuce);
        //创建数据库
        MyDB myDB=new MyDB(zhuceActivity.this,"mydb.db",null,1);
        //创建数据表
        db=myDB.getWritableDatabase();//以写的方式打开数据库

        Button takePhoto=(Button)findViewById(R.id.photos);
        picture=(ImageView)findViewById(R.id.picture);
        takePhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File outputImage=new File(getExternalCacheDir(),"output_image.jpg");
                try{
                    if(outputImage.exists()){
                        outputImage.delete();
                    }
                    outputImage.createNewFile();
                } catch (IOException e){
                    e.printStackTrace();
                }
                if(Build.VERSION.SDK_INT>=24){
                    imageUri= FileProvider.getUriForFile(zhuceActivity.this,"com.example",outputImage);
                }else{
                    imageUri=Uri.fromFile(outputImage);
                }
                //Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                intent.putExtra(MediaStore.EXTRA_OUTPUT,imageUri);
                startActivityForResult(intent,TAKE_PHOTO);
            }
        });
        //性别控件
        final RadioButton rb_male=(RadioButton)findViewById(R.id.rb_male);
        final RadioButton rb_female=(RadioButton)findViewById(R.id.rb_female);
        RadioGroup rg_sex=(RadioGroup)findViewById(R.id.rg_sex);
        rg_sex.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(rb_male.isChecked()){
                    sex=rb_male.getText().toString();
                }else if(rb_female.isChecked()){
                    sex=rb_female.getText().toString();
                }
                Toast.makeText(zhuceActivity.this,sex,Toast.LENGTH_SHORT).show();
            }
        });

        Button return_login=(Button)findViewById(R.id.return_login);
        return_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialog=new AlertDialog.Builder(zhuceActivity.this);
                dialog.setTitle("提示信息");
                dialog.setMessage("请确认注册信息");
                dialog.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        EditText nname=(EditText)findViewById(R.id.username);
                        String name=nname.getText().toString();
                        EditText pwd=(EditText)findViewById(R.id.pwd);
                        String password=pwd.getText().toString();
                        EditText pwd2=(EditText)findViewById(R.id.pwd2);
                        String password2=pwd2.getText().toString();
                        if(name.length()!=0&&password.length()!=0&&password2.length()!=0&&password.equals(password2)){
                            //想users表中添加数据
                            ContentValues values=new ContentValues();
                            values.put("username",name);
                            values.put("password",password);
                            values.put("sex",sex);
                            //参数1：表名，2：默认值为null，3：插入的一行数据
                            db.insert("users",null,values);

                            Intent intent=new Intent(zhuceActivity.this,LoginActivity.class);
                            Bundle User=new Bundle();
                            User.putString("name",name);
                            User.putString("password",password);
                            intent.putExtra("user",User);
                            startActivity(intent);
                        }
                        else
                            Toast.makeText(zhuceActivity.this,"请检查输入是否正确",Toast.LENGTH_SHORT).show();
                    }
                });
                dialog.show();

            }
        });


        Button return_fanhui=(Button)findViewById(R.id.fanhui);
        return_fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(zhuceActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });


        //下拉列表框
        Spinner sp_city=(Spinner)findViewById(R.id.sp_city);
        //为列表框添加数据
        final String [] citys={"北京","重庆","天津","上海","四川","广州","深圳"};
        //数组适配器:参数1：上下文，参数2：显示内容的格式（布局）,参数3：显示内容数据
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,citys);
        sp_city.setAdapter(adapter);

        //为控件添加监听
        sp_city.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                //参数3：选中项所在的位置，参数4：选中项所在的行
                //ShowMessage(citys[i]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode){
            case TAKE_PHOTO:
                if(resultCode==RESULT_OK) {
                    try {
                        Bitmap bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(imageUri));
                        picture.setImageBitmap(bitmap);
                    }catch (FileNotFoundException e){
                        e.printStackTrace();
                    }
                }
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(Menu.NONE,1,1,"帮助");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case 1:
                Toast.makeText(this,"输入完毕，请点击下方确认按钮返回登录界面",Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }

}
