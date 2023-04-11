class Solution {
    fun solution(word: String): Int {    
        var answer = 1
    
        var iteratorWord = "A"
    
        fun updateWord() {
            val lastWord = iteratorWord.last()
            val remaainWord = iteratorWord.substring(0 until iteratorWord.length-1)
            when(lastWord){
                'A' -> iteratorWord = remaainWord + 'E'
                'E' -> iteratorWord = remaainWord + 'I'
                'I' -> iteratorWord = remaainWord + 'O'
                'O' -> iteratorWord = remaainWord + 'U'
                'U' -> {
                    iteratorWord = remaainWord
                    updateWord()
                }
            }
        }
    
        while(true) {
            if(word == iteratorWord) return answer
            if(iteratorWord.length < 5){
                iteratorWord += 'A'
            } else {
                updateWord()
            }
            answer += 1
        }

    }
}