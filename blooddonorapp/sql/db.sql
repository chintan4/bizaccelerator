DROP TABLE Registration;
DROP TABLE MyDonations;
DROP TABLE RequestStatus;
DROP TABLE ReqStatusMapping;
DROP TABLE ReqDonorMapping;
DROP TABLE RequestDetails;
DROP TABLE BloodGroup;


CREATE TABLE BloodGroup (id INTEGER PRIMARY  KEY, bloodGroup VARCHAR(6));
INSERT INTO BloodGroup VALUES (1, "A +ve");
INSERT INTO BloodGroup VALUES (2, "A -ve");
INSERT INTO BloodGroup VALUES (3, "AB +ve");
INSERT INTO BloodGroup VALUES (4, "AB -ve");
INSERT INTO BloodGroup VALUES (5, "B +ve");
INSERT INTO BloodGroup VALUES (6, "B -ve");
INSERT INTO BloodGroup VALUES (7, "O +ve");
INSERT INTO BloodGroup VALUES (8, "O -ve");

CREATE TABLE Registration (id INTEGER PRIMARY KEY, userId VARCHAR(10), firstName VARCHAR(20), lastName VARCHAR(20), 
 						DOB DATE, city VARCHAR(50), bloodGroupId INTEGER, email VARCHAR(320), phoneNumber VARCHAR(20), 
						registrationDate DATE, FOREIGN KEY(bloodGroupId) REFERENCES BloodGroup(id) );
						
CREATE TABLE RequestDetails(id INTEGER PRIMARY KEY, donationDate DATE, bloodGroupId INTEGER, quantity INTEGER, place VARCHAR(50), 
							requestId VARCHAR(10), FOREIGN KEY(bloodGroupId) REFERENCES BloodGroup(id));
							
CREATE TABLE MyDonations (id INTEGER PRIMARY KEY, userId VARCHAR(10), donationDate DATE, place VARCHAR(50), Organiaztion VARCHAR(50));

CREATE TABLE ReqStatusMapping (id INTEGER PRIMARY KEY, requesterStatus VARCHAR(20));
INSERT INTO ReqStatusMapping VALUES(1, "IN PROGRESS");
INSERT INTO ReqStatusMapping VALUES(2, "AGREED");
INSERT INTO ReqStatusMapping VALUES(3, "FULFILLED");  

CREATE TABLE RequestStatus(id INTEGER PRIMARY KEY, requestId INTEGER, reqStatusCode INTEGER, 
							FOREIGN KEY (requestId) REFERENCES RequestDetails(ID), FOREIGN KEY (reqStatusCode) REFERENCES
							ReqStatusMapping(id) );
							
CREATE TABLE ReqDonorMapping(id INTEGER PRIMARY KEY, requestId INTEGER, donorId VARCHAR(10), 
							FOREIGN KEY (requestId) REFERENCES RequestDetails(id));