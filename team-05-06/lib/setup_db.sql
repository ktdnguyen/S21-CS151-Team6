CREATE database walletmanager;
USE walletmanager;
  CREATE TABLE `walletmanager`.`user` (
  `user_id` INT AUTO_INCREMENT,
  `user_name` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`user_id`));