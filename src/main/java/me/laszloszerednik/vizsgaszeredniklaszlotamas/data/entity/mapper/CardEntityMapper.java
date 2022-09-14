package me.laszloszerednik.vizsgaszeredniklaszlotamas.data.entity.mapper;

import me.laszloszerednik.vizsgaszeredniklaszlotamas.config.MapstructConfig;
import me.laszloszerednik.vizsgaszeredniklaszlotamas.data.entity.CardEntity;
import me.laszloszerednik.vizsgaszeredniklaszlotamas.domain.Card;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(config = MapstructConfig.class)
public interface CardEntityMapper {
    Card fromEntity(CardEntity entity);
    CardEntity toEntity(Card domain);

    List<Card> fromEntities(List<CardEntity> entities);
    List<CardEntity> toEntities(List<Card> domains);
}
