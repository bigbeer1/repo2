package com.dabenxiong.item.controller;

import com.dabenxiong.common.pojo.PageResult;
import com.dabenxiong.item.pojo.Software;
import com.dabenxiong.item.server.SoftwareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 一只大笨熊
 * @create 2020-02-29 7:40
 */

@Controller
@RequestMapping("software")
public class SoftwareController {

    @Autowired
    private  SoftwareService softwareService;

    /**
     * 增加一个软件
     * @param softwarename
     * @param servicestate
     * @param safetycode
     * @param registermode
     * @param version
     * @param bindingmode
     * @param trialmode
     * @param unbundingmode
     * @param trialtime
     * @param updatemode
     * @param updateurl
     * @param verificationcode
     * @param unbindingtime
     * @param registerdevtime
     * @param softwarebulletin
     * @param customcode
     * @param staticdata
     * @param loginmode
     * @param moreopennumber
     * @param authorid
     * @return
     */
    @PostMapping("add")
    public ResponseEntity<Void> AddSoftware(
            @RequestParam(value = "softwarename",required = true)String softwarename,
            @RequestParam(value = "servicestate",required = true)String servicestate,
            @RequestParam(value = "registermode",required = true)String registermode,
            @RequestParam(value = "version",required = true,defaultValue = "1.0")String version,
            @RequestParam(value = "bindingmode",required = true)String bindingmode,
            @RequestParam(value = "trialmode",required = true)String trialmode,
            @RequestParam(value = "unbundingmode",required = true)String unbundingmode,
            @RequestParam(value = "trialtime",required = true)String trialtime,
            @RequestParam(value = "updatemode",required = true)String updatemode,
            @RequestParam(value = "updateurl",required = false)String updateurl,
            @RequestParam(value = "verificationcode",required = true)String verificationcode,
            @RequestParam(value = "unbindingtime",required = true)String unbindingtime,
            @RequestParam(value = "registerdevtime",required = true)String registerdevtime,
            @RequestParam(value = "softwarebulletin",required = true)String softwarebulletin,
            @RequestParam(value = "customcode",required = true)String customcode,
            @RequestParam(value = "staticdata",required = false)String staticdata,
            @RequestParam(value = "loginmode",required = true)String loginmode,
            @RequestParam(value = "moreopennumber",required = false,defaultValue = "3")Integer moreopennumber,
            @RequestParam(value = "authorid",required = true)Integer authorid
                                            ){

        this.softwareService.AddSoftware(softwarename,servicestate,registermode,version,bindingmode,trialmode,unbundingmode,trialtime,updatemode,updateurl,verificationcode,unbindingtime,registerdevtime,softwarebulletin,customcode,staticdata,loginmode,moreopennumber,authorid);

        return ResponseEntity.ok().build();
    }

    @GetMapping("page")
    public ResponseEntity<PageResult<Software>> querySoftwareByAuthorid(
            @RequestParam(value = "authorid",required = true)Integer authorid
    ){
        PageResult<Software> result =this.softwareService.querySoftwareByAuthorid(authorid);

        return ResponseEntity.ok(result);

    }



}
