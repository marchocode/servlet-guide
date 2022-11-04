## Java Servlet

### 定义
Servlet 是一种技术，被用来创建一个JAVA WEB Application.

- 接收请求
  - 从请求中获得数据
  - 处理请求
- 响应请求
  - 写入响应内容

### Java Servlet

实现 `servlet-api` 提供的 Servlet接口，并且重写如下方法，但更好的方式是：继承并重写 `HttpServlet` 用于实现http方式的 请求处理

1. implements Servlet Interface
2. extends GenericServlet
3. extends HttpServlet 接口

```java
public interface Servlet {

    public void init(ServletConfig config);

    public void service(ServletRequest request,ServletResponse response);

    public void destroy();
    
    // ...
}
```

### ServletContext
Servlet上下文，每一个Java Web Application 中有且仅有一个，在war包部署到tomcat等容器之后，读取web.xml. 将所有信息释放到上下文中。
> https://www.javatpoint.com/servletcontext




### Servlet 生命周期
> https://www.javatpoint.com/life-cycle-of-a-servlet

1. 类加载器加载Servlet class
2. 创建Servlet class instance
3. 调用init() 方法初始化
4. 收到请求后进行处理，调用service(-,-)方法
5. 销毁destroy()

### Filter

#### 过滤器能干吗
> https://docs.oracle.com/javaee/6/api/javax/servlet/Filter.html

- 指定请求和响应的编码
- 压缩图片
- 认证
- 指定那些资源可以被访问 那些不能
- token 过滤器

#### 定义一个过滤器

```java
public class HelloServlet extends HttpServlet {
  void init(FilterConfig filterConfig);
  void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException;
  public void destroy();
}
```

#### 过滤器匹配请求


### Web.xml

#### load-on-startup
> If you pass the negative value, servlet will be loaded at request time, at first request.

指定servlet 加载顺序，如果不指定，则默认在首次请求到达的时候才进行初始化Servlet
如果指定：从0开始按照顺序加载，在服务器启动后。



### REFERENCES

- https://docs.oracle.com/javaee/6/api/javax/servlet/Filter.html
- https://developer.mozilla.org/en-US/docs/Web/API/URL_Pattern_API#concepts_and_usage
- https://dotblogs.com.tw/alantsai/2013/10/10/servlet-filter
- https://www.javatpoint.com/life-cycle-of-a-servlet