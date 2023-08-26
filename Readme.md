# Mumble Java ICE - POC

Sample project using java and ice to connect api exposed by [Mumble library](https://github.com/mumble-voip/mumble).

## Ice
```shell
  slice2java MumbleServer.ice -I /opt/homebrew/Cellar/ice/3.7.9/share/ice/slice
```

## Mumble server
For simplicity, use docker to run mumble server. 
```shell
    docker run --detach \
        --name mumble-server \
        --expose 6502 \
        --hostname mumble-server \
        --publish 64738:64738/tcp \
        --publish 64738:64738/udp \
        --publish 6502:6502/tcp \
        --publish 6502:6502/udp \
        --volume ./:/data \
        --restart on-failure \
        --env MUMBLE_CUSTOM_CONFIG_FILE=/data/murmur.ini \
        akito13/murmur:latest
```
Because Mumble use IP address to keep connection between server and client, so we have to create alias ip address in local machine
by this command: 
```shell
  sudo ifconfig en0 alias <container_ip> 255.255.255.0
```

Get ip address of container by this command:
```shell
    docker inspect \
        -f '{{range.NetworkSettings.Networks}}{{.IPAddress}}{{end}}' mumble-server
```