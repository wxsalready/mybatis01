package net.wanho.mapper;

import net.wanho.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2019/6/5.
 */
public interface UserMapper {
    List<User> selectAllUser();
    User selectOneById();
    void addUser(User user);
    List<User> selectByUsername(User user);
    void addUser1(User user);
    void addUser2(User user);
    void updateUser(String username,String password,String gender,Integer pid,Integer id);
   void  updateUser1(@Param("user") User user,@Param("id") Integer id);


}
