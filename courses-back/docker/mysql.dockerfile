FROM mysql:5.7
ADD db/my.cnf /etc/mysql
ADD db/coursesdb_init.sql /docker-entrypoint-initdb.d/
