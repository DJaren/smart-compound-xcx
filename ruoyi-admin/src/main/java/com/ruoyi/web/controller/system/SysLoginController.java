package com.ruoyi.web.controller.system;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.http.HttpUtils;
import com.ruoyi.system.service.ISysUserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.constant.Constants;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.entity.SysMenu;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.core.domain.model.LoginBody;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.utils.ServletUtils;
import com.ruoyi.framework.web.service.SysLoginService;
import com.ruoyi.framework.web.service.SysPermissionService;
import com.ruoyi.framework.web.service.TokenService;
import com.ruoyi.system.service.ISysMenuService;

/**
 * 登录验证
 *
 * @author ruoyi
 */
@RestController
public class SysLoginController
{
    @Autowired
    private SysLoginService loginService;
    @Autowired
    private ISysUserService userService;

    @Autowired
    private ISysMenuService menuService;

    @Autowired
    private SysPermissionService permissionService;

    @Autowired
    private TokenService tokenService;

    private String appID = "wxc0c8c19b45c0d5a7";
    private String appSecret = "668158b5680f1437c0c9417b2e4adc91";

    /**
     * 登录方法
     *
     * @param loginBody 登录信息
     * @return 结果
     */
//    @PostMapping("/login")
//    public AjaxResult login(@RequestBody LoginBody loginBody)
//    {
//        AjaxResult ajax = AjaxResult.success();
//        // 生成令牌
//        String token = loginService.login(loginBody.getUsername(), loginBody.getPassword(), loginBody.getCode(),
//                loginBody.getUuid());
//        ajax.put(Constants.TOKEN, token);
//        return ajax;
//    }

    //新的登陆方法，去除了验证码和UUID
    @PostMapping("/login")
    public AjaxResult login1(@RequestBody LoginBody loginBody)
    {
        AjaxResult ajax = AjaxResult.success();
        // 生成令牌
        Map<String,Object> res  = loginService.login(loginBody.getUsername(), loginBody.getPassword());
        ajax.put(Constants.TOKEN, res.get("token"));
        return ajax;
    }

    /**
     * 小程序登录
     * @param code
     * @return
     */
    @ApiOperation("小程序登录")
    @GetMapping("/wxLogin")
    public AjaxResult login2(@RequestParam(name = "code")String code)
    {

        String openId=getOpenId(code);
        AjaxResult ajax = AjaxResult.success();
        SysUser user = userService.selectUserByUserName(openId);
        if(user!=null) {
            // 生成令牌
            Map<String, Object> res = loginService.login1(openId);
            ajax.put(Constants.TOKEN, res.get("token"));
        }
            ajax.put("user", user);
            ajax.put("openId", openId);
        return ajax;
    }

    /**
     * 小程序登录
     * @param code
     * @return
     */
    @ApiOperation("小程序登录")
    @GetMapping("/fkLogin")
    public AjaxResult login3(@RequestParam(name = "code")String code)
    {

        String openId=getOpenId(code);
        AjaxResult ajax = AjaxResult.success();

        ajax.put("openId", openId);
        return ajax;
    }
    /**
     * 新增用户
     */
    @Log(title = "用户管理", businessType = BusinessType.INSERT)
    @ApiOperation("绑定用户信息")
    @PostMapping("/addUser")
    public AjaxResult add(@Validated @RequestBody SysUser user)
    {

        if (UserConstants.NOT_UNIQUE.equals(userService.checkPhoneUnique(user)))
        {
            return AjaxResult.error("新增用户'" + user.getUserName() + "'失败，手机号码已存在");
        }
//        else if (UserConstants.NOT_UNIQUE.equals(userService.checkEmailUnique(user)))
//        {
//            return AjaxResult.error("新增用户'" + user.getUserName() + "'失败，邮箱账号已存在");
//        }
        user.setCreateBy(SecurityUtils.getUsername());
        int rows=   userService.insertUser(user);
        //user.setPassword(SecurityUtils.encryptPassword(user.getPassword()));
        return rows > 0 ? AjaxResult.success() : AjaxResult.error();

    }
    /**
     * 获取用户信息
     *
     * @return 用户信息
     */
    @GetMapping("getInfo")
    public AjaxResult getInfo()
    {
        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
        SysUser user = loginUser.getUser();
        // 角色集合
        Set<String> roles = permissionService.getRolePermission(user);
        // 权限集合
        Set<String> permissions = permissionService.getMenuPermission(user);
        AjaxResult ajax = AjaxResult.success();
        ajax.put("user", user);
        ajax.put("roles", roles);
        ajax.put("permissions", permissions);
        return ajax;
    }

    /**
     * 获取路由信息
     *
     * @return 路由信息
     */
    @GetMapping("getRouters")
    public AjaxResult getRouters()
    {
        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
        // 用户信息
        SysUser user = loginUser.getUser();
        List<SysMenu> menus = menuService.selectMenuTreeByUserId(user.getUserId());
        return AjaxResult.success(menuService.buildMenus(menus));
    }
   private String getOpenId(String code){
       String result = "";
       try{//请求微信服务器，用code换取openid。HttpUtil是工具类，后面会给出实现，Configure类是小程序配置信息，后面会给出代码
           result = HttpUtils.sendGet(
                   "https://api.weixin.qq.com/sns/jscode2session?appid="
                           + this.appID + "&secret="
                           + this.appSecret + "&js_code="
                           + code
                           + "&grant_type=authorization_code", null);
       }
       catch (Exception e) {
           e.printStackTrace();
       }
       JSONObject obj=JSONObject.parseObject(result);
       System.out.println(obj.getString("openid"));
       return obj.getString("openid");
   }


}
