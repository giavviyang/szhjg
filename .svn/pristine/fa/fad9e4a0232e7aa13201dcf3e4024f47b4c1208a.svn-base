package com.fudian.framework.config;

import java.util.concurrent.TimeUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import com.fudian.common.config.RuoYiConfig;
import com.fudian.common.constant.Constants;
import com.fudian.framework.interceptor.RepeatSubmitInterceptor;

/**
 * 通用配置
 * 
 * @author fudian
 */
@Configuration
public class ResourcesConfig implements WebMvcConfigurer
{
    @Autowired
    private RepeatSubmitInterceptor repeatSubmitInterceptor;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry)
    {
        //xiaruibo 20230428 下面这两行代码是为了解决偶尔页面出现404的问题，如果不加这两行代码，可以创建WEB-INF/web.xml文件来解决这个问题，但是每次部署都要创建WEB-INF/web.xml文件，比较麻烦，所以用代码代替。为什么要加两行呢？其实加一行就行，加两行会优先从szhjg下查找文件，找不到再去static里找，这行更完善而已。 start
        registry.addResourceHandler("/szhjg/**").addResourceLocations("classpath:/szhjg/");   //xiaruibo 20230428 这行的意思是，如果前端dist打包后，不拷贝到后端resources/static中，拷贝到新建的前端文件夹szhjg中，后端单独打war包，这样前后端单独部署到tomcat里，互不影响，需要这么配置。
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/"); //xiaruibo 20230428 这行的意思是，如果前端dist打包后，把里面的静态资源文件拷贝到后端resources/static中，在打成一个总的war包，在部署到tomcat里时，需要这么配置。
        //xiaruibo 20230428 下面这两行代码是为了解决偶尔页面出现404的问题，如果不加这两行代码，可以创建WEB-INF/web.xml文件来解决这个问题，但是每次部署都要创建WEB-INF/web.xml文件，比较麻烦，所以用代码代替。为什么要加两行呢？其实加一行就行，加两行会优先从szhjg下查找文件，找不到再去static里找，这行更完善而已。 end

        /** 本地文件上传路径 */
        registry.addResourceHandler(Constants.RESOURCE_PREFIX + "/**")
                .addResourceLocations("file:" + RuoYiConfig.getProfile() + "/");

        /** swagger配置 */
        registry.addResourceHandler("/swagger-ui/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/springfox-swagger-ui/")
                .setCacheControl(CacheControl.maxAge(5, TimeUnit.HOURS).cachePublic());;
    }

    /**
     * 自定义拦截规则
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry)
    {
        registry.addInterceptor(repeatSubmitInterceptor).addPathPatterns("/**");
    }

    /**
     * 跨域配置
     */
    @Bean
    public CorsFilter corsFilter()
    {
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        // 设置访问源地址
        config.addAllowedOriginPattern("*");
        // 设置访问源请求头
        config.addAllowedHeader("*");
        // 设置访问源请求方法
        config.addAllowedMethod("*");
        // 有效期 1800秒
        config.setMaxAge(1800L);
        // 添加映射路径，拦截一切请求
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        // 返回新的CorsFilter
        return new CorsFilter(source);
    }
}