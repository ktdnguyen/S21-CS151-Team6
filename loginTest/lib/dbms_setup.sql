CREATE database walletmanager;
USE whms;

  CREATE TABLE `whms`.`user` (
  `user_id` INT NOT AUTO_INCREMENT,
  `user_name` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`user_id`));
  
INSERT INTO user values ('admin', 'admin');