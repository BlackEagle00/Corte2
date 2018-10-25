def BinarySearch(dato):
    
    left = 0
    right = len(list) - 1
    while left <= right:
        middle = (left + right) // 2
        if dato == (list[middle]):
            return middle
        elif dato < list[middle]:
            right = middle - 1
        else:
            left = middle + 1
    return None

def Find(dato):
    if BinarySearch(dato) == None:
        return "El dato %d no se encuentra" %(dato)
    else:
        return "El dato %d se encuentra en el indice: %d" %(dato, BinarySearch(dato))
                    
list = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

for i in range (len(list)):
    print("[%d]   =>  %d"%(i, list[i]))

print (Find(8)
