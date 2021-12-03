import com.mj.dao.UserMapper;
import com.mj.pojo.User;
import com.mj.utils.MybatisUtils;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import java.util.List;

/**
 * @author : MaJ
 * @date : 2021/11/8
 * @description ：测试类
 */
public class UserDaoTest {
    @Test
    public void getUserList() {
        SqlSession sqlSession = null;
        try {
            // 1. 获得 SqlSession对象
            sqlSession = MybatisUtils.getSqlSession();
            // 2. 执行SQL

            // 方式一，反射，不依赖于字符串字面值，会更安全一点
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            List<User> userList = mapper.getUserList();
            for (User user : userList) {
                System.out.println(user);
            }

            // 方式二，不推荐使用
            List<User> userList1 = sqlSession.selectList("com.mj.dao.UserDaoMapper.getUserList");
            for (User user : userList1) {
                System.out.println(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭 SqlSession
            sqlSession.close();
        }

    }

    @Test
    public void getUserById() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = mapper.getUserById(1);
        System.out.println(user);

        sqlSession.close();
    }

    // 增删改需提交事务
    @Test
    public void insert() {
        // 获取 SqlSession
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        // 反射获取 mapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = new User();
        user.setName("xiao");
        user.setPwd("ming");
        int insertNum = mapper.addUser(user);
        System.out.println(insertNum);

        // 提交事务
        sqlSession.commit();
        // 资源释放
        sqlSession.close();
    }

    // 增删改需提交事务
    @Test
    public void update() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = new User();
        user.setId(2);
        user.setName("xiao");
        user.setPwd("ming");
        int insertNum = mapper.updateUser(user);
        System.out.println(insertNum);

        // 提交事务
        sqlSession.commit();

        sqlSession.close();
    }

    // 增删改需提交事务
    @Test
    public void delete() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        int insertNum = mapper.deleteUser(8);
        System.out.println(insertNum);

        // 提交事务
        sqlSession.commit();

        sqlSession.close();
    }
}
