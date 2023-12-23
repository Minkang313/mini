package mk.mini.service.serviceImpl;

import mk.mini.mapper.PracMapper;
import mk.mini.service.PracService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        result.put("board1List", pracMapper.getBoard1List());

        return result;
    }

    /**
     * 페이징 함수
     * @param
     * @return
     */
    private Map<String, Object> paging(Map<String, Object> param){

        int boardCnt = pracMapper.getBoard1Cnt(param);

        return null;
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
