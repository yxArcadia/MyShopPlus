package cn.yxvk.myshop.plus.business;

import cn.yxvk.myshop.plus.commons.utils.MapperUtils;
import cn.yxvk.myshop.plus.commons.utils.OkHttpClientUtil;
import okhttp3.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yangxiang
 * @date 2019/11/19 9:33
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class OkHttp3Test {

    @Test
    public void testGet(){
        String url="http://www.baidu.com";
        OkHttpClient client=new OkHttpClient();
        Request request=new Request.Builder().url(url).build();
        Call call=client.newCall(request);
        try {
            Response response = call.execute();
            System.out.println(response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testPost(){
        String url="http://localhost:9001/oauth/token";
        OkHttpClient client=new OkHttpClient();
        RequestBody body=new FormBody.Builder()
                .add("username","admin")
                .add("password","123456")
                .add("grant_type","password")
                .add("client_id","client")
                .add("client_secret","secret").build();
        Request request=new Request.Builder().url(url).post(body).build();
        Call call=client.newCall(request);
        try {
            Response response = call.execute();
            System.out.println(response.body().string() );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testUtilPost(){
        OkHttpClientUtil instance = OkHttpClientUtil.getInstance();
        String url="http://localhost:9001/oauth/token";
        Map<String,String> param=new HashMap<>();
        param.put("username","admin");
        param.put("password","123456");
        param.put("grant_type","password");
        param.put("client_id","client");
        param.put("client_secret","secret");
        Response response = instance.postData(url, param);
        try {
            String json= response.body().string();
            Map<String, Object> map = MapperUtils.json2map(json);
            String token=map.get("access_token").toString();
            System.out.println(token);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
