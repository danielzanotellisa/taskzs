CREATE TABLE tasks(
    id TEXT PRIMARY KEY UNIQUE NOT NULL,
    name varchar(100) NOT NULL,
    deadline date NOT NULL,
    created_at timestamp,
    order integer
);