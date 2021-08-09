package com.example.calenderCat.Service;

import com.example.calenderCat.Dto.CalenderDto;
import com.example.calenderCat.configuration.CalenderConfiguration;
import com.example.calenderCat.utils.MyJsonUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.Data;
import okhttp3.*;
import org.aspectj.weaver.ast.Call;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@Data
public class CalenderService {

    private final CalenderConfiguration calenderConfiguration;

    public CalenderService(CalenderConfiguration calenderConfiguration) {
        this.calenderConfiguration = calenderConfiguration;
    }

    public CalenderDto getCalender() throws JsonProcessingException {
        Request request = new Request.Builder()
                .url(createUrl())
                .build();
        String response = executeRequest(request);
        CalenderDto result = MyJsonUtils.convertStringToObject(response, CalenderDto.class);
        return result;
    }

    //https://calendarific.com/api/v2/holidays?&api_key=65358a2cf96e950b8e93dfca3781a8e52208c476&country=PL&year=2019'
    //https://calendarific.com/api/v2/holidays?api_key=65358a2cf96e950b8e93dfca3781a8e52208c476&countries=PL&year=2019
    //https://calendarific.com/api/v2/holidays?%26api_key=65358a2cf96e950b8e93dfca3781a8e52208c476&countries=PL&year=2019
    //https://calendarific.com/api/v2?holidays&api_key=65358a2cf96e950b8e93dfca3781a8e52208c476&countries=PL&year=2019

    public HttpUrl createUrl() {
        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme("https")
                .host(calenderConfiguration.getUrl())
                .addPathSegment("api")
                .addPathSegment("v2")
                .addPathSegment("holidays")
                .addQueryParameter("api_key", calenderConfiguration.getApi_key())
                .addQueryParameter("countries", "PL")
                .addQueryParameter("year", "2019")
                .build();
        System.out.println(httpUrl);
        return httpUrl;
    }

    private String executeRequest(Request request) {
        String result = "";
        OkHttpClient client = new OkHttpClient();
        Call requestCall = client.newCall(request);
        try (ResponseBody response = requestCall.execute().body()) {
            if (response != null) {
                result = response.string();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;

    }
}
