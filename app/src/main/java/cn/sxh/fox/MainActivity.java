package cn.sxh.fox;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private ArcPointLoadingView mPointLoadingView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        USerManager.sUserId = 2;
        android.util.Log.e("sxh", "MainActivity------------->" + USerManager.sUserId);
        startActivity(new Intent(this,SecondActivity.class));
    }

    private void initView() {
        mPointLoadingView = findViewById(R.id.arc);
        mPointLoadingView.startAnimation();
    }
}
