#!/bin/bash -e

### Download Keycloak

cd /opt/jboss/

keycloakDistFile="/opt/jboss/keycloak_install_stage/downloads/$KEYCLOAK_DIST_FILE"
keycloakDistUrl="$KEYCLOAK_DIST_BASE$KEYCLOAK_DIST_FILE"

if [ -e $keycloakDistFile ];
then
    echo "Keycloak from downloads folder: $keycloakDistFile"
    tar zxf $keycloakDistFile
else
    echo "Keycloak from remote source: $keycloakDistUrl"
    curl -L $keycloakDistUrl | tar zx
fi

mv /opt/jboss/keycloak-??.?.?* ${KEYCLOAK_HOME}
rm ${keycloakDistFile}

### Install CT Providers

cp /opt/jboss/keycloak_install_stage/keycloak_providers/*.jar /opt/jboss/keycloak/providers

ls -laR /opt/jboss/keycloak/providers

### Install Theme

#mkdir -p /opt/jboss/keycloak/themes
#cp -R /opt/jboss/keycloak_install_stage/themes/* /opt/jboss/keycloak/themes

### Cleanup

rm -rf /opt/jboss/keycloak_install_stage

### Build Keycloak

dos2unix /opt/jboss/tools/*

/opt/jboss/keycloak/bin/kc.sh build
