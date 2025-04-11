INSERT INTO role (name) VALUES ('ROLE_ETUDIANT');
INSERT INTO role (name) VALUES ('ROLE_SECRETAIRE');
INSERT INTO role (name) VALUES ('ROLE_ADMIN');

-- Ajout d'un utilisateur admin par défaut
INSERT INTO app_user (email, password, role_id) VALUES (
    'admin@afitech.com',
    '$2a$10$NVM0n8ElaRgg7zWO1CxUdeiBPv8IZHXgZ2YtD2A.F6GJ3c9JYq3aK',
    (SELECT id FROM role WHERE name = 'ROLE_ADMIN')
);
