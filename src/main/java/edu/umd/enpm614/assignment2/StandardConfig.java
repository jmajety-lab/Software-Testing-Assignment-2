package edu.umd.enpm614.assignment2;

import edu.umd.enpm614.assignment2.application.WebApplication;
import edu.umd.enpm614.assignment2.interfaces.*;
import edu.umd.enpm614.assignment2.services.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.inject.Inject;

import static edu.umd.enpm614.assignment2.Assignment2Application.TASK_1_ENV;

@Profile(TASK_1_ENV)
@Configuration
public class StandardConfig {
@Bean
public Persistence persistence(FileSystem FS, Connection Con){
    return new PersistenceMySQL (FS,Con);
}
@Bean
public Frontend frontend(Authentication Auth){
    return new FrontendHTML(Auth);
}
@Bean
public Middleware middleware(){
    return new MiddlewareTomcat();
}
@Bean
public Authentication authentication(){
    return new AuthenticationSSL();
}
@Bean
public FileSystem fileSystem(){
    return new FileSystemNTFS();
}
@Bean
public Connection connection(){
    return new ConnectionPooled();
}
}
