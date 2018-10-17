package cn.sxh.fox;

import java.io.Serializable;


/**
 * @package-name: cn.sxh.fox
 * @auther:snowFox
 * @Email:snowTigersong@gmail.com
 * @time: 2018/9/30 0030 : 17 :25
 * @project-name: fox
 */

public class User implements Serializable {
    public int userId;
    public String userName;
    public boolean isMale;

    public User(int userId, String userName, boolean isMale) {
        this.userId = userId;
        this.userName = userName;
        this.isMale = isMale;
    }
}
