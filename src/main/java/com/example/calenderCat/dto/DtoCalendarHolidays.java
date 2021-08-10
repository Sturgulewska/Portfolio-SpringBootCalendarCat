package com.example.calenderCat.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class DtoCalendarHolidays {
    @JsonProperty("name")
    private  String name;

    @JsonProperty("date")
    private DtoDateHolidays dtoDateHolidays;



}
