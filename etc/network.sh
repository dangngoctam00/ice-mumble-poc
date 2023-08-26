# use command:
# docker inspect \
#  -f '{{range.NetworkSettings.Networks}}{{.IPAddress}}{{end}}' mumble-server
# to find ip address of container, then replace it with <container_ip>
# to make local environment resolve ip address

sudo ifconfig en0 alias <container_ip> 255.255.255.0

# remove alias: sudo ifconfig en0 -alias <container_ip>