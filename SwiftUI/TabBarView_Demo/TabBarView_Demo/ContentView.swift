//
//  ContentView.swift
//  TabBarView_Demo
//
//  Created by ZanyZephyr on 2020/8/27.
//  Copyright © 2020 李懿哲. All rights reserved.
//

import SwiftUI

struct ContentView: View {
    
    var flag = false
    
    var body: some View {
        TabView {
            
            Text("Tab A")
                .tabItem {
                    Image(systemName: "phone.fill")
                    Text("Tab A")
            }
            
            Text("Tab B")
                .tabItem{
                    Image(systemName: "tv.fill")
                    Text("Tab B")
            }
            
            if flag {
                Text("Tab C")
                    .tabItem{
                        Image(systemName: "pencil.tip")
                        Text("Tab C")
                }
            }
        }
    }
    mutating func onAppear(perform action: (() -> Void)? = nil) -> some View {
        print("on appear")
        flag = true
        return body
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
