-- auto-generated definition
create table transaction
(
    tx_id   bigint not null
        primary key,
    from_id bigint,
    to_id   bigint,
    amount  numeric(19, 2),
    created timestamp,
    updated timestamp
);

