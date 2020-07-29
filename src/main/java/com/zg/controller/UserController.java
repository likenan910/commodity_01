package com.zg.controller;

import com.zg.mapper.GoodsMapper;
import com.zg.mapper.IpAddressMapper;
import com.zg.pojo.EvaluateDTO;
import com.zg.pojo.GoodsDTO;
import com.zg.service.EvServiceImp;
import com.zg.service.IpServiceImp;
import com.zg.tools.IpAddressUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Controller
public class UserController {

    @Resource
    GoodsMapper goodsMapper;
    @Resource
    IpAddressMapper ipAddressMapper;
    @Resource
    EvServiceImp ev;
    @Resource
    IpServiceImp ipServiceImp;

    //主页面
    @GetMapping({"/index","/"})
    public String goodsMapperList(Model model){
        List<GoodsDTO> list = goodsMapper.queryGoodsList();
        model.addAttribute("list",list);
        return "/index";
    }

   //查看评论信息
    @RequestMapping("/Evaluate")
    public String getEvaluate(String id,Model model){
        model.addAttribute("id", id);
        return "/emp/Evaluate";
    }
    //查看平均分
    @RequestMapping("/emp/avg")
    public String avg(String id,Model model){
        model.addAttribute("id", id);
        Double avg = ev.getGoodsAvg(id);
        List<GoodsDTO> list = goodsMapper.queryGoodsList();
        model.addAttribute("avg", avg);
        model.addAttribute("list",list);
        return "/index";
    }

   //进入评论页面
    @RequestMapping("/emp/add")
    public String addEmp(String id,Model model) {
        model.addAttribute("id", id);
        return "emp/add";
    }

    //进入增加商品页面
    @RequestMapping("/emp/addGoods")
    public String addGoods(){
        return "emp/addGoods";
    }


    //删除商品信息
    @RequestMapping("/emp/delete")
    public String deleteGoods(String id,Model model){
        int count =  goodsMapper.getDeleteGoods(id);
        if(count!=0){
            System.out.println("删除成功！！");
        }
        model.addAttribute("id", id);
        return "redirect:/index";
    }

   //评论功能
    @PostMapping("/doAdd")
    public String doAdd( EvaluateDTO e, Model model, HttpServletRequest request) throws ParseException {
        System.out.println("用户名:"+e.getGoodsId());
        String ip = IpAddressUtil.getIpAddress(request);
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String source = sdf.format(date);
        Date ymd = sdf.parse(source);

        //首先查询数据库当天有没有这个ip地址
        int count =  ipServiceImp.ipAddressIntercepter(ip,ymd);
        if(count == 0){//如果没有。。。。
            //执行业务方法，添加评论
            goodsMapper.getInsertEvaluate(e);
            model.addAttribute("msg","评论成功了1！");
        }else {
            //返回不能评论
            model.addAttribute("msg","不能评论，今天你已经评论过了。");
        }
        return "emp/add";
    }

   //增加商品信息功能
    @PostMapping("/addGoods")
    public String addGoods(GoodsDTO goodsDTO,Model model){
        String name =  goodsDTO.getGoodsId();
        System.out.println("转过来的用户名为:"+name);
        List<GoodsDTO> goods = goodsMapper.getGoods(name);
            if(goods.isEmpty()){
                if(name.equals("")){
                    model.addAttribute("msg","用户名不能为空。");
                }else{
                    int count = goodsMapper.getInsertGoods(goodsDTO);
                    if (count!=0){
                    System.out.println("增加成功！！");
                    model.addAttribute("msg","添加商品信息成功。");
                    }
                }
            }else {
                model.addAttribute("msg","用户名已经存在。");
            }

        return "/emp/addGoods";
    }

}
