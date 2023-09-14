# Write a program to perform addition, subtraction, multiplication, division, and modulo 
# division on two integers

# Function to perform addition
def add(x, y):
    return x + y

# Function to perform subtraction
def subtract(x, y):
    return x - y

# Function to perform multiplication
def multiply(x, y):
    return x * y

# Function to perform division
def divide(x, y):
    if y == 0:
        return "Cannot divide by zero"
    return x / y

# Function to perform modulo division
def modulo(x, y):
    if y == 0:
        return "Cannot perform modulo with zero"
    return x % y

# Input two integers from the user
num1 = int(input("Enter the first integer: "))
num2 = int(input("Enter the second integer: "))

# Perform operations and display the results
print(f"{num1} + {num2} = {add(num1, num2)}")
print(f"{num1} - {num2} = {subtract(num1, num2)}")
print(f"{num1} * {num2} = {multiply(num1, num2)}")
print(f"{num1} / {num2} = {divide(num1, num2)}")
print(f"{num1} % {num2} = {modulo(num1, num2)}")
# Write a program to find the greatest number from three numbers.




# Input three numbers from the user
num1 = float(input("Enter the first number: "))
num2 = float(input("Enter the second number: "))
num3 = float(input("Enter the third number: "))

# Compare the numbers to find the greatest
if num1 >= num2 and num1 >= num3:
    greatest = num1
elif num2 >= num1 and num2 >= num3:
    greatest = num2
else:
    greatest = num3

# Display the greatest number
print(f"The greatest number among {num1}, {num2}, and {num3} is {greatest}.")
# Write a program to calculate roots of a quadratic equation.
import math
# Input coefficients a, b, and c from the user
a = float(input("Enter the coefficient a: "))
b = float(input("Enter the coefficient b: "))
c = float(input("Enter the coefficient c: "))

# Calculate the discriminant
discriminant = b**2 - 4*a*c

# Check if the discriminant is positive, zero, or negative
if discriminant > 0:
    # Two real and distinct roots
    root1 = (-b + math.sqrt(discriminant)) / (2*a)
    root2 = (-b - math.sqrt(discriminant)) / (2*a)
    print(f"The roots are real and distinct: {root1} and {root2}")
elif discriminant == 0:
    # One real root (repeated)
    root = -b / (2*a)
    print(f"The root is real and repeated: {root}")
else:
    # Complex roots
    real_part = -b / (2*a)
    imaginary_part = math.sqrt(abs(discriminant)) / (2*a)
    if discriminant < 0:
        print(f"The roots are complex: {real_part} + {imaginary_part}i and {real_part} - {imaginary_part}i")
    else:
        print(f"The roots are complex: {real_part} + {imaginary_part}j and {real_part} - {imaginary_part}j")

# Write a program to classify a given number as prime or composite.



# Input a number from the user
num = int(input("Enter a number: "))

# Check if the number is less than 2
if num < 2:
    print(f"{num} is not a prime number.")
else:
    is_prime = True
    
    # Check for divisibility from 2 to the square root of the number
    for i in range(2, int(num**0.5) + 1):
        if num % i == 0:
            is_prime = False
            break

    # Determine and print the result
    if is_prime:
        print(f"{num} is a prime number.")
    else:
        print(f"{num} is a composite number.")


# Write a program that finds whether a given character is present in a given string or not. In 
# case it is present it prints the index at which it is present. Do not use built-in find 
# functions to search the character


# Input a string from the user
input_string = input("Enter a string: ")

# Input a character to search for
char_to_find = input("Enter a character to search for: ")

# Initialize a variable to store the index
found_at_index = -1

# Iterate through the string and check each character
for index, char in enumerate(input_string):
    if char == char_to_find:
        found_at_index = index
        break

# Determine and print the result
if found_at_index != -1:
    print(f"'{char_to_find}' is present at index {found_at_index}.")
else:
    print(f"'{char_to_find}' is not present in the string.")


# Write a program to check whether a given year is leap year or not.


# Input a year from the user
year = int(input("Enter a year: "))

# Check if it's a leap year
if (year % 4 == 0 and year % 100 != 0) or (year % 400 == 0):
    print(f"{year} is a leap year.")
else:
    print(f"{year} is not a leap year.")

# Write a program to find GCD of two numbers


# Function to find the GCD using the Euclidean algorithm
def find_gcd(a, b):
    while b:
        a, b = b, a % b
    return a

# Input two numbers from the user
num1 = int(input("Enter the first number: "))
num2 = int(input("Enter the second number: "))

# Find and display the GCD
gcd = find_gcd(num1, num2)
print(f"The GCD of {num1} and {num2} is {gcd}.")



# Define a function which takes TWO objects representing complex numbers and returns 
# new complex number with a addition of two complex numbers. Define a suitable class 
# ‘Complex’ to represent the complex number. Develop a program to read N (N >=2) 
# complex numbers and to compute the addition of N complex numbers.




class Complex:
    def __init__(self, real, imaginary):
        self.real = real
        self.imaginary = imaginary
    
    def add(self, other):
        real_sum = self.real + other.real
        imaginary_sum = self.imaginary + other.imaginary
        return Complex(real_sum, imaginary_sum)
    
    def __str__(self):
        return f"{self.real} + {self.imaginary}i"

# Function to read a complex number from the user
def read_complex_number():
    real = float(input("Enter the real part: "))
    imaginary = float(input("Enter the imaginary part: "))
    return Complex(real, imaginary)

# Input the number of complex numbers to add
N = int(input("Enter the number of complex numbers to add (N >= 2): "))

# Ensure that N is at least 2
if N < 2:
    print("N should be greater than or equal to 2.")
else:
    # Read the first complex number
    result = read_complex_number()

    # Read and add the remaining (N-1) complex numbers
    for i in range(N - 1):
        complex_number = read_complex_number()
        result = result.add(complex_number)

    # Display the result
    print(f"The sum of the {N} complex numbers is: {result}")


# Develop a program that uses class Student which prompts the user to enter marks in three 
# subjects and calculates total marks, percentage and displays the score card details.





class Student:
    def __init__(self, name):
        self.name = name
        self.subjects = ["Subject 1", "Subject 2", "Subject 3"]
        self.marks = []

    def input_marks(self):
        print(f"Enter marks for {self.name}:")
        for subject in self.subjects:
            mark = float(input(f"Enter marks for {subject}: "))
            self.marks.append(mark)

    def calculate_total(self):
        return sum(self.marks)

    def calculate_percentage(self):
        total_marks = self.calculate_total()
        return (total_marks / (len(self.subjects) * 100)) * 100

    def display_scorecard(self):
        total_marks = self.calculate_total()
        percentage = self.calculate_percentage()

        print("\nScorecard:")
        print(f"Name: {self.name}")
        for i, subject in enumerate(self.subjects):
            print(f"{subject}: {self.marks[i]}")
        print(f"Total Marks: {total_marks}")
        print(f"Percentage: {percentage:.2f}%")

# Input student details
name = input("Enter student's name: ")
student = Student(name)

# Input marks
student.input_marks()

# Display scorecard
student.display_scorecard()
