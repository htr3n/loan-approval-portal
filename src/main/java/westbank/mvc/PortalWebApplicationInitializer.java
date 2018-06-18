package westbank.mvc;

public class PortalWebApplicationInitializer {

    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{PortalWebApplicationInitializer.class};
    }

    protected String[] getServletMappings() {
        return new String[]{"/portal"};
    }

}
