drop table if exists child_info_view;
drop view if exists child_info_view;

create view child_info_view as
  select t1.id, p.name as parent_name, p.age , m.name as meal_name, m.invented

  from person p

  join
    (select c.id, c.parent_id, max(like_index) as favoriteMeal
    from meal m right join child c
    on m.child_id = c.id
    group by c.id, c.parent_id) t1
    on t1.parent_id = p.id

  left join meal m
    on m.child_id = t1.id
    and m.like_index = t1.favoriteMeal;