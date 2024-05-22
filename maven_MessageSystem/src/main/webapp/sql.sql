-- 회원의 정보를 관리할 수 있는 테이블 생성--
create table web_member( 
	email varchar2(50) primary key,
	pw varchar2(50) not null,
	tel varchar2(50) not null,
	address varchar2(100) not null

);
insert into WEB_MEMBER values('admin','1234','010555','산정동')


select * from web_member

select case when count(*)>0 then 1 else 0 end result from WEB_MEMBER where email ='admin'


--메세지를 관리하기 위한 테이블 생성--
--메세지의 번호(pk), 보내는 사람, 받는 사람, 내용, 보낸 날짜--

create table web_message(
 	num number primary key,
 	sendName varchar2(50) not null,
 	receiveEmail varchar2(50) not null,
 	message varchar2(100) not null,
 	m_date date 
);

select * from web_message;

-- 메세지 추가시 자동적으로 num을 생성해줄 시퀀스 생성!--
create  sequence num_message increment by 1 start with 1 --increment: 증가--


insert into web_message 
values(num_message.nextval,'csm','test','test Message',sysdate);
	
insert into web_message 
values(num_message.nextval,'jkjk5656','test','test Message2',sysdate);


select * from web_message;



-- 게시판 사용을 위한 테이블 생성--
	
	create table web_board(
		num number primary key,
		title varchar2(50) not null,
		writer varchar2(50) not null,
		filename varchar2(100),
		content varchar2(100) not null,
		
	);
	select * from web_board;
	
	-- 게시글 추가시 자동적으로 num을 생성해줄 시퀀스 생성!--
create  sequence num_board increment by 1 start with 1


	
	












