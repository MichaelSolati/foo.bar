def solution(x):
    # Your code here
    result = '';
    for char in x:
        newChar = char
        if char.islower():
            newChar = chr(ord('z') - ord(char) + ord('a'))
        result = result + newChar
    return result