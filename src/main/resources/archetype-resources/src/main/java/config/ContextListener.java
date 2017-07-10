package ${package}.config;

import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.persist.jpa.JpaPersistModule;
import com.google.inject.servlet.GuiceServletContextListener;
import org.eurekaclinical.common.config.InjectorSupport;
import ${package}.props.ServiceProperties;

/**
 * Loaded on application startup, this class creates the Guice injector. If
 * this service accesses any 
 * {@link org.eurekaclinical.common.comm.clients.EurekaClinicalClient} REST API 
 * clients, override {@link #contextInitialized}, and in addition to calling
 * the superclass method, create a 
 * {@link org.eurekaclinical.common.config.ClientSessionListener} for each
 * client and add it to the servlet context.
 */
public class ContextListener extends GuiceServletContextListener {
    private static final String JPA_UNIT = "service-jpa-unit";
    
    private final ServiceProperties properties;
    
    /**
     * Constructs an instance of this class.
     */
    public ContextListener() {
        this.properties = new ServiceProperties();
    }

    /**
     * Binds any classes, sets up JPA persistence, and creates and returns the
     * Guice injector.
     * 
     * @return the Guice injector
     */
    @Override
    protected Injector getInjector() {
        return new InjectorSupport(
            new Module[]{
                new AppModule(),
                new ServletModule(this.properties),
                new JpaPersistModule(JPA_UNIT)
            },
            this.properties).getInjector();
    }
}
