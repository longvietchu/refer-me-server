CREATE TABLE "users" (
  "id" SERIAL PRIMARY KEY,
  "name" varchar NOT NULL,
  "email" varchar NOT NULL,
  "password" varchar NOT NULL,
  "dob" timestamp,
  "avatar" text,
  "background_image" text,
  "about" text,
  "gender" int,
  "created_at" timestamp NOT NULL
);

CREATE TABLE "experiences" (
  "id" SERIAL PRIMARY KEY,
  "job_title" varchar NOT NULL,
  "job_description" text,
  "company" varchar NOT NULL,
  "location" varchar,
  "employment_type" varchar,
  "joined_at" timestamp,
  "left_at" timestamp,
  "user_id" int,
  "organization_id" int
);

CREATE TABLE "educations" (
  "id" SERIAL PRIMARY KEY,
  "title" varchar NOT NULL,
  "description" text,
  "joined_at" timestamp,
  "graduated_at" timestamp,
  "user_id" int,
  "organization_id" int
);

CREATE TABLE "countries" (
  "id" SERIAL PRIMARY KEY,
  "province" varchar,
  "city" varchar,
  "country" varchar,
  "headquarter" boolean,
  "organization_id" int
);

CREATE TABLE "organizations" (
  "id" SERIAL PRIMARY KEY,
  "name" varchar NOT NULL,
  "avatar" varchar,
  "background_image" varchar,
  "description" text,
  "website" varchar,
  "industry" varchar,
  "company_size" int,
  "founded" varchar
);

CREATE TABLE "skills" (
  "id" SERIAL PRIMARY KEY,
  "name" varchar NOT NULL,
  "votes" int,
  "user_id" int
);

CREATE TABLE "posts" (
  "id" SERIAL PRIMARY KEY,
  "description" text,
  "created_at" timestamp,
  "user_id" int
);

CREATE TABLE "post_images" (
  "id" SERIAL PRIMARY KEY,
  "link" varchar,
  "created_at" timestamp,
  "post_id" int
);

CREATE TABLE "reactions" (
  "id" SERIAL PRIMARY KEY,
  "user_id" int,
  "post_id" int
);

CREATE TABLE "comments" (
  "id" SERIAL PRIMARY KEY,
  "body" text NOT NULL,
  "created_at" varchar,
  "user_id" int,
  "post_id" int
);

CREATE TABLE "connections" (
  "id" varchar PRIMARY KEY,
  "sender_id" int,
  "receiver_id" int,
  "created_at" timestamp
);

CREATE TABLE "jobs" (
  "id" SERIAL PRIMARY KEY,
  "title" varchar NOT NULL,
  "location" varchar,
  "description" text,
  "seniority_level" varchar,
  "employment_type" varchar,
  "industry" varchar,
  "job_functions" varchar,
  "created_at" timestamp,
  "organization_id" int
);

CREATE TABLE "applicants" (
  "id" SERIAL PRIMARY KEY,
  "job_id" int,
  "user_id" int,
  "created_at" timestamp
);

CREATE TABLE "rooms" (
  "id" varchar PRIMARY KEY,
  "creator_id" int NOT NULL,
  "receiver_id" int NOT NULL,
  "created_at" timestamp
);

CREATE TABLE "messages" (
  "id" SERIAL PRIMARY KEY,
  "room_id" varchar NOT NULL,
  "from" int NOT NULL,
  "to" int NOT NULL,
  "content" text NOT NULL,
  "is_seen" boolean NOT NULL,
  "type" varchar,
  "created_at" timestamp
);

ALTER TABLE "educations" ADD FOREIGN KEY ("user_id") REFERENCES "users" ("id");

ALTER TABLE "experiences" ADD FOREIGN KEY ("user_id") REFERENCES "users" ("id");

ALTER TABLE "skills" ADD FOREIGN KEY ("user_id") REFERENCES "users" ("id");

ALTER TABLE "countries" ADD FOREIGN KEY ("organization_id") REFERENCES "organizations" ("id");

ALTER TABLE "experiences" ADD FOREIGN KEY ("organization_id") REFERENCES "organizations" ("id");

ALTER TABLE "educations" ADD FOREIGN KEY ("organization_id") REFERENCES "organizations" ("id");

ALTER TABLE "post_images" ADD FOREIGN KEY ("post_id") REFERENCES "posts" ("id");

ALTER TABLE "posts" ADD FOREIGN KEY ("user_id") REFERENCES "users" ("id");

ALTER TABLE "reactions" ADD FOREIGN KEY ("user_id") REFERENCES "users" ("id");

ALTER TABLE "reactions" ADD FOREIGN KEY ("post_id") REFERENCES "posts" ("id");

ALTER TABLE "comments" ADD FOREIGN KEY ("user_id") REFERENCES "users" ("id");

ALTER TABLE "comments" ADD FOREIGN KEY ("post_id") REFERENCES "posts" ("id");

ALTER TABLE "connections" ADD FOREIGN KEY ("sender_id") REFERENCES "users" ("id");

ALTER TABLE "connections" ADD FOREIGN KEY ("receiver_id") REFERENCES "users" ("id");

ALTER TABLE "jobs" ADD FOREIGN KEY ("organization_id") REFERENCES "organizations" ("id");

ALTER TABLE "applicants" ADD FOREIGN KEY ("job_id") REFERENCES "jobs" ("id");

ALTER TABLE "applicants" ADD FOREIGN KEY ("user_id") REFERENCES "users" ("id");

ALTER TABLE "rooms" ADD FOREIGN KEY ("creator_id") REFERENCES "users" ("id");

ALTER TABLE "rooms" ADD FOREIGN KEY ("receiver_id") REFERENCES "users" ("id");

ALTER TABLE "messages" ADD FOREIGN KEY ("room_id") REFERENCES "rooms" ("id");

ALTER TABLE "messages" ADD FOREIGN KEY ("from") REFERENCES "users" ("id");

ALTER TABLE "messages" ADD FOREIGN KEY ("to") REFERENCES "users" ("id");

COMMENT ON COLUMN "users"."gender" IS '0 male / 1 female / 2 other';

COMMENT ON COLUMN "connections"."id" IS 'sender_id.receiver_id';

COMMENT ON COLUMN "rooms"."id" IS 'creator_id.receiver_id';

COMMENT ON COLUMN "messages"."room_id" IS 'creator_id.receiver_id';
