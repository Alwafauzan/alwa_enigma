INSERT INTO m_table (id, meja_name, id_customer)
VALUES (
        (
            (
                SELECT COALESCE(MAX(id)::text, '0')::integer + 1
                FROM m_table
            )
        ),
        (
            SELECT 'Meja ' || floor(random() * 100 + 1)::text
        ),
        (
            '56f1ab25-93fa-4e55-881b-ce29a9d52ca4'::uuid
        )
    );
-- SELECT *
-- FROM m_customer;
INSERT INTO m_tansaksi (
        jumlah_transaksi,
        table_name,
        id_meja,
        id_customer
    )
VALUES (
        (1000),
        ('ascdc'),
        (1),
        (
            '56f1ab25-93fa-4e55-881b-ce29a9d52ca4'::uuid
        )
    )
INSERT INTO m_transaksi (
        meja_name,
        id_customer,
        id_meja,
        jumlah_transaksi
    )
VALUES (
        'skxmasklxm',
        '56f1ab25-93fa-4e55-881b-ce29a9d52ca4',
        '1',
        2000
    );