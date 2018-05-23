package de.wagawin.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Meal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    String name;

    @Temporal(TemporalType.TIMESTAMP)
    private Date invented;

    @ManyToOne
    @JoinColumn(name = "child_id", nullable = false)
    private Child child;

    private Integer likeIndex;
}
