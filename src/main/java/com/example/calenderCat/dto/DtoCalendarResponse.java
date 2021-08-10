package com.example.calenderCat.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class DtoCalendarResponse {
    @JsonProperty("holidays")
    public ArrayList<DtoCalendarHolidays> dtoCalendarHolidays;
}
