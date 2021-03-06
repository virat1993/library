INSERT INTO books (id, name, author, publication, year_of_publication, isbn_no, quantity) VALUES
  ('1','Junior Level Books Introduction to Computer', 'Amit Garg', 'Readers Zone', '2011', '9789350195611', '10');
INSERT INTO books (id, name, author, publication, year_of_publication, isbn_no, quantity) VALUES
  ('2','Publish News Letter', 'Amit Garg', 'MCA Department MIET Meerut', '2011', '9789350195612', '50');
INSERT INTO books (id, name, author, publication, year_of_publication, isbn_no, quantity) VALUES
  ('3','.NET Framework & C', 'Sharad Kumar Verma', 'Sun India Publication New Delhi', '2009', '97893501956', '25');
INSERT INTO books (id, name, author, publication, year_of_publication, isbn_no, quantity) VALUES
  ('4','Data Structure Using C', 'Sharad Kumar Verma', 'Sun India Publication New Delhi', '2015', '978935019563', '25');

INSERT INTO users (id, name, address, library_card_number, is_active) VALUES
    ('1','Aman Patil', 'Dubai', '01', 1);
INSERT INTO users (id, name, address, library_card_number, is_active) VALUES
    ('2','Sujit Gowda', 'Bangalore', '02', 1);

INSERT INTO borrow (id, library_card_number, book_id, user_id, is_returned) VALUES
        ('1','LB1', '1', '1', 1);

