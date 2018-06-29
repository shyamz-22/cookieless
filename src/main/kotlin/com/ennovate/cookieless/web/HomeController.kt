package com.ennovate.cookieless.web

import org.springframework.stereotype.Controller
import org.springframework.ui.ModelMap
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.servlet.ModelAndView
import java.security.Principal
import javax.servlet.http.HttpServletResponse
import javax.servlet.http.HttpSession


@Controller
class HomeController {

    @GetMapping("/page/{id}")
    fun index(@PathVariable id: String,
              @RequestParam(value = "name") name: String,
              @RequestParam(value = "sessionV") sessionV: String,
              @RequestParam(value = "isNew") isNew: String,
              model: ModelMap): ModelAndView {

        model.addAllAttributes(mapOf(
                "name" to name,
                "sessionV" to sessionV,
                "isNew" to isNew))
        return ModelAndView(id, model)
    }

    @GetMapping("/hello")
    fun hello(model: ModelMap,
              @RequestParam(value = "name", required = false, defaultValue = "World") name: String,
              response: HttpServletResponse,
              session: HttpSession): ModelAndView {
        model.addAttribute("name", name)
        model.addAttribute("sessionV", session.id)

        return ModelAndView("hello", model)
    }

    @GetMapping("/user")
    fun user(model: ModelMap, principal: Principal,
             response: HttpServletResponse,
             session: HttpSession): ModelAndView {

        model.addAttribute("name", principal.name)
        model.addAttribute("sessionV", session.id)
        model.addAttribute("isNew", session.isNew.toString())

//        val redirectView = RedirectView("/page/userPage")

        return ModelAndView("userPage", model)
    }

    @GetMapping("/another")
    fun another(model: ModelMap, principal: Principal,
                response: HttpServletResponse,
                session: HttpSession): ModelAndView {
        model.addAttribute("name", principal.name)
        model.addAttribute("sessionV", session.id)
        model.addAttribute("isNew", session.isNew.toString())


        return ModelAndView("anotherPage", model)
    }
}