create table permission
(
    id          bigint      not null auto_increment,
    description varchar(80) not null,

    primary key (id)
) engine = InnoDB
  default charset = utf8;

create table role
(
    id   bigint      not null auto_increment,
    name varchar(80) not null unique,

    primary key (id)
) engine = InnoDB
  default charset = utf8;

create table role_permission
(
    id_role       bigint not null,
    id_permission bigint not null,
    primary key (id_role, id_permission)
) engine = InnoDB
  default charset = utf8;

create table role_user
(
    id_role bigint not null,
    id_user bigint not null,
    primary key (id_role, id_user)
) engine = InnoDB default char set utf8;


alter table role_permission
    add constraint fk_role_permission_permission
        foreign key (id_permission) references permission (id);

alter table role_permission
    add constraint fk_role_permission_role_user
        foreign key (id_role) references role (id);

alter table role_user
    add constraint fk_role_user_role
        foreign key (id_role) references role (id);

alter table role_user
    add constraint fk_role_user_user
        foreign key (id_user) references user (id);

