package edu.umd.enpm614.assignment2;

import edu.umd.enpm614.assignment2.application.WebApplication;
import edu.umd.enpm614.assignment2.interfaces.*;
import edu.umd.enpm614.assignment2.services.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.inject.Inject;

import static edu.umd.enpm614.assignment2.Assignment2Application.TASK_2_ENV;

@Profile(TASK_2_ENV)
@Configuration
public class AdditionalConfig {
    @Bean
    public Persistence persistence(FileSystem FS, Connection Con){
        return new PersistenceOracle(FS,Con);
    }
    @Bean
    public Frontend frontend(Authentication Auth){
        return new FrontendGWT(Auth);
    }
    @Bean
    public Middleware middleware(){
        return new MiddlewareJBoss();
    }
    @Bean
    public Authentication authentication(){
        return new AuthenticationTSL();
    }
    @Bean
    public FileSystem fileSystem(){
        return new FileSystemNFS();
    }
    @Bean
    public Connection connection(){
        return new ConnectionJDBC();
    }
}
