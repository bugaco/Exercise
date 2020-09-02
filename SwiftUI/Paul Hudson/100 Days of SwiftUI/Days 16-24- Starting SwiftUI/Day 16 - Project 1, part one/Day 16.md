# Day 16

## NavigationView、Form、navigationBarTitle

```swift
struct ContentView: View {
    var body: some View {
        NavigationView {
            Form {
                Section {
                    HStack {
                        Text("Hello, world!")
                            .padding()
                        Spacer()
                        Text("Hello, world!")
                    }
                    
                    Text("Hello, world!")
                    Text("Hello, world!")
                    Text("Hello, world!")
                    Text("Hello, world!")
                    Text("Hello, world!")
                    Text("Hello, world!")
                }
            }
            .navigationBarTitle(Text("SwiftUI"))
        }
    }
}
```

<img src="https://tva1.sinaimg.cn/large/007S8ZIlly1gicfa2wnfvj30u01sx0vs.jpg" alt="image-20200902171359536" style="zoom:33%;" />

---

## @State、Button

```swift
struct ContentView: View {
    @State var tapCount = 0
    
    var body: some View {
        Button("Tap Count: \(tapCount)") {
            self.tapCount += 1
        }
    }
}
```

![image-20200902171721380](https://tva1.sinaimg.cn/large/007S8ZIlly1gicfdioc55j309z0kk3ys.jpg)

---

## 将输入的值实时展示

```swift
struct ContentView: View {
    @State var name = ""
    
    var body: some View {
        Form {
            TextField("Enter your name", text: $name)
            Text("Your name is \(name)")
        }
    }
}
```

![image-20200902173833388](https://tva1.sinaimg.cn/large/007S8ZIlly1gicfzkh4hzj30at0nlab2.jpg)

---

## ForEach

```swift
struct ContentView: View {
    
    var body: some View {
        Form {
            ForEach(0 ..< 100) {
                Text("Row \($0)")
            }
        }
    }
}
```

