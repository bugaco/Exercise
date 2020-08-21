# MBProgressHUD的一个bug



![image-20200811084927385](https://tva1.sinaimg.cn/large/007S8ZIlly1ghml2ch533j31h50rddxh.jpg)

这一行：

```
[bezel addConstraints:bezelConstraints];
```

相关报错：

```
Thread 1: Exception: "Unable to install constraint on view.  Does the constraint reference something from outside the subtree of the view?  That's illegal. constraint:<NSLayoutConstraint:0x6000032656d0 UIImageView:0x7fbc9761bb50.centerX == MBBackgroundView:0x7fbc9745c580.centerX   (active)> view:<MBBackgroundView: 0x7fbc9745c580; frame = (0 0; 0 0); clipsToBounds = YES; animations = { opacity=<CASpringAnimation: 0x600001137ea0>; }; layer = <CALayer: 0x6000011c6ea0>>"
```

```
Terminating app due to uncaught exception 'NSGenericException', reason: 'Unable to install constraint on view.  Does the constraint reference something from outside the subtree of the view?  That's illegal. constraint:<NSLayoutConstraint:0x6000032656d0 UIImageView:0x7fbc9761bb50.centerX == MBBackgroundView:0x7fbc9745c580.centerX   (active)> view:<MBBackgroundView: 0x7fbc9745c580; frame = (0 0; 0 0); clipsToBounds = YES; animations = { opacity=<CASpringAnimation: 0x600001137ea0>; }; layer = <CALayer: 0x6000011c6ea0>>'
```



