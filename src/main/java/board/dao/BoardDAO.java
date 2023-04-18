package board.dao;

import java.util.List;

import board.bean.BoardDTO;
import board.bean.BoardQueryOption;

public interface BoardDAO {

	void create(BoardDTO board);

	BoardDTO getBoard(int id);

	List<BoardDTO> listBoards(BoardQueryOption option);

	void update(BoardDTO board);

	void delete(int id);

	void hit(int id);

}
