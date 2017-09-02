package ${package}.service.props;

import org.eurekaclinical.standardapis.props.CasJerseyEurekaClinicalProperties;

/**
 * Created by akalsan on 10/4/16.
 */
public class ServiceProperties extends CasJerseyEurekaClinicalProperties {

    public ServiceProperties() {
        super("/etc/${shortNamespace}");
    }

    @Override
    public String getProxyCallbackServer() {
        return getValue("${propertyNamespace}.service.callbackserver");
    }

    @Override
    public String getUrl() {
        return getValue("${propertyNamespace}.service.url");
    }

}
