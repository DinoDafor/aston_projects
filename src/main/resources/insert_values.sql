insert into client(name)
values ('Artem'),
       ('Boris'),
       ('Cirilla'),
       ('Dimon'),
       ('Eva');

insert into cat(name)
values ('Arya'),
       ('Bergamot'),
       ('Corzes'),
       ('Dillir'),
       ('Erik');


insert into clients_cats(client_id, cat_id)
VALUES (1, 1),
       (1, 2),
       (2, 3),
       (3, null),
       (4, 4),
       (5, 4),
       (null, 5);
