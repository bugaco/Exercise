## ①

```kotlin
Caused by: org.codehaus.groovy.control.MultipleCompilationErrorsException: startup failed
```

I solved it changing the gradle version of the project to the newest version 6.2.1 on the project structure options.

[![image](https://user-images.githubusercontent.com/3351420/75755922-86821080-5d27-11ea-82a3-3cc2bc286f05.png)](https://user-images.githubusercontent.com/3351420/75755922-86821080-5d27-11ea-82a3-3cc2bc286f05.png)

引用自:https://github.com/android/plaid/issues/818#issuecomment-593824196

