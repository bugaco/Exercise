//
//  ContentView.swift
//  SwiftUI-PageTabView
//
//  Created by BugaCo on 8/28/21.
//

import SwiftUI

struct ContentView: View {
    var body: some View {
        TabView {
            OnboardView(systemImageName: "star.fill", title: "标题", description: "In today's video I show you how to create a TabView with the Page style in SwiftUI. This results in views that you can swipe through with dots at the bottom indicating which screen you are on. This is typically found in onboard views. ")
        }
        .tabViewStyle(.page)
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}

struct OnboardView: View {
    
    let systemImageName: String
    let title: String
    let description: String
    
    var body: some View {
        VStack(spacing: 20) {
            Image(systemName: systemImageName)
                .resizable()
                .scaledToFit()
                .frame(width: 100, height: 100)
                .foregroundColor(Color.yellow)
            
            Text(title)
                .font(.title)
                .bold()
            
            Text(description)
                .multilineTextAlignment(.center)
                .foregroundColor(.secondary)
        }
    }
}

struct OnboardView_Previews: PreviewProvider {
    static var previews: some View {
        OnboardView(systemImageName: "star.fill", title: "标题", description: "In today's video I show you how to create a TabView with the Page style in SwiftUI. This results in views that you can swipe through with dots at the bottom indicating which screen you are on. This is typically found in onboard views. ")
    }
}
