#!/bin/bash

if [ -f .env ] ; then
    echo ".env file already exists. Skipping environment variable setup."
    else
    echo "Creating .env file with default values."

    generate_random_password() {
    tr -dc 'A-Za-z0-9' < /dev/urandom | head -c 16
    }

    REDIS_PASSWORD=$(generate_random_password)
    POSTGRES_PASSWORD=$(generate_random_password)
    RABBITMQ_DEFAULT_PASS=$(generate_random_password)
    RABBITMQ_DEFAULT_USER="admin"
    POSTGRES_USER="admin"
    POSTGRES_DB="swapper"
    RABBITMQ_DEFAULT_VHOST="/"
    SEQ_FIRSTRUN_ADMINUSERNAME="admin"
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
ACCEPT_EULA=$ACCEPT_EULA
SEQ_FIRSTRUN_APIKEY=$SEQ_FIRSTRUN_APIKEY
SEQ_FIRSTRUN_APIKEYSCOPES=$SEQ_FIRSTRUN_APIKEYSCOPES
EOL

    echo ".env file has been created with default values."
fi

docker-compose up -d