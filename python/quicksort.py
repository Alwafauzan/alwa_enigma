def quicksort(arr):
    if len(arr) <= 1:
        return arr
    pivot = arr[len(arr) // 2]
    kiri = [x for x in arr if x < pivot]
    tengah = [x for x in arr if x == pivot]
    kanan = [x for x in arr if x > pivot]
    return quicksort(kiri) + tengah + quicksort(kanan)  

arr = [6, 5, 4, 3, 2, 1]
print(quicksort(arr))