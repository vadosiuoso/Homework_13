INSERT INTO client (name)
VALUES
    ('Michael'),
    ('Nina'),
    ('Tom'),
    ('Arnold'),
    ('Kristina'),
    ('Alice'),
    ('Adam'),
    ('Roland'),
    ('John'),
    ('Tim');


INSERT INTO planet (id, name)
VALUES
    ('MAR', 'Mars'),
    ('VEN','Venus'),
    ('SAT','Saturn'),
    ('JUP','Jupiter'),
    ('MER','Mercury');


INSERT INTO ticket (client_id, from_planet_id, to_planet_id)
VALUES
    (1, 'MER', 'MAR'),
    (2, 'VEN', 'MAR'),
    (3, 'VEN', 'SAT'),
    (4, 'JUP', 'MER'),
    (5, 'VEN', 'MER'),
    (6, 'JUP', 'MAR'),
    (7, 'SAT', 'JUP'),
    (8, 'SAT', 'VEN'),
    (9, 'MAR', 'MER'),
    (10,'JUP', 'SAT');


