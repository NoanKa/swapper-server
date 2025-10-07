#!/bin/bash

generate_sha256_hash() {
  local password=$1
  local os
  os=$(uname)

  if [[ "$os" == "Darwin" || "$os" == "Linux" ]]; then
    echo -n "$password" | sha256sum | awk '{print $1}'
  elif [[ "$os" == "CYGWIN"* || "$os" == "MINGW"* || "$os" == "MSYS"* ]]; then
    # Create a temp file since certutil can't hash stdin
    local tmpfile
    tmpfile=$(mktemp)
    echo -n "$password" > "$tmpfile"
    certutil -hashfile "$tmpfile" SHA256 | grep -v -i "certutil" | grep -E "^[0-9A-F]+$"
    rm -f "$tmpfile"
  else
    echo "Unsupported OS"
    exit 1
  fi
}

generate_random_password() {
    tr -dc 'A-Za-z0-9' < /dev/urandom | head -c 16
}

if [ -f .env ] ; then
    echo ".env file already exists. Skipping environment variable setup."
    else
    echo "Creating .env file with default values."

    REDIS_PASSWORD=$(generate_random_password)
    POSTGRES_PASSWORD=$(generate_random_password)
    RABBITMQ_DEFAULT_PASS=$(generate_random_password)
    RABBITMQ_DEFAULT_USER="admin"
    POSTGRES_USER="admin"
    POSTGRES_DB="swapper"
    RABBITMQ_DEFAULT_VHOST="/"
    SEQ_FIRSTRUN_ADMINUSERNAME="admin"
    SEQ_FIRSTRUN_ADMINPASSWORD=$(generate_random_password)
    SEQ_FIRSTRUN_ADMINPASSWORDHASH=$(generate_sha256_hash "$SEQ_FIRSTRUN_ADMINPASSWORD")
    ACCEPT_EULA="Y"
    SEQ_FIRSTRUN_APIKEY=$(generate_random_password)
    SEQ_FIRSTRUN_APIKEYSCOPES="Ingest"


cat > .env <<EOL
REDIS_PASSWORD=$REDIS_PASSWORD
POSTGRES_USER=$POSTGRES_USER
POSTGRES_PASSWORD=$POSTGRES_PASSWORD
POSTGRES_DB=$POSTGRES_DB
RABBITMQ_DEFAULT_USER=$RABBITMQ_DEFAULT_USER
RABBITMQ_DEFAULT_PASSW=$RABBITMQ_DEFAULT_PASS
RABBITMQ_DEFAULT_VHOST=$RABBITMQ_DEFAULT_VHOST
SEQ_FIRSTRUN_ADMINUSERNAME=$SEQ_FIRSTRUN_ADMINUSERNAME
SEQ_FIRSTRUN_ADMINPASSWORD=$SEQ_FIRSTRUN_ADMINPASSWORD
SEQ_FIRSTRUN_ADMINPASSWORDHASH=$SEQ_FIRSTRUN_ADMINPASSWORDHASH
ACCEPT_EULA=$ACCEPT_EULA
SEQ_FIRSTRUN_APIKEY=$SEQ_FIRSTRUN_APIKEY
SEQ_FIRSTRUN_APIKEYSCOPES=$SEQ_FIRSTRUN_APIKEYSCOPES
EOL

    echo ".env file has been created with default values."
fi

docker-compose up -d