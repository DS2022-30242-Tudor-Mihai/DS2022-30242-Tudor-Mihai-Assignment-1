INSERT INTO users(id, username, password, role)
VALUES (1, 'mihai', '$2a$12$szRFkhD0Ov8RUXLscMS7teoXXDmfszQuso9t5ByX00ToPSDu7ezMi',
        'administrator') ON CONFLICT DO NOTHING;

INSERT INTO users(id, username, password, role)
VALUES (2, 'raluca', '$2a$12$tZGqj3FEVGEDOrunXeKd5eM0Ssej5b0kdsQCXEv3vjwoKLYZZiKVy', 'client') ON CONFLICT DO NOTHING;

INSERT INTO device
VALUES (1, 'Strada Dambovitei, nr.42', 'Domiciliu', 200, 2) ON CONFLICT DO NOTHING;

INSERT INTO reading
VALUES (1, 22, '2022-12-22 00:00:00', 1) ON CONFLICT DO NOTHING;
INSERT INTO reading
VALUES (2, 55, '2022-12-22 01:00:00', 1) ON CONFLICT DO NOTHING;
INSERT INTO reading
VALUES (3, 24, '2022-12-22 02:00:00', 1) ON CONFLICT DO NOTHING;
INSERT INTO reading
VALUES (4, 11, '2022-12-22 03:00:00', 1) ON CONFLICT DO NOTHING;
INSERT INTO reading
VALUES (5, 54, '2022-12-22 04:00:00', 1) ON CONFLICT DO NOTHING;
INSERT INTO reading
VALUES (6, 73, '2022-12-22 05:00:00', 1) ON CONFLICT DO NOTHING;
INSERT INTO reading
VALUES (7, 10, '2022-12-22 06:00:00', 1) ON CONFLICT DO NOTHING;
INSERT INTO reading
VALUES (8, 2, '2022-12-22 07:00:00', 1) ON CONFLICT DO NOTHING;
INSERT INTO reading
VALUES (9, 34, '2022-12-22 08:00:00', 1) ON CONFLICT DO NOTHING;
INSERT INTO reading
VALUES (10, 23, '2022-12-22 09:00:00', 1) ON CONFLICT DO NOTHING;
INSERT INTO reading
VALUES (11, 26, '2022-12-22 10:00:00', 1) ON CONFLICT DO NOTHING;
INSERT INTO reading
VALUES (12, 46, '2022-12-22 11:00:00', 1) ON CONFLICT DO NOTHING;
INSERT INTO reading
VALUES (13, 64, '2022-12-22 12:00:00', 1) ON CONFLICT DO NOTHING;
INSERT INTO reading
VALUES (14, 39, '2022-12-22 13:00:00', 1) ON CONFLICT DO NOTHING;
INSERT INTO reading
VALUES (15, 74, '2022-12-22 14:00:00', 1) ON CONFLICT DO NOTHING;
INSERT INTO reading
VALUES (16, 44, '2022-12-22 15:00:00', 1) ON CONFLICT DO NOTHING;
INSERT INTO reading
VALUES (17, 55, '2022-12-22 16:00:00', 1) ON CONFLICT DO NOTHING;
INSERT INTO reading
VALUES (18, 66, '2022-12-22 17:00:00', 1) ON CONFLICT DO NOTHING;
INSERT INTO reading
VALUES (19, 45, '2022-12-22 18:00:00', 1) ON CONFLICT DO NOTHING;
INSERT INTO reading
VALUES (20, 22, '2022-12-22 19:00:00', 1) ON CONFLICT DO NOTHING;
INSERT INTO reading
VALUES (21, 34, '2022-12-22 20:00:00', 1) ON CONFLICT DO NOTHING;
INSERT INTO reading
VALUES (22, 52, '2022-12-22 21:00:00', 1) ON CONFLICT DO NOTHING;
INSERT INTO reading
VALUES (23, 33, '2022-12-22 22:00:00', 1) ON CONFLICT DO NOTHING;
INSERT INTO reading
VALUES (24, 11, '2022-12-22 23:00:00', 1) ON CONFLICT DO NOTHING;