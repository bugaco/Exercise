### 将背景和状态栏融合在一起

按照书上设置之后，状态栏一致隐藏，不明原因

在`WeatherActivity`	中：

```kotlin
override fun onCreate(savedInstanceState: Bundle?) {
    ...
    if (Build.VERSION.SDK_INT >= 21) {

        val decorView = window.decorView
        decorView.systemUiVisibility =
            View.SYSTEM_UI_FLAG_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
        window.statusBarColor = Color.TRANSPARENT
    }
	  ...
}
```

`now.xml`文件中

```xaml
<FrameLayout
        android:id="@+id/titleLayout"
        android:layout_width="match_parent"
        android:layout_height="70dp"
        android:fitsSystemWindows="true"
        >	
```

效果：

<img src="https://tva1.sinaimg.cn/large/007S8ZIlly1genfiwb1dlj30m015m4qp.jpg" alt="image-20200510162220010" style="zoom: 33%;" /><img src="https://tva1.sinaimg.cn/large/007S8ZIlly1genfj6zp49j30l413a156.jpg" alt="image-20200510162240171" style="zoom: 33%;" />

### 

### 制作应用图标

依次打开`File`->`New`->`Image Asset`

![image-20200512205918101](https://tva1.sinaimg.cn/large/007S8ZIlly1gepyrscxiuj30u014hnpe.jpg)

如图：

![image-20200512210005704](https://tva1.sinaimg.cn/large/007S8ZIlly1gepysg45hkj318e0u0aii.jpg)

`Foreground Layer`是设置前景层的，`Backgroud Layer`是设置背景层的

1. 我们在`Path`中，选择我们的天气图片，在`Resize`处，调整大小，使之处于圆形的安全区内
2. 在背景层中，将`Asset Type`设置为`Color`，取值`3DDC84`![image-20200512210258237](https://tva1.sinaimg.cn/large/007S8ZIlly1gepyvfoc9pj300g00ca9v.jpg)

然后图标就做好了



#### 图标的配置

按照上面的步骤，默认的话，图标就已经被替换了

如果要手动更换，需要在 Manifest 中配置：

```xml
<application
    ...
    android:icon="@mipmap/ic_launcher"
    android:roundIcon="@mipmap/ic_launcher_round"
    ...
</application>
```

### 15.8生成正是签名的apk文件

开发阶段，直接运行，也能安装，是AS帮我们做了打包工作

### 15.8.1 使用Android Studio生成

