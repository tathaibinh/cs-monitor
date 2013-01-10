package org.game.cs.web.controller;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;

import net.barkerjr.gameserver.GameServer.RequestTimeoutException;

import org.game.cs.core.model.ServerInfo;
import org.game.cs.core.service.ControlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/admin")
public class GameController {

    @Autowired
    private ControlService controlService;

    @RequestMapping("/control")
    public String showControlPage() {
        return "control";
    }

    @RequestMapping(value = "/connect", method = RequestMethod.POST)
    public String connect(@RequestParam String ip, @RequestParam String port, @RequestParam String rcon) {
        try {
            controlService.connect(getLoggedInUserName(), ip, Integer.valueOf(port));
        } catch (NumberFormatException | RequestTimeoutException | IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return "redirect:/admin/control";
    }

    private String getLoggedInUserName() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }

    @RequestMapping(value = "getbasicinfo", method = RequestMethod.POST)
    @ResponseBody
    public Map<ServerInfo, String> showBasicInfo() {
        try {
            return controlService.getBasicInformation(getLoggedInUserName());
        } catch (RequestTimeoutException | IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return Collections.emptyMap();
    }
}