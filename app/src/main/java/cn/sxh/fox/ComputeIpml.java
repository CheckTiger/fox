package cn.sxh.fox;

import android.os.RemoteException;

/**
 * @package-name: cn.sxh.fox.aidl
 * @auther:snowFox
 * @Email:snowTigersong@gmail.com
 * @time: 2019/1/16 0016 : 16 :29
 * @project-name: fox
 */

public class ComputeIpml extends ICompute.Stub {
    @Override
    public int add(int a, int b)throws RemoteException {
        return a + b;
    }
}
