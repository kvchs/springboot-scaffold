# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.3.0.BUILD-SNAPSHOT/maven-plugin/)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.2.3.RELEASE/reference/htmlsingle/#boot-features-developing-web-applications)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)


### 生成个性化图标
http://www.network-science.de/ascii/

### Mybatis查询Mysql datetime类型时，相差8小时
https://blog.csdn.net/a549654065/article/details/88664077  
mysql使用系统默认时区，东八区  
Tomcat使用UTC时区进行处理业务逻辑  
时区不同，导致mysql数据库中的datetime类型查询后的值转到Java Bean时，多了8小时  
解决方案： jdbc:mysql://localhost:3306/dcoj?serverTimezone=Asia/Shanghai  

### 事务的传播性
PROPAGATION_REQUIRED  0  当前有事务就用当前的，没有就用新的    
PROPAGATION_SUPPORTS  1  事务可有可无，不是必须的  
PROPAGATION_MANDATORY  2  当前一点要有事务，不然就抛异常  
PROPAGATION_REQUIRES_NEW  3  无论是否有事务，都起个新的事务  
PROPAGATION_NOT_SUPPORTED  4  不支持事务，按非事务方式运行  
PROPAGATION_NEVER  5 不支持事务，如果有事务则抛出异常  
PROPAGATION_NESTED  6  当前有事务就在当前事务里再起一个事务  
### mybatis中的一些小常识：
1.mybatis的update语句返回的并不是受影响的行数！！返回的是匹配的行数，有可能出现返回值为1，但数据库中记录未发生变化的情况。  
解决方案：在数据库连接url后缀追加userAffectRows=true  
userAffectRows：表示是否用受影响的行数替代匹配查找到的行数来返回数据，也就是查找到了，但不一定真正修改了，在mysql中默认设置为false,所以这里把这个字段设置为true，返回受影响的行数即可；  

2.mybatis执行insert后的方法返回值并不是新增记录的主键！！！！在MyBatis中执行添加操作时只会返回当前添加的记录数。  
