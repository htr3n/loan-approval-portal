
-- initializing some roles
INSERT INTO Role (roleName) VALUES ('Manager');
INSERT INTO Role (roleName) VALUES ('Supervisor');
INSERT INTO Role (roleName) VALUES ('Post Processing Clerk');
INSERT INTO Role (roleName) VALUES ('Credit Broker');

-- and some staff
INSERT INTO Staff (staffId, firstName, lastName, password)
VALUES ('gerald', 'Gerald', 'Manager', 'abcd1234');

INSERT INTO Staff (staffId, firstName, lastName, password)
VALUES ('james', 'James', 'Supervisor', 'abcd1234');

INSERT INTO Staff (staffId, firstName, lastName, password)
VALUES ('david', 'David', 'Clerk', 'abcd1234');

INSERT INTO Staff (staffId, firstName, lastName, password)
VALUES ('bryan', 'Bryan', 'Broker', 'abcd1234');

INSERT INTO Customer (firstName, lastName, pin, income, email)
VALUES ('Alice', 'Power', 'abcd1234', '80000', 'power@abc.com');