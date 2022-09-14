package me.laszloszerednik.vizsgaszeredniklaszlotamas.data.entity.mapper;

import me.laszloszerednik.vizsgaszeredniklaszlotamas.config.MapstructConfig;
import me.laszloszerednik.vizsgaszeredniklaszlotamas.data.entity.KollectionEntity;
import me.laszloszerednik.vizsgaszeredniklaszlotamas.domain.Kollection;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(config = MapstructConfig.class, uses = CardEntityMapper.class)
public interface KollectionEntityMapper {
    Kollection fromEntity(KollectionEntity entity);
    KollectionEntity toEntity(Kollection domain);

    List<Kollection> fromEntities(List<KollectionEntity> entities);
    List<KollectionEntity> toEntities(List<Kollection> domains);
}
