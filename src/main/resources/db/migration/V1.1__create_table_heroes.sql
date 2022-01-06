create TABLE if not exists public.heroes
(
    short_name varchar(20)  not null,
    name       varchar(100) not null,
    last_sync  timestamp,
    primary key (short_name)
);

insert into public.heroes(short_name, name, last_sync)
values ('ironman', 'Iron Man', null),
       ('capamerica', 'Captain America', null);