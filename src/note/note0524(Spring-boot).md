# Spring-Boot
## Spring Boot、Spring MVC 和 Spring 有什么区别？
## 什么是Spring-Boot
spring boot来简化spring应用开发，约定大于配置，去繁从简，just run就能创建一个独立的，产品级别的应用
## Spring Boot有哪些优点？ 
   * -快速创建独立运行的spring项目与主流框架集成 
   * -使用嵌入式的servlet容器，应用无需打包成war包 
   * -starters自动依赖与版本控制 
   * -大量的自动配置，简化开发，也可修改默认值 
   * -准生产环境的运行应用监控 
   * -与云计算的天然集成
   
## RequestMapping 和 GetMapping 的不同之处在哪里？
   * RequestMapping 具有类属性的，可以进行 GET,POST,PUT 或者其它的注释中具有的请求方法。
   * GetMapping 是 GET 请求方法中的一个特例。它只是 ResquestMapping 的一个延伸，目的是为了提高清晰度。

## 如何重新加载Spring Boot上的更改，而无需重新启动服务器？ 
    这可以使用DEV工具来实现。通过这种依赖关系，您可以节省任何更改，嵌入式tomcat将重新启动。 
    Spring Boot有一个开发工具（DevTools）模块，它有助于提高开发人员的生产力。Java开发人员面临的一个主要挑战是将文件更改自动部署到服务器并自动重启服务器。 
    开发人员可以重新加载Spring Boot上的更改，而无需重新启动服务器。这将消除每次手动部署更改的需要。Spring Boot在发布它的第一个版本时没有这个功能。 
    这是开发人员最需要的功能。DevTools模块完全满足开发人员的需求。该模块将在生产环境中被禁用。它还提供H2数据库控制台以更好地测试应用程序。 ‘
    
## Spring Boot中的监视器是什么？ 
   * Spring boot actuator是spring启动框架中的重要功能之一。
   * Spring boot监视器可帮助您访问生产环境中正在运行的应用程序的当前状态。 
   * 有几个指标必须在生产环境中进行检查和监控。
   * 即使一些外部应用程序可能正在使用这些服务来向相关人员触发警报消息。
   * 监视器模块公开了一组可直接作为HTTP URL访问的REST端点来检查状态。
   
## 什么是YAML？ 
   * YAML是一种人类可读的数据序列化语言。它通常用于配置文件。 
   * 与属性文件相比，如果我们想要在配置文件中添加复杂的属性，YAML文件就更加结构化，而且更少混淆。可以看出YAML具有分层配置数据。
   
## springboot自动配置的原理 
   * 在spring程序main方法中 添加@SpringBootApplication或者@EnableAutoConfiguration 
   * 会自动去maven中读取每个starter中的spring.factories文件 
   * 该文件里配置了所有需要被创建spring容器中的bean