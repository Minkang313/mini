package mk.mini.service.serviceImpl;

import mk.mini.mapper.PracMapper;
import mk.mini.service.PracService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;

@Service
public class PracServiceImpl implements PracService {

    @Autowired PracMapper pracMapper;

    /**
     * 게시글1 목록 조회
     * @return
     */
    @Override
    public Map<String, Object> getBoard1List(Map<String, Object> param) {
        Map<String, Object> result = new HashMap<>();
        Map<String, Object> pageMap = paging(param);
        param.put("startRow", pageMap.get("startRow"));
        result.put("board1List", pracMapper.getBoard1List(param));
        result.put("pageMap", pageMap);

        return result;
    }

    /**
     * 페이징 함수
     * @param
     * @return
     */
    private Map<String, Object> paging(Map<String, Object> param){

        Map<String, Object> resultMap = new HashMap<>();

        int curPage = 1;
        if (null != param.get("curPage")) {
            curPage = Integer.parseInt(param.get("curPage").toString());
        }
        int boardCnt = pracMapper.getBoard1Cnt(param);
        int startRow = (curPage - 1) * 10;
        int maxPage = (int) Math.ceil((double) boardCnt / 10);
        if (curPage > maxPage) {
            curPage = maxPage;
        }
        if (curPage < 1) {
            curPage = 1;
        }
        int endPage = (int) ((Math.ceil((double) curPage / 5 - 1) + 1 ) * 5);
        if (endPage > maxPage) {
            endPage = maxPage;
        }
        if (endPage < 1) {
            endPage = 1;
        }
        int startPage = (int) (Math.ceil((double) curPage / 5 - 1) * 5 + 1);
        if (startPage < 1) {
            startPage = 1;
        }

        resultMap.put("curPage", curPage);
        resultMap.put("boardCnt", boardCnt);
        resultMap.put("maxPage", maxPage);
        resultMap.put("endPage", endPage);
        resultMap.put("startPage", startPage);
        resultMap.put("startRow", startRow);

        return resultMap;
    }


    /**
     * 게시글 상세 조회
     * @param boardId
     * @return
     */
    @Override
    public Map<String, Object> getBoard1Detail(int boardId) {

        return pracMapper.getBoardDetail(boardId);
    }

    /**
     * 게시글 추가
     * @param param
     * @return
     */
    @Override
    public int insertBoard1(Map<String, Object> param) {
        return pracMapper.insertBoard1(param);
    }

    /**
     * 게시글 수정
     * @param param
     * @return
     */
    @Override
    public int updateboard1(Map<String, Object> param) {
        return pracMapper.updateboard1(param);
    }

    /**
     * 조회수 1 증가
     * @param boardId
     * @return
     */
    @Override
    public int plusViewCnt(int boardId){
        return pracMapper.plusViewCnt(boardId);
    }

    /**
     * 게시글 삭제
     * @param boardId
     * @return
     */
    @Override
    public int deleteBoard1(int boardId) {
        return pracMapper.deleteBoard1(boardId);
    }
}
