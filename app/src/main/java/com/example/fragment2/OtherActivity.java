package com.example.fragment2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class OtherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);
        Button button = (Button)findViewById(R.id.to_MainActivity_YourFragment);
        Button button_back = (Button)findViewById(R.id.back);
        Button button_fm = (Button)findViewById(R.id.to_OtherFragment);
        button.setOnClickListener(new View.OnClickListener() {
            /*从一个Activity跳转到另外一个Activity的Fragment上
            例如我们要从OtherActivity跳转到MainActivity的YourFragment上去：
            首先，我们在OtherActivity中的跳转事件中给MainActivity传递一个名为id的参数：
            然后，我们在MainActivity里接收id值,对值进行判断，如果正确进行跳转操作：
            */
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OtherActivity.this, MainActivity.class);
                intent.putExtra("id",1);
                startActivity(intent);

            }
        });
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        button_fm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frame_container, new OtherFragment(), null)
                        .addToBackStack(null)
                        .commit();
            }
        });
    }
}