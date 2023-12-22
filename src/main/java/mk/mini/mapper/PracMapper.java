package mk.mini.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface PracMapper {

    List<Map<String, Object>> getBoard1List();

    Map<String, Object> getBoardDetail(int boardId);

    int insertBoard1(Map<String, Object> param);

    int updateboard1(Map<String, Object> param);

    int plusViewCnt(int boardId);

    int deleteBoard1(int boardId);
}
