import Foundation

func fibonacci(number n: Int) -> Int {
    guard n > 1 else { return n }
    
    let length = n + 1
    var numbers = Array(repeating:0, count: length)
    numbers[1] = 1
    
    for i in 2..<length {
        numbers[i] = numbers[i - 1] + numbers[i - 2]
    }
    
    return numbers[n]
}

print("Fibonacci number: \(fibonacci(number: 10))")
