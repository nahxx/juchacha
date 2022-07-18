SELECT v.vtype, v.buyTime, vu.useTime, vu.vuse, vu.regDate
FROM Voucher_use vu INNER JOIN Voucher v ON vu.vid = v.vid 
WHERE vu.uid = 4
;


SELECT v.vtype, v.buyTime, vu.useTime, vu.vuse, vu.regDate
	      		FROM Voucher_use vu INNER JOIN Voucher v ON vu.vid = v.vid
	      		WHERE vu.uid = 4
	      		;
	      		
SELECT * FROM Review;
SELECT AVG(star_rating) as avg FROM Review WHERE pid=2;

SELECT r.pid, r.content, r.star_rating, r.regDate, u.userId FROM Review r INNER JOIN UserInfo u ON r.uid = u.uid WHERE r.pid = 1 order by  r.regDate desc;