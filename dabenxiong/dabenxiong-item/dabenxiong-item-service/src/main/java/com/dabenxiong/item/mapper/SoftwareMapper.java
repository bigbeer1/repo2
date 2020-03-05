package com.dabenxiong.item.mapper;

import com.dabenxiong.item.pojo.Software;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author 一只大笨熊
 * @create 2020-02-29 7:56
 */
public interface SoftwareMapper extends Mapper<Software> {
    @Insert("INSERT INTO tb_software (softwarename, servicestate,safetycode,registermode,version,bindingmode,trialmode," +
            "unbundingmode,trialtime,updatemode,updateurl,verificationcode,unbindingtime,registerdevtime,softwarebulletin," +
            "customcode,staticdata,loginmode,moreopennumber,authorid) values" +
            "(#{softwarename},#{servicestate},#{safetycode},#{registermode},#{version},#{bindingmode},#{trialmode}," +
            "#{unbundingmode},#{trialtime},#{updatemode},#{updateurl},#{verificationcode},#{unbindingtime},#{registerdevtime},#{softwarebulletin}," +
            "#{customcode},#{staticdata},#{loginmode},#{moreopennumber},#{authorid})")
     int addsoftware(@Param("softwarename")String softwarename,@Param("servicestate")String servicestate,@Param("safetycode")Integer safetycode,
                            @Param("registermode")String registermode,@Param("version")String version,@Param("bindingmode")String bindingmode,
                            @Param("trialmode")String trialmode,@Param("unbundingmode")String unbundingmode,@Param("trialtime")String trialtime,
                            @Param("updatemode")String updatemode,@Param("updateurl")String updateurl,@Param("verificationcode")String verificationcode,
                            @Param("unbindingtime")String unbindingtime,@Param("registerdevtime")String registerdevtime,@Param("softwarebulletin")String softwarebulletin,
                            @Param("customcode")String customcode,@Param("staticdata")String staticdata,@Param("loginmode")String loginmode,
                            @Param("moreopennumber")Integer moreopennumber,@Param("authorid")Integer authorid);

}
