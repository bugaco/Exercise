//
//  ContentView.swift
//  Date Picker
//
//  Created by BugaCo on 2020/7/31.
//  Copyright © 2020 BugaCo. All rights reserved.
//

import SwiftUI

struct ContentView: View {
    @State private var date = Date()
    
    var body: some View {
        VStack {
            Text("Enter your birthday")
                .font(.largeTitle)
            DatePicker("Enter your birthday", selection: $date)
//                .datePickerStyle(GraphicalDatePickerStyle()) // iOS13貌似还不支持 GraphicalDatePickerStyle 这个属性
                .labelsHidden()
                .frame(maxHeight: 400)
        }
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
