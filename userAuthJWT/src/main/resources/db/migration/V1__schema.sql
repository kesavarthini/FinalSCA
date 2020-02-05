CREATE TABLE users (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  user_name varchar(40) NOT NULL,
  email varchar(40) NOT NULL,
  password varchar(100) NOT NULL
);

CREATE TABLE roles (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  name varchar(60) NOT NULL
);


CREATE TABLE `user_roles` (
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`)
);