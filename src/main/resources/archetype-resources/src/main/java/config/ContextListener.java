package ${package}.config;

import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.persist.jpa.JpaPersistModule;
import com.google.inject.servlet.GuiceServletContextListener;
import org.eurekaclinical.common.config.InjectorSupport;
import ${package}.props.ServiceProperties;

import javax.servlet.ServletContextEvent;
import java.util.ResourceBundle;

/**
 * Created by akalsan on 10/4/16.
 */
public class ContextListener extends GuiceServletContextListener {
    private static final String JPA_UNIT = "service-jpa-unit";
    private InjectorSupport injectorSupport;
    private ServiceProperties properties = new ServiceProperties();

    @Override
    protected Injector getInjector() {
        /*
         * Must be created here in order for the modules to initialize
         * correctly.
         */
        if (this.injectorSupport == null) {
                this.injectorSupport = new InjectorSupport(
                                    new Module[]{
                                        new AppModule(),
                                        new ServletModule(this.properties),
                                        new JpaPersistModule(JPA_UNIT)
                                    },
                                    this.properties);
        }
        return this.injectorSupport.getInjector();
    }
}
