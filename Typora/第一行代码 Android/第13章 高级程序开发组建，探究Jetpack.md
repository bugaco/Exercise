### 13.2.1 ViewModel的基本用法

1.引入依赖：

```
implementation 'androidx.lifecycle:lifecycle-extensions:2.1.0'
```

2.创建 MainActivity 对应的 ViewModel 类：

```kotlin
class MainViewModel: ViewModel() {
    var counter = 0
}
```

3.布局文件，很简单：

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    tools:context=".MainActivity">

    <TextView
        android:id="@+id/infoText"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_gravity="center_horizontal"
        android:textSize="32sp" />

    <Button
        android:id="@+id/plusOneBtn"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_gravity="center_horizontal"
        android:text="Plus One" />

</LinearLayout>
```

4.在 MainActivity 中使用：

```kotlin
class MainActivity : AppCompatActivity() {

    lateinit var viewModle: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModle = ViewModelProviders.of(this).get(MainViewModel::class.java)
        plusOneBtn.setOnClickListener {
            viewModle.counter ++
            updateTextInfo()
        }
        updateTextInfo()
    }

    private fun updateTextInfo() {
        infoText.text = viewModle.counter.toString()
    }
}
```

这样用 ViewModel 存储后，即使屏幕旋转，Activity 重新创建，数据也不会丢失了

<img src="https://tva1.sinaimg.cn/large/007S8ZIlly1ge78uu1di3j30ah0if0t0.jpg" alt="image-20200426162236260" style="zoom:50%;" />

<img src="https://tva1.sinaimg.cn/large/007S8ZIlly1ge78vcu9dvj30ig0alt8z.jpg" alt="image-20200426162258128" style="zoom:50%;" />

### 13.2.2 向ViewModel传递参数

1. 修改`MainViewModel`类：

   ```kotlin
   class MainViewModel(countReserved: Int = 0): ViewModel() {
       var counter = countReserved
   }
   ```

2. 新建`MainViewModelFactory`类：

   ```kotlin
   class MainViewModelFactory(val countReserved: Int): ViewModelProvider.Factory {
       override fun <T : ViewModel?> create(modelClass: Class<T>): T {
           return MainViewModel(countReserved) as T
       }
   }
   ```

3. 在`MainActivity`中，将count存储在本地，并构建带参数的 ViewModel:

   ```kotlin
   class MainActivity : AppCompatActivity() {
   
       companion object {
           const val COUNT_RESERVED = "count_reserved"
       }
   
       lateinit var viewModle: MainViewModel
       lateinit var sp: SharedPreferences
   
       override fun onCreate(savedInstanceState: Bundle?) {
           super.onCreate(savedInstanceState)
           setContentView(R.layout.activity_main)
   
           sp = getPreferences(Context.MODE_PRIVATE)
           val countReserved = sp.getInt(COUNT_RESERVED, 0)
           viewModle = ViewModelProviders.of(this,
               MainViewModelFactory(countReserved)).get(MainViewModel::class.java)
           plusOneBtn.setOnClickListener {
               viewModle.counter ++
               updateTextInfo()
           }
           clearBtn.setOnClickListener {
               viewModle.counter = 0
               updateTextInfo()
           }
           updateTextInfo()
       }
   
       override fun onPause() {
           super.onPause()
           sp.edit {
               putInt(COUNT_RESERVED, viewModle.counter)
           }
       }
   
       private fun updateTextInfo() {
           infoText.text = viewModle.counter.toString()
       }
   }
   ```

这样，即使app关闭，再打开count也不会丢失了：

![image-20200426192103761](https://i.loli.net/2020/04/26/H2IoUMbfOT3Yndt.png)

## 13.3 LifeCycle



