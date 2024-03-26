package com.negocioBimba.negocioBimba.config;

import com.negocioBimba.negocioBimba.converters.CategoryConverter;
import com.negocioBimba.negocioBimba.converters.ProductConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConverterConfig {

    @Bean
    public ProductConverter productConverter() {
        return new ProductConverter();
    }

    @Bean
    public CategoryConverter categoryConverter() {return new CategoryConverter();}

}
