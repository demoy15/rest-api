CREATE TABLE public.books
(
    id bigserial NOT NULL,
    title character varying NOT NULL,
    author character varying NOT NULL,
    PRIMARY KEY (id)
);
CREATE TABLE public.users
(
    id bigserial NOT NULL,
    name character varying NOT NULL,
    last_name character varying NOT NULL,
    PRIMARY KEY (id)
);
CREATE TABLE public.orders
(
    id bigserial NOT NULL,
    user_id bigint references users(id) NOT NULL,
    total_payment bigint NOT NULL,
    status character NOT NULL,
    PRIMARY KEY (id)
);
CREATE TABLE public.orders_books
(
    orders_id bigint references orders(id) NOT NULL,
    books_id bigint references books(id) NOT NULL
);




