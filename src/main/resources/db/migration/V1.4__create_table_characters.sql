create TABLE if not exists public.characters
(
    id          bigint       NOT NULL,
    name        varchar(100) NOT NULL,
    description varchar(2048),

    primary key (id)
);
