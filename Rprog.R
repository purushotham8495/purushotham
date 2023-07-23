n<-as.integer(readline(prompt="Enter no of fibo"))

fib<-function(n){
    if(n<=0){
        cat("invalid input enter >0")
    }else if (n==1){
        cat("fibbonacci",0)
    }else{
        return(fib(n)+fib(n-1))
    }      
}
fib(n)


a<-as.integer(readline(prompt="eter a coffecient of x^"))
b<-as.integer(readline(prompt="eter a coff of x"))
c<-as.integer(readline(prompt="eter a constant"))
D<-(b**2-(4*a*c))
if(D>0){
    print("Qudratic equations are real and distinct")
    r1<-((-b)+sqrt(D))/2
    r3<-((-b)-sqrt(D))/2
    cat("root 1:",r1,"root 2",r3)
}else if (D==0) {
    print("Qudratic equations are real and equal")
    r1=r3=(-b)/2*a
    cat("root 1:",r1,"root 2",r3)
}else{
    print("Qudratic equations are imaganary and distinct")
    r1<-(-b)/(2*a)
    r3<-abs(sqrt(D))/2
    cat("root 1:",r1,"+i",r3," root 2=",r1,"-i",r3)
}


findMinimum<-function(x){
    if(length(x)==0){
        cat("error: empty vector")
        return(NA)
    }
    x.min<-x[1]

    for(i in 2:length(x)){
        if(x[i]<x.min){
            x.min<-x[i]
        }
    }
    return(x.min)
}
vector<-c(7,3,4,5,6,8)
minimum<-findMinimum(vector)
cat("minimum",minimum)


random_number <-sample(1:10,1)

guess<- as.integer(readline("guss a number bw 1 and10 :"))
while(guss != random_number){
    if(guss>random_number){
        print("too high")
    }else{
        print("too low")
    }
    guss<-as.integer(readline("guss again:"))
}
print("congrtulations")




countVowelAndConsonents<-function(text){
    text<-tolower(text)

    vowels<-c("a","e","i","o","u")
    vowel_count<-0
    consonent_count<-0

    for(char in strsplit(text,"")[[1]]){
        if (char %in% vowels){
            vowel_count=vowel_count+1
        }else if (char>="a"&& char<="z") {
           consonent_count=consonent_count+1
        }
    }
    cat("number of vowels:",vowel_count,"\n")
    cat("numebr of consonant: ",consonent_count,"\n")
}

text<-readline(prompt="enter a word or sentence")

countVowelAndConsonents(text)






