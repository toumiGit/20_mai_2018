package de.wagawin.view;

import de.wagawin.entity.Meal;
import de.wagawin.entity.Person;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ChildInfo {

    Person parent;
    Meal favouriteMeal;

    public ChildInfo(ChildInfoView view){

        this.parent = Person.builder().name(view.parentName).age(view.age).build();
        this.favouriteMeal = Meal.builder().name(view.mealName).invented(view.invented).build();
    }
}
