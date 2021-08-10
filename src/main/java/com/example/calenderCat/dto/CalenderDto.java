package com.example.calenderCat.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CalenderDto {

    @JsonProperty("meta")
    private CalenderMetoDto meta;

    @JsonProperty("response")
    private DtoCalendarResponse dtoCalendarResponse;


}
