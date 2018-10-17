package cn.sxh.fox;

/**
 * @package-name: cn.sxh.fox
 * @auther:snowFox
 * @Email:snowTigersong@gmail.com
 * @time: 2018/9/30 0030 : 15 :39
 * @project-name: fox
 */

public interface IsecurityCenter {
    String encrypt(String content);
    String decrypt(String password);
}
