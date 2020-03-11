//
//  ContentView.swift
//  bullseye
//
//  Created by 李懿哲 on 2020/3/7.
//  Copyright © 2020 zanyzephyr. All rights reserved.
//

import SwiftUI

struct ContentView: View {
    
    @State var alertIsVisible = false
    @State var sliderValue = 50.0
    @State var target = Int.random(in: 0...100)
    
    var roundedValue: Int {
        return Int(sliderValue.rounded())
    }
    
    var body: some View {
        VStack(spacing: 4.0) {
            // Target row
            Spacer()
            HStack {
                Text("Put the bullseye as close as you can to:")
                Text("\(target)")
            }
            Spacer()
            HStack {
                Text("1")
                Slider(value: $sliderValue, in: 0...100)
                Text("100")
            }
            Spacer()
            
            
            
            // Button row
            Button(action: {
                print("Button pressed.")
                self.alertIsVisible = true
            }) {
                Text(/*@START_MENU_TOKEN@*/"Hit me"/*@END_MENU_TOKEN@*/)
            }
            .alert(isPresented: $alertIsVisible) { () -> Alert in
                return Alert(title: Text("Hello there!"), message: Text(
                    "This slider's value is \(roundedValue)\n" +
                    "You scored \(self.rewardedPoint()) points this round."
                ), dismissButton: .default(Text("Awesome!")))
            }
            Spacer()
            
            // Slider row
            
            HStack {
                Button(action: /*@START_MENU_TOKEN@*/{}/*@END_MENU_TOKEN@*/) {
                    Text("Start over")
                }
                Spacer()
                Text("Scrore")
                Text("999999")
                Spacer()
                Text("Round")
                Text("999")
                Spacer()
                Button(action: /*@START_MENU_TOKEN@*/{}/*@END_MENU_TOKEN@*/) {
                    Text("Info")
                }
            }
        .padding(20)
        }
    }
    
    func rewardedPoint() -> Int {
        let differenct = abs(roundedValue - target)
        let rewardedPoint = 100 - differenct
        return rewardedPoint
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView().previewLayout(.fixed(width: 896, height: 414))
    }
}

