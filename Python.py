# 1a. Write a python program to find the best of two test average marks out of three test’s marks 
# accepted from the user.
m1 = int(input("Enter marks for test1 : "))
m2 = int(input("Enter marks for test2 : "))
m3 = int(input("Enter marks for test3 : "))
if m1 <= m2 and m1 <= m3:
 avgMarks = (m2+m3)/2
elif m2 <= m1 and m2 <= m3:
 avgMarks = (m1+m3)/2
elif m3 <= m1 and m2 <= m2:
 avgMarks = (m1+m2)/2 
 
print('Average of best two test marks out of three test’s marks is', avgMarks);


# 1b.Develop a Python program to check whether a given number is palindrome or not and also 
# count the number of occurrences of each digit in the input number.
val = int(input("Enter a value : "))
str_val = str(val)
if str_val == str_val[::-1]:
 print("Palindrome")
else:
 print("Not Palindrome")
 
for i in range(10):
 if str_val.count(str(i)) > 0:
    print(str(i),"appears", str_val.count(str(i)), "times");


  # 2a.Defined as a function F as Fn = Fn-1 + Fn-2. Write a Python program which accepts a value 
# for N (where N >0) as input and pass this value to the function. Display suitable error message if 
# the condition for input value is not followed.
def fn(n):
 if n == 1:
    return 0
 elif n == 2:
    return 1
 else:
    return fn(n-1) + fn(n-2)
 
num = int(input("Enter a number : "))
if num > 0:
 print("fn(", num, ") = ",fn(num) , sep ="")
else:
 print("Error in input")


def bin2Dec(val):
 rev=val[::-1]
 dec = 0
 i = 0
 for dig in rev:
    dec += int(dig) * 2**i
    i += 1
 
 return dec
def oct2Hex(val):
 rev=val[::-1]
 dec = 0
 i = 0
 for dig in rev:
    dec += int(dig) * 8**i
    i += 1
    
 list=[]
 while dec != 0:
    list.append(dec%16)
    dec = dec // 16
 
 nl=[]
 
 for elem in list[::-1]:
    if elem <= 9:
        nl.append(str(elem))
    else:
        nl.append(chr(ord('A') + (elem -10)))
        hex = "".join(nl)
    return hex


num1 = input("Enter a binary number : ") 
print(bin2Dec(num1))
num2 = input("Enter a octal number : ")
print(oct2Hex(num2))



# 3a.Write a Python program that accepts a sentence and find the number of words, digits, 
# uppercase letters and lowercase letters.
sentence = input("Enter a sentence : ")
wordList = sentence.split(" ")
print("This sentence has", len(wordList), "words")
digCnt = upCnt = loCnt = 0
for ch in sentence:
 if '0' <= ch <= '9':
    digCnt += 1
 elif 'A' <= ch <= 'Z':
    upCnt += 1
 elif 'a' <= ch <= 'z':
    loCnt += 1
print("This sentence has", digCnt, "digits", upCnt, "upper case letters", loCnt, "lower caseletters")


# 3b.Write a Python program to find the string similarity between two given strings.
str1 = input("Enter String 1 \n")
str2 = input("Enter String 2 \n")
if len(str2) < len(str1):
 short = len(str2)
 long = len(str1)
else:
 short = len(str1)
 long = len(str2)
 
matchCnt = 0
for i in range(short):
 if str1[i] == str2[i]:
    matchCnt += 1
    
print("Similarity between two said strings:")
print(matchCnt/long)




import random
def merge_sort(lst):
    if len(lst) > 1:
        mid = len(lst) // 2
        left_half = lst[:mid]
        right_half = lst[mid:]
        
        
        merge_sort(left_half)
        merge_sort(right_half)
        
        i = j = k = 0
        
        while i < len(left_half) and j < len(right_half):
            if left_half[i] < right_half[j]:
                lst[k] = left_half[i]
                i += 1
            else:
                lst[k] = right_half[j]
                j += 1
            k += 1
                
            while i < len(left_half):
                lst[k] = left_half[i]
                i += 1
                k += 1
                
            while j < len(right_half):
                lst[k] = right_half[j]
                j += 1
                k += 1
            
    return lst
    
def insertion_sort(arr):
    for i in range(1, len(arr)):
        key = arr[i]
        j = i - 1
        while j >= 0 and key < arr[j]:
          arr[j + 1] = arr[j]
          j -= 1
          arr[j + 1] = key
        
my_list = []

for i in range(10):
    my_list.append(random.randint(0, 999))
    
print("\nUnsorted List")
print(my_list)
print("Sorting using Insertion Sort")
insertion_sort(my_list)
print(my_list)
    
    
my_list = []

for i in range(10):
    my_list.append(random.randint(0, 999))
    
print("\nUnsorted List")
print(my_list)
print("Sorting using Merge Sort")
merge_sort(my_list)
print(my_list)



def roman2Dec(romStr):
    roman_dict ={'I': 1, 'V': 5, 'X': 10, 'L': 50, 'C': 100, 'D': 500, 'M': 1000}
    romanBack = list(romStr)[::-1]
    value = 0
    rightVal = roman_dict[romanBack[0]] 
    for numeral in romanBack:
        leftVal = roman_dict[numeral]
        if leftVal < rightVal:
            value -= leftVal
        else:
            value += leftVal
            rightVal = leftVal
    return value
        
romanStr = input("Enter a Roman Number : ")
print(roman2Dec(romanStr))



import re
def isphonenumber(numStr):
    if len(numStr) != 12:
        return False
    for i in range(len(numStr)):
        if i==3 or i==7:
            if numStr[i] != "-":
                return False
        else:
            if numStr[i].isdigit() == False:
                return False
    return True
def chkphonenumber(numStr):
    ph_no_pattern = re.compile(r'^\d{3}-\d{3}-\d{4}$')
    if ph_no_pattern.match(numStr):
        return True
    else:
        return False
    
    
ph_num = input("Enter a phone number : ")
print("Without using Regular Expression") 
if isphonenumber(ph_num):
    print("Valid phone number")
else:
    print("Invalid phone number")
    print("Using Regular Expression")
if chkphonenumber(ph_num):
    print("Valid phone number")
else:
    print("Invalid phone number")


import re
phone_regex = re.compile(r'\+\d{12}')
email_regex = re.compile(r'[A-Za-z0-9._]+@[A-Za-z0-9]+\.[A-Z|a-z]{2,}')
with open('example.txt', 'r') as f:
    for line in f:
        matches = phone_regex.findall(line)
        for match in matches:
            print(match) 
        matches = email_regex.findall(line)
        for match in matches:
            print(match)
        
