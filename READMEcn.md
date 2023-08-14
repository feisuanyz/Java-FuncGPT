### 功能介绍

语言: [中文](https://github.com/feisuanyz/Java-FuncGPT/blob/main/READMEcn.md) | [English](https://github.com/feisuanyz/Java-FuncGPT/blob/main/README.md)

FuncGPT（慧函数）支持所有类型的Java函数创建。通过自然语言描述Java函数需求，实时生成高质量、高可读性的Java函数代码。生成代码可直接复制到IDEA，或一键导入Java全自动开发工具函数库。

#### FuncGPT（慧函数）五大能力

● 自然语言：通过自然语言即可生成函数，降低软件开发门槛。

● 秒级函数开发：全自动秒级开发函数，秒级完成，效率千倍提升。

● 一站式函数开发应用：函数生成即可直接应用，效率、安全有保障。

● 质量可靠：生成的函数代码符合业界规范、具备良好的可读性，符合最优解。

● 灵活生成：可以根据开发人员的具体需求生成并支持调整和修改。

![image](https://github.com/feisuanyz/Java-FuncGPT/assets/79617492/41b74106-e4c1-4f13-b1e9-91c9fc069913)

### 对比测试

测试案例：BigDecimal表达式运算

#### 1. FuncGPT vs 人工代码

|     | FuncGPT（慧函数）                | 人工代码                               |
|-----|-----------------------------|------------------------------------|
| 时间  | 23秒                         | 7天                                 |
| 可读性 | 可读性好，命名合理，注释简洁清晰            | 读性差，命名不规范，注释不清晰                   |
| 简洁性 | 算法简洁，使用了合适的数据结构和算，避免了复杂的嵌套逻辑和多重判断 | 简洁性差，代码层层嵌套，方法繁琐，不利于后期维护修改 |
| 健壮性 | 判断空值，健壮性和可靠性好            | 健壮性差，没有判断空值，存在漏洞                     |

对比案例源码：[FuncGPT：BigDecimal表达式运算](https://github.com/feisuanyz/Java-FuncGPT/blob/main/Test%20Case%20Src/Java%20FuncGPT%3A%20BigDecimal%20Expression%20Calculation.md) | [人工代码：BigDecimal表达式运算](https://github.com/feisuanyz/Java-FuncGPT/blob/main/Test%20Case%20Src/Manual%20Code%3A%20BigDecimal%20Expression%20Calculation.md)

#### 2. FuncGPT vs 文心一言

|     | FuncGPT（慧函数）                    | 文心一言                                           |
|-----|---------------------------------|------------------------------------------------|
| 时间  | 25秒                             | 1分钟                                            |
| 灵活性 | 灵活性和可扩展性好，使用栈的数据结构来处理表达式中的操作符和数字 | 不够灵活，可扩展性差，使用字符串分割和循环的方式逐步计算表达式|
| 健壮性 | 判断空值，健壮性和可靠性好                | 健壮性差，没有判断空值，存在漏洞                                 |
| 全面性 | 支持处理括号                         | 不支持处理括号                                         |

对比案例源码：[FuncGPT：BigDecimal表达式运算](https://github.com/feisuanyz/Java-FuncGPT/blob/main/Test%20Case%20Src/Java%20FuncGPT%3A%20BigDecimal%20Expression%20Calculation.md) | [文心一言：BigDecimal表达式运算](https://github.com/feisuanyz/Java-FuncGPT/blob/main/Test%20Case%20Src/ERNIE%20Bot%3A%20BigDecimal%20Expression%20Calculation.md)

#### 3. FuncGPT vs ChatGPT-4

|     | FuncGPT（慧函数）                    | ChatGPT-4                                           |
|-----|---------------------------------|------------------------------------------------|
| 时间  | 25秒                             | 21秒                                            |
| 简洁性 | 代码实现清晰明了，将不同的逻辑功能封装成了独立的函数，使得代码的结构更加清晰，易于理解和维护 | 递归实现的过程较为繁琐，容易出错|
| 健壮性 | 健壮性和可靠性好，提供了异常处理机制    | 健壮性不足，没有提供异常处理机制                                |

对比案例源码：[FuncGPT：BigDecimal表达式运算](https://github.com/feisuanyz/Java-FuncGPT/blob/main/Test%20Case%20Src/Java%20FuncGPT%3A%20BigDecimal%20Expression%20Calculation.md) | [ChatGPT-4：BigDecimal表达式运算](https://github.com/feisuanyz/Java-FuncGPT/blob/main/Test%20Case%20Src/ChatGPT-4%3A%20BigDecimal%20Expression%20Calculation.md)

#### 温馨提示

a）使用慧函数前，请确保已安装SoFlu软件机器人Java全自动开发工具，并已完成账户注册；

b）如果您已经登录SoFlu的Java开发工具客户端，签到点击领取FuncGPT慧函数次数，并立即体验FuncGPT慧函数。

#### 一、自然语言描述Java函数需求生成函数

#### 1. 点击主页面上方导航“函数库中心”。

![image](https://github.com/feisuanyz/Java-FuncGPT/assets/79617492/99b37a57-9c76-473d-920e-4d27e00106e1)

#### 2. 点击右上方“编写函数”，进入WEB-IDE。

![image](https://github.com/feisuanyz/Java-FuncGPT/assets/79617492/061075ef-1ba4-4526-8e2a-a7f242918546)

#### 3. 新建一个函数工程。

![image](https://github.com/feisuanyz/Java-FuncGPT/assets/79617492/35df2257-dd3f-4d38-8546-f1294acf2377)

#### 4. 填写Java包名和工程目录，并选择“AI生成代码”。

![image](https://github.com/feisuanyz/Java-FuncGPT/assets/79617492/afbce353-f016-4e76-ac02-ef35a987d161)

![image](https://github.com/feisuanyz/Java-FuncGPT/assets/79617492/5a74d9dc-ffe6-417a-be99-b535e0ec5c32)

#### 5.根据需求填写函数功能内容、类名、高级选项等，点击生成代码。

![image](https://github.com/feisuanyz/Java-FuncGPT/assets/79617492/f9942010-e251-452c-9d83-f99b06981544)

#### 提示

a）FuncGPT(示例).java 是 AI 生成的源代码；

b）BigDecimalExpressionCalculator.java是用来打包的代码。

#### 二、一键打包编译上传

#### 1. 点击“打开Maven”按钮，进入函数打包。

![image](https://github.com/feisuanyz/Java-FuncGPT/assets/79617492/2310e385-c78f-484e-ae28-8de3b45efebb)

#### 2. 点击“导入函数到平台”执行打包。

#### 3. 等待上传包，并确认上传成功。

![image](https://github.com/feisuanyz/Java-FuncGPT/assets/79617492/0086e37c-a21f-4308-a092-55017ea23e63)

### 三、项目中加载慧函数

#### 1. 点击导航“项目管理”，回到项目列表页面

#### 2. 点击“设置”图标，选择“加载项”

![image](https://github.com/feisuanyz/Java-FuncGPT/assets/79617492/9840c616-c823-41f9-8115-cbf252a35afa)

#### 3. 在“加载项”弹出的对话框中，分别选择：函数-自定义，导入刚刚上传的函数

![image](https://github.com/feisuanyz/Java-FuncGPT/assets/79617492/7a113fa1-2669-42ab-9e59-965941ed8ce9)

#### 4. 可以在接口模型中使用单函数组调用此函数。
