-- Create Users Table
CREATE TABLE IF NOT EXISTS users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nickname VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    progress INT DEFAULT 0
    );

-- Create Psychological Tests Table
CREATE TABLE IF NOT EXISTS psychological_tests (
                                                   id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                                   user_id BIGINT NOT NULL,
                                                   question VARCHAR(255),
    answer VARCHAR(255),
    FOREIGN KEY (user_id) REFERENCES users(id)
    );

-- Create Stage Tests Table
CREATE TABLE IF NOT EXISTS stage_tests (
                                           id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                           user_id BIGINT NOT NULL,
                                           stage_number INT,
                                           test_result VARCHAR(255),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(id)
    );

-- Create Stages Table
CREATE TABLE IF NOT EXISTS stages (
                                      id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                      user_id BIGINT NOT NULL,
                                      stage_number INT,
                                      FOREIGN KEY (user_id) REFERENCES users(id)
    );

-- Create Curriculum Table
CREATE TABLE IF NOT EXISTS curriculum (
                                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                          user_id BIGINT NOT NULL,
                                          goal VARCHAR(255),
    FOREIGN KEY (user_id) REFERENCES users(id)
    );

-- Create Curriculum Progress Table
CREATE TABLE IF NOT EXISTS curriculum_progress (
                                                   id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                                   user_id BIGINT NOT NULL,
                                                   curriculum_id BIGINT NOT NULL,
                                                   progress INT,
                                                   FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (curriculum_id) REFERENCES curriculum(id)
    );

-- Create Simulations Table
CREATE TABLE IF NOT EXISTS simulations (
                                           id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                           user_id BIGINT NOT NULL,
                                           scenario VARCHAR(255),
    response VARCHAR(255),
    FOREIGN KEY (user_id) REFERENCES users(id)
    );

-- Create AI Chat Logs Table
CREATE TABLE IF NOT EXISTS ai_chat_logs (
                                            id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                            user_id BIGINT NOT NULL,
                                            role VARCHAR(50),
    content TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(id)
    );

-- Create Certifications Table
CREATE TABLE IF NOT EXISTS certifications (
                                              id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                              user_id BIGINT NOT NULL,
                                              week INT,
                                              status VARCHAR(255),
    FOREIGN KEY (user_id) REFERENCES users(id)
    );

-- Create Newsletters Table
CREATE TABLE IF NOT EXISTS newsletters (
                                           id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                           user_id BIGINT NOT NULL,
                                           date DATE,
                                           content VARCHAR(255),
    FOREIGN KEY (user_id) REFERENCES users(id)
    );

-- Create Matchings Table
CREATE TABLE IF NOT EXISTS matchings (
                                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                         user_id BIGINT NOT NULL,
                                         matched_user_id BIGINT NOT NULL,
                                         created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                         FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (matched_user_id) REFERENCES users(id)
    );

-- Create External Institutions Table
CREATE TABLE IF NOT EXISTS external_institutions (
                                                     id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                                     name VARCHAR(255) NOT NULL,
    description TEXT,
    link VARCHAR(255)
    );

-- Create Resume Table
CREATE TABLE IF NOT EXISTS resume (
                                      id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                      user_id BIGINT NOT NULL,
                                      content TEXT,
                                      edited_content TEXT,
                                      submit_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                      edit_date TIMESTAMP,
                                      FOREIGN KEY (user_id) REFERENCES users(id)
    );
