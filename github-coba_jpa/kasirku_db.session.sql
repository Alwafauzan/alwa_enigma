CREATE TABLE barang (
    id_barang SERIAL PRIMARY KEY,
    nama_barang VARCHAR(255),
    poto VARCHAR(255),
    harga INT,
    stok_barang INT
);
CREATE TABLE pemasukan_barang(
    id_pemasukan_barang serial primary key,
    id_barang int,
    tanggal date default current_date,
    nama_barang varchar(255),
    jumlah_barang int,
    foreign key (id_barang) references barang(id_barang)
);
CREATE table input(
    id_input serial primary key,
    tanggal date default current_date,
    total int,
    bayar int
);
create table detail(
    id_detail serial primary key,
    id_input int,
    id_barang int,
    foreign key (id_input) references input(id_input),
    foreign key (id_barang) references barang(id_barang),
    nama varchar(255),
    harga int,
    jumlah int,
    subtotal int
);
INSERT INTO barang (nama_barang, poto, harga, stok_barang)
VALUES (
        'Morina pink',
        'barang_Images/7c03f799.poto.233332.jpg',
        1500,
        -2
    ),
    (
        'Sus vla',
        'barang_Images/bc8fa64b.poto.233527.jpg',
        2000,
        5
    ),
    (
        'Tahu bakso',
        'barang_Images/ca1ee3ad.poto.233531.jpg',
        1700,
        8
    ),
    (
        'Risol mayo',
        'barang_Images/71ac19a1.poto.233651.jpg',
        2000,
        0
    ),
    (
        'Donad',
        'barang_Images/f6fcae00.poto.000642.jpg',
        1300,
        8
    );