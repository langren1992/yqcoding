/*
 Navicat Premium Data Transfer

 Source Server         : localhost-----1
 Source Server Type    : MariaDB
 Source Server Version : 100313
 Source Host           : localhost:3306
 Source Schema         : yqcoding

 Target Server Type    : MariaDB
 Target Server Version : 100313
 File Encoding         : 65001

 Date: 24/06/2020 18:43:16
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for mq_consumer_error_log
-- ----------------------------
DROP TABLE IF EXISTS `mq_consumer_error_log`;
CREATE TABLE `mq_consumer_error_log`  (
  `id` bigint(20) UNSIGNED NOT NULL COMMENT 'id',
  `message_id` bigint(20) UNSIGNED NOT NULL COMMENT '消息ID',
  `queue_info` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '发送队列',
  `request_param` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '请求参数',
  `failure_reason` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '失败原因',
  `creator` bigint(20) UNSIGNED NOT NULL COMMENT '创建人',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '队列消费失败日志 ' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of mq_consumer_error_log
-- ----------------------------
INSERT INTO `mq_consumer_error_log` VALUES (1275387730810585090, 2, '{\"queue\":\"11111\",\"type\":\"direct\",\"consumerBeanName\":\"testConsumer\"}', '{\"code\":\"111111\",\"name\":\"1111111\"}', 'java.lang.ArithmeticException: / by zero\r\n	at com.anserx.yqcoding.mq.core.DefaultBaseConsumer.consumerMoreQueue(DefaultBaseConsumer.java:83)\r\n	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\r\n	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\r\n	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\r\n	at java.lang.reflect.Method.invoke(Method.java:498)\r\n	at org.springframework.messaging.handler.invocation.InvocableHandlerMethod.doInvoke(InvocableHandlerMethod.java:181)\r\n	at org.springframework.messaging.handler.invocation.InvocableHandlerMethod.invoke(InvocableHandlerMethod.java:114)\r\n	at org.springframework.amqp.rabbit.listener.adapter.HandlerAdapter.invoke(HandlerAdapter.java:51)\r\n	at org.springframework.amqp.rabbit.listener.adapter.MessagingMessageListenerAdapter.invokeHandler(MessagingMessageListenerAdapter.java:188)\r\n	at org.springframework.amqp.rabbit.listener.adapter.MessagingMessageListenerAdapter.onMessage(MessagingMessageListenerAdapter.java:126)\r\n	at org.springframework.amqp.rabbit.listener.AbstractMessageListenerContainer.doInvokeListener(AbstractMessageListenerContainer.java:1445)\r\n	at org.springframework.amqp.rabbit.listener.AbstractMessageListenerContainer.actualInvokeListener(AbstractMessageListenerContainer.java:1368)\r\n	at org.springframework.amqp.rabbit.listener.AbstractMessageListenerContainer.invokeListener(AbstractMessageListenerContainer.java:1355)\r\n	at org.springframework.amqp.rabbit.listener.AbstractMessageListenerContainer.executeListener(AbstractMessageListenerContainer.java:1334)\r\n	at org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer.doReceiveAndExecute(SimpleMessageListenerContainer.java:817)\r\n	at org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer.receiveAndExecute(SimpleMessageListenerContainer.java:801)\r\n	at org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer.access$700(SimpleMessageListenerContainer.java:77)\r\n	at org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer$AsyncMessageProcessingConsumer.run(SimpleMessageListenerContainer.java:1042)\r\n	at java.lang.Thread.run(Thread.java:748)\r\n', 0, '2020-06-23 19:18:25');
INSERT INTO `mq_consumer_error_log` VALUES (1275389128545648641, 2, '{\"queue\":\"11111\",\"type\":\"direct\",\"consumerBeanName\":\"testConsumer\"}', '{\"code\":\"111111\",\"name\":\"1111111\"}', 'java.lang.ArithmeticException: / by zero\r\n	at com.anserx.yqcoding.mq.core.DefaultBaseConsumer.consumerMoreQueue(DefaultBaseConsumer.java:83)\r\n	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\r\n	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\r\n	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\r\n	at java.lang.reflect.Method.invoke(Method.java:498)\r\n	at org.springframework.messaging.handler.invocation.InvocableHandlerMethod.doInvoke(InvocableHandlerMethod.java:181)\r\n	at org.springframework.messaging.handler.invocation.InvocableHandlerMethod.invoke(InvocableHandlerMethod.java:114)\r\n	at org.springframework.amqp.rabbit.listener.adapter.HandlerAdapter.invoke(HandlerAdapter.java:51)\r\n	at org.springframework.amqp.rabbit.listener.adapter.MessagingMessageListenerAdapter.invokeHandler(MessagingMessageListenerAdapter.java:188)\r\n	at org.springframework.amqp.rabbit.listener.adapter.MessagingMessageListenerAdapter.onMessage(MessagingMessageListenerAdapter.java:126)\r\n	at org.springframework.amqp.rabbit.listener.AbstractMessageListenerContainer.doInvokeListener(AbstractMessageListenerContainer.java:1445)\r\n	at org.springframework.amqp.rabbit.listener.AbstractMessageListenerContainer.actualInvokeListener(AbstractMessageListenerContainer.java:1368)\r\n	at org.springframework.amqp.rabbit.listener.AbstractMessageListenerContainer.invokeListener(AbstractMessageListenerContainer.java:1355)\r\n	at org.springframework.amqp.rabbit.listener.AbstractMessageListenerContainer.executeListener(AbstractMessageListenerContainer.java:1334)\r\n	at org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer.doReceiveAndExecute(SimpleMessageListenerContainer.java:817)\r\n	at org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer.receiveAndExecute(SimpleMessageListenerContainer.java:801)\r\n	at org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer.access$700(SimpleMessageListenerContainer.java:77)\r\n	at org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer$AsyncMessageProcessingConsumer.run(SimpleMessageListenerContainer.java:1042)\r\n	at java.lang.Thread.run(Thread.java:748)\r\n', 0, '2020-06-23 19:23:58');
INSERT INTO `mq_consumer_error_log` VALUES (1275389691140227073, 3, '{\"queue\":\"11111\",\"type\":\"direct\",\"consumerBeanName\":\"testConsumer\"}', '{\"code\":\"111111\",\"name\":\"1111111\"}', 'java.lang.ArithmeticException: / by zero\r\n	at com.anserx.yqcoding.mq.core.DefaultBaseConsumer.consumerMoreQueue(DefaultBaseConsumer.java:83)\r\n	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\r\n	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\r\n	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\r\n	at java.lang.reflect.Method.invoke(Method.java:498)\r\n	at org.springframework.messaging.handler.invocation.InvocableHandlerMethod.doInvoke(InvocableHandlerMethod.java:181)\r\n	at org.springframework.messaging.handler.invocation.InvocableHandlerMethod.invoke(InvocableHandlerMethod.java:114)\r\n	at org.springframework.amqp.rabbit.listener.adapter.HandlerAdapter.invoke(HandlerAdapter.java:51)\r\n	at org.springframework.amqp.rabbit.listener.adapter.MessagingMessageListenerAdapter.invokeHandler(MessagingMessageListenerAdapter.java:188)\r\n	at org.springframework.amqp.rabbit.listener.adapter.MessagingMessageListenerAdapter.onMessage(MessagingMessageListenerAdapter.java:126)\r\n	at org.springframework.amqp.rabbit.listener.AbstractMessageListenerContainer.doInvokeListener(AbstractMessageListenerContainer.java:1445)\r\n	at org.springframework.amqp.rabbit.listener.AbstractMessageListenerContainer.actualInvokeListener(AbstractMessageListenerContainer.java:1368)\r\n	at org.springframework.amqp.rabbit.listener.AbstractMessageListenerContainer.invokeListener(AbstractMessageListenerContainer.java:1355)\r\n	at org.springframework.amqp.rabbit.listener.AbstractMessageListenerContainer.executeListener(AbstractMessageListenerContainer.java:1334)\r\n	at org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer.doReceiveAndExecute(SimpleMessageListenerContainer.java:817)\r\n	at org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer.receiveAndExecute(SimpleMessageListenerContainer.java:801)\r\n	at org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer.access$700(SimpleMessageListenerContainer.java:77)\r\n	at org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer$AsyncMessageProcessingConsumer.run(SimpleMessageListenerContainer.java:1042)\r\n	at java.lang.Thread.run(Thread.java:748)\r\n', 0, '2020-06-23 19:26:12');
INSERT INTO `mq_consumer_error_log` VALUES (1275391933348036610, 4, '{\"queue\":\"11111\",\"type\":\"direct\",\"consumerBeanName\":\"testConsumer\"}', '{\"code\":\"111111\",\"name\":\"1111111\"}', 'java.lang.ArithmeticException: / by zero\r\n	at com.anserx.yqcoding.mq.core.DefaultBaseConsumer.consumerMoreQueue(DefaultBaseConsumer.java:83)\r\n	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\r\n	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\r\n	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\r\n	at java.lang.reflect.Method.invoke(Method.java:498)\r\n	at org.springframework.messaging.handler.invocation.InvocableHandlerMethod.doInvoke(InvocableHandlerMethod.java:181)\r\n	at org.springframework.messaging.handler.invocation.InvocableHandlerMethod.invoke(InvocableHandlerMethod.java:114)\r\n	at org.springframework.amqp.rabbit.listener.adapter.HandlerAdapter.invoke(HandlerAdapter.java:51)\r\n	at org.springframework.amqp.rabbit.listener.adapter.MessagingMessageListenerAdapter.invokeHandler(MessagingMessageListenerAdapter.java:188)\r\n	at org.springframework.amqp.rabbit.listener.adapter.MessagingMessageListenerAdapter.onMessage(MessagingMessageListenerAdapter.java:126)\r\n	at org.springframework.amqp.rabbit.listener.AbstractMessageListenerContainer.doInvokeListener(AbstractMessageListenerContainer.java:1445)\r\n	at org.springframework.amqp.rabbit.listener.AbstractMessageListenerContainer.actualInvokeListener(AbstractMessageListenerContainer.java:1368)\r\n	at org.springframework.amqp.rabbit.listener.AbstractMessageListenerContainer.invokeListener(AbstractMessageListenerContainer.java:1355)\r\n	at org.springframework.amqp.rabbit.listener.AbstractMessageListenerContainer.executeListener(AbstractMessageListenerContainer.java:1334)\r\n	at org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer.doReceiveAndExecute(SimpleMessageListenerContainer.java:817)\r\n	at org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer.receiveAndExecute(SimpleMessageListenerContainer.java:801)\r\n	at org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer.access$700(SimpleMessageListenerContainer.java:77)\r\n	at org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer$AsyncMessageProcessingConsumer.run(SimpleMessageListenerContainer.java:1042)\r\n	at java.lang.Thread.run(Thread.java:748)\r\n', 0, '2020-06-23 19:35:07');

-- ----------------------------
-- Table structure for mq_consumer_log
-- ----------------------------
DROP TABLE IF EXISTS `mq_consumer_log`;
CREATE TABLE `mq_consumer_log`  (
  `id` bigint(20) UNSIGNED NOT NULL COMMENT 'id',
  `message_id` bigint(20) UNSIGNED NOT NULL COMMENT '消息ID',
  `queue_info` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '发送队列',
  `request_param` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '请求参数',
  `creator` bigint(20) UNSIGNED NOT NULL COMMENT '创建人',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '队列消费日志 ' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of mq_consumer_log
-- ----------------------------
INSERT INTO `mq_consumer_log` VALUES (1275386611262767105, 1, '{\"queue\":\"11111\",\"type\":\"direct\",\"consumerBeanName\":\"testConsumer\"}', '{\"code\":\"111111\",\"name\":\"1111111\"}', 0, '2020-06-23 19:13:58');
INSERT INTO `mq_consumer_log` VALUES (1275389110019407874, 2, '{\"queue\":\"11111\",\"type\":\"direct\",\"consumerBeanName\":\"testConsumer\"}', '{\"code\":\"111111\",\"name\":\"1111111\"}', 0, '2020-06-23 19:23:54');
INSERT INTO `mq_consumer_log` VALUES (1275389690750156801, 3, '{\"queue\":\"11111\",\"type\":\"direct\",\"consumerBeanName\":\"testConsumer\"}', '{\"code\":\"111111\",\"name\":\"1111111\"}', 0, '2020-06-23 19:26:12');
INSERT INTO `mq_consumer_log` VALUES (1275391932932800514, 4, '{\"queue\":\"11111\",\"type\":\"direct\",\"consumerBeanName\":\"testConsumer\"}', '{\"code\":\"111111\",\"name\":\"1111111\"}', 0, '2020-06-23 19:35:07');

-- ----------------------------
-- Table structure for mq_producer_log
-- ----------------------------
DROP TABLE IF EXISTS `mq_producer_log`;
CREATE TABLE `mq_producer_log`  (
  `id` bigint(20) UNSIGNED NOT NULL COMMENT 'id',
  `message_id` bigint(20) UNSIGNED NOT NULL COMMENT '消息ID',
  `queue_info` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '发送队列',
  `request_param` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '请求参数',
  `ack` bit(1) NOT NULL COMMENT '是否确认',
  `creator` bigint(20) UNSIGNED NOT NULL COMMENT '创建人',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '队列生产日志 ' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of mq_producer_log
-- ----------------------------
INSERT INTO `mq_producer_log` VALUES (1275386610780422146, 1, '{\"messageId\":1,\"data\":{\"name\":\"1111111\",\"code\":\"111111\"}}', '{\"queue\":\"11111\",\"type\":\"direct\",\"consumerBeanName\":\"testConsumer\"}', b'1', 0, '2020-06-23 19:13:58');
INSERT INTO `mq_producer_log` VALUES (1275387698254397442, 1, '{\"messageId\":1,\"data\":{\"name\":\"1111111\",\"code\":\"111111\"}}', '{\"queue\":\"11111\",\"type\":\"direct\",\"consumerBeanName\":\"testConsumer\"}', b'1', 0, '2020-06-23 19:18:17');
INSERT INTO `mq_producer_log` VALUES (1275389109583200257, 2, '{\"messageId\":2,\"data\":{\"name\":\"1111111\",\"code\":\"111111\"}}', '{\"queue\":\"11111\",\"type\":\"direct\",\"consumerBeanName\":\"testConsumer\"}', b'1', 0, '2020-06-23 19:23:53');
INSERT INTO `mq_producer_log` VALUES (1275389690427195393, 3, '{\"messageId\":3,\"data\":{\"name\":\"1111111\",\"code\":\"111111\"}}', '{\"queue\":\"11111\",\"type\":\"direct\",\"consumerBeanName\":\"testConsumer\"}', b'1', 0, '2020-06-23 19:26:12');
INSERT INTO `mq_producer_log` VALUES (1275391932614033410, 4, '{\"messageId\":4,\"data\":{\"name\":\"1111111\",\"code\":\"111111\"}}', '{\"queue\":\"11111\",\"type\":\"direct\",\"consumerBeanName\":\"testConsumer\"}', b'1', 0, '2020-06-23 19:35:07');

-- ----------------------------
-- Table structure for oauth_access_token
-- ----------------------------
DROP TABLE IF EXISTS `oauth_access_token`;
CREATE TABLE `oauth_access_token`  (
  `token_id` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `token` blob NULL DEFAULT NULL,
  `authentication_id` varchar(48) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `user_name` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `client_id` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `authentication` blob NULL DEFAULT NULL,
  `refresh_token` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`authentication_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for oauth_client_details
-- ----------------------------
DROP TABLE IF EXISTS `oauth_client_details`;
CREATE TABLE `oauth_client_details`  (
  `client_id` varchar(48) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `resource_ids` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `client_secret` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `scope` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `authorized_grant_types` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `web_server_redirect_uri` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `authorities` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `access_token_validity` int(11) NULL DEFAULT NULL,
  `refresh_token_validity` int(11) NULL DEFAULT NULL,
  `additional_information` varchar(4096) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `autoapprove` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`client_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of oauth_client_details
-- ----------------------------
INSERT INTO `oauth_client_details` VALUES ('webApp', 'app', '{bcrypt}$2a$10$lGLMxkNqnbRRrw1XN1OIAOlklqyVtQGHo.tzQtjCjcZ1GtIy3uUhS', 'select,write', 'authorization_code,password,refresh_token,client_credentials', NULL, NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for oauth_refresh_token
-- ----------------------------
DROP TABLE IF EXISTS `oauth_refresh_token`;
CREATE TABLE `oauth_refresh_token`  (
  `token_id` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `token` blob NULL DEFAULT NULL,
  `authentication` blob NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for oauth_role
-- ----------------------------
DROP TABLE IF EXISTS `oauth_role`;
CREATE TABLE `oauth_role`  (
  `id` bigint(20) UNSIGNED NOT NULL COMMENT 'ID',
  `code` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '编码',
  `name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '名称',
  `creator` bigint(20) UNSIGNED NOT NULL COMMENT '创建人',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `modifier` bigint(20) UNSIGNED NOT NULL COMMENT '修改人',
  `modify_time` datetime(0) NOT NULL COMMENT '修改时间',
  `status` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '状态',
  `version` int(10) UNSIGNED NOT NULL COMMENT '版本号',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '逻辑删除',
  `company_id` bigint(20) UNSIGNED NOT NULL COMMENT '公司ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '角色信息 ' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for oauth_user
-- ----------------------------
DROP TABLE IF EXISTS `oauth_user`;
CREATE TABLE `oauth_user`  (
  `id` bigint(20) UNSIGNED NOT NULL COMMENT 'ID',
  `username` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户名',
  `name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `password` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '密码',
  `mobile_phone` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '移动电话',
  `creator` bigint(20) UNSIGNED NOT NULL COMMENT '创建人',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `modifier` bigint(20) UNSIGNED NOT NULL COMMENT '修改人',
  `modify_time` datetime(0) NOT NULL COMMENT '修改时间',
  `status` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '状态',
  `version` int(10) UNSIGNED NOT NULL COMMENT '版本号',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '逻辑删除',
  `company_id` bigint(20) UNSIGNED NOT NULL COMMENT '公司ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户信息 ' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of oauth_user
-- ----------------------------
INSERT INTO `oauth_user` VALUES (1, 'admin', '超级管理员', '{bcrypt}$2a$10$eaFbNDaOegMQiFQ7SwBVpeYHRNEyq4cNEO7GlsX.KFo0IJFhvOaBq', '13100000000', 0, '2020-06-24 16:28:26', 0, '2020-06-24 16:28:32', '1', 0, b'0', 0);

-- ----------------------------
-- Table structure for oauth_user_role
-- ----------------------------
DROP TABLE IF EXISTS `oauth_user_role`;
CREATE TABLE `oauth_user_role`  (
  `id` bigint(20) UNSIGNED NOT NULL COMMENT 'ID',
  `user_id` bigint(20) UNSIGNED NOT NULL COMMENT '用户ID',
  `role_id` bigint(20) UNSIGNED NOT NULL COMMENT '角色ID',
  `creator` bigint(20) UNSIGNED NOT NULL COMMENT '创建人',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `modifier` bigint(20) UNSIGNED NOT NULL COMMENT '修改人',
  `modify_time` datetime(0) NOT NULL COMMENT '修改时间',
  `status` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '状态',
  `version` int(10) UNSIGNED NOT NULL COMMENT '版本号',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '逻辑删除',
  `company_id` bigint(20) UNSIGNED NOT NULL COMMENT '公司ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户角色信息 ' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
