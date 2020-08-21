# 记录一次url带中文的图片加载不出来的情况

如下图片url：

```
http://xydadm.tingfoyin.com/upload/images/2020-07-28/组 2.png
```

浏览器可以正常打开，用Kingfisher就打不开，需要将中文转一下码：

```swift
let escapedString = imageUrlString.addingPercentEncoding(withAllowedCharacters: .urlQueryAllowed)
```

