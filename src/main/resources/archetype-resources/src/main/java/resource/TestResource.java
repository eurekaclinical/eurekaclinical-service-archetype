package ${package}.resource;

import com.google.inject.persist.Transactional;
import org.eurekaclinical.standardapis.dao.RoleDao;
import org.eurekaclinical.standardapis.dao.UserDao;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by akalsan on 10/5/16.
 */


@Path("/protected/test")
@Transactional
public class TestResource {

    public TestResource() {
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String getStringHello() {
        return "Hello World";
    }
}
