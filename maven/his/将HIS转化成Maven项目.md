
今天（2016年4月4日15:13:18）试着把HIS项目转换成Maven项目。经过数个小时的奋战，终于完成。
./pom.xml就是转换后的POM文件。另外，需要在WEB-INF/lib目录下导入以下jar文件。
<![CDATA[
	<classpathentry kind="lib" path="src/main/webapp/WEB-INF/lib/json-lib-2.2.2-jdk15.jar"/>
	<classpathentry kind="lib" path="src/main/webapp/WEB-INF/lib/json-lib.jar"/>
	<classpathentry kind="lib" path="src/main/webapp/WEB-INF/lib/mybatis-3.0.5-SNAPSHOT.jar"/>
	<classpathentry kind="lib" path="src/main/webapp/WEB-INF/lib/mybatis-pager-1.0.0.jar"/>
	<classpathentry kind="lib" path="src/main/webapp/WEB-INF/lib/mybatis-spring-1.0.1-SNAPSHOT.jar"/>
	<classpathentry kind="lib" path="src/main/webapp/WEB-INF/lib/mybatis-spring-1.0.1.jar"/>
	<classpathentry kind="lib" path="src/main/webapp/WEB-INF/lib/sqljdbc4.jar"/>
]]>
