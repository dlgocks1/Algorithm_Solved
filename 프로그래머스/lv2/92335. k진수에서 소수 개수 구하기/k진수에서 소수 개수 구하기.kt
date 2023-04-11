class Solution {
    
    fun getPrimNumber():List<Boolean> {
        val primeNumbers = Array(1_000_001) { true }
        primeNumbers[0] = false
        primeNumbers[1] = false
        
        for(i in 2..1_000_000) {
            if(primeNumbers[i] == true) {
                for(j in (i+i)..1_000_000 step i) {
                    primeNumbers[j] = false
                }
            }
        }
        
        return primeNumbers.toList()
    }
    
    fun isPrime(number : Long):Boolean {
        val halfNum = Math.sqrt(number.toDouble()).toLong()
        
        if(number <= 1L) return false
        for(i in 2..halfNum){
            if(number % i == 0L) return false
        }
        return true
    }
    

    fun solution(n: Int, k: Int): Int {
        var answer: Int = -1
        var num = n
        var stringNum = StringBuilder()
        while(num > 0) {
            stringNum.append((num % k).toString())
            num /= k
        }
        
        // val primeNumbers = getPrimNumber()
        
        // stringNum
        //     .toString()
        //     .reversed()
        //     .split("0")
        //     .let { 
        //         it.forEach {
        //             if(it != ""){                    
        //                 print((it.toDouble()))
        //                 print(isPrime(it.toDouble()))
        //             }
        //         }
        //     }
            
        // return -1
        return stringNum
            .toString()
            .reversed()
            .split("0")
            .filter { it != "" && isPrime(it.toLong()) }
            .count()
    }
    
    
}