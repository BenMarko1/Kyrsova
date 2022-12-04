create table basic_salads
(
    id      serial primary key,
    name    varchar(40)  not null
);

create table vegetable
(
    id              serial primary key,
    name            varchar(40)  not null,
    calory          double precision not null,
    proteins        double precision not null,
    fats            double precision not null,
    carbohydrates   double precision not null
);

create table vegetable_salad
(
    basic_salad_id  int not null,
    vegetable_id    int not null,
    foreign key (basic_salad_id) references basic_salads ON DELETE CASCADE,
    foreign key (vegetable_id) references vegetable ON DELETE CASCADE
);

---------------
