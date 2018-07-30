FROM saibalkumarghosh/ubuntuorajdk8latest:v2
EXPOSE 8080 
ADD PciIvr-0.0.1-SNAPSHOT.jar PciIvr-0.0.1-SNAPSHOT.jar
RUN mkdir -p /saplibs
ADD sapidoc3.jar /saplibs/sapidoc3.jar
ADD sapjco3.jar /saplibs/sapjco3.jar
ADD libsapjco3.so /saplibs/libsapjco3.so
ENTRYPOINT ["java","-Dloader.path=/saplibs/","-jar","/PciIvr-0.0.1-SNAPSHOT.jar"]