--liquibase formatted sql
--changeset pkwiatkowski:1
create table user
(
    id         BIGINT AUTO_INCREMENT PRIMARY KEY,
    name       VARCHAR(20),
    password   VARCHAR(20) NOT NULL,
    phone_id   BIGINT,
    address_id BIGINT
) ENGINE = InnoDB;
# --OneToOne unidirectional
create table address
(
    id              BIGINT AUTO_INCREMENT PRIMARY KEY,
    street          varchar(20) not null,
    house_number_id BIGINT
) ENGINE = InnoDB;
ALTER TABLE user
    ADD CONSTRAINT fk_user_address_id
        FOREIGN KEY (address_id) REFERENCES address (id);

INSERT INTO address (street)
VALUES ('Paderewskiego'),
       ('Gdanska');

create table house_number
(
    id     BIGINT AUTO_INCREMENT PRIMARY KEY,
    number VARCHAR(20)
) ENGINE = InnoDB;
ALTER TABLE address
    ADD CONSTRAINT fk_address_house_number_id
        FOREIGN KEY (house_number_id) REFERENCES house_number (id);

INSERT INTO house_number (number)
VALUES ('23'),
       ('24');

UPDATE address
SET house_number_id = 1
WHERE id = 1;
UPDATE address
SET house_number_id = 2
WHERE id = 2;

create table phone
(
    id     BIGINT AUTO_INCREMENT PRIMARY KEY,
    number varchar(20)
) ENGINE = InnoDB;
# --OneToOne bidirectional
ALTER TABLE user
    ADD CONSTRAINT fk_user_phone_id
        FOREIGN KEY (phone_id) REFERENCES phone (id);
SET FOREIGN_KEY_CHECKS = 0;
INSERT INTO phone (number)
VALUES ('+48555555555'),
       ('+48666666666');
SET FOREIGN_KEY_CHECKS = 1;
INSERT INTO user (name, password, phone_id,address_id)
VALUES ('Piotr', 'haslo', 2 ,1),
       ('Marcin', 'haslo', 1, 2);

# --OneToMany
create table class_room
(
    id      BIGINT AUTO_INCREMENT PRIMARY KEY,
    name    varchar(20),
    user_id BIGINT
) ENGINE = InnoDB;

ALTER TABLE class_room
    ADD CONSTRAINT fk_class_user_id
        FOREIGN KEY (user_id) REFERENCES user (id);
INSERT INTO class_room (name, user_id)
VALUES ('124', 1),
       ('124', 2),
       ('125', 1),
       ('125', 2),
       ('126', 1);


# --ManyToMany


create table activity
(
    id   BIGINT AUTO_INCREMENT PRIMARY KEY,
    name varchar(20)
) ENGINE = InnoDB;


CREATE TABLE user_activity
(
    user_id     bigint(20) NOT NULL,
    activity_id bigint(20) NOT NULL,
    FOREIGN KEY (user_id) REFERENCES user (id) ON DELETE RESTRICT ON UPDATE CASCADE,
    FOREIGN KEY (activity_id) REFERENCES activity (id) ON DELETE RESTRICT ON UPDATE CASCADE,
    PRIMARY KEY (user_id, activity_id)
);

INSERT INTO activity (name)
VALUES ('Bieganie'),
       ('Rower');

INSERT INTO user_activity (user_id, activity_id)
VALUES (1, 1),
       (1, 2),
       (2, 1),
       (2, 2);