package com.soft1851.music.controller;

import com.alibaba.fastjson.JSONObject;
import com.soft1851.music.dao.MusicDao;
import com.soft1851.music.dao.TypeDao;
import com.soft1851.music.service.MusicService;
import com.soft1851.music.service.TypeService;
import com.soft1851.music.util.ResponseObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @Author yhChen
 * @Description
 * @Date 2020/4/5
 */
@Controller
@RequestMapping(value = "/Music")
public class MusicPlayerController {
    @Resource
    private MusicService musicService;
    @Resource
    private TypeService typeService;

    @GetMapping(value = "musics",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String getMusic() {
        ResponseObject rs = new ResponseObject(1,"success",musicService.selectAll());
        return JSONObject.toJSONString(rs);
    }

    @GetMapping(value = "types",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String getType() {
        ResponseObject rs = new ResponseObject(1,"success",typeService.selectAllType());
        return JSONObject.toJSONString(rs);
    }

    @GetMapping("/music")
    public String music(Model model) {
        model.addAttribute("musics", musicService.selectAll());
        model.addAttribute("types",typeService.selectAllType());
        return "music";
    }
}
