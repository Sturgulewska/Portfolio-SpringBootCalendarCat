package com.example.calenderCat.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CalenderDto {

    @JsonProperty("meta")
    private CalenderMetoDto meta;


}
