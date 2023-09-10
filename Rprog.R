//001

n<-as.integer(readline(prompt="Enter no of fibo"))

fib<-function(n){
    if(n<=0){
        return(cat("invalid input enter >0"))
        
    }else if (n==1){
        return(0)
    }else if (n==2){
        return(1)
    }else if (n>1){
        return(fib(n-1)+fib(n-2))
    }      
}
paste("fibo sequence is")
for(i in 1:n){
cat(" ",fib(i), " ")
}


//002
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

//003

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

//04
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



//005
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

//006
# Create a data frame with names and ages
names <- c("Adith", "Babloo", "Sanju", "Raj")
ages <- c(25, 30, 35, 40)
df <- data.frame(Name = names, Age = ages)
# Calculate the mean age using the apply family of functions
mean_age <- mean(df$Age)
print(mean_age)
# Calculate the median age using the apply family of functions
median_age <- median(df$Age)
print(median_age)

//007
# Function to calculate mean
calculate_mean <- function(column) {
 return(mean(column, na.rm = TRUE))
}
# Function to calculate median
calculate_median <- function(column) {
 return(median(column, na.rm = TRUE))
}
# Function to calculate variance
calculate_variance <- function(column) {
 return(var(column, na.rm = TRUE))
}
# Function to calculate standard deviation
calculate_std_dev <- function(column) {
 return(sd(column, na.rm = TRUE))
}
# Function to calculate standard error
calculate_std_error <- function(column) {
 return(sd(column, na.rm = TRUE) / sqrt(length(column)))
}
# Function to calculate statistics for a single column
calculate_column_stats <- function(column) {
 stats <- c(
 mean = calculate_mean(column),
 median = calculate_median(column),
 variance = calculate_variance(column),
 std_dev = calculate_std_dev(column),
 std_error = calculate_std_error(column)
 )
 return(stats)
}
# Create a sample dataframe
data <- data.frame(
 name = c("Alice", "Bob", "Charlie", "David", "Emma"),
 age = c(25, 32, 45, 28, 22),
 income = c(50000, 60000, 75000, 55000, 40000),
 expenses = c(30000, 35000, 40000, 32000, 28000)
)
# Numeric columns
numeric_columns <- sapply(data, is.numeric)
# Use lapply to calculate statistics for each numeric column
numeric_stats <- lapply(data[, numeric_columns], calculate_column_stats)
# Convert the list of statistics into a data frame
numeric_stats_df <- do.call(rbind, numeric_stats)

rownames(numeric_stats_df) <- paste0("Numeric_",colnames(data)[numeric_columns])
# Print numeric statistics
print("Numeric Column Statistics:")
print(numeric_stats_df)

//007
# Read data from file (replace 'data.txt' with your file path)
original_data <- read.table("data.txt", header = TRUE)
# Display the original data
cat("Original Data:\n")
print(original_data)
# Replace negative values with zero using apply
modified_data <- data.frame(apply(original_data, 2, function(column) 
ifelse(column < 0, 0, column)))
# Call the function to display data modification
cat("\nData after replacing negative values with zero:\n")
print(modified_data)
# Function to calculate mean, variance, and standard deviation
calculate_stats <- function(column) {
 stats <- c(
 mean = mean(column),
 variance = var(column),
 std_dev = sd(column)
 )
 return(stats)
}
# Use apply to calculate statistics for each column
column_stats <- lapply(modified_data, calculate_stats)
# Convert the list of statistics into a data frame
stats_df <- do.call(rbind, column_stats)
rownames(stats_df) <- c("Mean", "Variance", "Standard Deviation")
# Print the statistics
cat("\nColumn Statistics:\n")
print(stats_df)

//008
# Read data from file (replace 'data.txt' with your file path)
original_data <- read.table("data.txt", header = TRUE)
# Display the original data
cat("Original Data:\n")
print(original_data)
# Replace negative values with zero using apply
modified_data <- data.frame(apply(original_data, 2, function(column) 
ifelse(column < 0, 0, column)))
# Call the function to display data modification
cat("\nData after replacing negative values with zero:\n")
print(modified_data)
# Function to calculate mean, variance, and standard deviation
calculate_stats <- function(column) {
 stats <- c(
 mean = mean(column),
 variance = var(column),
 std_dev = sd(column)
 )
 return(stats)
}
# Use apply to calculate statistics for each column
column_stats <- lapply(modified_data, calculate_stats)
# Convert the list of statistics into a data frame
stats_df <- do.call(rbind, column_stats)
rownames(stats_df) <- c("Mean", "Variance", "Standard Deviation")
# Print the statistics
cat("\nColumn Statistics:\n")
print(stats_df)

