INSERT INTO application_ifto.user (id, name, email, password, uuid, date_create, date_update) VALUES (1, 'Victtor', 'victtorfreits95@gmail.com', '$2a$12$5Wcdi5Ho.3GGCsBqAxLysu1fJVhZ/957yLqHJikdmKWTP7JaSmE/K', '7d62b5d8-0907-412a-9632-f97a7e420714', '2022-10-22 20:42:52', '2022-10-22 20:42:52');

INSERT INTO application_ifto.permission (id, description) VALUES (1, 'CONSULT_USER');

INSERT INTO application_ifto.role (id, name) VALUES (1, 'ADM');
INSERT INTO application_ifto.role (id, name) VALUES (2, 'CONSULT_ALL');

INSERT INTO application_ifto.role_permission (id_role, id_permission) VALUES (1, 1);

INSERT INTO application_ifto.role_user (id_role, id_user) VALUES (1, 1);
