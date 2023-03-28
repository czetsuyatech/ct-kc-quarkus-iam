#!/bin/bash -e

set -eou pipefail

# Saves the value of an environment variable into a file. Use by Docker's secrets.
# Usage: file_env VAR [DEFAULT]
#    ie: file_env 'DB_PASSWORD' 'secret'
#        Will save the value 'secret' into DB_PASSWORD_FILE file.
file_env() {
  local var="$1"
  local fileVar="${var}_FILE"
  local def="${2:-}"

  if [[ ${!var:-} && ${!fileVar:-} ]]; then
    echo >&2 "error: both $var and $fileVar are set (but are exclusive)"
    exit 1
  fi

  local val="$def"
  if [[ ${!var:-} ]]; then
    val="${!var}"
  elif [[ ${!fileVar:-} ]]; then
    val="$(<"${!fileVar}")"
  fi

  if [[ -n $val ]]; then
    export "$var"="$val"
  fi

  unset "$fileVar"
}

### Import Realm

#exec /opt/keycloak/bin/kc.sh import --file "/opt/keycloak/data/import/ct-realm-prod.json"

KEYCLOAK_ARGS=""

exec /opt/keycloak/bin/kc.sh start-dev
exit $?
