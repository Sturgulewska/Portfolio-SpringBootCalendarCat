package com.example.calenderCat.Dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
@Data
@RequiredArgsConstructor
@Getter
public class CatDto {

    @JsonProperty("id")
    private String id;

    @JsonProperty("created_at")
    private LocalDateTime createTime;

    @JsonProperty("url")
    private String urlCat;
}
