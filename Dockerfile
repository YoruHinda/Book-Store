FROM ubuntu:latest
LABEL authors="panda"

ENTRYPOINT ["top", "-b"]