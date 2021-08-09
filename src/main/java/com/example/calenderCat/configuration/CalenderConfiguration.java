package com.example.calenderCat.configuration;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
public class CalenderConfiguration {

    @Value("${api.calendarific.url}")
    private String url;

    @Value("${api.calendarific.api_key}")
    private String api_key;

}
