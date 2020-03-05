package com.dabenxiong.item.server;

import com.dabenxiong.common.pojo.AlgorithmCommon;
import com.dabenxiong.common.pojo.PageResult;
import com.dabenxiong.item.mapper.SoftwareMapper;
import com.dabenxiong.item.pojo.Software;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author 一只大笨熊
 * @create 2020-02-29 7:57
 */
@Service
public class SoftwareService  {
    @Autowired
    private SoftwareMapper softwareMapper;

    /**
     * 增加软件
     * @param softwarename
     * @param servicestate
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
     */
    public void AddSoftware(String softwarename, String servicestate,String registermode, String version, String bindingmode, String trialmode, String unbundingmode, String trialtime, String updatemode, String updateurl, String verificationcode, String unbindingtime, String registerdevtime, String softwarebulletin, String customcode, String staticdata, String loginmode, Integer moreopennumber,Integer authorid) {
        AlgorithmCommon algorithmCommon = new AlgorithmCommon();

        Integer safetycode=algorithmCommon.getNum(8);

        softwareMapper.addsoftware(softwarename,servicestate,safetycode,registermode,version,bindingmode,trialmode,unbundingmode,trialtime,updatemode,updateurl,verificationcode,unbindingtime,registerdevtime,softwarebulletin,customcode,staticdata,loginmode,moreopennumber,authorid);
    }


    public PageResult<Software> querySoftwareByAuthorid(Integer authorid) {
        Example example = new Example(Software.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("authorid",authorid);
        PageHelper.startPage(1,10);
        List<Software> softwares = softwareMapper.selectByExample(example);
        PageInfo<Software> PageInfo =new PageInfo<>(softwares);
        return new PageResult<>(PageInfo.getTotal(),PageInfo.getList());

    }
}
