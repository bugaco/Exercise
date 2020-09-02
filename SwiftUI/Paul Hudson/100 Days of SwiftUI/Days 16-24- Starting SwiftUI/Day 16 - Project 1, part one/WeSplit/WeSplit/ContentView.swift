//
//  ContentView.swift
//  WeSplit
//
//  Created by BugaCo on 2020/9/2.
//

import SwiftUI

struct ContentView: View {
    
    var body: some View {
        Form {
            ForEach(0 ..< 100) {
                Text("Row \($0)")
            }
        }
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
            .previewDevice("iPhone XS Max")
    }
}

