//
//  UserData.swift
//  Landmarks
//
//  Created by 李懿哲 on 2019/12/19.
//  Copyright © 2019 Apple. All rights reserved.
//

import SwiftUI
import Combine

final class UserData: ObservableObject {
    @Published var showFavoritesOnly = false
    @Published var landmarks = landmarkData
}
