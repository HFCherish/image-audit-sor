CREATE TABLE images(
  id VARCHAR(32) PRIMARY KEY,
  name VARCHAR(32) NOT NULL,
  data text NOT NULL,
  description text
);

create TABLE approvals(
  imageid VARCHAR(32),
  createAt TIMESTAMP(3) NOT NULL,
  FOREIGN KEY (imageid) REFERENCES images(id) ON DELETE CASCADE
);