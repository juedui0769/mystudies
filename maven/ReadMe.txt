
* Maven4.0 Xml Schema 的地址:
  |- 
  |- http://maven.apache.org/xsd/maven-4.0.0.xsd
  |- 
  |- 
  |- 
  |- 

* 在xsd中搜索下面code能找到'Dependency'中能够包含的所有元素.
  |- 
  |- <xs:complexType name="Dependency">
  |- 
  |- type : pom, jar, maven-plugin, ejb, ejb3, war, rar, par, java-source, javadoc, ejb-client, test-jar
  |- 参考 http://maven.apache.org/ref/3.3.9/maven-core/artifact-handlers.html
  |- 或参考: 当前目录(或子目录)下的 001_maven-core_artifact-handlers.html
  |- 
  |- type的值只能写一个,默认是jar. 不能写成 <type>jar,java-source</type> .
  |- 
  |- 
  |- 
  |- 

* Maven 源码阅读
  |- 
  |- 官网下载地址只提供 bin, src 的压缩包下载.貌似没有带doc的压缩包下载.
  |- 
  |- 解压src会看到有很多子目录. 如下: 
apache-maven, maven-aether-provider, maven-artifact, maven-compat, 
maven-core, maven-embedder, maven-model, maven-model-builder, 
maven-plugin-api, maven-repository-metadata, maven-settings, 
maven-settings-builder, src
  |- 
  |- 打开任何文件夹都有 pom.xml 文件. 从中可以看到很多有用的信息. maven-core下还有test
  |- 
  |- 
  |- 
  |- 
  |- 
  |- 
  |- 
  |- 
  |- 
  |- 
  |- 
  |- 
  |- 
  |- 
  |- 



