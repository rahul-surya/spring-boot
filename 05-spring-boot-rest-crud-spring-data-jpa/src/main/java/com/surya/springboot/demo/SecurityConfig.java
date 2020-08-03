package com.surya.springboot.demo;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private DataSource dataSource;
	
	
	@Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().passwordEncoder(new BCryptPasswordEncoder())
            .dataSource(dataSource)
            .usersByUsernameQuery("select username, password, enabled from users where username=?")
            .authoritiesByUsernameQuery("select username, role from users where username=?")
        ;
    }
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .httpBasic()
            .and()
            .authorizeRequests()
            .anyRequest().authenticated();
        http.csrf().disable();
    }
 
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//            .anyRequest().authenticated()
//            .and()
//            .formLogin().permitAll()
//            .and()
//            .logout().permitAll();     
//    }
	
	
	/*
	  CREATE TABLE `users` ( `user_id` int(11) NOT NULL AUTO_INCREMENT, `username`
	  varchar(45) NOT NULL, `password` varchar(64) NOT NULL, `role` varchar(45) NOT
	  NULL, `enabled` tinyint(4) DEFAULT NULL, PRIMARY KEY (`user_id`) );
	  
	 INSERT INTO `users` (`username`,`password`,`role`,`enabled`)
	 VALUES ('rohit',
			'$2a$10$6WLKz7D9EmfPltdcc7jkBOUk/Qok83mqWN6VMRqZbMgdCz.WzzMQm',
			'ROLE_USER', 1);


	INSERT INTO `users` (`username`,`password`,`role`,`enabled`)
	VALUES ('rahul',
		'$2a$10$JPHEFHtuXaUBEg4Ia7nIzuyE7EvBfLuqGhy0PrPAuYwE8IacErAPm',
		'ROLE_ADMIN', 1);
	 
	*/
}
