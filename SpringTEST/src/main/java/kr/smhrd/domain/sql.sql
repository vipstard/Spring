create table Book(
	num number(4),
	title varchar2(50) not null,
	author varchar2(30) not null,
	company varchar2(50) not null,
	isbn varchar2(30) not null,
	count number(4) not null,
	constraint pk_n primary key(num)
	);

create sequence book_seq
start with 1
increment by 1
maxvalue 100
cycle
nocache;

select * from book

insert into Book values (book_seq.nextval, '코드로배우는 스프링 웹프로젝트', '구멍가게 코딩단', '남가람부스', '979-11-89184-01-8', '100');
insert into Book values (book_seq.nextval, '생활코딩! Node.js 프로그래밍', '이고잉', '위키북스', '979-11-5839-238-3', '88');
insert into Book values (book_seq.nextval, '전자정부 표준프레임워크', '채큐태,표선영', '루비페이퍼', '979-11-86710-37-1', '120');
insert into Book values (book_seq.nextval, '토비의 스프링3.1', '이일민', '에이콘', '978-89-6077-341-7', '50');
insert into Book values (book_seq.nextval, '자바 채팅 프로그래밍', '안용화', '구민사', '978-89-7074-776-7', '70');
