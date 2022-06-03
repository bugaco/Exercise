//
//  AboutView.swift
//  bullseye
//
//  Created by 李懿哲 on 2020/3/11.
//  Copyright © 2020 zanyzephyr. All rights reserved.
//

import SwiftUI

struct AboutView: View {
    
    let backgroundColor = Color(red: 255.0 / 255.0, green: 214.0 / 255.0, blue: 179.0 / 255.0)
    
    struct HeadingStyle: ViewModifier {
        func body(content: Content) -> some View {
            return content
                .foregroundColor(Color.black)
                .font(Font.custom("Arial Rounded MT Bold", size: 30))
                .padding([.top, .bottom], 20)
        }
    }
    
    struct TextViewStyle: ViewModifier {
        func body(content: Content) -> some View {
            return content
                .foregroundColor(Color.black)
                .font(Font.custom("Arial Rounded MT Bold", size: 16))
                .padding([.leading, .trailing], 60)
                .padding(.bottom, 20)
        }
    }
    
    var body: some View {
        Group{
            VStack {
                Text("🎯 Bullseye 🎯").modifier(HeadingStyle())
                Text("This is Bullseye, the game where you can win points and earn fame by dragging a slider.")
                    .modifier(TextViewStyle())
                Text("Your goal is to place the slider as close as possible to the target value. The closer you are, the more points you score.")
                    .modifier(TextViewStyle())
                Text("Enjoy!")
                    .modifier(TextViewStyle())
            }
            .navigationBarTitle(Text("About Bullseye"))
            
            .background(backgroundColor)
        }
        .background(Image("Background"), alignment: .center)

    }
    
}

struct AboutView_Previews: PreviewProvider {
    static var previews: some View {
        AboutView().previewLayout(.fixed(width: 896, height: 414))
    }
}
