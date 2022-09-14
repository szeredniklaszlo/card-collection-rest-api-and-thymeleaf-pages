package me.laszloszerednik.vizsgaszeredniklaszlotamas.service;

import lombok.RequiredArgsConstructor;
import me.laszloszerednik.vizsgaszeredniklaszlotamas.data.entity.KollectionEntity;
import me.laszloszerednik.vizsgaszeredniklaszlotamas.data.entity.mapper.KollectionEntityMapper;
import me.laszloszerednik.vizsgaszeredniklaszlotamas.data.repository.KollectionEntityRepository;
import me.laszloszerednik.vizsgaszeredniklaszlotamas.domain.Kollection;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class KollectionService {
    private final KollectionEntityRepository kollectionEntityRepository;
    private final KollectionEntityMapper kollectionEntityMapper;

    public Kollection create(Kollection newKollection) {
        KollectionEntity newKollectionEntity = kollectionEntityMapper.toEntity(newKollection);

        KollectionEntity savedKollectionEntity = kollectionEntityRepository.save(newKollectionEntity);
        return kollectionEntityMapper.fromEntity(savedKollectionEntity);
    }

    public List<Kollection> readAll() {
        List<KollectionEntity> kollections = kollectionEntityRepository.findAll();

        return kollectionEntityMapper.fromEntities(kollections);
    }
}
