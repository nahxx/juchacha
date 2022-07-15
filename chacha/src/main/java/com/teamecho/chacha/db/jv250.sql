DROP TABLE Voucher_use;
DROP TABLE Review;
DROP TABLE Favorite;
DROP TABLE Reservation;
DROP TABLE Voucher;
DROP TABLE Parkinglot_Use;
DROP TABLE Parkinglot;
DROP TABLE UserInfo;


CREATE TABLE UserInfo(
   uid				BIGINT			PRIMARY KEY AUTO_INCREMENT,
   userId			VARCHAR(20)		NOT NULL,
   passwd			VARCHAR(20)		NOT NULL,
   userName			VARCHAR(20)		NOT NULL,
   userPhone		VARCHAR(13)			NULL,
   addr				VARCHAR(60)			NULL,
   licenseNumber	VARCHAR(10)		NOT NULL,
   userType			VARCHAR(1)		NOT	NULL	DEFAULT 'Y',
   regDate			TIMESTAMP		NOT NULL	DEFAULT CURRENT_TIMESTAMP
)AUTO_INCREMENT = 1;

CREATE TABLE Parkinglot (
   pid         		BIGINT			PRIMARY KEY AUTO_INCREMENT, -- PRIMARY KEY는 자동으로 NOT NULL임, AUTO_INCREMENT는 INSERT 될 때마다 자동으로 증가해주는 키워드
   parkingCode		VARCHAR(20)		NOT NULL, -- 주차장 코드
   parkingName		VARCHAR(20)		NOT NULL, -- 주차장 이름
   parkingAddr      VARCHAR(60)		NOT NULL, -- 주차장 주소
   parkingTel		VARCHAR(13)			NULL, -- 주차장 연락처
   timeCost			DOUBLE			NOT NULL	DEFAULT 0, 
   dayCost			DOUBLE			NOT NULL	DEFAULT 0, 
   monthCost		DOUBLE 			NOT NULL	DEFAULT 0,
   parkingSpace		INT				NOT NULL	DEFAULT 0,
   pointX			DOUBLE			NOT NULL,
   pointY			DOUBLE			NOT NULL,
   regDate			TIMESTAMP		NOT NULL	DEFAULT CURRENT_TIMESTAMP -- 데이터가 들어온 날짜를 입력하기 위해 만듬(값이 안들어갔을 대 현재의 TIMESTAMP값을 넣겠다는 의미)
) AUTO_INCREMENT = 1; -- 1번부터 시작한다는 의미(초기 셋팅값)

CREATE TABLE Parkinglot_Use (
   puid        		BIGINT			PRIMARY KEY AUTO_INCREMENT, -- PRIMARY KEY는 자동으로 NOT NULL임, AUTO_INCREMENT는 INSERT 될 때마다 자동으로 증가해주는 키워드
   useSpaces		INT				NOT NULL	DEFAULT 0,
   pid				BIGINT			NOT NULL,
   regDate			TIMESTAMP		NOT NULL	DEFAULT CURRENT_TIMESTAMP, -- 데이터가 들어온 날짜를 입력하기 위해 만듬(값이 안들어갔을 대 현재의 TIMESTAMP값을 넣겠다는 의미)
   
   CONSTRAINT Parkinglot_Use_Pid_FK FOREIGN KEY (pid) REFERENCES Parkinglot(pid)
) AUTO_INCREMENT = 1; -- 1번부터 시작한다는 의미(초기 셋팅값)

CREATE TABLE Voucher (
   vid				BIGINT			PRIMARY KEY AUTO_INCREMENT,
   vType			VARCHAR(1)		NOT NULL,
   buyTime			INT				NOT NULL	DEFAULT 0,
   regDate			TIMESTAMP		NOT NULL	DEFAULT CURRENT_TIMESTAMP
)AUTO_INCREMENT = 1;

CREATE TABLE Reservation (
   rid				BIGINT			PRIMARY KEY AUTO_INCREMENT, -- 1부터 자동으로 증가
   start_time		TIMESTAMP		NOT NULL,
   end_time			TIMESTAMP		NOT NULL,
   cost				INT				NOT NULL	DEFAULT 0, -- 값을 입력하지 않으면 디폴트값 0으로 적용
   voucher_use		VARCHAR(1)		NOT NULL	DEFAULT 'N', -- 예약 당시 N으로 디폴트, 사용시 Y로 변경
   uid				BIGINT			NOT NULL,
   pid				BIGINT			NOT NULL,
   regDate			TIMESTAMP		NOT NULL	DEFAULT CURRENT_TIMESTAMP,
   
   CONSTRAINT Reservation_Uid_FK FOREIGN KEY (uid) REFERENCES UserInfo(uid),
   CONSTRAINT Reservation_Pid_FK FOREIGN KEY (pid) REFERENCES ParkingLot(pid)   
) AUTO_INCREMENT = 1;

CREATE TABLE Favorite (
   fid				BIGINT			PRIMARY KEY AUTO_INCREMENT,
   uid				BIGINT			NOT NULL,
   pid				BIGINT			NOT NULL,
   regDate			TIMESTAMP		NOT NULL	DEFAULT CURRENT_TIMESTAMP,
   
   CONSTRAINT Favorite_Uid_FK FOREIGN KEY (uid) REFERENCES UserInfo(uid),
   CONSTRAINT Favorite_Pid_FK FOREIGN KEY (pid) REFERENCES ParkingLot(pid)
)AUTO_INCREMENT = 1;

CREATE TABLE Review (
   rvid				BIGINT			PRIMARY KEY AUTO_INCREMENT,      
   uid				BIGINT			NOT NULL,
   pid				BIGINT			NOT NULL,
   content			VARCHAR(100)		NULL,   
   star_rating		INT				NOT NULL	DEFAULT 5,
   regDate			TIMESTAMP		NOT NULL	DEFAULT CURRENT_TIMESTAMP,
   
   CONSTRAINT Review_Uid_FK FOREIGN KEY (uid) REFERENCES UserInfo(uid),
   CONSTRAINT Review_Pid_FK FOREIGN KEY (pid) REFERENCES ParkingLot(pid)
) AUTO_INCREMENT = 1;

CREATE TABLE Voucher_use (
   vuid				BIGINT			PRIMARY KEY AUTO_INCREMENT,
   useTime			INT				NOT NULL,
   vuse				VARCHAR(1)		NOT NULL	DEFAULT 'N',
   uid				BIGINT			NOT NULL,
   vid				BIGINT			NOT NULL,
   rid				BIGINT				NULL,
   regDate			TIMESTAMP		NOT NULL	DEFAULT CURRENT_TIMESTAMP,
   
   CONSTRAINT Voucher_use_Uid_FK FOREIGN KEY (uid) REFERENCES UserInfo(uid),
   CONSTRAINT Voucher_use_Vid_FK FOREIGN KEY (vid) REFERENCES Voucher(vid),
   CONSTRAINT Voucher_use_Rid_FK FOREIGN KEY (rid) REFERENCES Reservation(rid)
)AUTO_INCREMENT = 1;

CREATE TABLE Parking_Keyword (
   pkid				BIGINT   		PRIMARY KEY AUTO_INCREMENT, -- 1부터 자동으로 증가
   keyword			VARCHAR(60)		NOT NULL,
   pid				BIGINT			NOT NULL,
   regDate			TIMESTAMP		NOT NULL	DEFAULT CURRENT_TIMESTAMP,
   
   CONSTRAINT Parking_Keyword_FK FOREIGN KEY (pid) REFERENCES ParkingLot(pid)   
) AUTO_INCREMENT = 1;