CREATE TABLE room(
    id VARCHAR(50) PRIMARY KEY NOT NULL ,
    title VARCHAR(30),
    reserve_info VARCHAR(50),
    active BOOL DEFAULT FALSE,
    vacancy BOOL DEFAULT FALSE,
    room_type ENUM('SINGLE','DOUBLE','TWIN','TRIPLE','QUAD')
);