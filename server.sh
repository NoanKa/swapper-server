#!/bin/bash

# Check if the .env file already exists
if [ -f .env ]; then
    echo ".env file already exists. Skipping environment variable setup."
else
    echo "Creating .env file with default values."

    # Generate random 16-character alphanumeric password for Redis, PostgreSQL, and RabbitMQ
    generate_random_password() {
        tr -dc 'A-Za-z0-9' </dev/urandom | head -c 16
    }

    REDIS_PASSWORD=$(generate_random_password)
    POSTGRES_PASSWORD=$(generate_random_password)
    RABBITMQ_PASSWORD=$(generate_random_password)
    RABBITMQ_USER="admin"
    POSTGRES_USER="admin"
    POSTGRES_DB="swapper"
    RABBITMQ_VHOST="/"

    # Create .env file with automatically generated values
    cat > .env <<EOL
# Automatically generated .env file
REDIS_PASSWORD=$REDIS_PASSWORD
POSTGRES_USER=$POSTGRES_USER
POSTGRES_PASSWORD=$POSTGRES_PASSWORD
POSTGRES_DB=$POSTGRES_DB
RABBITMQ_USER=$RABBITMQ_USER
RABBITMQ_PASSWORD=$RABBITMQ_PASSWORD
RABBITMQ_VHOST=$RABBITMQ_VHOST
EOL

    # Inform user about the generated .env file
    echo ".env file has been created with default values."
fi

# Run docker-compose up if .env exists or after it's created
docker-compose up -d
