package me.laszloszerednik.vizsgaszeredniklaszlotamas.controller.card.dto.mapper;

import me.laszloszerednik.vizsgaszeredniklaszlotamas.config.MapstructConfig;
import me.laszloszerednik.vizsgaszeredniklaszlotamas.controller.card.dto.CardDTO;
import me.laszloszerednik.vizsgaszeredniklaszlotamas.domain.Card;
import me.laszloszerednik.vizsgaszeredniklaszlotamas.domain.strategy.EstimatedPriceCalculationStrategyFactory;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.LocalDate;
import java.util.List;

@Mapper(config = MapstructConfig.class, imports = {
        EstimatedPriceCalculationStrategyFactory.class, LocalDate.class
})
public interface CardDTOMapper {
    Card fromDTO(CardDTO dto);
    @Mapping(
            target = "estimatedPrice",
            expression = "java( domain.calculateEstimatedPrice(EstimatedPriceCalculationStrategyFactory.createStrategy(strategy), LocalDate.now().getYear()) )"
    )
    CardDTO toDTO(Card domain, String strategy);
    default CardDTO toDTO(Card domain) {
        return toDTO(domain, "default");
    }

    List<Card> fromDTOs(List<CardDTO> cardDTOs);
    List<CardDTO> toDTOs(List<Card> domains);
}
