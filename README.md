How to run sitespeed.io locally:
`docker run --shm-size 2g --rm -v "/c:/src/sakila:/sitespeed.io/sitespeed-result/:rw" sitespeedio/sitespeed.io:26.1.0 -b firefox http://host.docker.internal:8081/mvc/ui/payments`  
https://www.sitespeed.io/documentation/sitespeed.io/docker/#more-about-volumes
https://www.sitespeed.io/documentation/sitespeed.io/installation/
