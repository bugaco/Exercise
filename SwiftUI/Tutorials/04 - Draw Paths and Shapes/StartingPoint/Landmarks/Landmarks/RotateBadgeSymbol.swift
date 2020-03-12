//
//  RotateBadgeSymbol.swift
//  Landmarks
//
//  Created by 李懿哲 on 2019/12/20.
//  Copyright © 2019 Apple. All rights reserved.
//

import SwiftUI

struct RotateBadgeSymbol: View {
    let angle: Angle
    var body: some View {
        BadgeSymbol()
        .padding(-60)
            .rotationEffect(angle, anchor: .bottom)
    }
}

struct RotateBadgeSymbol_Previews: PreviewProvider {
    static var previews: some View {
        RotateBadgeSymbol(angle: .init(degrees: 5))
    }
}
