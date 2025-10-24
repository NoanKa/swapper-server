#!/bin/bash

generate_random_password() {
    tr -dc 'A-Za-z0-9' < /dev/urandom | head -c 16
}

if [ -f .env ] ; then
    echo ".env file already exists. Skipping environment variable setup."
else
    echo "Creating .env file with default values."

    # --- Generate passwords ---
    REDIS_PASSWORD=$(generate_random_password)
    POSTGRES_PASSWORD=$(generate_random_password)
    POSTGRES_USER="admin"
    POSTGRES_DB="swapper"
    RABBITMQ_DEFAULT_PASS=$(generate_random_password)
    RABBITMQ_DEFAULT_USER="admin"
    RABBITMQ_DEFAULT_VHOST="/"
    SEQ_FIRSTRUN_ADMINUSERNAME="admin"
    SEQ_FIRSTRUN_ADMINPASSWORD=$(generate_random_password)
    SEQ_FIRSTRUN_ADMINPASSWORDHASH=$(echo "$SEQ_FIRSTRUN_ADMINPASSWORD" | docker run --rm -i datalust/seq:2025 config hash)
    SEQ_FIRSTRUN_APIKEY=$(generate_random_password)
    SEQ_FIRSTRUN_APIKEYSCOPES="Ingest"
    ACCEPT_EULA="Y"

    # --- Docker Compose service hostnames & ports ---
    POSTGRES_HOST="postgres"
    POSTGRES_PORT=5432
    REDIS_HOST="redis"
    REDIS_PORT=6379
    RABBITMQ_HOST="rabbit"
    RABBITMQ_PORT=5672
    RABBITMQ_MANAGEMENT_PORT=15672
    SEQ_HOST="seq"
    SEQ_PORT=5341
    SEQ_WEB_PORT=5342

    # --- Write .env file ---
    cat > .env <<EOL
# --- Redis ---
REDIS_HOST=$REDIS_HOST
REDIS_PORT=$REDIS_PORT
REDIS_PASSWORD=$REDIS_PASSWORD

# --- Database ---
POSTGRES_HOST=$POSTGRES_HOST
POSTGRES_PORT=$POSTGRES_PORT
POSTGRES_USER=$POSTGRES_USER
POSTGRES_PASSWORD=$POSTGRES_PASSWORD
POSTGRES_DB=$POSTGRES_DB

# --- RabbitMQ ---
RABBITMQ_HOST=$RABBITMQ_HOST
RABBITMQ_PORT=$RABBITMQ_PORT
RABBITMQ_MANAGEMENT_PORT=$RABBITMQ_MANAGEMENT_PORT
RABBITMQ_DEFAULT_USER=$RABBITMQ_DEFAULT_USER
RABBITMQ_DEFAULT_PASS=$RABBITMQ_DEFAULT_PASS
RABBITMQ_DEFAULT_VHOST=$RABBITMQ_DEFAULT_VHOST

# --- Seq ---
SEQ_HOST=$SEQ_HOST
SEQ_PORT=$SEQ_PORT
SEQ_WEB_PORT=$SEQ_WEB_PORT
SEQ_FIRSTRUN_ADMINUSERNAME=$SEQ_FIRSTRUN_ADMINUSERNAME
SEQ_FIRSTRUN_ADMINPASSWORD=$SEQ_FIRSTRUN_ADMINPASSWORD
SEQ_FIRSTRUN_ADMINPASSWORDHASH=$SEQ_FIRSTRUN_ADMINPASSWORDHASH
ACCEPT_EULA=$ACCEPT_EULA
SEQ_FIRSTRUN_APIKEY=$SEQ_FIRSTRUN_APIKEY
SEQ_FIRSTRUN_APIKEYSCOPES=$SEQ_FIRSTRUN_APIKEYSCOPES
EOL

    echo ".env file has been created with default values."
fi

docker compose up -d

echo
read -r -p "Press Enter to continue..." _
