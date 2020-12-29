/*
* js 变量类型
*
*
* js 特殊的值
* undefined  未初始化，默认值全部为undefined
* null        空值
* NAN         Not a number
*
*
* 等于 和 全等于
* == 等于只做简单的字面值比较
* === 全等于还要做类型比较
*
*
* 逻辑运算
*
* && and
* || or
* | 取反
* 前提条件，在js中，所有变量都可以当作bool类型使用
* 0,null，undefined，"" 认为是false
*
* and 运算
* 1、表达式全真时，返回最后一个表达式的值
* 2、当表达式为假时，返回第一个为假的表达式的值
*
* or 运算
* 1、表达式全假，返回最后一个表达式的值
* 2、只有一个表达式为真，就会返回第一个为真的值
*
* js数组 重点
* var var_name = [];
*
*
* fun 有隐藏参数，
*
*
* js中的Object自定义对象,就是对象 OOP
* object
* var name = new Object();
*name.attribute = ;
*
* 花括号型的自定义对象
* var objname = {
*                 attribute1:value,
*                 attribute2:value,
*                 attribute3:value,
*                 function_name: function(){};
*                };
*
*
* js中的事件
* 电脑与界面进行交互，叫事件
*
* 常用事件：
* onload 加载完成事件     页面加载完成后，常用于页面js初始化操作
* onclick                常用于按钮点击操作
* onblur                 常用于输入框失去焦点后验证输入内容是否合法
* onchange                 常用于下拉列表和输入框内容发生改变后操作
* onsubmit                 常用于表单提交前，验证所有表单项时候合法
*
* 事件的注册（绑定）：告诉浏览器，当时间响应后要执行那些操作代码，就叫事件的注册/绑定
*
* 静态注册
* 通过html标签的事件属性直接赋予事件响应后的代码
*
* 动态注册
*先通过js代码得到标签的dom对象，然后再通过dom对象。事件名 = function（）{}这种形式赋予响应后的代码，叫动态注册
*
* 动态注册基本步骤：
*   1、获取标签对象
*   2、function(){ }
*
* */