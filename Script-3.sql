--CREATE EXTENSION pgcrypto

DROP TABLE IF EXISTS accounts;
DROP TABLE IF EXISTS customers CASCADE;
DROP TABLE IF EXISTS employees;
DROP TABLE IF EXISTS admins;

CREATE TABLE customers(
   customerID INT GENERATED ALWAYS AS IDENTITY,
   name VARCHAR(25) NOT NULL,
   PASSWORD VARCHAR(100) NOT NULL,
   username VARCHAR(25) NOT NULL,
   PRIMARY KEY(customerID)
);

CREATE TABLE admins(
	adminID INT GENERATED ALWAYS AS IDENTITY,
	name VARCHAR(25) NOT NULL,
	PASSWORD VARCHAR(100) NOT NULL,
	username VARCHAR(25) NOT NULL,
	PRIMARY KEY(adminID)
);

CREATE TABLE employees(
	employeeID INT GENERATED ALWAYS AS IDENTITY,
	name VARCHAR(25) NOT NULL,
	PASSWORD VARCHAR(100) NOT NULL,
	username VARCHAR(25) NOT NULL,
	PRIMARY KEY(employeeID)
);

CREATE TABLE accounts(
   accountID INT GENERATED ALWAYS AS IDENTITY,
   customerID INT,
   accounttype VARCHAR(25) NOT NULL,
   status VARCHAR(25),
   amount NUMERIC(8,2),
   
  
   PRIMARY KEY(accountID),
   CONSTRAINT fk_customer
      FOREIGN KEY(customerID) 
	  REFERENCES customers(customerID)
	  ON DELETE CASCADE
);

INSERT INTO customers (name, PASSWORD, username) VALUES (
  'pearl',
  crypt('cheer', gen_salt('bf')),
  'dadhater'
);

INSERT INTO accounts (customerid, accounttype, status, amount) VALUES (
1,
'checking',
'open',
30
);

INSERT INTO accounts (customerid, accounttype, status, amount) VALUES (
1,
'savings',
'open',
30
);

INSERT INTO customers (name, PASSWORD, username) VALUES (
  'sandy',
  crypt('acorns', gen_salt('bf')),
  'landlover'
);

INSERT INTO accounts (customerid, accounttype, status, amount) VALUES (
2,
'checking',
'open',
100
);

INSERT INTO accounts (customerid, accounttype, status, amount) VALUES (
2,
'savings',
'open',
100
);

INSERT INTO accounts (customerid, accounttype, status, amount) VALUES (
2,
'investment',
'open',
100
);
INSERT INTO customers (name, PASSWORD, username) VALUES (
  'patrick',
  crypt('password', gen_salt('bf')),
  'patrick'
);

INSERT INTO employees (name, PASSWORD, username) VALUES (
  'squidward',
  crypt('clarinet', gen_salt('bf')),
  'artlover'
);

INSERT INTO employees (name, PASSWORD, username) VALUES (
  'spongebob',
  crypt('gary', gen_salt('bf')),
  'bestcook'
);

INSERT INTO admins (name, PASSWORD, username) VALUES (
  'krabs',
  crypt('money', gen_salt('bf')),
  'eugene'
);
