INSERT INTO account (account_id, balance, created, updated, version) VALUES (1, 41.21, '2022-08-30 11:54:05.993814', '2022-08-30 11:54:14.911013', 1);
INSERT INTO account (account_id, balance, created, updated, version) VALUES (2, 43.63, '2022-08-30 11:54:08.201051', '2022-08-30 11:54:14.917035', 1);
INSERT INTO transaction (tx_id, from_id, to_id, amount, created, updated) VALUES (1, 1, 2, 1.21, '2022-08-30 11:54:14.908632', '2022-08-30 11:54:14.908649');

SELECT setval('transaction_tx_id_seq', (SELECT MAX(tx_id) FROM transaction));
SELECT setval('account_account_id_seq', (SELECT MAX(account_id) FROM account));



