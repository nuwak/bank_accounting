alter table transaction
    add constraint fk_from_id_account_id
        foreign key (from_id) references account (account_id);

alter table transaction
    add constraint fk_to_id_account_id
        foreign key (to_id) references account (account_id);
