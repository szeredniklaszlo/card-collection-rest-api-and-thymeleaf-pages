package me.laszloszerednik.vizsgaszeredniklaszlotamas.controller.kollection.dto.mapper;

import me.laszloszerednik.vizsgaszeredniklaszlotamas.config.MapstructConfig;
import me.laszloszerednik.vizsgaszeredniklaszlotamas.controller.card.dto.mapper.CardDTOMapper;
import me.laszloszerednik.vizsgaszeredniklaszlotamas.controller.kollection.dto.KollectionDTO;
import me.laszloszerednik.vizsgaszeredniklaszlotamas.domain.Kollection;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(config = MapstructConfig.class, uses = CardDTOMapper.class)
public interface KollectionDTOMapper {
    Kollection fromDTO(KollectionDTO dto);
    KollectionDTO toDTO(Kollection domain);

    List<Kollection> fromDTOs(List<KollectionDTO> cardDTOs);
    List<KollectionDTO> toDTOs(List<Kollection> domains);
}
