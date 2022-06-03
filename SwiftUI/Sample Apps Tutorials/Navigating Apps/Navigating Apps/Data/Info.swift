//
//  Info.swift
//  Navigating Apps
//
//  Created by ZanyZephyr on 2022/5/23.
//

import Foundation
import SwiftUI

struct Info {
    let image: String
    let name: String
    let story: String
    let hobbies: [String]
    let foods: [String]
    let colors: [Color]
    let funFacts: [String]
}

let information = Info(
    image: "IMG_0004",
    name: "Bugaco",
    story: """
"On March 25, 2020, when India went into a nationwide lockdown, all schools, colleges, and tuition centres had to follow suit. What followed was an unprecedented rise of online education—propelled by the need of the hour—and the sensational growth of India’s edtech sector.
    
    In a year when funding was supposed to recede due to investors becoming cautious, edtech startups in India raised a record $2.2 billion, leading the deal volume for the first time. This momentum continued in 2021 as well, with ﻿BYJU'S﻿ alone raising $1 billion-plus in funding.

    The edtech major also became India’s most valuable startup last June—at a valuation of $16 billion—and is currently valued at over $22 billion.

    ﻿Unacademy﻿, another leading edtech player in the country, also saw a meteoric rise in its valuation, up by 70 percent from $2 billion in November 2020 to $3.44 billion in August 2021.

    It really did seem like online education was here to stay, forever.

    But in 2022, life came full circle for the sector.
""",
    hobbies: ["bicycle", "ticket.fill", "book.fill"],
    foods: ["🥐", "🌮", "🍣"],
    colors: [.blue, .purple, .pink],
    funFacts: [
        "The femur is the longest and largest bone in the human body.",
        "The moon is 238,900 miles away.",
        "Prince’s last name was Nelson.",
        "503 new species were discovered in 2020.",
        "Ice is 9 percent less dense than liquid water.",
        "You can spell every number up to 1,000 without using the letter A.\n\n...one, two, three, four...ninety-nine...nine hundred ninety-nine 🧐",
        "A collection of hippos is called a bloat.",
        "White sand beaches are made of parrotfish poop.",
    ])
