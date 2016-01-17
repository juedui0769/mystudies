
* shiro官网
  |- http://shiro.apache.org/

* 中文介绍
  |- 
  |- http://www.ibm.com/developerworks/cn/web/wa-apacheshiro/
  |- 
  |- * http://www.docin.com/p-265759178.html
  |- 
  |- 
  |- 
  |- 

* 一些概念
  |- * http://www.docin.com/p-265759178.html
  |- 
  |- shiro是三个核心组件: Subject, SecurityManager 和 Realms.
  |- 
  |- Subject: 即"当前操作用户". 不仅仅指人,也可以是第三方进程,后台账户或其他类似事物. 
    它仅仅意味着"当前跟软件交互的东西".
  |- 
  |- SecurityManager: 门面模式.
  |- 
  |- Realm: 当用户执行认证(登录)和授权(访问控制)验证时,Shiro会从应用配置的Realm中查找用户及其权限信息.
    |- Realm实质上是一个安全相关的DAO,它封装了数据源的连接细节.
    |- Shiro 内置了可以连接大量安全数据源(又名目录)的Realm. 如: LDAP, 关系数据库(JDBC),
      类似INI的文本配置资源,以及属性文件等.
  |- 
  |- 
  |- 
  |- 
  |- 


