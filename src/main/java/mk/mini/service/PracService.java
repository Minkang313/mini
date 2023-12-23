package mk.mini.service;

import java.util.Map;

public interface PracService {

    Map<String, Object> getBoard1List(Map<String, Object> param);

    Map<String, Object> getBoard1Detail(int boardId);

    int insertBoard1(Map<String, Object> param);

    int updateboard1(Map<String, Object> param);

    int plusViewCnt(int boardId);

    int deleteBoard1(int boardId);
}
