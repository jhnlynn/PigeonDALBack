CREATE TABLE "user_info" (
  "id" SERIAL PRIMARY KEY NOT NULL,
  "user_id" varchar NOT NULL,
  "full_name" varchar(50),
  "email" varchar(50),
  "type" int
);

CREATE TABLE "batch_info" (
  "id" SERIAL PRIMARY KEY NOT NULL,
  "item_id" varchar NOT NULL,
  "name" varchar NOT NULL,
  "uom" int,
  "status" int,
  "user_id" varchar NOT NULL,
  "current_package_id" varchar,
  "unit_number" int
);

CREATE TABLE "package_info" (
  "id" SERIAL PRIMARY KEY NOT NULL,
  "package_id" varchar NOT NULL,
  "destination" varchar NOT NULL,
  "arrival_time" datetime NOT NULL,
  "tracking_id" varchar NOT NULL
);

CREATE TABLE "inventory_info" (
  "id" SERIAL PRIMARY KEY NOT NULL,
  "inventory_id" varchar NOT NULL,
  "location" varchar,
  "capacity" int,
  "last_time_inventory_id" int
);

CREATE TABLE "user_type" (
  "type_num" int,
  "user_id" varchar
);

ALTER TABLE "inventory_info" ADD FOREIGN KEY ("last_time_inventory_id") REFERENCES "inventory_info" ("inventory_id");

ALTER TABLE "user_type" ADD FOREIGN KEY ("user_id") REFERENCES "user_info" ("user_id");

ALTER TABLE "package_info" ADD FOREIGN KEY ("destination") REFERENCES "batch_info" ("uom");

ALTER TABLE "package_info" ADD FOREIGN KEY ("package_id") REFERENCES "package_info" ("id");
