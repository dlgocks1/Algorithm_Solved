fun main(args:Array<String>){
    var (n,w,h,l) = readLine()!!.split(' ').map(String::toInt)
    if ( (w/l) * (h/l) > n){
        print(n)
    }else{
        print((w/l) * (h/l))
    }

}