//009        


# Define the Student class
Student <- setClass(
 "Student",
 slots = c(
 name = "character",
 age = "numeric",
 height = "numeric"
 )
)
# Create an instance of the Student class
student1 <- new("Student", name = "Alice", age = 21, height = 165)
student2 <- new("Student", name = "Bob", age = 22, height = 178)
student3 <- new("Student", name = "Charlie", age = 21, height = 172)
student4 <- new("Student", name = "David", age = 19, height = 160)
student5 <- new("Student", name = "Emma", age = 23, height = 175)
student6 <- new("Student", name = "Frank", age = 28, height = 170)
student7 <- new("Student", name = "Grace", age = 34, height = 163)
student8 <- new("Student", name = "Henry", age = 20, height = 180)
student9 <- new("Student", name = "Ivy", age = 27, height = 168)
student10 <- new("Student", name = "Jack", age = 30, height = 175)
# Define functions to operate on Student objects
get_name_uppercase <- function(student) {
 return(toupper(student@name))
}
get_stats <- function(student) {
 age <- student@age
 height <- student@height
 
 stats <- list(
 mean_age = mean(age),
 median_age = median(age),
 mean_height = mean(height),
 median_height = median(height)
 )
 
 return(stats)
}
# Create lists to store results for each metric
names_upper <- character()
mean_ages <- numeric()
median_ages <- numeric()
mean_heights <- numeric()
median_heights <- numeric()
# Call functions for each student and populate the result lists
students <- list(student1, student2, student3, student4, student5,
 student6, student7, student8, student9, student10)
for (student in students) {

 names_upper <- c(names_upper, get_name_uppercase(student))
 stats <- get_stats(student)
 
 mean_ages <- c(mean_ages, stats$mean_age)
 median_ages <- c(median_ages, stats$median_age)
 mean_heights <- c(mean_heights, stats$mean_height)
 median_heights <- c(median_heights, stats$median_height)
}
# Create a data frame to display the separate results
results <- data.frame(
 Names = names_upper
)
# Display the results
print(results)
print(paste("Mean Age: ", mean(mean_ages)))
print(paste("Median Age: ", median(median_ages)))
print(paste("Mean Height: ", mean(mean_heights)))
print(paste("Median Height: ", median(median_heights)))
                                  
//010
# Define the studentRecord class
studentRecord <- list(
 name = NULL,
 subjects_completed = NULL,
 grades = NULL,
 credit = NULL
)
# Create the mean method for studentRecord
mean.studentRecord <- function(x, ...) {
 total_credits <- sum(x$credit)
 weighted_grades <- sum(x$grades * x$credit)
 mean_gpa <- weighted_grades / total_credits
 
 return(mean_gpa)
}
# Create the print method for studentRecord
print.studentRecord <- function(x, ...) {
 cat("Name:", x$name, "\n")
 cat("Subjects Completed:", x$subjects_completed, "\n")
 cat("Grades:", x$grades, "\n")
 cat("Credit:", x$credit, "\n")
}
# Create the cohort class
cohort <- list(
 students = NULL
)
# Create the mean method for cohort
mean.cohort <- function(x, ...) {
 student_gpas <- sapply(x$students, mean)
 mean_gpa <- mean(student_gpas)
 
 return(mean_gpa)
}
# Create the print method for cohort
print.cohort <- function(x, ...) {
 for (student in x$students) {
 print(student)
 cat("---------------------------\n")
 }
}
# Create a sample student record
student <- studentRecord
student$name <- "John Doe"
student$subjects_completed <- c("Math", "English", "Science")
student$grades <- c(80, 90, 85)
student$credit <- c(3, 4, 3)
# Calculate the mean GPA for the student
mean_gpa <- mean(student)
cat("Mean GPA:", mean_gpa, "\n")
# Print the student record
print(student)
# Create a sample cohort
cohort <- cohort
cohort$students <- list(student, student)
# Calculate the mean GPA for the cohort
mean_gpa_cohort <- mean(cohort)
cat("Mean GPA for Cohort:", mean_gpa_cohort, "\n")
# Print the student records in the cohort
print(cohort)

 //data      
 col1 col2 col3
1 3 -2 7
2 -1 5 8
3 4 2 -6
4 -3 0 9
5 6 -4 12
6 2 -7 10
7 9 8 -5
8 -2 11 14
9 -8 6 3
10 7 0 -9
