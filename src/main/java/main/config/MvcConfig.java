package main.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
@EnableWebMvc
public class MvcConfig implements WebMvcConfigurer {

  private static final String[] CLASSPATH_RESOURCE_LOCATIONS = {
      "classpath:/META-INF/resources/", "classpath:/resources/",
      "classpath:/static/", "classpath:/public/"};

  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
      registry
          .addResourceHandler("/**")
          .addResourceLocations(CLASSPATH_RESOURCE_LOCATIONS);
  }
}



