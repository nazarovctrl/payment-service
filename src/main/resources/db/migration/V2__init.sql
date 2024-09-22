insert into users(username, password, role, name)
values ('admin', '$2a$10$.xxGRIFgxVl988b9elARc.jjSChPAN83oiVK1V2h2KDdjJDoTxWPy', 'ADMINISTRATOR', 'System administrator');

CREATE SEQUENCE account_number_seq START WITH 1000000000 INCREMENT BY 1;
CREATE SEQUENCE card_number_seq START WITH 8600000000000000 INCREMENT BY 1;

