## 12.2 Toolbar

### 最基本的使用

1.先隐藏默认显示的`ActionBar`：

在`res/values/styles.xml`中，修改`parent`属性：

```xml
<resources>
		...
    <style name="AppTheme" parent="Theme.AppCompat.Light.NoActionBar">
        ...
    </style>

</resources>
```

2.然后在布局文件中写上`Toolbar`：

```xml
<?xml version="1.0" encoding="utf-8"?>
<FrameLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    >

    <androidx.appcompat.widget.Toolbar
        android:id="@+id/toolbar"
        android:layout_width="match_parent"
        android:layout_height="?attr/actionBarSize"
        android:background="@color/colorAccent"
        android:theme="@style/ThemeOverlay.AppCompat.Dark.ActionBar"
        app:popupTheme="@style/Theme.AppCompat.Light"
        />


</FrameLayout>
```

3.在Activity中启用：

```kotlin
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        ...
        setSupportActionBar(toolbar)
    }
}
```

效果图：

<img src="https://tva1.sinaimg.cn/large/007S8ZIlly1ge3srffeg6j30aw0iwgly.jpg" alt="image-20200423164902501" style="zoom: 50%;" />

### 添加菜单：

#### 创建菜单布局文件

在`res->menu`下新建`toolbar.xml`布局文件

```xml
<menu xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto">

    <item
        android:id="@+id/backup"
        android:icon="@drawable/ic_backup"
        android:title="Backup"
        app:showAsAction="always"
        />
    <item
        android:id="@+id/delete"
        android:icon="@drawable/ic_delete"
        android:title="Delete"
        app:showAsAction="ifRoom"
        />
    <item
        android:id="@+id/settings"
        android:icon="@drawable/ic_settings"
        android:title="Settings"
        app:showAsAction="never"
        />
</menu>
```

在代码中加载：

```kotlin
class MainActivity : AppCompatActivity() {
		...
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val msg = when (item.itemId) {
            R.id.backup -> "Backup"
            R.id.delete -> "Delete"
            R.id.settings -> "Settings"
            else -> "null"
        }
        Toast.makeText(this, "$msg", Toast.LENGTH_LONG)
            .show()
        return true
    }
}
```

## 12.3 滑动菜单

### 12.3.1 DrawerLayout

修改main activity的布局文件：

```xml
<androidx.drawerlayout.widget.DrawerLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:id="@+id/drawerLayout"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <FrameLayout

        android:layout_width="match_parent"
        android:layout_height="match_parent">

        <androidx.appcompat.widget.Toolbar
            android:id="@+id/toolbar"
            android:layout_width="match_parent"
            android:layout_height="?attr/actionBarSize"
            android:background="@color/colorAccent"
            android:theme="@style/ThemeOverlay.AppCompat.Dark.ActionBar"
            app:popupTheme="@style/Theme.AppCompat.Light" />
    </FrameLayout>

    <TextView
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:layout_gravity = "start"
        android:background="#f0f"
        android:text="This is menu"
        android:textSize="30sp" />

</androidx.drawerlayout.widget.DrawerLayout>
```

这样就可以了，安卓的这个布局真是强大

⚠️`android:layout_gravity = "start"`这个属性这是很重要