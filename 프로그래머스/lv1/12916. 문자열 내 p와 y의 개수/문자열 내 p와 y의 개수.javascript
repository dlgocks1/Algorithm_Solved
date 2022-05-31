function solution(s){
    // var s = "pPoooyY"
    let str = s.toLowerCase()
    let p = 0
    let y = 0
    for(i in s){
        if(str[i]=="p"){
            p+=1
        }
        if(str[i]=="y"){
            y+=1
        }
    }

    return ( p ===y ? true:false )
    
}