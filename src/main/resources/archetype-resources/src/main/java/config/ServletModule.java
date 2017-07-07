package ${package}.config;

import org.eurekaclinical.common.config.AbstractAuthorizingJerseyServletModuleWithPersist;
import ${package}.props.ServiceProperties;

/**
 * Created by akalsan on 10/4/16.
 */
public class ServletModule extends AbstractAuthorizingJerseyServletModuleWithPersist {

    private static final String PACKAGE_NAMES = "${package}.resource";
    private final ServiceProperties properties;

    public ServletModule(ServiceProperties inProperties) {
        super(inProperties, PACKAGE_NAMES);
        this.properties = inProperties;
    }
}
