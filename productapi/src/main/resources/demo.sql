DROP TABLE IF EXISTS advert;
CREATE TABLE advert (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(50) NOT NULL,
  content VARCHAR(250) NOT NULL,
  status_id INT DEFAULT 0,
  active INT DEFAULT 0,
  price INT DEFAULT 0,
  updater INT DEFAULT null,
  version  INT DEFAULT 0,
  creationDate DATE NOT NULL,
  modifyDate DATE NOT NULL
);
