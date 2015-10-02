USE myDB;
CREATE TABLE Operating_Systems(OS char(50), version char(20), notes varchar(255), PRIMARY KEY(OS, version));
INSERT INTO Operating_Systems(OS, version, notes)
VALUES('Ubuntu', '12.04', 'laptop VM');
INSERT INTO Operating_Systems(OS, version, notes)
VALUES('Windows', '8.1', 'laptop host');
INSERT INTO Operating_Systems(OS, version, notes)
VALUES('Android', '4.4.4', 'phone');
INSERT INTO Operating_Systems(OS, version, notes)
VALUES('Windows', '7', 'desktop');
