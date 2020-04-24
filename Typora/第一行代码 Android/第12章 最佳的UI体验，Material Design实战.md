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

#### 1⃣️

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

#### 2⃣️添加按钮，点击后打开抽屉

```kotlin
override fun onCreate(savedInstanceState: Bundle?) {
    ...
    supportActionBar?.let {
        it.setDisplayHomeAsUpEnabled(true) // 设置显示home按钮
        it.setHomeAsUpIndicator(R.drawable.ic_menu) // 自定义icon
    }
}


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var msg = ""
        when (item.itemId) {
            ...
            android.R.id.home -> {
                drawerLayout.openDrawer(GravityCompat.START, true) // 监听事件，打开抽屉
            }
            else -> "null"
        }
        return true
    }
```

### 12.3.2 NavigationView

引入依赖：

```
dependencies {
    ...
    implementation 'com.google.android.material:material:1.0.0'
    implementation 'de.hdodenhof:circleimageview:3.0.1'
}
```

创建`res/menu/nav_menu.xml`和`res/layout/nav_header.xml`布局文件：

```xml
<menu xmlns:android="http://schemas.android.com/apk/res/android">
    <group android:checkableBehavior="single">
        <item
            android:id="@+id/navCall"
            android:icon="@drawable/nav_call"
            android:title="Call" />
        <item
            android:id="@+id/navFriends"
            android:icon="@drawable/nav_friends"
            android:title="Friends" />
        <item
            android:id="@+id/navLocation"
            android:icon="@drawable/nav_location"
            android:title="Location" />
        <item
            android:id="@+id/navMail"
            android:icon="@drawable/nav_mail"
            android:title="Mail" />
        <item
            android:id="@+id/navTask"
            android:icon="@drawable/nav_task"
            android:title="Tasks" />
    </group>
</menu>
```

```xml
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="180dp"
    android:background="@color/colorPrimaryDark"
    android:padding="10dp">

    <de.hdodenhof.circleimageview.CircleImageView
        android:id="@+id/iconImage"
        android:layout_width="70dp"
        android:layout_height="70dp"
        android:layout_centerInParent="true"
        android:src="@drawable/nav_icon" />

    <TextView
        android:id="@+id/mailText"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignParentBottom="true"
        android:text="liyizhezhe@gmail.com"
        android:textColor="#fff"
        android:textSize="14sp" />

    <TextView
        android:id="@+id/userText"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_above="@+id/mailText"
        android:text="Tony Green"
        android:textColor="#fff"
        android:textSize="14sp" />

</RelativeLayout>
```

修改`activity_main.xml`布局文件：

```xml
<androidx.drawerlayout.widget.DrawerLayout 
		...>

    <FrameLayout
			...
    </FrameLayout>

    <com.google.android.material.navigation.NavigationView
        android:id="@+id/navView"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:layout_gravity = "start"
        app:menu="@menu/nav_menu"
        app:headerLayout="@layout/nav_header"
        />

</androidx.drawerlayout.widget.DrawerLayout>
```

修改`MainActivity`中的代码：

```kotlin
override fun onCreate(savedInstanceState: Bundle?) {
    ...
    navView.setCheckedItem(R.id.navFriends)
    navView.setNavigationItemSelectedListener {
        drawerLayout.closeDrawers()
        true
    }
}
```

效果图：

