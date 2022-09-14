package me.laszloszerednik.vizsgaszeredniklaszlotamas.controller.card.dto;

import lombok.Data;
import me.laszloszerednik.vizsgaszeredniklaszlotamas.controller.kollection.dto.KollectionDTO;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@Data
public class CardDTO {
    private Long id;

    @NotBlank
    @Length(min = 1, max = 20)
    private String name;
    private String type;

    @Positive
    @Min(1)
    @Max(100)
    private Double quantityRatio;

    @Positive
    private Integer obtainPrice;

    @Positive
    private Integer obtainYear;

    @Positive
    private Integer releaseYear;

    @Positive
    private Integer releasePrice;

    private KollectionDTO collection;
    private Double estimatedPrice;
}
