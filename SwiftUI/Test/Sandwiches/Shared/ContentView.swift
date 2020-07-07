//
//  ContentView.swift
//  Shared
//
//  Created by 李懿哲 on 2020/6/26.
//

import SwiftUI

struct ContentView: View {
    
    var body: some View {
        NavigationView {
            
            VStack {
                List(/*@START_MENU_TOKEN@*/0 ..< 5/*@END_MENU_TOKEN@*/) { item in
                    SandwichCell(index: item)
                }
                
                HStack {
                    Spacer()
                    Text(" 5 Sandwiches")
                    Spacer()
                }
            }
            .navigationTitle("Sandwiches")
            .toolbar {
                #if os(iOS)
                EditButton()
                #endif
                Button("Add", action: addAction)
            }
            Text("Select a sandwich")
                .font(.largeTitle)
        }
        
        
    }
    
    func onMove() {
        
    }
    
    func addAction() {
        
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}

struct SandwichCell: View {
    var index: Int
    var body: some View {
        NavigationLink(destination: SandwichDetail()){
            Image(systemName: "photo").cornerRadius(/*@START_MENU_TOKEN@*/3.0/*@END_MENU_TOKEN@*/)
            VStack(alignment: .leading) {
                Text("My sandwich! \(index)").padding()
                Text("3 ingredinets")
                    .font(.subheadline)
                    .foregroundColor(.secondary)
            }
        }
    }
}
