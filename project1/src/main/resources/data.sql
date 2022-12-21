INSERT INTO users(id, username, password, role)
VALUES (1,'Mihai', '$2a$12$szRFkhD0Ov8RUXLscMS7teoXXDmfszQuso9t5ByX00ToPSDu7ezMi', 'administrator') ON CONFLICT DO NOTHING;

INSERT INTO users(id, username, password, role)
VALUES (2,'Raluca' , '$2a$12$nlmPaUOLzhRDiJjlTmVSh.gDJbtuQum1hKNP6.S.9R7XZ2H.rCMam', 'client')  ON CONFLICT DO NOTHING;