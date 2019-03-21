package cn.sxh.fox;

import android.os.RemoteException;

/**
 * @package-name: cn.sxh.fox.aidl
 * @auther:snowFox
 * @Email:snowTigersong@gmail.com
 * @time: 2019/1/16 0016 : 16 :24
 * @project-name: fox
 */

public class SecurityCenterIpml extends ISecurityCenter.Stub {

    private static final char SECRET_COCE = '^';
    @Override
    public String encrypt(String content) throws RemoteException{
        char[] chars = content.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            chars[i] ^= SECRET_COCE;
        }
        return new String(chars);
    }

    @Override
    public String decrypt(String password) throws RemoteException{
        return encrypt(password);
    }
}
