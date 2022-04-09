AdjMatrix.java

打印邻接矩阵

```java
private int V; // 矩阵维度
private int E; // 相连边
private int[][] adj;// 存储矩阵信息
```

`Scanner`可以获得用户的输入，`new Scanner(System.in);`获得键盘输入

`nextXxx` 和 `nextLine`之间的区别

- 前者直到遇到有效的字符，并以空白字符结束即有效
- 后者以换行符为有效结尾

`@Override`在重写父类方法的时候，可以检测函数名和参数是否书写正确

在程序开发过程中，我们常常碰到字符串连接的情况，方便和直接的方式是通过
"+"符号来实现，但是这种方式达到目的的效率比较低，且每执行一次都会创建
一个String对象，即耗时，又浪费空间。使用StringBuilder类就可以避免这种问题
的发生

方法：

- append  字符串连接
- toString()：返回一个与构建起或缓冲器内容相同的字符串
- setCharAt(int i, char c)：将第 i 个代码单元设置为 c（可以理解为替换）
- insert(int offset, String str)/insert(int offset, Char c)：在指定位置之前插入字符(串)
- delete(int startIndex,int endIndex)：删除起始位置（含）到结尾位置（不含）之间的字符串
