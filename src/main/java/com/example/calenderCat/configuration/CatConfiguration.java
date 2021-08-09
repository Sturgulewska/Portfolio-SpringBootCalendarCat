package com.example.calenderCat.configuration;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
@Getter
@Setter
public class CatConfiguration {

    @Value("${api.cataas.url}")
    private String url;


}

