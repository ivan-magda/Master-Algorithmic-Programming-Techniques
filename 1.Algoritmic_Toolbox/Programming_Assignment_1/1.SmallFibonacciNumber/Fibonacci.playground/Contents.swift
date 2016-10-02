import Foundation

func fibonacci(number n: Int) -> Int {
    guard n > 1 else { return n }
    
    var numbers = Array(repeating:0, count: n + 1)
    numbers[1] = 1
    
    for i in 2..<numbers.count {
        numbers[i] = numbers[i - 1] + numbers[i - 2]
    }
    
    return numbers[n]
}

print("Fibonacci number: \(fibonacci(number: 10))")
