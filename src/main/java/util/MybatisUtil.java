package util;

import net.wanho.test.TestMybatis;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * Created by Administrator on 2019/6/5.
 */
public class MybatisUtil {
    private static ThreadLocal<SqlSession> threadLocal;
    private static  SqlSessionFactory sf;
    static {

        threadLocal=new ThreadLocal<SqlSession>();
        InputStream inputStream = MybatisUtil.class.getClassLoader().getResourceAsStream("mybatis-config.xml");
         sf=new SqlSessionFactoryBuilder().build(inputStream);

    }
    /*获取连接*/
public static SqlSession getsession(){
    SqlSession session=threadLocal.get();
    //session不存在
    if(session==null){
        /*开启新的session,同时存在本地线程*/
        session=sf.openSession();
        threadLocal.set(session);
    }
    return session;
}

public static  void closeSession(){
    SqlSession session=threadLocal.get();
    if (session!=null){
        session.close();
        threadLocal.remove();
    }
}

}
