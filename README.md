# devops-backstage
backstage devops sample


## mysql容器创建

docker pull mysql

## my.cnf配置

/home/deploy/mysql_data/test/conf 目录下创建my.cnf,内容如下

```ini

[client] 
default-character-set=utf8mb4 
  
[mysqld]
port=3306
expire_logs_days=7
max_connections = 100
max_user_connections = 20
character-set-server = utf8mb4 
collation-server = utf8mb4_unicode_ci 
init_connect='SET NAMES utf8mb4'
skip-character-set-client-handshake = true 
# 开启慢查询日志
slow_query_log = ON
slow_query_log_file = /var/lib/mysql/localhost-slow.log
long_query_time = 1
# 记录没有使用索引的慢查询
log_queries_not_using_indexes = ON

# mysql8 默认使用“mysql_native_password”插件认证
default_authentication_plugin=mysql_native_password

# 不区分大小写
lower_case_table_names=1
  
[mysql] 
default-character-set = utf8mb4

```

docker run --restart=always --name mysql-test -v /etc/localtime:/etc/localtime -v /home/deploy/mysql_data/test/conf:/etc/mysql/conf.d -v /home/deploy/mysql_data/test/data:/var/lib/mysql -v /home/deploy/mysql_data/test/log:/var/log -p 3306:3306 -e MYSQL_ROOT_PASSWORD=123456 -itd mysql

## springboot镜像生成

mvn clean package -B -e -U -Dmaven.test.skip=true

mvn docker:build

## springboot容器连接mysql容器

docker run --name devops-backstage-test -e ACTIVE=test -p 9090:8080 --link mysql-test:mysql-test -itd devops-backstage


docker run -e 环境变量必须在-p之前，多个环境变量就需要多个-e,否则参数传不进去就会报错