import Foundation

func fibonacci(number n: Int) -> Int {
    guard n > 1 else { return n }
    
    var numbers = Array(repeating:0, count: n)
    
    numbers[0] = 0
    numbers[1] = 1
    
    for i in 2..<n {
        numbers[i] = numbers[i - 1] + numbers[i - 2]
    }
    
    return numbers[n-1]
}

print("Fibonacci number: \(fibonacci(number: 5))")
