package kr.board.mapper;

import java.util.List;

import kr.board.entity.Board;

//@Mapper - Mybatis API
public interface BoardMapper {
	public List<Board> getLists();
	public void boardInsert(Board vo);
	public Board boardContent(int idx);
	public void boardDelete(int idx);
	
}
