package cn.sxh.fox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        android.util.Log.e("sxh", "SecondActivity------------->" + USerManager.sUserId);
        init();
    }

    private void init() {
        User user = new User(0, "jake", true);
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("cache.text"));
            out.writeObject(user);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("cache.text"));
            User newUser = (User) inputStream.readObject();
            android.util.Log.e("sxh", "newUser------------->" + newUser.userName);
            android.util.Log.e("sxh", "newUser------------->" + newUser.isMale);
            android.util.Log.e("sxh", "newUser------------->" + newUser.userId);
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
