package me.laszloszerednik.vizsgaszeredniklaszlotamas.data.repository;

import me.laszloszerednik.vizsgaszeredniklaszlotamas.data.entity.CardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CardEntityRepository extends JpaRepository<CardEntity, Long> {
    List<CardEntity> findAllByQuantityRatioIsGreaterThan(Double quantityRatio);
}