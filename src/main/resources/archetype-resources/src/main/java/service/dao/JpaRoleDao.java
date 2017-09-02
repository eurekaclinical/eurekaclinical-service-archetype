package ${package}.service.dao;

import ${package}.service.entity.RoleEntity;
import org.eurekaclinical.standardapis.dao.AbstractJpaRoleDao;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.persistence.EntityManager;

/**
 * Created by akalsan on 10/4/16.
 */


public class JpaRoleDao extends AbstractJpaRoleDao<RoleEntity> {

    /**
     * Create an object with the give entity manager.
     *
     * @param inEMProvider The entity manager to be used for communication with
     * the data store.
     */
    @Inject
    public JpaRoleDao(final Provider<EntityManager> inEMProvider) {
        super(RoleEntity.class, inEMProvider);
    }
}
