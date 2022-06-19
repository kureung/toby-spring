package app;

import app.user.dao.DaoFactory;
import app.user.dao.UserDao;
import app.user.domain.UserVO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Main {
    public static void main(String[] args) throws SQLException {

        UserDao dao = new DaoFactory().userDao();
        UserVO user = new UserVO();

        user.setId("whiteship");
        user.setName("백기선");
        user.setPassword("married");

        dao.add(user);

        System.out.println(user.getId() + " 등록 성공");

        UserVO user2 = dao.get("whiteship");
        System.out.println(user2.getName());

    }
/*
    public static void initDb() throws SQLException {
        String deleteSql = """
            DROP TABLE IF EXISTS users
        """;

        String creatSql = """
                CREATE TABLE IF NOT EXISTS users (

                   id VARCHAR primary key not null,
                   name VARCHAR not null,
                   password VARCHAR not null

                )
                """;

        Connection c = DriverManager.getConnection("jdbc:h2:~/test;MODE=mysql","sa","");
        PreparedStatement ps = c.prepareStatement(deleteSql);
        ps.executeUpdate();
        ps = c.prepareStatement(creatSql);
        ps.executeUpdate();
    }*/
}
