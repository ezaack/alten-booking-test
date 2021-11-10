CREATE TABLE tb_room (
	id uuid PRIMARY KEY,
	number int NOT NULL UNIQUE
);

CREATE TABLE tb_booking (
	id uuid NOT NULL PRIMARY KEY,
	booking_date_time timestamp NOT NULL,
	checkin_date date NOT NULL,
	checkout_date date NOT NULL,
	status varchar(6) NOT NULL,
	room_id uuid NULL,
	CONSTRAINT fk_booking_room FOREIGN KEY (room_id) REFERENCES tb_room(id)
);


CREATE TABLE tb_gest(
	id uuid PRIMARY KEY,
	name varchar(100) NOT NULL,
    age INT NOT NULL,
    main_gest BIT NOT NULL,
    booking_id UUID NOT NULL,
	CONSTRAINT fk_get_booking FOREIGN KEY (booking_id) REFERENCES tb_booking(id)
)