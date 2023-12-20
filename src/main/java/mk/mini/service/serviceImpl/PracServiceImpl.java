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
    public Map<String, Object> getBoard1List() {
        Map<String, Object> result = new HashMap<>();
        result.put("board1List", pracMapper.getBoard1List());

        return result;
    }
}
