# Weather Scheduler

psql -U postgres
CREATE DATABASE weather;
CREATE USER weather WITH PASSWORD 'weather';
GRANT ALL PRIVILEGES ON DATABASE weather TO weather;
