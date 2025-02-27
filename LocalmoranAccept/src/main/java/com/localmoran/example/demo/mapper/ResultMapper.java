package com.localmoran.example.demo.mapper;

import com.localmoran.example.demo.entity.Result;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ResultMapper extends Mapper<Result> {
	
	@Select("select count(*) from lresult where id = #{id}")
    Integer seletCountByCond(@Param("id") String id);
	
	@Select("select * from lresult where id = #{id} and type = #{type} order by cre_time")
    List<Result> seletByCond(@Param("id") String id, @Param("type") Integer type);
	
	@Insert("insert into lresult(id,content,type) values (#{id},#{content},#{type})")
	Integer insertData(@Param("id") String id, @Param("content") String content, @Param("type") Integer type);

	//@Insert("insert into kresult(id,content,type,d) values (#{id},#{content},#{type},#{d}) ")
	//Integer insertData(@Param("id") String id, @Param("content") String content, @Param("type") Integer type,@Param("d") Integer d);


}