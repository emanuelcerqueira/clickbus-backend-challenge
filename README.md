# Clickbus Back-end Challenge

## How to run

#### 1. Clone the project
``
git clone https://github.com/emanuelcerqueira/clickbus-backend-challenge.git
``

#### 2. Build the project
``
./mvnw package
``

#### 3. Build image
``
docker build -t clickbus-backend-challenge .
``

#### 4. Run image
``
docker run -p 8080:8080 clickbus-backend-challenge
``
