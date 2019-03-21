package cn.sxh.fox.aidl;

import android.os.IBinder;

/**
 * @package-name: cn.sxh.fox.aidl
 * @auther:snowFox
 * @Email:snowTigersong@gmail.com
 * @time: 2019/1/16 0016 : 16 :24
 * @project-name: fox
 */

public class SecurityCenterIpml implements ISecurityCenter {
    @Override
    public String encrypt(String content) {
        return null;
    }

    @Override
    public String decrypt(String password) {
        return null;
    }

    @Override
    public IBinder asBinder() {
        return null;
    }

}
