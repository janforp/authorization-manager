/*
Navicat PGSQL Data Transfer

Source Server         : docker
Source Server Version : 90601
Source Host           : 192.168.99.100:5432
Source Database       : zbmatsu
Source Schema         : iam

Target Server Type    : PGSQL
Target Server Version : 90601
File Encoding         : 65001

Date: 2016-12-31 14:36:35
*/


-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS "iam"."permission";
CREATE TABLE "iam"."permission" (
"id" varchar(36) COLLATE "default" NOT NULL,
"role_id" varchar(36) COLLATE "default" NOT NULL,
"resource_id" varchar(36) COLLATE "default" NOT NULL
)
WITH (OIDS=FALSE)

;
COMMENT ON COLUMN "iam"."permission"."id" IS 'ID';
COMMENT ON COLUMN "iam"."permission"."role_id" IS '角色ID';
COMMENT ON COLUMN "iam"."permission"."resource_id" IS '资源ID';

-- ----------------------------
-- Alter Sequences Owned By
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table permission
-- ----------------------------
ALTER TABLE "iam"."permission" ADD PRIMARY KEY ("id");


/*
Navicat PGSQL Data Transfer

Source Server         : docker
Source Server Version : 90601
Source Host           : 192.168.99.100:5432
Source Database       : zbmatsu
Source Schema         : iam

Target Server Type    : PGSQL
Target Server Version : 90601
File Encoding         : 65001

Date: 2016-12-31 14:36:42
*/


-- ----------------------------
-- Table structure for resource
-- ----------------------------
DROP TABLE IF EXISTS "iam"."resource";
CREATE TABLE "iam"."resource" (
"id" varchar(36) COLLATE "default" NOT NULL,
"name" varchar(255) COLLATE "default" NOT NULL,
"type" varchar(20) COLLATE "default" NOT NULL,
"url" varchar(255) COLLATE "default",
"parent_id" varchar(36) COLLATE "default" DEFAULT 0 NOT NULL,
"icon_image" varchar(255) COLLATE "default",
"sort" int4,
"status" char(1) COLLATE "default" NOT NULL,
"certificates" varchar(255) COLLATE "default" NOT NULL,
"description" varchar(255) COLLATE "default"
)
WITH (OIDS=FALSE)

;
COMMENT ON COLUMN "iam"."resource"."id" IS 'ID';
COMMENT ON COLUMN "iam"."resource"."name" IS '资源名称';
COMMENT ON COLUMN "iam"."resource"."type" IS '资源类型(''button'',''menu'',''link'')';
COMMENT ON COLUMN "iam"."resource"."url" IS '资源访问url';
COMMENT ON COLUMN "iam"."resource"."parent_id" IS '父资源ID(最上层ID为0)';
COMMENT ON COLUMN "iam"."resource"."icon_image" IS '资源icon';
COMMENT ON COLUMN "iam"."resource"."sort" IS '排序号';
COMMENT ON COLUMN "iam"."resource"."status" IS '状态(0--正常， 1--删除)';
COMMENT ON COLUMN "iam"."resource"."certificates" IS '证书 (用来区分是哪个app接入的)';
COMMENT ON COLUMN "iam"."resource"."description" IS '描述';

-- ----------------------------
-- Alter Sequences Owned By
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table resource
-- ----------------------------
ALTER TABLE "iam"."resource" ADD PRIMARY KEY ("id");


/*
Navicat PGSQL Data Transfer

Source Server         : docker
Source Server Version : 90601
Source Host           : 192.168.99.100:5432
Source Database       : zbmatsu
Source Schema         : iam

Target Server Type    : PGSQL
Target Server Version : 90601
File Encoding         : 65001

Date: 2016-12-31 14:36:47
*/


