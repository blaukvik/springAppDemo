package com.example.springAppDemo.instrumentering;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

/**
 * Created by bla on 27/04/2018.
 */
@Configuration
@Profile("medhsql")
public class HsqlManager {

    @Autowired
    DataSource dataSource;

    public void getDbManager()
    {
/*
        DatabaseManagerSwing.main(
                new String[] { "--url", "jdbc:hsqldb:mem:testdb", "--user", "sa", "--password", ""}
        );

*/
    }



}
