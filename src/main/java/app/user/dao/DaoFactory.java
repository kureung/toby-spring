package app.user.dao;

import app.connection.NConnector;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DaoFactory {

    //private final ConnectionManager connectionManager;

    /*public DaoFactory(ConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
    }*/

    @Bean
    public UserDao userDao(){
        return new UserDao(new NConnector());
    }

}
