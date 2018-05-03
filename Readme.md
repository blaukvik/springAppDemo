#Mitt springboot demoprosjekt

har prøvd springboot diverse features

##Todo:
custom Errorpages
changelog i flere filer er bedre for lesbarhet i db

#java 10

Logging


## database entites
Repository for student klasse

###Liquibase changelog
delt i flere filer

###hsql profil

###mysql 
Start docker med:
 > docker run -p 3306:3306 --name minMySql -e MYSQL_ROOT_PASSWORD=myp -e MYSQL_DATABASE=demo -d mysql
  
Log inn i docker: 
 > docker exec -it minMySql mysql -uroot -p


## metrics
Diverse metrics og Timed annoteringer
Satt opp en prometheus til å skrape, samt en grafana til å vise...
- prometheus kjører på 9090 med en av
    - Downloads/prometheus-2.2.1.darwin-amd64/prometheus     
    - docker run -p 9090:9090 prom/prometheus
- grafana på http://localhost:3000/login ( admin/admin)


## controllers
Demo

## swagger
Annotert ++


# java 10
Illegal reflective action:
--add-opens java.base/java.lang=ALL-UNNAMED