def tampilkan_deret(array, n, deret=[]):
    if n <= 0:
        return
    
    if n > len(array):
        print("eror")
        return
    
    deret.append(array[n-1])
    print(deret)
    return tampilkan_deret(array, n-1, deret)
    
array = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
tampilkan_deret(array, 7)