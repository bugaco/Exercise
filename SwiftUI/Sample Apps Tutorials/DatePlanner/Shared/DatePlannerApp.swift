//
//  DatePlannerApp.swift
//  Shared
//
//  Created by BugaCo on 2022/6/3.
//

import SwiftUI

@main
struct DatePlannerApp: App {
    @StateObject private var eventData = EventData()
    
    var body: some Scene {
        WindowGroup {
            NavigationView {
                EventList()
                Text("Select an Event")
                    .foregroundColor(.secondary)
            }
            .environmentObject(eventData)
        }
    }
}
