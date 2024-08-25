def cari_angka_hilang(angka):
  angka.sort()
  for i in range(1, len(angka)):
    if angka[i] < 0 and angka[i] - angka[i-1] > 1:
      return angka[i] - 1
  return None

angka = [4, 3, 2, 1, -1, -3, -4]
hasil = cari_angka_hilang(angka)
print(hasil)  # Output: -2
