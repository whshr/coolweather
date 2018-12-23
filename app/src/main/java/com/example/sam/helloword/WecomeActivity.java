package com.example.sam.helloword;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.NavigationView;
import android.support.v4.content.FileProvider;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TabHost;
import android.widget.Toolbar;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.NavigableMap;

public class WecomeActivity extends BaseActivity implements View.OnClickListener {
    private TabHost tabHost;
    private RadioGroup radioGroup;
    private int menuid;
    private DrawerLayout mDrawerLayout;
    private String[] data={"10岁以下","10至14岁","15至19岁","20至24岁",
            "25至29岁","30岁至34岁","35岁至39岁","40岁至44","45岁至49岁",
            "50岁至54岁","55岁以上","春天","夏天","秋天","冬天",
            "天气适合出去","天气不适合出去"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wecome);

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(
                WecomeActivity.this,android.R.layout.simple_list_item_1,data);
        final ListView listView=(ListView)findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    AlertDialog.Builder dialog=new AlertDialog.Builder(WecomeActivity.this);
                    dialog.setTitle("推荐运动");
                    dialog.setMessage("");
                    dialog.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });
                    dialog.show();
                }
                else if(position==1){
                    AlertDialog.Builder dialog=new AlertDialog.Builder(WecomeActivity.this);
                    dialog.setTitle("推荐运动");
                    dialog.setMessage("");
                    dialog.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });
                    dialog.show();
                }
                else if(position==2){
                    AlertDialog.Builder dialog=new AlertDialog.Builder(WecomeActivity.this);
                    dialog.setTitle("推荐运动");
                    dialog.setMessage("");
                    dialog.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });
                    dialog.show();
                }
                else if(position==3){
                    AlertDialog.Builder dialog=new AlertDialog.Builder(WecomeActivity.this);
                    dialog.setTitle("推荐运动");
                    dialog.setMessage("");
                    dialog.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });
                    dialog.show();
                }
                else if(position==4){
                    AlertDialog.Builder dialog=new AlertDialog.Builder(WecomeActivity.this);
                    dialog.setTitle("推荐运动");
                    dialog.setMessage("");
                    dialog.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });
                    dialog.show();
                }
                else if(position==5){
                    AlertDialog.Builder dialog=new AlertDialog.Builder(WecomeActivity.this);
                    dialog.setTitle("推荐运动");
                    dialog.setMessage("");
                    dialog.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });
                    dialog.show();
                }
                else if(position==6){
                    AlertDialog.Builder dialog=new AlertDialog.Builder(WecomeActivity.this);
                    dialog.setTitle("推荐运动");
                    dialog.setMessage("");
                    dialog.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });
                    dialog.show();
                }
                else if(position==7){
                    AlertDialog.Builder dialog=new AlertDialog.Builder(WecomeActivity.this);
                    dialog.setTitle("推荐运动");
                    dialog.setMessage("");
                    dialog.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });
                    dialog.show();
                }
                else if(position==8){
                    AlertDialog.Builder dialog=new AlertDialog.Builder(WecomeActivity.this);
                    dialog.setTitle("推荐运动");
                    dialog.setMessage("");
                    dialog.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });
                    dialog.show();
                }
                else if(position==9){
                    AlertDialog.Builder dialog=new AlertDialog.Builder(WecomeActivity.this);
                    dialog.setTitle("推荐运动");
                    dialog.setMessage("");
                    dialog.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });
                    dialog.show();
                }
                else if(position==10){
                    AlertDialog.Builder dialog=new AlertDialog.Builder(WecomeActivity.this);
                    dialog.setTitle("推荐运动");
                    dialog.setMessage("");
                    dialog.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });
                    dialog.show();
                }
                else if(position==11){
                    AlertDialog.Builder dialog=new AlertDialog.Builder(WecomeActivity.this);
                    dialog.setTitle("推荐运动");
                    dialog.setMessage("");
                    dialog.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });
                    dialog.show();
                }
                else if(position==12){
                    AlertDialog.Builder dialog=new AlertDialog.Builder(WecomeActivity.this);
                    dialog.setTitle("推荐运动");
                    dialog.setMessage("");
                    dialog.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });
                    dialog.show();
                }
                else if(position==13){
                    AlertDialog.Builder dialog=new AlertDialog.Builder(WecomeActivity.this);
                    dialog.setTitle("推荐运动");
                    dialog.setMessage("");
                    dialog.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });
                    dialog.show();
                }
                else if(position==14){
                    AlertDialog.Builder dialog=new AlertDialog.Builder(WecomeActivity.this);
                    dialog.setTitle("推荐运动");
                    dialog.setMessage("");
                    dialog.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });
                    dialog.show();
                }
                else if(position==15){
                    AlertDialog.Builder dialog=new AlertDialog.Builder(WecomeActivity.this);
                    dialog.setTitle("推荐运动");
                    dialog.setMessage("");
                    dialog.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });
                    dialog.show();
                }
                else if(position==16){
                    AlertDialog.Builder dialog=new AlertDialog.Builder(WecomeActivity.this);
                    dialog.setTitle("推荐运动");
                    dialog.setMessage("");
                    dialog.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });
                    dialog.show();
                }
            }
        });

        Button but_cai1=(Button)findViewById(R.id.cai1);
        but_cai1.setOnClickListener(this);
        Button but_cai2=(Button)findViewById(R.id.cai2);
        but_cai2.setOnClickListener(this);
        Button but_cai3=(Button)findViewById(R.id.cai3);
        but_cai3.setOnClickListener(this);

        NavigationView navView1=(NavigationView)findViewById(R.id.nav_view1);
        navView1.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.nav_call:
                        AlertDialog.Builder dialog11 = new AlertDialog.Builder(WecomeActivity.this);
                        dialog11.setTitle("个人信息");
                        dialog11.setMessage("");
                        dialog11.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        }
                        });
                        dialog11.show();
                        break;
                    case R.id.nav_friends:

                        break;
                    case R.id.nav_location:
                        AlertDialog.Builder dialog12 = new AlertDialog.Builder(WecomeActivity.this);
                        dialog12.setTitle("关于我们");
                        dialog12.setMessage("本APP可以，，，，，，");
                        dialog12.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        });
                        dialog12.show();
                        break;
                    case  R.id.nav_mail:
                        finish();
                        break;
                }
                return true;
            };
        });
        NavigationView navView2=(NavigationView)findViewById(R.id.nav_view2);
        navView2.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.nav_call:
                        AlertDialog.Builder dialog21 = new AlertDialog.Builder(WecomeActivity.this);
                        dialog21.setTitle("个人信息");
                        dialog21.setMessage("");
                        dialog21.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        });
                        dialog21.show();
                        break;
                    case R.id.nav_friends:

                        break;
                    case R.id.nav_location:
                        AlertDialog.Builder dialog22 = new AlertDialog.Builder(WecomeActivity.this);
                        dialog22.setTitle("关于我们");
                        dialog22.setMessage("本APP可以，，，，，，");
                        dialog22.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        });
                        dialog22.show();
                        break;
                    case  R.id.nav_mail:
                        finish();
                        break;
                }
                return true;
            };
        });
        NavigationView navView3=(NavigationView)findViewById(R.id.nav_view3);
        navView3.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.nav_call:
                        AlertDialog.Builder dialog31 = new AlertDialog.Builder(WecomeActivity.this);
                        dialog31.setTitle("个人信息");
                        dialog31.setMessage("");
                        dialog31.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        });
                        dialog31.show();
                        break;
                    case R.id.nav_friends:

                        break;
                    case R.id.nav_location:
                        AlertDialog.Builder dialog32 = new AlertDialog.Builder(WecomeActivity.this);
                        dialog32.setTitle("关于我们");
                        dialog32.setMessage("本APP可以，，，，，，");
                        dialog32.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        });
                        dialog32.show();
                        break;
                    case  R.id.nav_mail:
                        finish();
                        break;
                }
                return true;
            };
        });

        radioGroup=(RadioGroup)findViewById(R.id.radiogroup);
        tabHost=(TabHost)findViewById(android.R.id.tabhost);
        tabHost.setup();

        tabHost.addTab(tabHost.newTabSpec("g1").setIndicator("g1").setContent(R.id.fragment_g1));
        tabHost.addTab(tabHost.newTabSpec("g2").setIndicator("g2").setContent(R.id.fragment_g2));
        tabHost.addTab(tabHost.newTabSpec("g3").setIndicator("g3").setContent(R.id.fragment_g3));

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
//                menuid=checkedId;
                switch (checkedId){
                    case R.id.radio_g1:
                        tabHost.setCurrentTabByTag("g1");
                        break;
                    case R.id.radio_g2:
                        tabHost.setCurrentTabByTag("g2");
                        break;
                    case R.id.radio_g3:
                        tabHost.setCurrentTabByTag("g3");
                        break;
                }
                getWindow().invalidatePanelMenu(Window.FEATURE_OPTIONS_PANEL);
            }
        });
    }
    public void onClick(View v){
        switch (v.getId()){
            case R.id.cai1:
                Intent intent1=new Intent(WecomeActivity.this,LoginActivity.class);
                startActivity(intent1);
                break;
            case R.id.cai2:
                Intent intent2=new Intent(WecomeActivity.this,LoginActivity.class);
                startActivity(intent2);
                break;
            case R.id.cai3:
                Intent intent3=new Intent(WecomeActivity.this,LoginActivity.class);
                startActivity(intent3);
                break;
            default:
                break;
        }
    }
}
