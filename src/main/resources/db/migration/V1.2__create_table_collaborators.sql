create TABLE if not exists public.collaborators
(
    id       bigserial    not null,
    comic_id bigint       not null,
    name     varchar(255) not null,
    role     varchar(50)  not null,

    primary key (id)
);

