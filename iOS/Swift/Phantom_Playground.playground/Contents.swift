import UIKit

struct Employee<Role>: Equatable {
    var name: String
    var role: String
}

enum Sales{
    
}
enum Programmer { }

let zoe1 = Employee<Programmer>(name: "Zoe", role: "Programmer")
let zoe2 = Employee<Sales>(name: "zoe", role: "Sales")
print(zoe1 == zoe2)
