package ${package}.service.config;

import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;
import ${package}.service.dao.JpaRoleDao;
import ${package}.service.dao.JpaUserDao;
import ${package}.service.entity.RoleEntity;
import ${package}.service.entity.UserEntity;
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
