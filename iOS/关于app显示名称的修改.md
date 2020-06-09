# 关于app显示名称的修改



之前一直接改的`Display Name`：

![image-20200603165705616](https://tva1.sinaimg.cn/large/007S8ZIlly1gff7edsgvnj30y408l42u.jpg)	

但最近发现有俩问题：

1. 最近发现控制台的日志有中文的乱码，可能是中文名字引起的，这个除了看起来不舒服，也无大碍
2. 修改app名称后，app再启动会crash，找不到之前的一些类了，之前存的是`Name.Model`，改完名字之后，报错，找不到`Name2.Model`了

---

看了下[官方的文档](https://developer.apple.com/library/archive/qa/qa1823/_index.html)，在这里修改就没上述问题了：

![image-20200603165611381](https://tva1.sinaimg.cn/large/007S8ZIlly1gff7dg12dnj30sh0e9zt6.jpg)