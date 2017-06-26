# Android模块化拆分示例
适用于想要模块化自己的应用，在开发一个完整应用的同时还可以将其中的部分提供成SDK供别的应用使用

## 目的
模块间最大可能的解耦，依赖动态配置，application依赖模块的实现后模块自动添加，解除依赖也不影响应用正常运行，除了模块正常的对外接口，还具备提供mock修改的方式

## 简介
### account
账号模块，提供账号体系，含有一个登录界面
### IM
IM模块，提供im功能，含有一个IM的Fragment
### main
主框架部分，提供MainActivity，作为其他模块的容器和入口
### setting
设置模块，其它模块可以向其注册需要设置的部分，其本身拥有一个Fragment需要显示在main模块

## 模块间的依赖
虽然需要最大程度的解耦，但是模块间的依赖是不可避免的，有的甚至是必须的，则每个模块分离出一个`xx-common`模块，将其需要对外界暴露的部分以接口的形式定义在这个模块里，其它模块可以依赖这个`xx-common`模块，但是不可以直接依赖`xx`（即实现部分）

下图为依赖关系的示意图：
![依赖关系](https://github.com/EndSmile/EoaSplit/blob/170b8d389995afe2a82ac6136bf4e92f25daace9/image/Eoa%E4%BE%9D%E8%B5%96%E5%85%B3%E7%B3%BB.png?raw=true)

## 模块生命周期
由于模块之间的解耦，模块的生命周期开始不可能通过被调用的方式开始，所以设计为广播的形式，各个模块继承[ModuleInitReceiver](https://github.com/EndSmile/EoaSplit/blob/master/common/src/main/java/com/ldy/common/receiver/ModuleInitReceiver.java)，并按其注释在`AndroidManifest.xml`中注册，包含先后两次广播，第一次是让各模块初始化自己，第二次则可以调用其它模块

## 模块通信方式
模块的通信方式主要定义在[modulecommounication](https://github.com/EndSmile/EoaSplit/tree/170b8d389995afe2a82ac6136bf4e92f25daace9/common/src/main/java/com/ldy/common/modulecommunication)包下。

### event
模块发生的事件，在特定情境发出，用于通知或获取未知提供者的数据

#### NotificationEvent
通知事件，纯粹的事件，用于模块间的消息传递

#### GetDatasEvent
获取数据的事件，被设计为需要其它模块提供数据时，而数据的提供方又不确定，发出此事件，由其它模块调用此事件的接口添加数据，事件发送方则可以在事件完成后获取此事件的数据

##### GetSortDatasEvent
继承自`GetDatasEvent `,在添加数据时为数据排序，保证数据的顺序

#### EventPlug
事件的插件，也可以理解为事件的拦截器，注册之后在事件发出前和事件结束后会回调插件，插件也可以在事件发出前拦截此事件，默认有一个`EventLogPlug`的实现，用于为事件打印日志



### facade
模块向外提供的确定性的接口，例如`account`模块为外提供的账号，实现方应在`xx`部分实现`ModuleFacade`接口，在`xx-common`继承`ModuleFacadeRepository`接口，并在**初始化自己模块**(参加模块生命周期部分)的时候调用
`ModuleFacadeRepository#setFacade(ModuleFacade)`具体可参加代码示例

## 配置
每个实现模块(`xx`)应定义自己的`xxConfig`类，用于自身模块的配置，且让`application`方便的修改配置

配置的帮助部分在`BaseConfig`中以静态方法定义，主要实现为以优先级的形式从数组中获取非空值

### ConfigValue
实现`ConfigValue`接口的对象在数组中被解析时为其`getValue()`方法返回的值，默认的实现`PropertyValue`用于读取`config.properties`的值，`ResourceValue`用于读取资源文件的`id`

### 配置示例
参见[IMConfig](https://github.com/EndSmile/EoaSplit/blob/master/im/src/main/java/com/ldy/im/config/IMConfig.java)的配置

注意：使用此用法时，在配置类初始化时由于常量的机制会导致所有属性初始化，涉及到性能问题时可以进行这里的测试

## activityjumpinterceptor
Activity跳转的插件，用于mock activity的跳转，任意的修改参数和回复




