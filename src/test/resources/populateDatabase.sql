INSERT INTO person (id,name, age)
VALUES
(1,'person1', 1),
(2,'person2', 2),
(3,'person3', 3);


INSERT INTO house (address,type, zip_code, person_id)
VALUES
('address1', 'HOUSE', 'zip1', 1),
('address2', 'HOUSE', 'zip2', 2),
('address3', 'HOUSE', 'zip3', 3);

INSERT INTO child (id, child_sex,age,name, hair_color, bicycle_color, parent_id)
VALUES
(1,'Child', 1, 'child1', null, null, 1),
(2,'Son', 1, 'son1', null, 'red', 1),
(3,'Daughter', 1, 'daughter1', 'blond', null, 1),
(4,'Child', 1, 'child2', null, null, 2);

INSERT INTO meal (id, name, invented, like_index, child_id)
VALUES
(1,'meal1', now(), 5,1),
(2,'meal favourite', now(), 10,1);