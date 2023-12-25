package mk.mini.web;

import mk.mini.service.PracService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Map;

@Controller
@RequestMapping("/prac")
public class PracController {

    @Autowired PracService pracService;


    /**
     * 게시판1로 이동
     */
    @RequestMapping("/board1.do")
    public String moveBoard1(Model model, @RequestParam Map<String, Object> param, @RequestParam(value = "curPage", required = false, defaultValue = "1")int curPage){

        param.put("curPage", curPage);
        Map<String, Object> board1Map = pracService.getBoard1List(param);
        model.addAttribute("board1Map", board1Map);

        if (param.get("msg") != null) {
            model.addAttribute("msg", param.get("msg"));
        }

        return "prac/board1/board1";
    }

    /**
     * 게시글 상세 조회
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/boardDetail.do")
    public String board1Detail(@RequestParam(value = "id") int id, Model model, @RequestParam(value = "msg", required = false) String msg){

        pracService.plusViewCnt(id);
        Map<String, Object> boardDetail = pracService.getBoard1Detail(id);
        model.addAttribute("boardDetail", boardDetail);
        System.out.println("msg: " + msg);
        if (msg != null) {
            model.addAttribute("msg", msg);
        }

        return "prac/board1/board1Detail";
    }

    /**
     * 게시판 추가 화면
     * @return
     */
    @RequestMapping("/addBoard1.do")
    public String addboard1(@RequestParam(value = "msg", required = false) String msg, Model model){

        if (msg != null) {
            model.addAttribute("msg", msg);
        }

        return "prac/board1/addBoard1";
    }

    /**
     * 게시글 추가
     * @param param
     * @return
     */
    @PostMapping("/addBoardPro.do")
    public String addBoardPro(@RequestParam Map<String, Object> param, Model model, RedirectAttributes reAttr){
        int boardId = pracService.insertBoard1(param);
        if (boardId != 0) {
            reAttr.addAttribute("msg", "게시글 작성에 성공했습니다.");
            return "redirect:/prac/boardDetail.do?id=" + boardId;
        } else {
            reAttr.addAttribute("msg", "게시글 작성에 실패했습니다.");
            return "redirect:/prac/addBoard1.do";
        }
    }

    /**
     * 수정 페이지로 이동
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/updateBoard1.do")
    public String updateBoard1(@RequestParam(value = "id") int id, @RequestParam(value = "msg", required = false) String msg, Model model){
        Map<String, Object> boardDetail = pracService.getBoard1Detail(id);
        model.addAttribute("boardDetail", boardDetail);
        if (msg != null) {
            model.addAttribute("msg", msg);
        }

        return "prac/board1/updateBoard1";
    }

    /**
     * 게시글 수정
     * @param param
     * @param model
     * @return
     */
    @RequestMapping(value = "/updateBoard1Pro.do")
    public String updateBoard1Pro(@RequestParam Map<String, Object> param, Model model, RedirectAttributes reAttr){

        int boardId = Integer.parseInt((String) param.get("id"));
        int result = pracService.updateboard1(param);

        if(result == 1){
            reAttr.addAttribute("msg", "게시글 수정에 성공했습니다.");
            return "redirect:/prac/boardDetail.do?id=" + boardId;
        } else {
            reAttr.addAttribute("msg", "게시글 수정에 실패했습니다.");
            return "redirect:/prac/updateBoard1.do?id=" + boardId;
        }
    }

    /**
     * 게시글 삭제
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/deleteBoard1.do")
    public String deleteBoard1(@RequestParam(value = "id") int id, Model model, RedirectAttributes reAttr){

        int result = pracService.deleteBoard1(id);
        if (result == 1) {
            reAttr.addAttribute("msg", "삭제에 성공했습니다.");
            return "redirect:/prac/board1.do";
        } else {
            reAttr.addAttribute("msg", "삭제에 실패했습니다.");
            return "redirect:/prac/boardDetail.do?id=" + id;
        }
    }
}
