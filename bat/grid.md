### Create grid network ###

```batch
docker network create grid
```

### Run grid hub ###

```batch
docker run -d -p 4444:4444 --net grid --name selenium-hub selenium/hub:3.8.1-francium  
```

### Run chrome node ###

```batch
docker run -d --net grid -e HUB_HOST=selenium-hub -v /dev/shm:/dev/shm selenium/node-chrome:3.8.1-francium
```

### Run tests on grid ###

```batch
mvn clean verify -DokLogin="***" -DokPass="***" -Dwebdriver.remote.url=http://localhost:4444/wd/hub -Dwebdriver.remote.driver=chrome -Dit.test="ui/**/*.java"
```

### Removes the grid network ###

```batch
docker network rm grid
```
