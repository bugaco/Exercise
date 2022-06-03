import UIKit

struct Compartment {
    var name: String?
}

struct Backpack {
    var compartment: Compartment
}

var myPack = Backpack(compartment: Compartment())
myPack.compartment.name = "小黑包"
var yourBackpack = myPack
yourBackpack.compartment.name = "小白包"

print(myPack.compartment.name ?? "么有名字")
