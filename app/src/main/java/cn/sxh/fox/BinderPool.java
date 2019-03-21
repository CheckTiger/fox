package cn.sxh.fox;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import java.util.concurrent.CountDownLatch;

/**
 * @package-name: cn.sxh.fox
 * @auther:snowFox
 * @Email:snowTigersong@gmail.com
 * @time: 2019/1/22 0022 : 17 :22
 * @project-name: fox
 */

public class BinderPool {
    private static final String TAG = "BinderPool";
    public static final int BINDER_NONE = -1;
    public static final int BINDER_COMPUTE = 0;
    public static final int BINDER_SECURITY_CENTER = 1;

    private Context mContext;
    private IBinderPool mBinderPool;
    private static volatile BinderPool sIntance;
    private CountDownLatch mConnectBinderPoolCountDownLatch;

    public BinderPool(Context context) {
        this.mContext = context.getApplicationContext();
        connectBinderPoolService();
    }

    public static BinderPool getsIntance(Context context) {
        if (sIntance == null) {
            synchronized (BinderPool.class) {
                if (sIntance == null) {
                    sIntance = new BinderPool(context);
                }
            }
        }
        return sIntance;
    }

    private synchronized void connectBinderPoolService() {
        mConnectBinderPoolCountDownLatch = new CountDownLatch(1);
        Intent service = new Intent(mContext, BinderPoolService.class);
        mContext.bindService(service, mBinderPoolConnection, Context.BIND_AUTO_CREATE);
        try {
            mConnectBinderPoolCountDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public IBinder queryBinder(int binderCode) {
        IBinder binder = null;
        try {
            if (mBinderPool != null) {
                binder = mBinderPool.queryBinder(binderCode);
                Log.e(TAG, "queryBinder: ");
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return binder;
    }

    private ServiceConnection mBinderPoolConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mBinderPool = IBinderPool.Stub.asInterface(service);
            try {
                mBinderPool.asBinder().linkToDeath(mConnectBinderPoolDeathRecipient,0);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
            mConnectBinderPoolCountDownLatch.countDown();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    private IBinder.DeathRecipient mConnectBinderPoolDeathRecipient = new IBinder.DeathRecipient() {
        @Override
        public void binderDied() {
            Log.w(TAG, "binderDied: ");
            mBinderPool.asBinder().unlinkToDeath(mConnectBinderPoolDeathRecipient, 0);
            mBinderPool = null;
            connectBinderPoolService();
        }
    };

    public static class BinderPoolImpl extends IBinderPool.Stub{

        public BinderPoolImpl(){
            super();
        }
        @Override
        public IBinder queryBinder(int binderCode) throws RemoteException {
            IBinder binder = null;
            switch (binderCode) {
                case BINDER_SECURITY_CENTER:{
                    binder = new SecurityCenterIpml();
                    break;
                }
                case BINDER_COMPUTE:{
                    binder = new ComputeIpml();
                    break;
                }
                default:
                    break;
            }
            return binder;
        }
    }
}
