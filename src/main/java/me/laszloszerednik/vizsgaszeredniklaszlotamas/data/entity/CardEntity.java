package me.laszloszerednik.vizsgaszeredniklaszlotamas.data.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class CardEntity {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String type;
    private Double quantityRatio;
    private Integer obtainPrice;
    private Integer obtainYear;
    private Integer releaseYear;
    private Integer releasePrice;

    @ManyToOne
    private KollectionEntity collection;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        CardEntity cardEntity = (CardEntity) o;
        return id != null && Objects.equals(id, cardEntity.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
