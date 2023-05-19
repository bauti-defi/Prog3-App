package edu.ucema.marketplace.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import edu.ucema.marketplace.services.CollectionServiceImpl;
import edu.ucema.marketplace.services.interfaces.ICollectionService;

@Configurable
public class AppConfig {
    
    @Bean
    @Primary
    public ICollectionService createCollectionService(){
        return new CollectionServiceImpl();
    }

}
