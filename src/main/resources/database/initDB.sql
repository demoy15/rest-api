CREATE TABLE public.book
(
    id bigserial NOT NULL,
    title character varying NOT NULL,
    author character varying NOT NULL,
    price bigint NOT NULL,
    PRIMARY KEY (id)
);
CREATE TABLE public.person
(
    id bigserial NOT NULL,
    name character varying NOT NULL,
    last_name character varying NOT NULL,
    PRIMARY KEY (id)
);
CREATE TABLE public.orders
(
    id bigserial NOT NULL,
    person_id bigint references public."person"(id) NOT NULL,
    status character NOT NULL,
    PRIMARY KEY (id)
);
CREATE TABLE public.order_book
(
    orders_id bigint references "orders"(id) NOT NULL,
    books_id bigint references book(id) NOT NULL
);




