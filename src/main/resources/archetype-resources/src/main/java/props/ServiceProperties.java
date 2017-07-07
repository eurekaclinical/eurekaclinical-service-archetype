package ${package}.props;

import org.eurekaclinical.standardapis.props.CasEurekaClinicalProperties;

/**
 * Created by akalsan on 10/4/16.
 */
public class ServiceProperties extends CasEurekaClinicalProperties {

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
