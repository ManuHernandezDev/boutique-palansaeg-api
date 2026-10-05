-- 1. Create table roles
create table roles (
    id serial primary key,
    name varchar(50) not null unique
);
-- 2. Create table users
create table users (
    id serial primary key,
    name varchar(100) not null,
    email varchar(100) not null unique,
    username varchar(50) not null unique,
    password varchar(255) not null,
    role_id INTEGER NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    -- Foreign key constraint
    constraint fk_user_role foreign key (role_id) references roles(id)
);

