# ChatClient by java

##程序功能说明

MAC下界面：

![](https://ws3.sinaimg.cn/large/006tNc79ly1fqk6iky0mmj30rs0godgh.jpg)

**监听端口**：在`Listen Port`后输入你想要监听的本机接口，点击`Listen`按钮，程序就会开始一直监听该端口，如果收到其他client发来的信息，会在`receive`窗口显示. 你可以同时监听多个端口，同时每个端口可以收到多个client发来的不同信息. 

**发送信息**：在`IP`输入框输入你想要发送给的机器的IPv4地址，`Port`	框输入对方正在监听的端口号，在send框输入你想要发送的信息，点击`send`按钮就会发送内容. 

**Note**: 本程序使用TCP协议连接，支持同一局域网内多台计算机发送数据，使用公网IP连接功能完整性未知. 曾使用两台MAC在教学楼局域网下使用子网IP发送信息成功. 须知晓对方子网IP及开放端口. 



##测试

在教学楼局域网中子网IP`10.0.44.162` 和 `10.0.40.43`使用Wireshark抓包得到数据如下

![image-20180421131912144](/var/folders/4g/vf9lsm1x21x3vqkymzf202xh0000gn/T/abnerworks.Typora/image-20180421131912144.png)

其中传输了65Byte数据，从对方计算机收到ACK时间RTT为0.00067s. 速率约为0.7Mbps. 

使用TCP协议，无丢包率. 

##编译及使用说明

`out/artifacts/ChatClient_jar/ChanClient.jar`为可运行jar文件，在任意安装最新版本JDK机器上均可直接运行. 运行时注意接受Java的网络端口使用请求. 

本程序使用Intellij IDEA开发, 可直接导入Intellij IDEA编译运行. 



GitHub url :