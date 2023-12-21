package mk.mini.service;

import java.util.Map;

public interface PracService {

    Map<String, Object> getBoard1List();

    Map<String, Object> getBoardDetail(int boardId);
}
