#################################################################
#####                 Build ct-keycloak-quarkus-iam                 #####
#################################################################

FROM eclipse-temurin:17.0.6_10-jre as builder

### ------------------------- Environment Variables ------------------------- ###

ENV KEYCLOAK_VERSION 21.0.1
ENV JDBC_MYSQL_VERSION 8.0.29

ENV LAUNCH_JBOSS_IN_BACKGROUND 1
ENV PROXY_ADDRESS_FORWARDING false
ENV JBOSS_HOME /opt/jboss/keycloak
ENV LANG en_US.UTF-8
ENV KEYCLOAK_IMPORT /opt/jboss/keycloak_install_stage/realms/ct-realm-dev-${KEYCLOAK_VERSION}.json

### ------------------------- Bash Arguments ------------------------- ###

ARG KEYCLOAK_DIST_BASE=https://github.com/keycloak/keycloak/releases/download/$KEYCLOAK_VERSION/
ARG KEYCLOAK_DIST_FILE=keycloak-$KEYCLOAK_VERSION.tar.gz
ARG JDBC_MYSQL_JAR_BASE=https://repo1.maven.org/maven2/mysql/mysql-connector-java/$JDBC_MYSQL_VERSION/
ARG JDBC_MYSQL_JAR_FILE=mysql-connector-java-$JDBC_MYSQL_VERSION.jar

### ------------------------- Base ------------------------- ###

USER root

# Install the necessary packages

RUN apt-get update \
    && apt-get install -y --no-install-recommends \
        apt-transport-https ca-certificates curl jsvc unzip \
# git
        git \
# procps : for 'free' command
        procps \
# iptools-ping : for 'ping' command
#        iptools-ping \
# iproute2 : for 'ip' command
        iproute2 \
# java.lang.UnsatisfiedLinkError: /usr/local/openjdk-11/lib/libfontmanager.so: libfreetype.so.6: cannot open shared object file: No such file or directory
# java.lang.NoClassDefFoundError: Could not initialize class sun.awt.X11FontManager
# https://github.com/docker-library/openjdk/pull/235#issuecomment-424466077
        fontconfig libfreetype6 \
    && apt-get autoremove -y && rm -rf /var/lib/apt/lists/*

### ------------------------- Configurations ----------------------------- ###

RUN mkdir /opt/jboss

ADD src/main/resources/tools /opt/jboss/tools
RUN chmod +x /opt/jboss/tools/*

ADD downloads /opt/jboss/keycloak_install_stage/downloads

ADD target/keycloak_providers /opt/jboss/keycloak_install_stage/keycloak_providers

### ------------------------- Build Keycloak ----------------------------- ###

RUN /opt/jboss/tools/build-keycloak.sh

### ------------------------- Start Keycloak ------------------------- ###

FROM eclipse-temurin:17.0.6_10-jre
COPY --from=builder /opt/jboss/ /opt/jboss/

RUN groupadd -r jboss -g 1000 \
    && useradd -u 1000 -r -g jboss -m -d /opt/jboss -s /sbin/nologin -c "JBoss User" jboss \
    && chown -R jboss:jboss /opt/jboss \
    && chmod -R g+rw /opt/jboss

USER jboss

# Ensure signals are forwarded to the JVM process correctly for graceful shutdown
ENV LAUNCH_JBOSS_IN_BACKGROUND true

# Expose Keycloak ports
EXPOSE 8080
EXPOSE 8443
EXPOSE 9990

ENTRYPOINT [ "/opt/jboss/tools/docker-entrypoint.sh" ]

CMD ["-b", "0.0.0.0"]
