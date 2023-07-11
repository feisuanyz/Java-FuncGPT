## 函数开发说明

### 1. 函数定义

函数是实现某个功能的语句块的集合。

### 2. 函数设计原则
为了开发出满足特定功能的组件，用户需要先了解组函数的设计原则，主要分为以下六点： 

#### 2.1 通用功能
对重复出现、有相似性的通用功能编写成函数，便于重复使用。 

#### 2.2 不依赖特定环境
函数运行环境基于JDK版本，可能运行的环境包括各种操作系统，功能不能只适配某特定环境，应适应多种目标环境。 

#### 2.3 单一职责原则
最好保持函数的原子性，一个函数只完成1个功能，这样有利于后期的扩展。 

#### 2.4 最佳实践
采取最优策略来实现功能，不能为了追求开发速度，牺牲函数的性能。 

#### 2.5 健壮性
函数应用到平台后，会运行在各类复杂环境，在异常处理中需充分考虑，返回合理的异常。 

#### 2.6 质量与安全
需确保函数代码及引用的相关JAR包，均通过了相关漏洞测试，安全审核；在代码质量上起码要达到平台要求，同时追求高质量代码。

### 3. 函数开发
#### 3.1 开发步骤
#### 3.1.1 自定义函数

前提条件：自定义函数需要下载Demo工程包和开发辅助工具，其中：1）函数Demo工程包下载地址为 https://www.feisuanyz.com/fsimage/gj-image/demo-function.zip ；2）在全自动开发平台中，单击图1-1所示右上角，下载开发辅助工具。

