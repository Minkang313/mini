package mk.mini.web;

import mk.mini.service.PracService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/prac")
public class PracController {

    @Autowired PracService pracService;


    /**
     * 게시판1로 이동
     */
    @RequestMapping("/board1.do")
    public String moveBoard1(Model model){

        Map<String, Object> board1Map = pracService.getBoard1List();
        model.addAttribute("board1Map", board1Map);

        return "prac/board1";
    }


}
