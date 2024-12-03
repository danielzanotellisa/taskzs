CREATE TABLE tasks(
    id TEXT PRIMARY KEY UNIQUE NOT NULL,
    name varchar(100) NOT NULL,
    description varchar(255) not null,
    deadline date NOT NULL,
    created_at timestamp,
    task_order integer
);