def python_to_java(python_code):
    """
    Fungsi sederhana untuk menerjemahkan perintah print Python ke Java.
    """
    java_code = ""
    for line in python_code.split("\n"):
        line = line.strip()
        if line.startswith("print(") and line.endswith(")"):
            # Ekstrak string yang ingin dicetak
            print_str = line[6:-1]
            # Konversi ke perintah System.out.println Java
            java_code += f"System.out.println({print_str});\n"
        else:
            print(f"Baris '{line}' tidak didukung oleh converter ini.")
    return java_code

# Contoh penggunaan
python_code = """
print("Hello, World!")
""" 
java_code = python_to_java(python_code)

print("Kode Java:")
print(java_code)