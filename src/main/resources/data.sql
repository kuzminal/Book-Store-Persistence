Delete from bookstore.author_book;
Delete from bookstore.book;
Delete from bookstore.author;
Delete from bookstore.publisher;


INSERT into bookstore.author (id, age, genre, name)
values (1, 34, 'History', 'Joana Nimar');
INSERT into bookstore.author (id, age, genre, name)
values (2, 38, 'Anthology', 'Alicia Tom');

insert into bookstore.publisher (id, company)
values (1, 'Company 1');

insert into bookstore.book (id, isbn, title, publisher_id)
values (1, '001-JN', 'A History of Ancient Prague', 1);

insert into bookstore.book (id, isbn, title, publisher_id)
values (2, '002-JN', 'A Peoples History', 1);

insert into bookstore.author_book (author_id, book_id)
values (1, 1);
insert into bookstore.author_book (author_id, book_id)
values (2, 2);