![1-1](https://images.gitee.com/uploads/images/2021/0906/153449_b401dcd8_8721401.png "1-1.png")
##### 图1-1 下载开发辅助工具

#### a）对自定义函数注释注解

注意：由于函数是一个工具类，所以函数里面的方法需要全部定义为静态公有的（` Public Static `）。

在定义函数的时候必须要为所定义的每一个函数编写注释，这是通过专门的注释注解来完成的。之所以要这样，是因为源码中虽然有Java Doc注释，但是编译后的` Class `文件中是获取不到这些注释信息的，因此为了从` Class `文件中获取注释且避免采用额外的DB来保存这些注释信息，故而采用注解的方式来保存注释信息是最行之有效的方式，且简单不需要做其他额外的事情。

注释注解定义有2个，两者需要结合起来使用，它们被定义在` flow-core-cmptJar `包中，因此定义函数时导入此Jar包即可。


##### MethodDesc
` com.feisuanyz.flow.core.cmpt.annotation.function.MethodDesc `
```
/* 
 * All rights Reserved, Designed By www.feisuanyz.com
 * @title     MethodDesc.java   
 * @package   com.feisuanyz.flow.core.cmpt.annotation.function   
 * @version   V1.0 
 * @copyright 2020 www.feisuanyz.com Inc. All rights reserved.
*/
package com.feisuanyz.flow.core.cmpt.annotation.function;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**   
 * <p>
 *   函数(方法)信息描述注解
 * <p>
 * 	用来对类中的方法(函数)进行描述。
 * 
 * @author 飞算云智
 * @date yyyy-mm-dd HH:mm
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface MethodDesc {
    
    /** 
     * <p>
     * 	 方法描述
     * </p>
     * @return String 
     */
    String desc();
    
    /** 
     * <p>
     * 	 参数描述信息列表
     * </p>
     * @return ParamDesc[] 
     */
    ParamDesc[] params();

}
```

##### ParamDesc
` com.feisuanyz.flow.core.cmpt.annotation.function.ParamDesc `
```
/* 
 * All rights Reserved, Designed By www.feisuanyz.com
 * @title     ParamDesc.java   
 * @package   com.feisuanyz.flow.core.cmpt.annotation.function   
 * @version   V1.0 
 * @copyright 2020 www.feisuanyz.com Inc. All rights reserved. 
 */
package com.feisuanyz.flow.core.cmpt.annotation.function;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**   
 * <p>
 *   函数参数描述注解
 * <p>
 * 	用来对函数中的参数进行描述。
 * 
* @author 飞算云智
 * @date yyyy-mm-dd HH:mm
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface ParamDesc {

    /** 
     * <p>
     * 	 参数名称
     * </p>
     * @return String 
     */
    String name();
    
    /** 
     * <p>
     * 	 参数描述
     * </p>
     * @return String 
     */
    String desc();
}
```

##### 使用示例
```
/* 
 * All rights Reserved, Designed By www.feisuanyz.com
 * @title     Calculator.java   
 * @package   com.feisuanyz.ops.function  
 * @version   V1.0 
 * @copyright 2020 
 */
package com.feisuanyz.ops.function;

import com.feisuanyz.flow.core.cmpt.annotation.function.MethodDesc;
import com.feisuanyz.flow.core.cmpt.annotation.function.ParamDesc;

/**   
 * <p>
 *   计算器
 * </p>
* @author 飞算云智
 * @date yyyy-mm-dd HH:mm
 */
public final class Calculator {
    
    private Calculator() {
    }
    
    /** 
     * <p>
     * 	 两个数相加
     * </p>
     * @param a
     * @param b
     * @return int 
     */
    @MethodDesc(desc = "两个数相加", params = {
        @ParamDesc(name = "a", desc = "参数a"),
        @ParamDesc(name = "b", desc = "参数b")
    })
    public static int add(int a, int b) {
        return a + b;
    }
    
    /** 
     * <p>
     * 	 两个数相减
     * </p>
     * @param a
     * @param b
     * @return int 
     */
    @MethodDesc(desc = "两个数相减", params = {
        @ParamDesc(name = "a", desc = "参数a"),
        @ParamDesc(name = "b", desc = "参数b")
    })
    public static int subtract(int a, int b) {
        return a - b;
    }

```

#### b）编写XML定义文件

函数的定义需要按照以下` xml `格式进行描述，然后存放到项目中的` resources `目录下名为` functions.xml `的文件中，并一起打成Jar包上传到平台即可。


注意：


目前如果某个函数类不用了，` XML `定义文件中配置的类信息以及函数类Java源文件不能删除，还是要继续保留着，不然上传Jar包时检查不通过会报错——会检查DB中此Jar包上一个版本包含的类数量和正在上传版本中所配置的类数量是否匹配（是否匹配是通过` name `属性来判断的，` name `属性值相同则认为DB中的类还存在于正在上传Jar包的配置中，否则认为不存在）。所以最好不要修改` name `属性的值。

` XML `文件示例如下：
```
<?xml version="1.0" encoding="UTF-8"?>
<functions>
<!-- Explain: 函数信息XML定义 
    name: 函数名称 (函数名称只能以大写英文开头，包含英文、数字 、下划线 1-50位)
    classpath: 函数类路径 (不能为空)
    desc: 函数描述 (不能为空)
-->
<function name="Fun_Calculator" classpath="com.feisuanyz.ops.function.Calculator" desc="计算器" />
<function name="Fun_Validator" classpath="com.feisuanyz.ops.function.Validator" desc="验证器" />
</functions>
```

#### c）配置Jar包依赖

在定义函数时，函数Jar包的` pom `文件中所依赖的第三方Jar包必须遵守以下约定：

c1）引用` flow-core-cmpt `Jar包时，必须为其指定范围为` provided `，因为系统在启动时也会自动依赖此Jar包，因此用户定义的Jar包只要能够解决编译依赖即可，不需要强行引入。如果强行引入，那么在函数Jar包导入时在对函数上面的注释注解进行校验检查时则会报错，无法识别，检查不通过。

正确的示例如下：
```
<dependency>
     <groupId>com.feisuanyz.flow</groupId>
     <artifactId>flow-core-cmpt</artifactId>
     <version>${version}</version>
     <scope>provided</scope>
     <systemPath>${开发辅助工具路径}/flow-core-cmpt-${version}.jar</systemPath>
</dependency>
```

c2）引用的所有Jar包都必须明确为其指定版本号，不然在对函数进行校验检查时可能会报` java.lang.ClassNotFoundException `问题。也可以将Jar包的版本号配置在 `<properties>xxx</properties> `节点中，然后引用。

正确的示例如下：
```
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <groupId>com.feisuanyz.ops</groupId>
    <artifactId>jar-fdops-fun</artifactId>
    <packaging>jar</packaging>
    <name>jar-fdops-fun</name>
    <description>Function Jar</description>

    <properties>
        <java.version>1.8</java.version>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <flow-core-cmpt.version>2.0.26</flow-core-cmpt.version>
    </properties>

    <dependencies>
        <dependency>
            <groupId>com.feisuanyz.flow</groupId>
            <artifactId>flow-core-cmpt</artifactId>
            <version>${flow-core-cmpt.version}</version>
            <scope>provided</scope>
        </dependency>
    </dependencies>

    <build>
  <plugins>
    <plugin>
      <groupId>org.apache.maven.plugins</groupId>
      <artifactId>maven-jar-plugin</artifactId>
    </plugin>
  </plugins>
</build>
</project>
```

d）编译Jar包

由于在使用时要获取所定义函数及其参数的注释信息，而每个参数的注释信息是通过反射机制从` Method `对象中获取到其参数列表，然后和注释注解` ParamDesc `中定义的参数名来进行匹配的，因此编译后的` Class `文件中必须要包含方法的参数信息。

d1）查看` Class `文件中是否有参数信息的命令。

` javap -v xxx.class `

![2-1](https://images.gitee.com/uploads/images/2021/0906/154908_2ce30595_8721401.png "2-1.png")
##### 图2-1 查看是否有参数信息

d2）如果编译后的` Class `文件中没有方法的参数信息，那么就需要对IDE进行相关的设置，以确保其在编译时能够生成方法的参数信息。

##### Eclipse配置如图2-2所示：

![2-2](https://images.gitee.com/uploads/images/2021/0906/155150_93a968ff_8721401.png "2-2.png")
##### 图2-2 Eclipse配置

##### IntelliJ IDEA配置如图2-3所示：

需要在IDEA中配置一下，让其编译时生成方法的参数` -parameters `。

![2-3](https://images.gitee.com/uploads/images/2021/0906/155346_4f58b9bf_8721401.png "2-3.png")
##### 图2-3 IDEA中配置

e）设置pom文件编译选项

正确的示例如下：
```
<build>
      <plugins>
      	<plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-compiler-plugin</artifactId>
            <version>3.3</version>
            <configuration>
                <source>1.8</source>
                <target>1.8</target>
                <compilerArgs>
                    <arg>-parameters</arg>
                </compilerArgs>
            </configuration>
        </plugin>
      </plugins>
    </build>
```

f）对自定义的函数打jar包，生成如下类似文件
```
demo-function-1.0.0.jar
demo-function-1.0.0.pom
```

g）将生成的` demo-function-1.0.0.jar `和` demo-function-1.0.0.pom `压缩成一个` zip `包上传到平台即可。

#### 3.2 导入自定义函数

前提条件：您需要拥有“函数库中心”模块的权限，且权限由系统管理员在“用户权限中心”系统中配置。

a）选择“函数库中心”，系统显示“函数库中心”页面，如图3-1所示。

![3-1](https://images.gitee.com/uploads/images/2021/0906/160742_9c7cd921_8721401.png "3-1.png")
##### 图3-1 函数库中心

b）在“函数库中心”区域，单击“导入”，系统显示“导入函数”页面，如图3-2所示:

![3-2](https://images.gitee.com/uploads/images/2021/0906/161021_5d93498d_8721401.png "3-2.png")
##### 图3-2 导入函数

c）单击“选择文件”添加需要导入系统的jar包。

d）单击“确定”。
   

系统提示“操作成功”。

#### 函数库使用说明点击此处[下载](https://www.feisuanyz.com/fsimage/zc-image/%E5%85%A8%E8%87%AA%E5%8A%A8%E5%BC%80%E5%8F%91%E5%B9%B3%E5%8F%B0%E5%87%BD%E6%95%B0%E5%BA%93_%E4%BD%BF%E7%94%A8%E8%AF%B4%E6%98%8E%E4%B9%A6-v1.1-(%E5%AF%B9%E5%A4%96%E5%85%AC%E5%BC%80).pdf)
