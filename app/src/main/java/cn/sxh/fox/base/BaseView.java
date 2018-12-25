package cn.sxh.fox.base;


/**
 * @package-name: cn.sxh.fox.base
 * @auther:snowFox
 * @Email:snowTigersong@gmail.com
 * @time: 2018/12/13 0013 : 15 :38
 * @project-name: fox
 */

public interface BaseView {

    void showLoadProgress();

    void closeLoadProgress();

    void printfErrorMessage(String message);
}
