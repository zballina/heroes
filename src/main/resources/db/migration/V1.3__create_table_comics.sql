create TABLE if not exists public.comics
(
    id          bigint       not null,
    digital_id  bigint,
    title       varchar(255) not null,
    description varchar(2048),

    primary key (id)
);

