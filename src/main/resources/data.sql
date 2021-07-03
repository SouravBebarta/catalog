CREATE TABLE IF NOT EXISTS tblcategory (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS tblcategory_attributes (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  attribute VARCHAR(50) NOT NULL,
  category_id integer NOT NULL,
  CONSTRAINT fk_tblcategory_attributes_tblcategory FOREIGN KEY (category_id) REFERENCES tblcategory (id)
);

CREATE TABLE IF NOT EXISTS tblproduct (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  productName VARCHAR(50) NOT NULL,
  category_id integer NOT NULL,
  attributes text NOT NULL,
  CONSTRAINT fk_tblcategory_attributes_tblcategory FOREIGN KEY (category_id) REFERENCES tblcategory (id)
);