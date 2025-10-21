#!/bin/bash

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
    ACCEPT_EULA="Y"
    SEQ_FIRSTRUN_APIKEY=$(generate_random_password)
    SEQ_FIRSTRUN_APIKEYSCOPES="Ingest"

    OS=$(uname | tr '[:upper:]' '[:lower:]')
    if [ "$OS" = "darwin" ]; then
      SEQ_FIRSTRUN_ADMINPASSWORDHASH=$(docker run --rm epicsoft/bcrypt hash "$SEQ_ADMIN_PASSWORD" | base64 -b 0)
    else
      SEQ_FIRSTRUN_ADMINPASSWORDHASH=$(docker run --rm epicsoft/bcrypt hash "$SEQ_ADMIN_PASSWORD" | base64 | tr -d '\n')
    fi

cat > .env <<EOL
# --- Redis ---
REDIS_PASSWORD=$REDIS_PASSWORD
# --- Database ---
POSTGRES_USER=$POSTGRES_USER
POSTGRES_PASSWORD=$POSTGRES_PASSWORD
POSTGRES_DB=$POSTGRES_DB
# --- RabbitMQ ---
RABBITMQ_DEFAULT_USER=$RABBITMQ_DEFAULT_USER
RABBITMQ_DEFAULT_PASSW=$RABBITMQ_DEFAULT_PASS
RABBITMQ_DEFAULT_VHOST=$RABBITMQ_DEFAULT_VHOST
# --- Seq ---
SEQ_FIRSTRUN_ADMINUSERNAME=$SEQ_FIRSTRUN_ADMINUSERNAME
SEQ_FIRSTRUN_ADMINPASSWORDHASH=$SEQ_FIRSTRUN_ADMINPASSWORDHASH
ACCEPT_EULA=$ACCEPT_EULA
SEQ_FIRSTRUN_APIKEY=$SEQ_FIRSTRUN_APIKEY
SEQ_FIRSTRUN_APIKEYSCOPES=$SEQ_FIRSTRUN_APIKEYSCOPES
EOL

    echo ".env file has been created with default values."
fi

docker compose up -d

echo "SEQ_FIRSTRUN_ADMINPASSWORD=$SEQ_FIRSTRUN_ADMINPASSWORD" >> .env

echo
read -r -p "Press Enter to continue..." _