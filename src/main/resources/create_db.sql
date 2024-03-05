create table IF NOT EXISTS Client
(
    ID   serial PRIMARY KEY,
    name varchar(20) NOT NULL
);

create table IF NOT EXISTS Cat
(
    ID        serial PRIMARY KEY,
    name      varchar(20) NOT NULL
);

create table IF NOT EXISTS clients_cats
(
    client_id integer ,
    foreign key (client_id) references Client(ID) ON DELETE CASCADE,
    cat_id    integer,
    foreign key (cat_id) references Cat (ID) ON DELETE CASCADE
);
