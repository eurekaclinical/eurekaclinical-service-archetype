package ${package}.resource;

import com.google.inject.Inject;
import com.google.inject.persist.Transactional;
import org.eurekaclinical.common.resource.AbstractRoleResource;
import ${package}.entity.RoleEntity;
import org.eurekaclinical.standardapis.dao.RoleDao;
import org.eurekaclinical.common.comm.Role;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Path;

/**
 * Created by akalsan on 10/5/16.
 */
@Path("/protected/roles")
@Transactional
public class RoleResource extends AbstractRoleResource<RoleEntity, Role> {

    @Inject
    public RoleResource(RoleDao<RoleEntity> inRoleDao) {
        super(inRoleDao);
    }

    @Override
    protected Role toComm(RoleEntity roleEntity, HttpServletRequest req) {
        Role role = new Role();
        role.setId(roleEntity.getId());
        role.setName(roleEntity.getName());
        return role;
    }

}
