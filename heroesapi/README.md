# REST API of Heroes using Spring WebFlux, DynamoDB and Docker

## Install AWS CLI

Use [the official documentatation](https://docs.aws.amazon.com/cli/latest/userguide/getting-started-install.html) to install `aws` command line.

For linux use:

```bash
# Install AWS CLI
curl "https://awscli.amazonaws.com/awscli-exe-linux-x86_64.zip" -o "awscliv2.zip"
unzip awscliv2.zip
sudo ./aws/install

# Configure AWS locally
aws configure
# AWS Access Key ID: fakeMyKeyId
# AWS Secret Access Key: fakeSecretAccessKey
# Default region name [None]: us-east-1
# Default output format [None]: json
```

## Using DynamoDB with Docker Compose

```bash
# Create container of DynamoDB 
docker-compose up

# Run container again
docker run -p 8000:8000 amazon/dynamodb-local

# List all tables
aws dynamodb list-tables --endpoint-url http://localhost:8000
```