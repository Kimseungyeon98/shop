/* 회원 테이블 */
CREATE SEQUENCE MEMBER_SEQ;
CREATE TABLE MEMBER
("NUM" NUMBER NOT NULL,
 "NAME" VARCHAR2(50 BYTE) NOT NULL,
 "ID" VARCHAR2(50 BYTE) NOT NULL,
 "PASSWORD" VARCHAR2(50 BYTE) NOT NULL,
 CONSTRAINT MEMBER_PK PRIMARY KEY (NUM)
);

/* 게시판 테이블 */
CREATE SEQUENCE BOARD_SEQ;
CREATE TABLE BOARD
   ("NUM" NUMBER NOT NULL,
	"TITLE" VARCHAR2(500 BYTE) NOT NULL,
	"CONTENT" VARCHAR2(500 BYTE) NOT NULL,
	"REG_DATE" DATE NOT NULL,
	"MEM_NUM" NUMBER NOT NULL,
    CONSTRAINT BOARD_PK PRIMARY KEY (NUM),
    CONSTRAINT BOARD_FK1 FOREIGN KEY (MEM_NUM) REFERENCES MEMBER(NUM)
);

/* 상품 테이블 */
CREATE SEQUENCE ITEM_SEQ;
CREATE TABLE ITEM
   ("NUM" NUMBER NOT NULL,
	"NAME" VARCHAR2(50 BYTE) NOT NULL,
	"TYPE" VARCHAR2(50 BYTE) NOT NULL,
	"CONTENT" VARCHAR2(500 BYTE) NOT NULL,
	"PRICE" NUMBER NOT NULL,
	"IMAGE" CLOB, 
	"REG_DATE" DATE NOT NULL,
    "QUANTITY" NUMBER(10,0) NOT NULL,
	"MEM_NUM" NUMBER NOT NULL,
    CONSTRAINT ITEM_PK PRIMARY KEY (NUM),
    CONSTRAINT ITEM_FK1 FOREIGN KEY (MEM_NUM) REFERENCES MEMBER(NUM)
   );

/* 관심 상품 테이블 */
CREATE SEQUENCE ITEM_CART_SEQ;
CREATE TABLE ITEM_CART
   ("NUM" NUMBER NOT NULL,
	"MEM_NUM" NUMBER NOT NULL,
	"ITEM_NUM" NUMBER NOT NULL,
	"REG_DATE" DATE NOT NULL,
    CONSTRAINT ITEM_CART_PK PRIMARY KEY (NUM),
    CONSTRAINT ITEM_CART_FK1 FOREIGN KEY (MEM_NUM) REFERENCES MEMBER(NUM),
    CONSTRAINT ITEM_CART_FK2 FOREIGN KEY (ITEM_NUM) REFERENCES ITEM(NUM)
   );

/* 예약 테이블 */
CREATE SEQUENCE RESERVATION_SEQ;
CREATE TABLE RESERVATION
    ("NUM" NUMBER NOT NULL,
     "NAME" VARCHAR2(500) NOT NULL,
     "CONTENT" VARCHAR2(1000) NOT NULL,
     "START_DATE" DATE NOT NULL,
     "END_DATE" DATE,
     "PRICE" NUMBER NOT NULL,
     "MEM_NUM" NUMBER NOT NULL,
     CONSTRAINT RESERVATION_PK PRIMARY KEY (NUM),
     CONSTRAINT RESERVATION_FK1 FOREIGN KEY (MEM_NUM) REFERENCES MEMBER(NUM)
    );