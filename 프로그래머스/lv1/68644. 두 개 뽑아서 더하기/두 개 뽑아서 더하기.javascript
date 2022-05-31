function solution(numbers) {
    var answer = [];
    const temp = new Set();
    for(i=0;i<numbers.length;i++){
        for ( let j = i + 1; j < numbers.length; j++) {
            let sum = numbers[i] + numbers[j];
            temp.add(sum)
        }
    }
    var answer = []
    temp.forEach((number)=>{
        answer.push(number);
    })

    return answer.sort((a,b) => a-b)
}