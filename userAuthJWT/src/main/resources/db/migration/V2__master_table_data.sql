INSERT  INTO roles(name) VALUES('ROLE_USER');
INSERT  INTO roles(name) VALUES('ROLE_ADMIN');

INSERT INTO `users` (`id`, `user_name`, `email`, `password`) VALUES ('1', 'deepak001', 'deepak.g1@gmail.com', '$2a$10$Cq6SPHU47762NgEGjd4qJOzk003U/oSdP4w7M3UdPOoX6hNnSVPUi');
INSERT INTO `users` (`id`, `user_name`, `email`, `password`) VALUES ('2', 'deepak002', 'deepak.g2@gmail.com', '$2a$10$Cq6SPHU47762NgEGjd4qJOzk003U/oSdP4w7M3UdPOoX6hNnSVPUi');
INSERT INTO `users` (`id`, `user_name`, `email`, `password`) VALUES ('3', 'deepak003', 'deepak.g3@gmail.com', '$2a$10$Cq6SPHU47762NgEGjd4qJOzk003U/oSdP4w7M3UdPOoX6hNnSVPUi');
INSERT INTO `users` (`id`, `user_name`, `email`, `password`) VALUES ('4', 'deepak004', 'deepak.g4@gmail.com', '$2a$10$Cq6SPHU47762NgEGjd4qJOzk003U/oSdP4w7M3UdPOoX6hNnSVPUi');

INSERT INTO `user_roles` (`user_id`, `role_id`) VALUES ('1', '2');
INSERT INTO `user_roles` (`user_id`, `role_id`) VALUES ('2', '1');
INSERT INTO `user_roles` (`user_id`, `role_id`) VALUES ('3', '1');
INSERT INTO `user_roles` (`user_id`, `role_id`) VALUES ('4', '1');