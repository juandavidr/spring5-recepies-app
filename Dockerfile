# Upgrading system
FROM centos
# install java 11
RUN	yum -y update && \
	yum -y install java-11-openjdk java-11-openjdk-devel

# create temp volume
VOLUME /tmp
# copy springboot app to docker image
ADD /target/recepies-0.0.1-SNAPSHOT.jar myapp.jar
# update resources date
RUN sh -c 'touch /myapp.jar'
# run the jar
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/myapp.jar"]