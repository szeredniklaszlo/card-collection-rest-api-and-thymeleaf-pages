package me.laszloszerednik.vizsgaszeredniklaszlotamas.data.repository;

import me.laszloszerednik.vizsgaszeredniklaszlotamas.data.entity.KollectionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KollectionEntityRepository extends JpaRepository<KollectionEntity, Long> {
}