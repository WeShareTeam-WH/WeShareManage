### 启动后端项目

```
cd backend

mvn clean package -Dmaven.test.skip

java -jar target/weshare-manage-1.0-SNAPSHOT.jar
```

浏览器打开 http://localhost:8080/swagger-ui.html

### 启动前端项目

```
cd frontend

npm install

# or yarn install

npm run dev
```

浏览器打开 http://localhost:4000
