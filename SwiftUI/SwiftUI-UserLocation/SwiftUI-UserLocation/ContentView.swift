//
//  ContentView.swift
//  SwiftUI-UserLocation
//
//  Created by ZanyZephyr on 2021/8/26.
//

import SwiftUI
import MapKit

struct ContentView: View {
    @StateObject private var viewModel = ContentViewModel()
    
    var body: some View {
        Map(coordinateRegion: $viewModel.region, showsUserLocation: true)
            .ignoresSafeArea()
            .accentColor(.orange)
            .onAppear(perform: {
                viewModel.checkIfLocationServiceIsEnabled()
            })
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
