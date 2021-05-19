

INSERT INTO CORE.TB_USER VALUES(CORE.SEQ_USER.nextval, 'Nokia447x', sysdate);
INSERT INTO CORE.TB_POST VALUES(CORE.SEQ_POST.nextval, CORE.SEQ_USER.currval, sysdate, 'Meu primeiro post', 0);


