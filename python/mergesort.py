def mergesort(arr):
    if len(arr) > 1:
        r = len(arr)//2
        kiri = arr[:r]
        kanan = arr[r:]
        mergesort(kiri)
        mergesort(kanan)
        i = j = k = 0
        while i < len(kiri) and j < len(kanan):
            if kiri[i] < kanan[j]:
                arr[k] = kiri[i]
                i += 1
            else:
                arr[k] = kanan[j]
                j += 1
            k += 1
        while i < len(kiri):
            arr[k] = kiri[i]
            i += 1
            k += 1  
        while j < len(kanan):
            arr[k] = kanan[j]
            j += 1
            k += 1  
    return arr

array = [7, 6, 5, 4, 3, 2, 1]
print("Sorted array is:")
print(mergesort(array))