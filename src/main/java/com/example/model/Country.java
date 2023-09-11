package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Country {
  String code2;
  String headofstate;
  String govermentform;
  String localname;
  Integer gnp_old;
  Integer gnp;
  Integer life_expectancy;
  Integer population;
  Integer indep_year;
  Integer surface_area;
  String region;
  String continent;
  String name;
  String code;
}
