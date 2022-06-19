package app.user.dao;

import app.connection.ConnectionManager;
import app.user.domain.UserVO;

import java.sql.*;

public class UserDao{

    private ConnectionManager connManager;

    public UserDao(ConnectionManager conn){
        this.connManager = conn;
    }

    public void add(UserVO user) throws SQLException {
        Connection c = connManager.getConnection();
        PreparedStatement ps = c.prepareStatement("insert into users(id, name, password) values(?,?,?)");
        try(c;ps){
            ps.setString(1,user.getId());
            ps.setString(2,user.getName());
            ps.setString(3,user.getPassword());

            ps.executeUpdate();

            //c.commit();
        }catch (SQLException e){
            //c.rollback();
            e.printStackTrace();
        }

    }

    public UserVO get(String id) throws SQLException {
        UserVO user = new UserVO();

        Connection c = connManager.getConnection();
        PreparedStatement ps = c.prepareStatement("select * from users where id = ? ");
        ps.setString(1,id);

        try(c;ps;ResultSet rs = ps.executeQuery()){
            rs.next();

            user.setId(rs.getString("id"));
            user.setName(rs.getString("name"));
            user.setPassword(rs.getString("password"));

        }catch(SQLException e){
            e.printStackTrace();
        }
        return user;

    }

}
