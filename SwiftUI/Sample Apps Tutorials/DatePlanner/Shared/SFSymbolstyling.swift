//
//  SFSymbolstyling.swift
//  DatePlanner
//
//  Created by BugaCo on 2022/6/3.
//

import SwiftUI

struct SFSybmolStyling: ViewModifier {
    func body(content: Content) -> some View {
        content
            .imageScale(.large)
            .symbolRenderingMode(.monochrome)
    }
}

extension View {
    func sfSymbolStyling() -> some View {
        modifier(SFSybmolStyling())
    }
}
