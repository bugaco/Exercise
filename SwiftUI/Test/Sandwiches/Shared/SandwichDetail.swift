//
//  SandwichDetail.swift
//  Sandwiches
//
//  Created by 李懿哲 on 2020/6/26.
//

import SwiftUI

struct SandwichDetail: View {
    
    @State private var zoomed = false
    
    var body: some View {
        VStack {
            Spacer()
            Image("sandwich")
                .resizable()
                .aspectRatio(contentMode: zoomed ? .fill : .fit)
                .onTapGesture {
                    withAnimation {
                        zoomed.toggle()
                    }
                    
                }
            Spacer()
            if !zoomed {
                HStack {
                    Spacer()
                    Label("Spicy", systemImage: "flame.fill")
                        .font(Font.headline.smallCaps())
                    Spacer()
                        
                }
                .padding(/*@START_MENU_TOKEN@*/.all/*@END_MENU_TOKEN@*/)
                .foregroundColor(.yellow)
                .background(Color.red  )
                .transition(.move(edge: .bottom))
            }
                
        }
        .navigationTitle("详情")
        .edgesIgnoringSafeArea(/*@START_MENU_TOKEN@*/.all/*@END_MENU_TOKEN@*/)
    }
}

struct SandwichDetail_Previews: PreviewProvider {
    static var previews: some View {
        SandwichDetail()
    }
}
