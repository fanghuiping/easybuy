package com.fp.easybuy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * 注销功能
 */
@Controller
public class CancellationController {
    /**
     * 用户注销功能
     * @param request
     * @return
     */
    @RequestMapping("/Cancellation")
    public String cancellation(HttpServletRequest request)
    {
        request.getSession().removeAttribute("err");
        return "redirect:/Journalism";
    }
}