-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS "iam"."role";
CREATE TABLE "iam"."role" (
"id" varchar(36) COLLATE "default" NOT NULL,
"name" varchar(255) COLLATE "default" NOT NULL,
"status" char(1) COLLATE "default" NOT NULL,
"certificates" varchar(255) COLLATE "default" NOT NULL,
"description" varchar(255) COLLATE "default",
"create_user_id" varchar(36) COLLATE "default" NOT NULL,
"creation_time" timestamp(6) NOT NULL
)
WITH (OIDS=FALSE)

;
COMMENT ON COLUMN "iam"."role"."id" IS 'ID';
COMMENT ON COLUMN "iam"."role"."name" IS '角色名称';
COMMENT ON COLUMN "iam"."role"."status" IS '状态(0--正常， 1--删除)';
COMMENT ON COLUMN "iam"."role"."certificates" IS '证书 (用来区分是哪个app接入的)';
COMMENT ON COLUMN "iam"."role"."description" IS '描述';
COMMENT ON COLUMN "iam"."role"."create_user_id" IS '创建人ID';
COMMENT ON COLUMN "iam"."role"."creation_time" IS '创建时间';

-- ----------------------------
-- Alter Sequences Owned By
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table role
-- ----------------------------
ALTER TABLE "iam"."role" ADD PRIMARY KEY ("id");


/*
Navicat PGSQL Data Transfer

Source Server         : docker
Source Server Version : 90601
Source Host           : 192.168.99.100:5432
Source Database       : zbmatsu
Source Schema         : iam

Target Server Type    : PGSQL
Target Server Version : 90601
File Encoding         : 65001

Date: 2016-12-31 14:36:52
*/


-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS "iam"."user";
CREATE TABLE "iam"."user" (
"id" varchar(36) COLLATE "default" NOT NULL,
"name" varchar(255) COLLATE "default" NOT NULL,
"user_name" varchar(255) COLLATE "default",
"password" varchar(255) COLLATE "default",
"addresses" varchar(255) COLLATE "default",
"emails" varchar(255) COLLATE "default",
"phone_numbers" varchar(20) COLLATE "default",
"photos" varchar(255) COLLATE "default",
"roles" varchar(36) COLLATE "default",
"creation_time" timestamp(6) NOT NULL,
"modification_time" timestamp(6) NOT NULL,
"create_user_id" varchar(36) COLLATE "default",
"last_update_user_id" varchar(36) COLLATE "default",
"status" char(1) COLLATE "default" NOT NULL,
"certificates" varchar(255) COLLATE "default" NOT NULL,
"description" varchar(255) COLLATE "default"
)
WITH (OIDS=FALSE)

;
COMMENT ON COLUMN "iam"."user"."id" IS 'ID';
COMMENT ON COLUMN "iam"."user"."name" IS '用户名称';
COMMENT ON COLUMN "iam"."user"."user_name" IS '用户名';
COMMENT ON COLUMN "iam"."user"."password" IS '用户密码';
COMMENT ON COLUMN "iam"."user"."addresses" IS '用户地址';
COMMENT ON COLUMN "iam"."user"."emails" IS '用户邮箱';
COMMENT ON COLUMN "iam"."user"."phone_numbers" IS '用户手机';
COMMENT ON COLUMN "iam"."user"."photos" IS '用户头像';
COMMENT ON COLUMN "iam"."user"."roles" IS '用户角色ID';
COMMENT ON COLUMN "iam"."user"."creation_time" IS '创建时间';
COMMENT ON COLUMN "iam"."user"."modification_time" IS '修改时间';
COMMENT ON COLUMN "iam"."user"."create_user_id" IS '创建人ID';
COMMENT ON COLUMN "iam"."user"."last_update_user_id" IS '最后修改人ID';
COMMENT ON COLUMN "iam"."user"."status" IS '用户状态(0--正常，1--删除)';
COMMENT ON COLUMN "iam"."user"."certificates" IS '证书 (用来区分是哪个app接入的)';
COMMENT ON COLUMN "iam"."user"."description" IS '描述';

-- ----------------------------
-- Alter Sequences Owned By
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table user
-- ----------------------------
ALTER TABLE "iam"."user" ADD PRIMARY KEY ("id");
