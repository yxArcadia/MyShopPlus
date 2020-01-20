package cn.yxvk.myshop.plus.business;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author yangxiang
 * @date 2019/11/14 17:39
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class BusinessOAuth2Tests {
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Test
    public void testPasswordEncode(){
        String encode = passwordEncoder.encode("123456");
        System.out.println(encode);
    }
}
