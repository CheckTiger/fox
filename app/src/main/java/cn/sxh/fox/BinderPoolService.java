package cn.sxh.fox;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * @package-name: cn.sxh.fox
 * @auther:snowFox
 * @Email:snowTigersong@gmail.com
 * @time: 2019/1/18 0018 : 10 :37
 * @project-name: fox
 */

public class BinderPoolService extends Service{

    private static final String TAG = BinderPoolService.class.getSimpleName();
    private Binder mBinderPool = new BinderPool.BinderPoolImpl();

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.e(TAG, "onBind: BinderPoolService");
        return mBinderPool;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
