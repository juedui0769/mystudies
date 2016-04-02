
#Java
* * *

###sun.misc.*
- 在阅读源码的过程中经常会碰到"sun.misc.*"下面的类，譬如:"sun.misc.Resource","sun.misc.URLClassPath"等。JDK和IDE中常常不包含它们的源码，如果想看看具体的实现，该怎么办呢？
- 在CSDN论坛[sun.misc.Launcher](http://bbs.csdn.net/topics/330202558)找到了答案。
- 帖子中是这样写的：
	> sun.misc.Launcher是 JRE 类库，JDK 的 src 中没有，需要到[下面](http://download.java.net/openjdk/jdk6/)这个地址去下载 OpenJDK 6 的源代码。解压到 %OPENJDK6_HOME% 目录中，sun.misc.Launcher 位于 **%OPENJDK6_HOME%/jdk/src/share/classes/sun/misc** 目录里。
- 补充下openjdk的下载地址: <https://java.net/projects/openjdk6/downloads/>  将其中的**6**换成**7**就是openjdk7的下载地址。


