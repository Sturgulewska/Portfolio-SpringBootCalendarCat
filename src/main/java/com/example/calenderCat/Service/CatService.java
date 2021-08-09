package com.example.calenderCat.Service;

import com.example.calenderCat.Dto.CatDto;
import com.example.calenderCat.configuration.CatConfiguration;
import com.example.calenderCat.utils.MyJsonUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.Data;
import okhttp3.*;
import org.springframework.stereotype.Service;

import java.io.IOException;
@Data
@Service
public class CatService {

    private final CatConfiguration catConfiguration;

    public CatService(CatConfiguration catConfiguration) {
        this.catConfiguration = catConfiguration;
    }

    public CatDto getCat() throws JsonProcessingException {
        Request request = new Request.Builder()
                .url(createUrl())
                .build();
        String response = executeRequest(request);
        CatDto result = MyJsonUtils.convertStringToObject(response, CatDto.class);
        return result;
    }


    public HttpUrl createUrl() {
        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme("https")
                .host(catConfiguration.getUrl())
                .addPathSegment("cat")
                .addQueryParameter("json", "true")
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

