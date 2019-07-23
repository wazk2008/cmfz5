package com.baizhi;

import com.baizhi.dao.AdminDao;
import com.baizhi.dao.UserDao;
import com.baizhi.entity.Admin;
import com.baizhi.entity.UserCityAccount;
import org.apache.ibatis.session.RowBounds;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tk.mybatis.mapper.entity.Example;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Cmfz5ApplicationTests {

    @Autowired
    private AdminDao adminDao;

    @Test
    public void test1(){
        List<Admin> admins = adminDao.selectAll();
        for (Admin admin : admins) {
            System.out.println(admin);
        }
    }

    @Test
    public void test2(){
        Admin admin = adminDao.selectByPrimaryKey("1");
        System.out.println(admin);
    }

    @Test
    public void test3(){
        Admin admin = new Admin();
//        admin.setUsername("admin");
        admin.setPassword("111111");
        int i = adminDao.selectCount(admin);
        System.out.println(i);
    }

    @Test
    public void test4(){
        Example example = new Example(Admin.class);
        example.createCriteria().andEqualTo("username","admin");
        List<Admin> admins = adminDao.selectByExample(example);
        for (Admin admin : admins) {
            System.out.println(admin);
        }
    }

    @Test
    public void test5(){
        Example example = new Example(Admin.class);
        example.createCriteria().andIsNull("username").andLike("nickname","小%");
        List<Admin> admins = adminDao.selectByExample(example);
        System.out.println(admins.size());
        for (Admin admin : admins) {
            System.out.println(admin);
        }
    }

    @Test
    public void test6(){
        int page = 1;
        int pageSize = 3;

        Admin admin = new Admin();
        admin.setUsername("admin");
        //offset:起始下标   limit:查询几条
        RowBounds rowBounds = new RowBounds((page-1)*pageSize,pageSize);
        List<Admin> admins = adminDao.selectByRowBounds(admin, rowBounds);
        for (Admin admin1 : admins) {
            System.out.println(admin1);
        }
    }

    @Test
    public void test7(){
        Admin admin = new Admin();
        admin.setId("11");
        admin.setUsername("qwe");
        admin.setPassword("ewq");
        int i = adminDao.insert(admin);
        System.out.println(i);
    }

    @Test
    public void test8(){
        Admin admin = new Admin();
        admin.setId("13");
        admin.setUsername("qwe");
        admin.setPassword("ewq");
        int i = adminDao.insertSelective(admin);
        System.out.println(i);
    }

    @Test
    public void test9(){
        Admin admin = new Admin();
        admin.setId("2");
        admin.setUsername("aaaa");
        admin.setPassword("bbbb");
        admin.setNickname(null);
        adminDao.updateByPrimaryKey(admin);
    }

    @Test
    public void test10(){
        Admin admin = new Admin();
        admin.setId("3");
        admin.setUsername("aaaa");
        admin.setPassword("bbbb");
        adminDao.updateByPrimaryKeySelective(admin);
    }

    @Test
    public void test11(){
        Admin admin = new Admin();
        int delete = adminDao.delete(admin);
        System.out.println(delete);
    }

    @Test
    public void test12(){
        Example example = new Example(Admin.class);
        example.createCriteria().andIsNull("nickname");
        int i = adminDao.deleteByExample(example);
        System.out.println(i);
    }

    @Autowired
    private UserDao userDao;

    @Test
    public void test13(){
        List<UserCityAccount> list = userDao.selectUserByCity("男");
        for (UserCityAccount userCityAccount : list) {
            System.out.println(userCityAccount);
        }

    }




}
