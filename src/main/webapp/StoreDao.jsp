<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd" >
<mapper namespace="co.jp.mamol.myapp.dao.OrderDeliverDao">
	<!-- 3001 -->
	<select id="deptList"
		resultType="co.jp.mamol.myapp.dto.DepartmentDto">

		select * from DEPARTMENT
	</select>

	<!-- 3002 -->
	<select id="approvaledList"
		resultType="co.jp.mamol.myapp.dto.SizaiDto">

		select s.id,s.name,s.num,s.souko_id,sou.name as
		souko_name,s.category_id,c.name as
		category_name,s.request_user_id,u.name as request_user_name
		,s.request_dept_id,d.name as request_dept_name,s.status,sta.name as
		status_name,
		to_char(s.REQUEST_DATE,'yyyy-mm-dd') as request_date,
		to_char(s.ORDER_DATE,'yyyy-mm-dd') as order_date,
		to_char(s.DELIVERY_DATE,'yyyy-mm-dd') as delivery_date,
		to_char(s.INSTORE_DATE,'yyyy-mm-dd') as instore_date,
		to_char(s.OUTSTORE_DATE,'yyyy-mm-dd') as outstore_date,
		s.note
		from
		sizai s inner join category c on s.CATEGORY_ID = c.ID
		inner join users
		u on s.REQUEST_USER_ID = u.id
		inner join department d on
		s.REQUEST_DEPT_ID = d.id
		inner join status sta on s.STATUS = sta.code
		left join souko sou on s.SOUKO_ID = sou.id

		where s.REQUEST_DEPT_ID =
		#{dempId} and status = '2' or status ='4'

	</select>


	<!-- 3003 -->
	<select id="orderedList"
		resultType="co.jp.mamol.myapp.dto.SizaiDto">

		select s.id,s.name,s.num,s.souko_id,sou.name as
		souko_name,s.category_id,c.name as
		category_name,s.request_user_id,u.name as request_user_name
		,s.request_dept_id,d.name as request_dept_name,s.status,sta.name as
		status_name,
		to_char(s.REQUEST_DATE,'yyyy-mm-dd') as request_date,
		to_char(s.ORDER_DATE,'yyyy-mm-dd') as order_date,
		to_char(s.DELIVERY_DATE,'yyyy-mm-dd') as delivery_date,
		to_char(s.INSTORE_DATE,'yyyy-mm-dd') as instore_date,
		to_char(s.OUTSTORE_DATE,'yyyy-mm-dd') as outstore_date,
		s.note
		from
		sizai s inner join category c on s.CATEGORY_ID = c.ID
		inner join users
		u on s.REQUEST_USER_ID = u.id
		inner join department d on
		s.REQUEST_DEPT_ID = d.id
		inner join status sta on s.STATUS = sta.code
		left join souko sou on s.SOUKO_ID = sou.id

		where s.REQUEST_DEPT_ID =
		#{dempId} and status = '4' or status ='5'

	</select>


	<!-- 3004 -->

	<update id="orderAct">

		update sizai set status = '4',ORDER_DATE = sysdate

		where id = #{sizaiId} and (status = '2')


	</update>


	<!-- 3005 -->

	<update id="deleverAct">

		update sizai set status = '5',DELIVERY_DATE = sysdate

		where id = #{sizaiId} and (status = '4')


	</update>

















</mapper>






