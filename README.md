# lotus
Build the single javaEE application framework with springMVC,Hibernte, Mybatis and others

# web.xml零配置集成spring mvc
无需再web应用的web.xml文件中配置核心控制器DispatchServlet，以及初始化Spring上下文的ContextLoaderListener。完全使用Java Config和Annotation配置基于Spring框架的web应用。实现Spring提供的WebApplicationInitializer接口，在web容器启动的时候，完成spring框架的初始化工作，如初始化spring和DispatchServlet的上下文，添加DispatchServlet等。

# Spring MVC Jackson配置，Jackson Json数据处理
