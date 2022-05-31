function solution(absolutes, signs) {
    var answer = 0;
    
    for(i=0;i<absolutes.length;i++){
        if(signs[i]){
            answer +=absolutes[i]
        }else{
            answer -=absolutes[i]
        }
        console.log(signs[i]);
    }
    return answer;
}