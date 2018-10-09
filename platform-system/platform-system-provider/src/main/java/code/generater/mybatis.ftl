<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${mybatisNameSpace}">
	
	<select id="selPageList" resultType="${entityPackage}.${entityName}">
		select * from ${tableName}
		<where>
			<!-- 条件 -->
		</where>
		order by create_time desc
	</select>
</mapper>