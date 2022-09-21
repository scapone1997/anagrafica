# MySQL con Docker

Pullare immagine mysql

`docker pull mysql`

Eseguire un container contenente un database:

`docker run --name universita -e MYSQL_ROOT_PASSWORD=ciao -d --publish 3306:3306 mysql`

Entrare dentro container mysql

`docker exec -it <num_container> bash`

Mostrare MySQL Console

`mysql -uroot -p<password>`
