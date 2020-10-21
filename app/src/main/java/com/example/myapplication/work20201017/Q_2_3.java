package com.example.myapplication.work20201017;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.example.myapplication.R;

public class Q_2_3 extends AppCompatActivity {

    private Button more;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q_2_3);

        more = (Button)findViewById(R.id.more);
    }

    public void popupMenu(View v){
        PopupMenu popupMenu = new PopupMenu(this, v);
        MenuInflater inflater = popupMenu.getMenuInflater();
        //添加点击事件
        popupMenu.setOnMenuItemClickListener((item) -> {
            switch (item.getItemId()){
                case R.id.create:
                    Toast.makeText(getApplicationContext(),"新建",Toast.LENGTH_LONG).show();
                    return true;
                case R.id.copy:
                    Toast.makeText(getApplicationContext(),"复制",Toast.LENGTH_LONG).show();
                    return true;
                case R.id.paste:
                    Toast.makeText(getApplicationContext(),"粘贴",Toast.LENGTH_LONG).show();
                    return true;
                case R.id.delete:
                    Toast.makeText(getApplicationContext(),"删除",Toast.LENGTH_LONG).show();
                    return true;
                default:
                    return false;
            }
        });
        inflater.inflate(R.menu.popupmenu, popupMenu.getMenu());
        popupMenu.show();
    }

    public void click_01(View v){
        Intent intent = new Intent();
        intent.setAction("activity_2_4");
        startActivity(intent);
    }
}