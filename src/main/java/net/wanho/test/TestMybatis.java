package net.wanho.test;

import net.wanho.mapper.UserMapper;
import net.wanho.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import util.MybatisUtil;

import java.io.InputStream;
import java.util.List;

/**
 * Created by Administrator on 2019/6/5.
 */
public class TestMybatis {
    private  SqlSession sqlSession;
    private UserMapper userMapper;
    @Before
    public void Before(){
       /* InputStream inputStream = TestMybatis.class.getClassLoader().getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(inputStream);
        //创建会话
         sqlSession = sf.openSession();*/
        sqlSession=MybatisUtil.getsession();
         userMapper = sqlSession.getMapper(UserMapper.class);
    }

    @Test
    public  void addUser(){
        User user=new User(null,"lx","123456","1",1);
       /* sqlSession.update("net.wanho.mapper.UserMapper.addUser",user);
        sqlSession.commit();
        sqlSession.close();*/
        SqlSession session = MybatisUtil.getsession();
        sqlSession.update("net.wanho.mapper.UserMapper.addUser",user);
        sqlSession.commit();
        MybatisUtil.closeSession();
    }
    @Test
    public  void selectUserById(){

        SqlSession session = MybatisUtil.getsession();
        User user = session.selectOne("net.wanho.mapper.UserMapper.selectOneById",4);
        System.out.println(user);
        MybatisUtil.closeSession();
    }

    @Test
    public  void selectAllUser(){

       /* SqlSession session = MybatisUtil.getsession();
        List<User> users = session.selectList("net.wanho.mapper.UserMapper.selectAllUser");
        System.out.println(users);
        MybatisUtil.closeSession();*/
        List<User> users = userMapper.selectAllUser();
        System.out.println(users);
        MybatisUtil.closeSession();
    }

    @Test
    public  void selectByUsername(){

        SqlSession session = MybatisUtil.getsession();
        User user=new User();
        user.setUsername("张");
        List<User> users = session.selectList("net.wanho.mapper.UserMapper.selectByUsername", user);
        System.out.println(users);
        MybatisUtil.closeSession();
    }
    @Test
    public  void addUser1(){
        User user=new User(null,"thy","123456","1",1);

       /* SqlSession session = MybatisUtil.getsession();
        session.update("net.wanho.mapper.UserMapper.addUser1",user);*/
        //sqlSession.update("net.wanho.mapper.UserMapper.addUser1",user);
        userMapper.addUser1(user);
        sqlSession.commit();
        System.out.println(user.getId());
        MybatisUtil.closeSession();
    }

    @Test
    public  void addUser2(){
        User user=new User(null,"xiazaogou","123456","1",1);

       /* SqlSession session = MybatisUtil.getsession();
        session.update("net.wanho.mapper.UserMapper.addUser1",user);*/
        //sqlSession.update("net.wanho.mapper.UserMapper.addUser1",user);
        userMapper.addUser2(user);
        sqlSession.commit();
        System.out.println(user.getId());
        MybatisUtil.closeSession();
    }

    @Test
    public  void  updateUser(){

        userMapper.updateUser("xizaohou","12346","1",1,21);
        sqlSession.commit();
        MybatisUtil.closeSession();
    }

    @Test
    public  void  updateUser1(){
       User user=new User(16,"uzii","57859","1",1);
        userMapper.updateUser1(user,16);
        sqlSession.commit();
        MybatisUtil.closeSession();
    }
}
