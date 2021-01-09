package dev.manuel.msscbreweryclient.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Beer {

  private UUID id;
  private String beerName;
  private String beerStyle;
  private Long upc;


}
