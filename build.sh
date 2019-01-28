cd backend && mvn clean package -Dmaven.test.skip

cd ../

cd frontend && yarn install && npm run build

cd ../

docker-compose up -d --build
