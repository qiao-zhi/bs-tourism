package cn.qs.mapper.tourism;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import cn.qs.bean.tourism.Comment;
import cn.qs.bean.tourism.CommentExample;

@Mapper
public interface CommentMapper {
	int countByExample(CommentExample example);

	int deleteByExample(CommentExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(Comment record);

	int insertSelective(Comment record);

	List<Comment> selectByExampleWithBLOBs(CommentExample example);

	List<Comment> selectByExample(CommentExample example);

	Comment selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") Comment record, @Param("example") CommentExample example);

	int updateByExampleWithBLOBs(@Param("record") Comment record, @Param("example") CommentExample example);

	int updateByExample(@Param("record") Comment record, @Param("example") CommentExample example);

	int updateByPrimaryKeySelective(Comment record);

	int updateByPrimaryKeyWithBLOBs(Comment record);

	int updateByPrimaryKey(Comment record);
}