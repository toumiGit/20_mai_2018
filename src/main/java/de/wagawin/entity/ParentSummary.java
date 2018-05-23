package de.wagawin.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = {"amountOfPerson", "amountOfChildren"})
public class ParentSummary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    Long amountOfPerson;
    Long amountOfChildren;

    public ParentSummary(Long amountOfPerson, Long amountOfChildren){
        this.amountOfPerson = amountOfPerson;
        this.amountOfChildren = amountOfChildren;
    }
}
