SET REFERENTIAL_INTEGRITY FALSE;

TRUNCATE TABLE shop;
TRUNCATE TABLE operating_hour;
TRUNCATE TABLE users;

SET REFERENTIAL_INTEGRITY TRUE;

ALTER TABLE shop ALTER COLUMN id RESTART WITH 1;
ALTER TABLE operating_hour ALTER COLUMN id RESTART WITH 1;
ALTER TABLE users ALTER COLUMN id RESTART WITH 1;

INSERT INTO shop (name, type, detail)
VALUES ('칰칰폭폭 치킨집', '야식', '맛있어요. 살안찝니다.');
INSERT INTO shop (name, type, detail)
VALUES ('뿡뿡이가 좋아요 중국집', '중식', '사천짜장이 기가막혀요');
INSERT INTO shop (name, type, detail)
VALUES ('민수네 떡볶이', '분식', '컵떡 500원');

INSERT INTO operating_hour (shop_id, day_of_week, time)
VALUES (1, 'MONDAY', '12:00');
INSERT INTO operating_hour (shop_id, day_of_week, time)
VALUES (1, 'TUESDAY', '12:00');
INSERT INTO operating_hour (shop_id, day_of_week, time)
VALUES (1, 'WEDNESDAY', '12:00');
INSERT INTO operating_hour (shop_id, day_of_week, time)
VALUES (1, 'THURSDAY', '12:00');
INSERT INTO operating_hour (shop_id, day_of_week, time)
VALUES (1, 'FRIDAY', '12:00');

INSERT INTO operating_hour (shop_id, day_of_week, time)
VALUES (2, 'SATURDAY', '20:00');
INSERT INTO operating_hour (shop_id, day_of_week, time)
VALUES (2, 'SATURDAY', '21:00');
INSERT INTO operating_hour (shop_id, day_of_week, time)
VALUES (2, 'SATURDAY', '22:00');

INSERT INTO users (name, email, password)
VALUES ('고영희', 'meow@example.com', '1234');
INSERT INTO users (name, email, password)
VALUES ('모코', 'moko@example.com', '1234');
INSERT INTO users (name, email, password)
VALUES ('메론', 'melon@example.com', '1234');
