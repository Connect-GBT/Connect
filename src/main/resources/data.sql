-- Create Users Table
CREATE TABLE IF NOT EXISTS users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    progress INT DEFAULT 0
);

-- Create Psychological Tests Table
CREATE TABLE IF NOT EXISTS psychological_tests (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT NOT NULL,
    question VARCHAR(255),
    answer VARCHAR(255)
);

-- Create Stages Table
CREATE TABLE IF NOT EXISTS stages (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT NOT NULL,
    stage_number INT
);

-- Create Curriculum Table
CREATE TABLE IF NOT EXISTS curriculum (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT NOT NULL,
    goal VARCHAR(255)
);

-- Create Simulations Table
CREATE TABLE IF NOT EXISTS simulations (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT NOT NULL,
    scenario VARCHAR(255),
    response VARCHAR(255)
);

-- Create Chats Table
CREATE TABLE IF NOT EXISTS chats (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT NOT NULL,
    message VARCHAR(255)
);

-- Create Certifications Table
CREATE TABLE IF NOT EXISTS certifications (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT NOT NULL,
    week INT,
    status VARCHAR(255)
);

-- Create Newsletters Table
CREATE TABLE IF NOT EXISTS newsletters (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT NOT NULL,
    date DATE,
    content VARCHAR(255)
);

ALTER TABLE users ADD COLUMN progress INT DEFAULT 0;

-- Insert Data
INSERT INTO users (id, email, password, progress) VALUES (1, 'test@example.com', 'password', 0);
INSERT INTO psychological_tests (id, user_id, question, answer) VALUES (1, 1, 'Question 1', 'Answer 1');
INSERT INTO stages (id, user_id, stage_number) VALUES (1, 1, 1);
INSERT INTO curriculum (id, user_id, goal) VALUES (1, 1, 'Goal 1');
INSERT INTO simulations (id, user_id, scenario, response) VALUES (1, 1, 'Scenario 1', 'Response 1');
INSERT INTO chats (id, user_id, message) VALUES (1, 1, 'Hello');
INSERT INTO certifications (id, user_id, week, status) VALUES (1, 1, 1, 'Completed');
INSERT INTO newsletters (id, user_id, date, content) VALUES (1, 1, '2023-10-01', 'Newsletter Content');