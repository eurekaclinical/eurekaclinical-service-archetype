package ${package}.config;

import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;
import ${package}.dao.JpaRoleDao;
import ${package}.dao.JpaUserDao;
import ${package}.entity.RoleEntity;
import ${package}.entity.UserEntity;
import org.eurekaclinical.standardapis.dao.RoleDao;
import org.eurekaclinical.standardapis.dao.UserDao;

/**
 * Created by akalsan on 10/4/16.
 */
public class AppModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(new TypeLiteral<UserDao<UserEntity>>() {}).to(JpaUserDao.class);
        bind(new TypeLiteral<UserDao<? extends org.eurekaclinical.standardapis.entity.UserEntity<? extends org.eurekaclinical.standardapis.entity.RoleEntity>>>() {}).to(JpaUserDao.class);
        bind(new TypeLiteral<RoleDao<RoleEntity>>() {}).to(JpaRoleDao.class);
    }
}
