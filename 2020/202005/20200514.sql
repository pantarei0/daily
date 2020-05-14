--로그 테이블 재생성 + 데이터 이동

--1
ALTER TABLE "YBDS"."CO_SYS_LOG" RENAME TO CO_SYS_LOG_bak;

--2
CREATE TABLE CO_SYS_LOG 
(
 	 SYS_SEQ	 NUMBER(10)  NOT NULL ,
 	 SYS_NM	 VARCHAR2(100)   ,
 	 ...
 	 SQL_CNTN	 CLOB  
)
NOLOGGING COMPRESS FOR OLTP ===>정확한 의미 폿팅
;
--테이블 확인

COMMENT ON COLUMN CO_SYS_LOG.SYS_SEQ IS '시스템순번';
COMMENT ON COLUMN CO_SYS_LOG.SYS_NM IS '시스템명';
...
COMMENT ON TABLE CO_SYS_LOG IS '시스템로그';

--3
INSERT INTO CO_SYS_LOG
--SELECT * FROM CO_SYS_LOG_bak; --컬럼 순서가 맞지 않아 에러
SELECT sys_seq --새로 생성한 테이블의 컬럼 
,sys_nm
...
,sql_cntn
FROM CO_SYS_LOG_bak; --536,439개 행 이(가) 삽입되었습니다.

COMMIT;

--4
DROP TABLE CO_SYS_LOG_bak;  

--5
CREATE UNIQUE INDEX CO_SYS_LOG_PK ON CO_SYS_LOG
 ( SYS_SEQ );

ALTER TABLE CO_SYS_LOG
 ADD CONSTRAINT CO_SYS_LOG_PK PRIMARY KEY ( SYS_SEQ )
 USING INDEX CO_SYS_LOG_PK;
 
