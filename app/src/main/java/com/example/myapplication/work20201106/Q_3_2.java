package com.example.myapplication.work20201106;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapplication.R;

public class Q_3_2 extends Activity {

    private EditText entryText ;
    private Button button;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q_3_2);
        entryText = (EditText)findViewById(R.id.entry);
        button = (Button)findViewById(R.id.btn);

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent("activity_3_2_1");
                intent.putExtra("message", entryText.getText().toString());
//                sendBroadcast(intent);
                startActivity(intent);
            }
        });
    }
}