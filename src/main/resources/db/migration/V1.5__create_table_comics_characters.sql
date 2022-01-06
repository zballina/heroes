create TABLE if not exists public.comics_characters
(
    comic_id     bigint NOT NULL,
    character_id bigint NOT NULL,

    primary key (comic_id, character_id)
);
