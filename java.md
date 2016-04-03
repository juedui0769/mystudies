
#Java
* * *

####sun.misc.*
- 在阅读源码的过程中经常会碰到"sun.misc.*"下面的类，譬如:"sun.misc.Resource","sun.misc.URLClassPath"等。JDK和IDE中常常不包含它们的源码，如果想看看具体的实现，该怎么办呢？
- 在CSDN论坛[sun.misc.Launcher](http://bbs.csdn.net/topics/330202558)找到了答案。
- 帖子中是这样写的： sun.misc.Launcher是 JRE 类库，JDK 的 src 中没有，需要到[下面](http://download.java.net/openjdk/jdk6/)这个地址去下载 OpenJDK 6 的源代码。解压到 %OPENJDK6_HOME% 目录中，sun.misc.Launcher 位于 **%OPENJDK6_HOME%/jdk/src/share/classes/sun/misc** 目录里。
- 补充下openjdk的下载地址: <https://java.net/projects/openjdk6/downloads/>  将其中的**6**换成**7**就是openjdk7的下载地址。

####slf4j,log4j
在网上拷贝项目或他人代码来学习时，有时会碰到slf4j/log4j的一些问题。下面罗列我碰到的一些情况。
- 项目中没有导入slf4j-log4j-xxx.jar。如果出现这种情况，控制台会有提示：see <http://www.slf4j.org/codes.html#StaticLoggerBinder>。
- 没有配置log4j.properties文件。see <http://logging.apache.org/log4j/1.2/faq.html#noconfig>。
- log4j.properties文件放置位置不正确。如果是eclipse中，可以建立一个资源目录"resources"来放置log4j.properties文件。注意：在eclipse中，放置在"java"资源目录和放置在"test"资源目录效果是不同的。放置在test下是没效果的。（这可能是IDE的设置）
- 如果从其他地方拷贝了log4j.properties文件，要注意日志级别。特别是"threshold"，我曾碰到过这种情况，拷贝的配置文件中"log4j.threshold = WARN"，然后死活得不到输出，还以为是jar包缺少和配置文件放置不正确的问题，结果换了配置文件就正常了。然后才发现是"threshold"级别设置过高导致的。






