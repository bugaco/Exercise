//
//  StoryView.swift
//  Navigating Apps
//
//  Created by ZanyZephyr on 2022/5/23.
//

import SwiftUI

struct StoryView: View {
    var body: some View {
        NavigationView {
            StoryPageView(story: story, pageIndex: 0)
        }
    }
}

struct StoryView_Previews: PreviewProvider {
    static var previews: some View {
        StoryView()
    }
}
