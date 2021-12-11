PGDMP                         y            jourina    13.3    13.3 9    �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    25600    jourina    DATABASE     d   CREATE DATABASE jourina WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Russian_Russia.1251';
    DROP DATABASE jourina;
                postgres    false            �            1259    25642 
   department    TABLE     T   CREATE TABLE public.department (
    id integer NOT NULL,
    name text NOT NULL
);
    DROP TABLE public.department;
       public         heap    postgres    false            �            1259    25640    department_id_seq    SEQUENCE     �   CREATE SEQUENCE public.department_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 (   DROP SEQUENCE public.department_id_seq;
       public          postgres    false    207            �           0    0    department_id_seq    SEQUENCE OWNED BY     G   ALTER SEQUENCE public.department_id_seq OWNED BY public.department.id;
          public          postgres    false    206            �            1259    25626    journal    TABLE     Q   CREATE TABLE public.journal (
    id integer NOT NULL,
    name text NOT NULL
);
    DROP TABLE public.journal;
       public         heap    postgres    false            �            1259    25624    journal_id_seq    SEQUENCE     �   CREATE SEQUENCE public.journal_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.journal_id_seq;
       public          postgres    false    205            �           0    0    journal_id_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public.journal_id_seq OWNED BY public.journal.id;
          public          postgres    false    204            �            1259    25658    log    TABLE     �   CREATE TABLE public.log (
    id integer NOT NULL,
    "time" text NOT NULL,
    user_id bigint NOT NULL,
    journal_id bigint NOT NULL,
    coordinate text NOT NULL,
    old_value text,
    new_value text
);
    DROP TABLE public.log;
       public         heap    postgres    false            �            1259    25656 
   log_id_seq    SEQUENCE     �   CREATE SEQUENCE public.log_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 !   DROP SEQUENCE public.log_id_seq;
       public          postgres    false    209            �           0    0 
   log_id_seq    SEQUENCE OWNED BY     9   ALTER SEQUENCE public.log_id_seq OWNED BY public.log.id;
          public          postgres    false    208            �            1259    25679    note    TABLE     c  CREATE TABLE public.note (
    id integer NOT NULL,
    income_date text NOT NULL,
    start_date text NOT NULL,
    end_date text NOT NULL,
    probe_code text NOT NULL,
    probe_id bigint NOT NULL,
    element bigint NOT NULL,
    document text NOT NULL,
    probe_weight_f real NOT NULL,
    probe_weight_s real NOT NULL,
    size real NOT NULL,
    result_f real NOT NULL,
    result_s real NOT NULL,
    divergence real NOT NULL,
    norma real NOT NULL,
    proportion real NOT NULL,
    error real NOT NULL,
    result_date text NOT NULL,
    users_id bigint NOT NULL,
    journal_id bigint NOT NULL
);
    DROP TABLE public.note;
       public         heap    postgres    false            �            1259    25677    note_id_seq    SEQUENCE     �   CREATE SEQUENCE public.note_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 "   DROP SEQUENCE public.note_id_seq;
       public          postgres    false    211            �           0    0    note_id_seq    SEQUENCE OWNED BY     ;   ALTER SEQUENCE public.note_id_seq OWNED BY public.note.id;
          public          postgres    false    210            �            1259    25615    roles    TABLE     O   CREATE TABLE public.roles (
    id integer NOT NULL,
    name text NOT NULL
);
    DROP TABLE public.roles;
       public         heap    postgres    false            �            1259    25613    roles_id_seq    SEQUENCE     �   CREATE SEQUENCE public.roles_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 #   DROP SEQUENCE public.roles_id_seq;
       public          postgres    false    203            �           0    0    roles_id_seq    SEQUENCE OWNED BY     =   ALTER SEQUENCE public.roles_id_seq OWNED BY public.roles.id;
          public          postgres    false    202            �            1259    25603    users    TABLE       CREATE TABLE public.users (
    id integer NOT NULL,
    login text NOT NULL,
    password text NOT NULL,
    name text NOT NULL,
    role bigint NOT NULL,
    department bigint NOT NULL,
    CONSTRAINT users_password_check CHECK ((length(password) >= 6))
);
    DROP TABLE public.users;
       public         heap    postgres    false            �            1259    25601    users_id_seq    SEQUENCE     �   CREATE SEQUENCE public.users_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 #   DROP SEQUENCE public.users_id_seq;
       public          postgres    false    201            �           0    0    users_id_seq    SEQUENCE OWNED BY     =   ALTER SEQUENCE public.users_id_seq OWNED BY public.users.id;
          public          postgres    false    200            J           2604    25645    department id    DEFAULT     n   ALTER TABLE ONLY public.department ALTER COLUMN id SET DEFAULT nextval('public.department_id_seq'::regclass);
 <   ALTER TABLE public.department ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    206    207    207            I           2604    25629 
   journal id    DEFAULT     h   ALTER TABLE ONLY public.journal ALTER COLUMN id SET DEFAULT nextval('public.journal_id_seq'::regclass);
 9   ALTER TABLE public.journal ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    204    205    205            K           2604    25661    log id    DEFAULT     `   ALTER TABLE ONLY public.log ALTER COLUMN id SET DEFAULT nextval('public.log_id_seq'::regclass);
 5   ALTER TABLE public.log ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    208    209    209            L           2604    25682    note id    DEFAULT     b   ALTER TABLE ONLY public.note ALTER COLUMN id SET DEFAULT nextval('public.note_id_seq'::regclass);
 6   ALTER TABLE public.note ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    211    210    211            H           2604    25618    roles id    DEFAULT     d   ALTER TABLE ONLY public.roles ALTER COLUMN id SET DEFAULT nextval('public.roles_id_seq'::regclass);
 7   ALTER TABLE public.roles ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    202    203    203            F           2604    25606    users id    DEFAULT     d   ALTER TABLE ONLY public.users ALTER COLUMN id SET DEFAULT nextval('public.users_id_seq'::regclass);
 7   ALTER TABLE public.users ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    201    200    201            �           2613    25698    25698    BLOB     &   SELECT pg_catalog.lo_create('25698');
 &   SELECT pg_catalog.lo_unlink('25698');
                postgres    false            �           2613    25699    25699    BLOB     &   SELECT pg_catalog.lo_create('25699');
 &   SELECT pg_catalog.lo_unlink('25699');
                postgres    false            �          0    25642 
   department 
   TABLE DATA           .   COPY public.department (id, name) FROM stdin;
    public          postgres    false    207   S=       �          0    25626    journal 
   TABLE DATA           +   COPY public.journal (id, name) FROM stdin;
    public          postgres    false    205   �=       �          0    25658    log 
   TABLE DATA           `   COPY public.log (id, "time", user_id, journal_id, coordinate, old_value, new_value) FROM stdin;
    public          postgres    false    209   �=       �          0    25679    note 
   TABLE DATA           �   COPY public.note (id, income_date, start_date, end_date, probe_code, probe_id, element, document, probe_weight_f, probe_weight_s, size, result_f, result_s, divergence, norma, proportion, error, result_date, users_id, journal_id) FROM stdin;
    public          postgres    false    211   �=       �          0    25615    roles 
   TABLE DATA           )   COPY public.roles (id, name) FROM stdin;
    public          postgres    false    203   >       �          0    25603    users 
   TABLE DATA           L   COPY public.users (id, login, password, name, role, department) FROM stdin;
    public          postgres    false    201   7>                   0    0    department_id_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public.department_id_seq', 4, true);
          public          postgres    false    206                       0    0    journal_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.journal_id_seq', 1, true);
          public          postgres    false    204                       0    0 
   log_id_seq    SEQUENCE SET     8   SELECT pg_catalog.setval('public.log_id_seq', 1, true);
          public          postgres    false    208                       0    0    note_id_seq    SEQUENCE SET     :   SELECT pg_catalog.setval('public.note_id_seq', 1, false);
          public          postgres    false    210                       0    0    roles_id_seq    SEQUENCE SET     :   SELECT pg_catalog.setval('public.roles_id_seq', 3, true);
          public          postgres    false    202                       0    0    users_id_seq    SEQUENCE SET     :   SELECT pg_catalog.setval('public.users_id_seq', 2, true);
          public          postgres    false    200            �          0    0    BLOBS    BLOBS                             false   �>       V           2606    25650    department department_pkey 
   CONSTRAINT     X   ALTER TABLE ONLY public.department
    ADD CONSTRAINT department_pkey PRIMARY KEY (id);
 D   ALTER TABLE ONLY public.department DROP CONSTRAINT department_pkey;
       public            postgres    false    207            T           2606    25634    journal journal_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.journal
    ADD CONSTRAINT journal_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.journal DROP CONSTRAINT journal_pkey;
       public            postgres    false    205            Z           2606    25666    log log_pkey 
   CONSTRAINT     J   ALTER TABLE ONLY public.log
    ADD CONSTRAINT log_pkey PRIMARY KEY (id);
 6   ALTER TABLE ONLY public.log DROP CONSTRAINT log_pkey;
       public            postgres    false    209            N           2606    25701    users login_unique 
   CONSTRAINT     N   ALTER TABLE ONLY public.users
    ADD CONSTRAINT login_unique UNIQUE (login);
 <   ALTER TABLE ONLY public.users DROP CONSTRAINT login_unique;
       public            postgres    false    201            X           2606    25703    department name_unique 
   CONSTRAINT     Q   ALTER TABLE ONLY public.department
    ADD CONSTRAINT name_unique UNIQUE (name);
 @   ALTER TABLE ONLY public.department DROP CONSTRAINT name_unique;
       public            postgres    false    207            \           2606    25687    note note_pkey 
   CONSTRAINT     L   ALTER TABLE ONLY public.note
    ADD CONSTRAINT note_pkey PRIMARY KEY (id);
 8   ALTER TABLE ONLY public.note DROP CONSTRAINT note_pkey;
       public            postgres    false    211            R           2606    25623    roles roles_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.roles
    ADD CONSTRAINT roles_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.roles DROP CONSTRAINT roles_pkey;
       public            postgres    false    203            P           2606    25612    users users_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.users DROP CONSTRAINT users_pkey;
       public            postgres    false    201            `           2606    25672    log log_journal_id_fkey    FK CONSTRAINT     {   ALTER TABLE ONLY public.log
    ADD CONSTRAINT log_journal_id_fkey FOREIGN KEY (journal_id) REFERENCES public.journal(id);
 A   ALTER TABLE ONLY public.log DROP CONSTRAINT log_journal_id_fkey;
       public          postgres    false    209    2900    205            _           2606    25667    log log_user_id_fkey    FK CONSTRAINT     s   ALTER TABLE ONLY public.log
    ADD CONSTRAINT log_user_id_fkey FOREIGN KEY (user_id) REFERENCES public.users(id);
 >   ALTER TABLE ONLY public.log DROP CONSTRAINT log_user_id_fkey;
       public          postgres    false    201    2896    209            b           2606    25693    note note_journal_id_fkey    FK CONSTRAINT     }   ALTER TABLE ONLY public.note
    ADD CONSTRAINT note_journal_id_fkey FOREIGN KEY (journal_id) REFERENCES public.journal(id);
 C   ALTER TABLE ONLY public.note DROP CONSTRAINT note_journal_id_fkey;
       public          postgres    false    205    211    2900            a           2606    25688    note note_users_id_fkey    FK CONSTRAINT     w   ALTER TABLE ONLY public.note
    ADD CONSTRAINT note_users_id_fkey FOREIGN KEY (users_id) REFERENCES public.users(id);
 A   ALTER TABLE ONLY public.note DROP CONSTRAINT note_users_id_fkey;
       public          postgres    false    211    2896    201            ^           2606    25651    users users_department_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_department_fkey FOREIGN KEY (department) REFERENCES public.department(id);
 E   ALTER TABLE ONLY public.users DROP CONSTRAINT users_department_fkey;
       public          postgres    false    201    207    2902            ]           2606    25635    users users_role_fkey    FK CONSTRAINT     q   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_role_fkey FOREIGN KEY (role) REFERENCES public.roles(id);
 ?   ALTER TABLE ONLY public.users DROP CONSTRAINT users_role_fkey;
       public          postgres    false    203    2898    201            �   $   x�3�442�2�425���2Ӗ\&�)�\1z\\\ Ta      �      x�3���/-�K������ $S�      �   &   x�3�44�34�3202�AGCNCSN#C�=... Y�      �      x������ � �      �   &   x�3�tt����2��u�stw�2���2b���� sE�      �   ;   x�3���O���,H,..�/J��K�MaNCNC.#����"NC#cS30*e����� `c      �   bd      x�KI-H,*�M�+ �5      cd   
   x�K1  � �          