//
//  EventTask.swift
//  DatePlanner
//
//  Created by BugaCo on 2022/6/3.
//

import Foundation

struct EventTask: Identifiable, Hashable {
    var id = UUID()
    var text: String
    var isCompleted = false
    var isNew = false
}
