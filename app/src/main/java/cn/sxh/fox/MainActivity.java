package cn.sxh.fox;

import android.content.Context;
import android.content.Intent;
import android.inputmethodservice.Keyboard;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import cn.sxh.fox.view.MainActivityView;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private ArcPointLoadingView mPointLoadingView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mPointLoadingView = findViewById(R.id.arc);
        mPointLoadingView.startAnimation();
    }
}
