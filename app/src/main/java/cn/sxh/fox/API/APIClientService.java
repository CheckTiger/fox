package cn.sxh.fox.API;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * @package-name: cn.sxh.fox.API
 * @auther:snowFox
 * @Email:snowTigersong@gmail.com
 * @time: 2019/2/26 0026 : 14 :56
 * @project-name: fox
 */

public interface APIClientService {
    @GET("users/{user}/repos")
    Call<Response> listRepos(@Path("user") String user);
}
