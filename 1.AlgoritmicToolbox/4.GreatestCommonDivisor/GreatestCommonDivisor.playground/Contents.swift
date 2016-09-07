import Foundation

func greatestCommonDivisor(of a: Int, and b: Int) -> Int {
    guard b > 0 else { return a }
    let remainder = a % b
    
    return greatestCommonDivisor(of: b, and: remainder)
}

print("GCD = \(greatestCommonDivisor(of: 357, and: 234))")
