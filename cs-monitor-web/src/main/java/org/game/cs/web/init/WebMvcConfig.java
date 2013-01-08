package org.game.cs.web.init;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan(basePackages = {"org.game.cs.**"})
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }

    @Bean
    TilesConfigurer getTilesConfigurer() {
        TilesConfigurer tilesConfigurer = new TilesConfigurer();
        tilesConfigurer.setDefinitions(new String[]{"/WEB-INF/tiles-config/general.xml"});
        return tilesConfigurer;
    }

    @Bean
    UrlBasedViewResolver getUrlBasedViewResolver() {
        UrlBasedViewResolver urlBasedViewResolver = new UrlBasedViewResolver();
        urlBasedViewResolver.setOrder(0);
        urlBasedViewResolver.setViewClass(TilesView.class);
        return urlBasedViewResolver;
    }

}
