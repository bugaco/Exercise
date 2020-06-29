//
//  ContentView.swift
//  Grids in SwiftUI
//
//  Created by 李懿哲 on 2020/6/26.
//

import SwiftUI

struct ContentView: View {
    let data = Array(1...1000).map{ "Item \($0)" }
    let layout = [
        GridItem(.flexible(minimum: 150, maximum: 180 )),
        GridItem(.flexible(maximum: 80))
    ]
    var body: some View {
        ScrollView(.horizontal) {
            LazyHGrid(rows: layout, alignment: /*@START_MENU_TOKEN@*/.center/*@END_MENU_TOKEN@*/, spacing: 20){
                ForEach(data, id: \.self) { item in
                    VStack {
                        Capsule()
                            .fill(Color.blue)
                            .frame(height: 50)
                        Text(item)
                            .foregroundColor(.secondary)
                    }
                }
            }
        }
        .padding(.horizontal)
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
