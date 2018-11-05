package ami.cloudexample.milkapp.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * @author Mihai Alexandru
 * @date 30.10.2018
 */
@Controller
@RefreshScope
public class MilkAppController {

    @Value("${server.servlet.context-path}")
    private String serverContextPath;

    @Value("${milk.app.team.name:Team}")
    private String milkAppTeamName;



    @GetMapping("/milk")
    public ModelAndView getMilkPage(Map<String, Object> model) {
        model.put("milkAppUri", serverContextPath);
        model.put("milkAppTeamName", milkAppTeamName);
        return new ModelAndView("milk-page", model);
    }
}