![image-20200424095557294](https://tva1.sinaimg.cn/large/007S8ZIlly1ge4mfwckzlj30an0ilwf8.jpg)

## 12.4 悬浮按钮和可交互提示

### 12.4.1 FloatingActionButton

在布局文件中创建：

```xml
<androidx.drawerlayout.widget.DrawerLayout 
		...>

    <FrameLayout
        .../>
        <com.google.android.material.floatingactionbutton.FloatingActionButton
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:id="@+id/fab"
            android:layout_gravity="bottom|end"
            android:layout_margin="16dp"
            android:src="@drawable/ic_done"
            android:elevation="8dp"/>
    </FrameLayout>

    <com.google.android.material.navigation.NavigationView
        ...
        />

</androidx.drawerlayout.widget.DrawerLayout>
```

在代码中注册点击事件：

```kotlin
fab.setOnClickListener {
    Toast.makeText(this, "FAB clicked", Toast.LENGTH_LONG).show()
}
```

效果图：

<img src="https://tva1.sinaimg.cn/large/007S8ZIlly1ge4mrkt04uj30ag0l30tg.jpg" alt="image-20200424100710822" style="zoom: 33%;" />

### 12.4.2 Snackbar

用起来很简单：

```kotlin
fab.setOnClickListener {
    Snackbar.make(it, "Data deleted", Snackbar.LENGTH_LONG)
        .setAction("Undo") {
            Toast.makeText(this, "Data restored", Toast.LENGTH_LONG).show()
        }
        .show()
}
```

效果图：

<img src="https://tva1.sinaimg.cn/large/007S8ZIlly1ge4mwlfjhgj30b90jdmy1.jpg" alt="image-20200424101200586" style="zoom: 67%;" />

可以看到，按钮被遮挡了

### 12.4.3 CoordinatorLayout

将`Framelayout`替换为`androidx.coordinatorlayout.widget.CoordinatorLayout`就可以完美解决遮挡的问题了

效果图：

<img src="https://tva1.sinaimg.cn/large/007S8ZIlly1ge4n2bd83jj30aq0j7jri.jpg" alt="image-20200424101726374" style="zoom:67%;" />

## 12.5 卡片式布局

### 12.5.1 MaterialCardView

添加依赖库：

```
implementation 'androidx.recyclerview:recyclerview:1.1.0'
implementation 'com.github.bumptech.glide:glide:4.9.0'
```

创建fruit_item布局文件

```xml
<com.google.android.material.card.MaterialCardView
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:layout_margin="5dp"
    app:cardCornerRadius="4dp">

    <LinearLayout
        android:orientation="vertical"
        android:layout_width="match_parent"
        android:layout_height="wrap_content">

        <ImageView
            android:id="@+id/fruitImage"
            android:layout_width="match_parent"
            android:layout_height="100dp"
            android:scaleType="centerCrop" />

        <TextView
            android:id="@+id/fruitName"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_gravity="center_horizontal"
            android:layout_margin="5dp"
            android:textSize="16sp" />
    </LinearLayout>

</com.google.android.material.card.MaterialCardView>
```

创建FruitAdapter适配器：

```kotlin
class FruitAdapter(val context: Context, val fruitList: List<Fruit>) : RecyclerView.Adapter<FruitAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val fruitImage: ImageView = view.findViewById(R.id.fruitImage)
        val fruitName: TextView = view.findViewById(R.id.fruitName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.fruit_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val fruit = fruitList[position]
        holder.fruitName.text = fruit.name
        Glide.with(context).load(fruit.imageId).into(holder.fruitImage);
    }

    override fun getItemCount() = fruitList.size

}
```

在Activity中设置适配器和布局管理：

```kotlin
val fruits = mutableListOf<Fruit>(
    Fruit("Apple", R.drawable.apple),
    Fruit("Banana", R.drawable.banana),
    Fruit("Watermelon", R.drawable.watermelon),
    Fruit("Grape", R.drawable.grape),
    Fruit("Strawberry", R.drawable.strawberry),
    Fruit("Mango", R.drawable.mango),
    Fruit("Orange", R.drawable.orange),
    Fruit("Pear", R.drawable.pear),
    Fruit("Pineapple", R.drawable.pineapple),
    Fruit("Cherry", R.drawable.cherry)
)
val fruitList = ArrayList<Fruit>()

override fun onCreate(savedInstanceState: Bundle?) {
    ...
    /* 设置RecyclerView */
    initFruits()
    val layoutManager = GridLayoutManager(this, 2)
    recyclerView.layoutManager = layoutManager
    val adapter = FruitAdapter(this, fruitList)
    recyclerView.adapter = adapter
}

private fun initFruits() {
    fruitList.clear()
    repeat(50) {
        val index = (0 until fruits.size).random()
        fruitList.add(fruits[index])
    }
}
```

中间遇到了一个报错，

```
...
Error inflating class com.google.android.material.card.MaterialCardView
...
```

Google了一下，修改了一下 style 配置文件，添加了两行，暂时不报错了：

```xml
<resources>

    <!-- Base application theme. -->
    <style name="AppTheme1" parent="Theme.MaterialComponents.Light.DarkActionBar">
        <!-- Customize your theme here. -->
        ...
        <item name="windowActionBar">true</item>
        <item name="windowNoTitle">true</item>
    </style>

</resources>
```

但是 Toolbar 被遮挡了。

### 12.5.2 AppBarlayout

两部解决被遮挡的问题：

```xml
<androidx.coordinatorlayout.widget.CoordinatorLayout
    ...>

    <com.google.android.material.appbar.AppBarLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content">
      	// 1⃣️将 Toolbar 嵌套进 AppBarLayout 中
        <androidx.appcompat.widget.Toolbar
            ... />
    </com.google.android.material.appbar.AppBarLayout>

    <androidx.recyclerview.widget.RecyclerView
        ...
        // 2⃣️给RecyclerView 添加一个行为                                       
        app:layout_behavior="@string/appbar_scrolling_view_behavior"/>

    ...
</androidx.coordinatorlayout.widget.CoordinatorLayout>
```

效果图：

![image-20200424162209379](https://tva1.sinaimg.cn/large/007S8ZIlly1ge4xlrmazoj30aq0iswng.jpg)



实现 Toolbar 滚动时自动隐藏、显示：

```xml
<androidx.appcompat.widget.Toolbar
    ...
    app:layout_scrollFlags="scroll|enterAlways|snap"
    />
```

## 12.6 下拉刷新



## 12.7 可折叠式标题栏