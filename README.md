### 功能介绍

FuncGPT（慧函数）支持所有类型的Java函数创建。通过自然语言描述Java函数需求，实时生成高质量、高可读性的Java函数代码。生成代码可直接复制到IDEA，或一键导入Java全自动开发工具函数库。

FuncGPT（慧函数）五大能力：

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

对比案例源码：[FuncGPT：BigDecimal表达式运算](https://github.com/feisuanyz/Java-FuncGPT/blob/main/FuncGPT%EF%BC%88%E6%85%A7%E5%87%BD%E6%95%B0%EF%BC%89%E5%AF%B9%E6%AF%94%E6%A1%88%E4%BE%8B%20/FuncGPT%E4%BB%A3%E7%A0%81%EF%BC%9ABigDecimal%E8%A1%A8%E8%BE%BE%E5%BC%8F%E8%BF%90%E7%AE%97.md) | [人工代码：BigDecimal表达式运算](https://github.com/feisuanyz/Java-FuncGPT/blob/main/FuncGPT%EF%BC%88%E6%85%A7%E5%87%BD%E6%95%B0%EF%BC%89%E5%AF%B9%E6%AF%94%E6%A1%88%E4%BE%8B%20/%E4%BA%BA%E5%B7%A5%E4%BB%A3%E7%A0%81%EF%BC%9ABigDecimal%E8%A1%A8%E8%BE%BE%E5%BC%8F%E8%BF%90%E7%AE%97.md)

#### 2. FuncGPT vs 文心一言

|     | FuncGPT（慧函数）                    | 文心一言                                           |
|-----|---------------------------------|------------------------------------------------|
| 时间  | 25秒                             | 1分钟                                            |
| 灵活性 | 灵活性和可扩展性好，使用栈的数据结构来处理表达式中的操作符和数字 | 不够灵活，可扩展性差，使用字符串分割和循环的方式逐步计算表达式|
| 健壮性 | 判断空值，健壮性和可靠性好                | 健壮性差，没有判断空值，存在漏洞                                 |
| 全面性 | 支持处理括号                         | 不支持处理括号                                         |

对比案例源码：[FuncGPT：BigDecimal表达式运算](https://github.com/feisuanyz/Java-FuncGPT/blob/main/FuncGPT%EF%BC%88%E6%85%A7%E5%87%BD%E6%95%B0%EF%BC%89%E5%AF%B9%E6%AF%94%E6%A1%88%E4%BE%8B%20/FuncGPT%E4%BB%A3%E7%A0%81%EF%BC%9ABigDecimal%E8%A1%A8%E8%BE%BE%E5%BC%8F%E8%BF%90%E7%AE%97.md) | [文心一言：BigDecimal表达式运算](https://github.com/feisuanyz/Java-FuncGPT/blob/main/FuncGPT%EF%BC%88%E6%85%A7%E5%87%BD%E6%95%B0%EF%BC%89%E5%AF%B9%E6%AF%94%E6%A1%88%E4%BE%8B%20/%E6%96%87%E5%BF%83%E4%B8%80%E8%A8%80%E4%BB%A3%E7%A0%81%EF%BC%9ABigDecimal%E8%A1%A8%E8%BE%BE%E5%BC%8F%E8%BF%90%E7%AE%97.md)

#### 3. FuncGPT vs ChatGPT-4

|     | FuncGPT（慧函数）                    | ChatGPT-4                                           |
|-----|---------------------------------|------------------------------------------------|
| 时间  | 25秒                             | 21秒                                            |
| 简洁性 | 代码实现清晰明了，将不同的逻辑功能封装成了独立的函数，使得代码的结构更加清晰，易于理解和维护 | 递归实现的过程较为繁琐，容易出错|
| 健壮性 | 健壮性和可靠性好，提供了异常处理机制    | 健壮性不足，没有提供异常处理机制                                |

对比案例源码：[FuncGPT：BigDecimal表达式运算](https://github.com/feisuanyz/Java-FuncGPT/blob/main/FuncGPT%EF%BC%88%E6%85%A7%E5%87%BD%E6%95%B0%EF%BC%89%E5%AF%B9%E6%AF%94%E6%A1%88%E4%BE%8B%20/FuncGPT%E4%BB%A3%E7%A0%81%EF%BC%9ABigDecimal%E8%A1%A8%E8%BE%BE%E5%BC%8F%E8%BF%90%E7%AE%97.md) | [ChatGPT-4：BigDecimal表达式运算](https://github.com/feisuanyz/Java-FuncGPT/blob/main/FuncGPT%EF%BC%88%E6%85%A7%E5%87%BD%E6%95%B0%EF%BC%89%E5%AF%B9%E6%AF%94%E6%A1%88%E4%BE%8B%20/ChatGPT-4%E4%BB%A3%E7%A0%81%EF%BC%9ABigDecimal%E8%A1%A8%E8%BE%BE%E5%BC%8F%E8%BF%90%E7%AE%97.md)

### 使用教程

温馨提示：

a）FuncGPT（慧函数）目前仅支持在SoFlu软件机器人Java全自动开发工具内使用。请下载[Java全自动开发工具](https://download.feisuanyz.com/release-java/SoFlu_Java_Setup_3.0.65.exe)，并完成账户注册；

b）如果您已经登录SoFlu的Java开发工具客户端，签到点击领取FuncGPT慧函数次数，并立即体验FuncGPT慧函数。

#### 1. 自然语言描述Java函数需求生成函数

a）点击主页面上方导航“函数库中心”。

![image](https://github.com/feisuanyz/Java-FuncGPT/assets/79617492/ccef44de-ccd3-4eae-897c-ffa4f597973d)

b）点击右上方“编写函数”，进入WEB-IDE。

![image](https://github.com/feisuanyz/Java-FuncGPT/assets/79617492/83d9d751-a999-42f4-999d-d17d9747ed59)

c）新建一个函数工程。

![image](https://github.com/feisuanyz/Java-FuncGPT/assets/79617492/71448273-2c4b-42e3-8ccc-08c46a15ce0a)

d）填写Java包名和工程目录，并选择“AI生成代码”。

![image](https://github.com/feisuanyz/Java-FuncGPT/assets/79617492/1499b4f8-aa78-4445-a3a9-4de6edf8d41f)

![image](https://github.com/feisuanyz/Java-FuncGPT/assets/79617492/147009e6-89bb-4ba3-bef8-eb7e9e564db1)

e）根据需求填写函数功能内容、类名、高级选项等，点击生成代码。

![image](https://github.com/feisuanyz/Java-FuncGPT/assets/79617492/589b22c9-3c6f-4453-b9ad-0bc0f0bd6608)

提示：a）FuncGPT(示例).java 是 AI 生成的源代码；b）BigDecimalExpressionCalculator.java是用来打包的代码。

#### 2. 一键打包编译上传

a）点击“打开Marven”按钮，进入函数打包。

![image](https://github.com/feisuanyz/Java-FuncGPT/assets/79617492/269f89c2-c362-4349-b36a-0fa8fa9b6304)

b）点击“导入函数到平台”执行打包。

c）等待上传包，并确认上传成功。

![image](https://github.com/feisuanyz/Java-FuncGPT/assets/79617492/50e66be0-2cbe-4486-afb9-68dde02d12e0)

#### 3. 项目中加载慧函数

a）点击导航“项目管理”，回到项目列表页面

b）点击“设置”图标，选择“加载项”

![image](https://github.com/feisuanyz/Java-FuncGPT/assets/79617492/d2e2e47d-ac8c-4cc8-bed4-4f24ac0f8b58)

c）在“加载项”弹出的对话框中，分别选择：函数-自定义，导入刚刚上传的函数

![image](https://github.com/feisuanyz/Java-FuncGPT/assets/79617492/1ebd1d4d-f2d5-4add-ae6f-57b4d9378376)

d）可以在接口模型中使用单函数组调用此函数。
