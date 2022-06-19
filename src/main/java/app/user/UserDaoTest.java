package app.user;

import app.user.dao.DaoFactory;
import app.user.dao.UserDao;
import app.user.domain.UserVO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

public class UserDaoTest {
    public static void main(String[] args) throws SQLException {

        ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);

        UserDao dao = context.getBean("userDao", UserDao.class);

        UserVO user = new UserVO();

        user.setId("testID1");
        user.setName("테스트1");
        user.setPassword("testPWD1");
        dao.add(user);

        UserVO user2 = dao.get("testID1");
        System.out.println("ID : " + user2.getId());
        System.out.println("NAME : " + user2.getName());
        System.out.println("PASSWORD : " + user2.getPassword());
    }
}
