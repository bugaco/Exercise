支付crash bug调查

3天内一共13次



```
*** Terminating app due to uncaught exception 'NSInvalidArgumentException', reason: '*** -[__NSPlaceholderDictionary initWithObjects:forKeys:count:]: attempt to insert nil object from objects[2]'
```

8次



```
*** Terminating app due to uncaught exception 'NSInvalidArgumentException', reason: 'data parameter is nil'
```

5次

可能原因：网络请求返回的数据没有对空值进行处理

用 crash 分析工具分析出来的

```objective-c
-[NSMutableArray(HMDSafe) hmd_addObject:] (in ) (NSArray+HMDSafe.m:50)
```

