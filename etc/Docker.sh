# arm architecture
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