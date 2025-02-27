package com.accept.jugo.mapper;

import com.accept.jugo.entity.Result;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ResultMapper extends Mapper<Result> {
	
	@Select("select count(*) from result where id = #{id}")
    Integer seletCountByCond(@Param("id") String id);
	
	@Select("select * from result where id = #{id} and type = #{type} order by cre_time")
    List<Result> seletByCond(@Param("id") String id, @Param("type") Integer type);
	
	@Insert("insert into result(id,content,type) values (#{id},#{content},#{type}) ")
	Integer insertData(@Param("id") String id, @Param("content") String content, @Param("type") Integer type);
}