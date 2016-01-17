
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
