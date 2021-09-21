# 注册登录

## 需求分析

输入验证码，前端发送登录注册请求。如果数据库用户不存在，则注册，最终也需要跳转首页。如果数据库用户存在，则登录跳转首页。

## 数据库表

![62475453234](assets/1624754532343.png)

用户表：根据手机号码查询用户表 用户是否存在

用户表：如果用户不存在，插入记录

用户信息表：当新用户注册，会跳转用户信息页面，保存用户信息（性别 昵称 出生年月日 城市 头像）

![image-20210627173925660](/Users/liufan/Library/Application Support/typora-user-images/image-20210627173925660.png)

## 消费编码

1.  tanhua_server工程中接收请求 phone verificationCode

2. controllere调用service业务层

   a.根据手机号作为key查询redis验证码是否存在

   b.验证码不存在，说明验证码失效了

   c.验证码存在，校验验证码

   d.校验验证码失败了，说明验证码错误

   f.验证码校验成功了，说明登录成功了

   g.调用服务提供者：根据手机号码查询tb_user表 看用户是否存在

   h.如果用户存在**，则生成token存入redis**

   j.如果用户不存在，保存用户:服务提供者保存用户，**则生成token存入redis**

## 服务提供者编码

**昨天已经实现**

1. 根据手机号码查询tb_user表 看用户是否存在
2. 保存用户

## 测试

1. 测试用户已经注册-直接跳转首页
2. 测试用户未注册的-跳转完善个人信息页面



## 生成Token写入redis

登录成功后，需要做的事

**1.什么是token?**

字符串（令牌） 为了做登录功能 固定格式 a.b.c

eyJhbGciOiJIUzI1NiJ9.eyJtb2JpbGUiOiIxMjM0NTc4OSIsImlkIjoiMiJ9.VivsfLzrsKFOJo_BdGIf6cKY_7wr2jMOMOIGaFt_tps

**2.为什么用token?**

之前如何实现登录功能？cookie+session

当前探花前后端分离项目 可不可以使用cookie+session?  不可以，原因 cookie不能跨域  session共享登录信息很麻烦

token将用户信息保存在客户端（app端）

**3.怎么用token?**

```
builder():生成token  parser():校验token是否正确
```





# 今日内容介绍

![62475904133](assets/1624759041333.png)

# 阿里云OSS使用说明

```
Endpoint：oss-cn-shenzhen.aliyuncs.com
bucket:mytanhua113
url:mytanhua113.oss-cn-shenzhen.aliyuncs.com
```

![62475945136](assets/1624759451360.png)

为AK SK授权OSS功能

![62475996036](assets/1624759960367.png)



# 百度人脸识别使用说明

```
AppID：24447715
API Key：PLuQZEvOD6dmny7WZrGZMNcz
Secret Key：gsqWgxxULsaMwOldrxXozTGWs8T7C0PK 
```

# 完善个人信息（重点）

## 需求分析

输入正确的验证码，当前用户是新用户，会跳转完善个人信息页面。

个人信息：性别、昵称、出生年月日、城市 点击“设置头像”保存个人信息

点击“设置头像” 拍照（头像），进行人脸识别 并上传OSS   更新个人信息 头像

## 数据库表

tb_user_info：保存用户个人信息 

tb_user_info：更新用户个人信息 的头像

## 消费者编码分析

新用户---1填写资料

1. controller接收完善个人信息请求，

2. controller调用service业务处理

   判断Token是否存在（是否登录了？）

   调用服务提供者保存用户个人信息



新用户---2选取头像

1. controller接收头像图片请求

2. controller调用service业务处理

   a.判断Token是否存在（是否登录了？）

   b校验token

   c.人脸识别 调用百度云组件

   d.上传头像 调用阿里云OSS组件

   f.更新用户头像

## 服务提供者编码分析

1. 服务提供者：保存用户个人信息
2. 服务提供者：更新用户个人信息的头像



## 课堂提问

```
为什么使用vo?
* 1.让请求响应对象（app对应）  跟  数据库操作对象 解耦
* 2.通过vo可以严格按照前端需要的数据封装

copy工具类
BeanUtils.copyProperties(userInfoVo,userInfo);

1.将需要copy对象中属性 跟 目标对象的属性 一样的数据 copy过去
2.一般将copy代码放到最前面
```

## 测试

![62476649234](assets/1624766492347.png)

![62476654639](assets/1624766546398.png)





# 查询用户信息

## 需求分析

点击“我的” 展示当前用户的个人信息

## 数据库表

tb_userinfo:查询

## 消费者编码分析

1. controller接收请求 参数userID huanxinID

2. controller调用service业务处理

   a.判断Token是否存在(判断是否登录了)

   b.调用服务提供者：根据当前用户id查询tb_userInfo数据

   c.得到UserInfo后将数据copy到UserInfoVO中

   d.返回UserInfoVo

## 服务提供者编码分析

1. 服务提供者：根据当前用户id查询tb_userInfo数据



# 更新用户信息

## 需求分析

点击“编辑” 修改用户头像 生日 性别 等等 每个信息修改都会发送修改请求

## 数据库表

tb_userInfo ：修改

## 消费者编码分析

1. controller接收请求  参数 @RequestBody UserInfoVo 

2. controller调用service业务处理

   a.判断Token是否存在(判断是否登录了)

   b.调用服务提供者：根据当前用户id更新tb_userInfo数据

   c.如果更新了生日，需要同步更新年龄字段

## 服务提供者编码分析

1. 调用服务提供者：根据当前用户id更新tb_userInfo数据



## Rest API

请求方式：get post put delete 等

需求：根据用户id查询用户对象

以前：get  http://localhost:8080/findById?userId=1

现在：get  http://localhost:8080/findById/1   此处用@PathVariable 接收地址栏参数值

请求体参数使用 @RequestBody

# 获取token代码太冗余

解决：抽取公共方法  还存在问题？  拦截器（在进入controller之前拦截）



# token续期

1天内如果有操作app,以最后操作的时间 往后延长1天。



# created与updated统一处理

1. 删除了User UserInfo中created与updated
2. 创建BasePoJo 让User UserInfo继承BasePoJo
3. 创建MyMetaObjectHandler自定义填充处理类，针对插入（created updated）  更新(updated)数据填充
4. 将dubbo服务工程中之前手动设置时间代码删除





# 作业

1. 更新用户头像（作业）



# 总结

![62478130942](assets/1624781309424.png)