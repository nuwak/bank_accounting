-- auto-generated definition
create table account
(
    account_id bigint not null
        primary key,
    balance    numeric(19, 2),
    created    timestamp,
    updated    timestamp
);

create sequence hibernate_sequence;
