package com.springboot30.application.config;

import com.springboot30.application.handler.UrlAuthenticationSuccessHandler;
import com.springboot30.application.repository.UserService;
import com.springboot30.application.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
//
//    @Autowired
//    private BCryptPasswordEncoder bCryptPasswordEncoder;
//
    @Bean
    public AuthenticationSuccessHandler myAuthenticationSuccessHandler() {
        return new UrlAuthenticationSuccessHandler();
    }

    @Autowired
    private DataSource dataSource;
//
//    private final String USERS_QUERY = "select mail, password, active from users where mail=?";
//    private final String ROLES_QUERY = "select u.mail, r.name from users u inner join users_roles ur on (u.id = ur.users_id) inner join roles r on (ur.roles_id=r.id) where u.mail=?";
//
//    @Bean
//    public BCryptPasswordEncoder passwordEncoder() {
//        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
//        return bCryptPasswordEncoder;
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.jdbcAuthentication()
//                .usersByUsernameQuery(USERS_QUERY)
//                .authoritiesByUsernameQuery(ROLES_QUERY)
//                .dataSource(dataSource)
//                .passwordEncoder(bCryptPasswordEncoder); //userdetailservice userdetail использовать
//    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new UserServiceImpl();
    };

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    };

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
    }





    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.formLogin()
                // указываем страницу с формой логина
                .loginPage("/login")
                //указываем логику обработки при логине
                //.successHandler(new LoginSuccessHandler())
                .successHandler(myAuthenticationSuccessHandler())
                // указываем action с формы логина
                .loginProcessingUrl("/login")
                // Указываем параметры логина и пароля с формы логина
                .usernameParameter("email")
                .passwordParameter("password")
                // даем доступ к форме логина всем
                .permitAll();

        http.logout()
                // разрешаем делать логаут всем
                .permitAll()
                // указываем URL логаута
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                // указываем URL при удачном логауте
                .logoutSuccessUrl("/login?logout")
                //выклчаем кроссдоменную секьюрность (на этапе обучения неважна)
                .and().csrf().disable();

        http
                // делаем страницу регистрации недоступной для авторизированных пользователей
                .authorizeRequests()
                //страницы аутентификаци доступна всем
                .antMatchers("/login").anonymous()
                // защищенные URL
                .antMatchers("/admin").access("hasAnyRole('ADMIN')")
                .antMatchers("/user").access("hasAnyRole('USER', 'ADMIN')")
                .anyRequest().authenticated();


//        http.authorizeRequests()
//                .antMatchers("/").permitAll()
//                .antMatchers("/login").permitAll()
//                .antMatchers("/signup").permitAll()
//        // /userInfo page requires login as ROLE_USER or ROLE_ADMIN.
//        // If no login, it will redirect to /login page.
//                .antMatchers("/user").access("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
//
//        // For ADMIN only.
////                .antMatchers("/**").access("hasRole('ROLE_ADMIN')")
//                .antMatchers("/**").hasAuthority("ADMIN").anyRequest()
//                .authenticated().and().csrf().disable()
//                .formLogin().loginPage("/login").failureUrl("/login?error=true")
////                .defaultSuccessUrl("/home")
//                .successHandler(UrlAuthenticationSuccessHandler())
//                .usernameParameter("email")
//                .passwordParameter("password")
//                .and().logout()
//                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//                .logoutSuccessUrl("/")
//                .and().rememberMe()
//                .tokenRepository(persistentTokenRepository())
//                .tokenValiditySeconds(60*60)
//                .and().exceptionHandling().accessDeniedPage("/access_denied");
    }

//    @Bean
//    public PersistentTokenRepository persistentTokenRepository() {
//        JdbcTokenRepositoryImpl db = new JdbcTokenRepositoryImpl();
//        db.setDataSource(dataSource);
//
//        return db;
//    }
}
