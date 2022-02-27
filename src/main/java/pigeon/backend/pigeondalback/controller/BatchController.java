package pigeon.backend.pigeondalback.controller;

import com.sun.org.slf4j.internal.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * <p>
 *
 * </p>
 *
 * @author Johannes
 * @date 2/26/22
 */
@RestController
@RequestMapping("api/v1/batch")
public class BatchController extends BaseController implements WebMvcConfigurer {

    Logger logger = new Logger(this.getClass().toString());

    private static final long MAX_AGE_SECS = 3600;

//    @GetMapping(value = "/split/{splitJson}")
//    public String split(@PathVariable String splitJson) throws Exception {
//        return "123";
//    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedMethods("HEAD", "OPTIONS", "GET", "POST", "PUT", "PATCH", "DELETE").allowedOrigins("*")
                .allowedHeaders("*").maxAge(MAX_AGE_SECS);
    }
}
