package cn.sxh.fox.aidl;

import android.os.IBinder;

/**
 * @package-name: cn.sxh.fox.aidl
 * @auther:snowFox
 * @Email:snowTigersong@gmail.com
 * @time: 2019/1/16 0016 : 16 :29
 * @project-name: fox
 */

public class ComputeIpml implements ICompute {
    @Override
    public int add(int a, int b) {
        return 0;
    }

    @Override
    public IBinder asBinder() {
        return null;
    }
}
