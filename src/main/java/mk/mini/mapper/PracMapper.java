package mk.mini.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface PracMapper {

    List<Map<String, Object>> getBoard1List();
}
