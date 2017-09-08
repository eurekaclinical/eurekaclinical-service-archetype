package ${package}.service.resource;

import com.google.inject.persist.Transactional;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * Created by akalsan on 10/5/16.
 */


@Path("/protected/test")
@Transactional
public class TestResource {

    public TestResource() {
    }

    @GET
    public String getStringHello() {
        return "Hello World";
    }
}
