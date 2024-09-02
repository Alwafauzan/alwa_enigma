-- INSERT INTO student (id, jurusan, nama)
-- VALUES (1, 'tb1', 'alwa'),
--     (2, 'tb2', 'malwa'),
--     (3, 'tb3', 'amlwa'),
--     (4, 'tb4', 'almwa'),
--     (5, 'tb5', 'alwma'),
--     (6, 'tb6', 'alwam');
-- ALTER TABLE students
--     RENAME TO matkul;
-- ALTER TABLE matkul
-- RENAME COLUMN id TO matkul_id;
-- RENAME COLUMN name TO matkul_name;
-- RENAME COLUMN age TO student_id;
INSERT INTO matkul (matkul_id, matkul_name, student_id)
VALUES (1, 'matkul1', 1),
    (2, 'matkul2', 1),
    (3, 'matkul3', 1),
    (4, 'matkul4', 1),
    (5, 'matkul5', 2),
    (6, 'matkul6', 2);
INSERT INTO student (id, jurusan, nama)
VALUES (
        id :integer,
        'jurusan:character varying',
        'nama:character varying'
    );
INSERT INTO matkul (matkul_id, matkul_name, student_id)
VALUES (
        matkul_id :integer,
        'matkul_name:character varying',
        student_id :integer
    );
ALTER TABLE matkul
ADD CONSTRAINT fk_matkul_student FOREIGN KEY (student_id) REFERENCES student(id);