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
    @State var target = ContentView.randomTarget()
    @State var score = 0
    @State var round = 1
    let midnightBlue = Color(red: 0.0 / 255.0, green: 51.0 / 255.0, blue: 102.0 / 255.0)
    
    struct LabelStyle: ViewModifier {
        func body(content: Content) -> some View {
            return content
                .foregroundColor(Color.white)
                .modifier(Shadow())
                .font(Font.custom("Arial Rounded MT Bold", size: 18))
        }
    }
    
    struct ValueStyle: ViewModifier {
        func body(content: Content) -> some View {
            return content
                .foregroundColor(Color.yellow)
                .modifier(Shadow())
                .font(Font.custom("Arial Rounded MT Bold", size: 24))
        }
    }
    
    struct Shadow: ViewModifier {
        func body(content: Content) -> some View {
            return content
                .shadow(color: Color.black, radius: 5, x: 2, y: 2)
        }
    }
    
    struct ButtonLargeTextStyle: ViewModifier {
        func body(content: Content) -> some View {
            return content
                .foregroundColor(Color.black)
                .font(Font.custom("Arial Rounded MT Bold", size: 18))
        }
    }
    
    struct ButtonSmallTextStyle: ViewModifier {
        func body(content: Content) -> some View {
            return content
                .foregroundColor(Color.black)
                .font(Font.custom("Arial Rounded MT Bold", size: 12))
        }
    }
    
    var roundedValue: Int {
        return Int(sliderValue.rounded())
    }
    
    var body: some View {
        VStack(spacing: 4.0) {
            // Target row
            Spacer()
            HStack {
                Text("Put the bullseye as close as you can to:")
                    .modifier(LabelStyle())
                
                Text("\(target)")
                    .modifier(ValueStyle())
            }
            Spacer()
            HStack {
                Text("1")
                    .modifier(LabelStyle())
                Slider(value: $sliderValue, in: 0...100)
                    .accentColor(.green)
                Text("100")
                    .modifier(LabelStyle())
            }
            Spacer()
            
            // Button row
            Button(action: {
                print("Button pressed.")
                self.alertIsVisible = true
            }) {
                Text(/*@START_MENU_TOKEN@*/"Hit me"/*@END_MENU_TOKEN@*/).modifier(ButtonLargeTextStyle())
                
            }
            .alert(isPresented: $alertIsVisible) { () -> Alert in
                return Alert(title: Text("\(alertTitle())"), message: Text(
                    "This slider's value is \(roundedValue)\n" +
                    "You scored \(self.pointsForCurrentRound()) points this round."
                    ), dismissButton: .default(Text("Awesome!"), action: {
                        self.target = ContentView.randomTarget()
                        self.round += 1
                        self.score += self.pointsForCurrentRound()
                    }))
            }
            .background(Image.init("Button")).modifier(Shadow())
            Spacer()
            
            // Slider row
            
            HStack {
                Button(action: {
                    self.resetTheGame()
                }) {
                    HStack {
                        Image("StartOverIcon")
                        Text("Start over").modifier(ButtonSmallTextStyle())
                    }
                }
                .background(Image.init("Button")).modifier(Shadow())
                
                Spacer()
                Text("Scrore")
                Text("\(score)")
                    .modifier(ValueStyle())
                Spacer()
                Text("Round")
                Text("\(round)")
                    .modifier(ValueStyle())
                Spacer()
                NavigationLink(destination: AboutView()) {
                    HStack {
                        Image.init("InfoIcon")
                        Text("Info").modifier(ButtonSmallTextStyle())
                    }
                }
                .background(Image.init("Button")).modifier(Shadow())
                
            }
            .padding(20)
        }
        .background(Image.init("Background"), alignment: .center)
        .accentColor(midnightBlue)
    .navigationBarTitle(Text("Bullseye"))
    }
    
    func pointsForCurrentRound() -> Int {
        let maximumScore = 100
        var bonus: Int
        let difference = amountOff()
        if difference == 0 {
            bonus = 100
        } else if difference == 1 {
            bonus = 50
        } else {
            bonus = 0
        }
        return maximumScore - difference + bonus
    }
    
    func alertTitle() -> String {
        var title: String
        let difference = amountOff()
        if difference == 0 {
            title = "Perfect!"
        } else if difference < 5 {
            title = "You almost had it!"
        } else if difference <= 10 {
            title = "Not bad."
        } else {
            title = "Are you even trying?"
        }
        return title
    }
    
    func amountOff() -> Int {
        return abs(roundedValue - target)
    }
    
    static func randomTarget() -> Int {
        return Int.random(in: 0...100)
    }
    
    // MARK: - Reset the game
    
    private func resetTheGame() {
        round = 1
        score = 0
        target = ContentView.randomTarget()
        sliderValue = 50.0
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView().previewLayout(.fixed(width: 896, height: 414))
    }
}

