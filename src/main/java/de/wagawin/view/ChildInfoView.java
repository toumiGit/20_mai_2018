package de.wagawin.view;

import jdk.nashorn.internal.ir.annotations.Immutable;

import javax.persistence.*;
import java.util.Date;


@Entity
@Immutable
@Table(name = "child_info_view")
public class ChildInfoView {

    @Id
    int id;

    String parentName;
    int age;


    @Temporal(TemporalType.TIMESTAMP)
    Date invented;
    String mealName;
}
