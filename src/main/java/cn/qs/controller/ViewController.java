package cn.qs.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.MapUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.qs.bean.tourism.View;
import cn.qs.bean.user.User;
import cn.qs.service.tourism.ViewService;
import cn.qs.utils.DefaultValue;
import cn.qs.utils.JSONResultUtil;
import cn.qs.utils.ValidateCheck;

@Controller /** 自动返回的是json格式数据 ***/
@RequestMapping("view")
public class ViewController {

	private static final Logger logger = LoggerFactory.getLogger(ViewController.class);

	@Autowired
	private ViewService viewService;

	@RequestMapping("/view-list")
	public String view_list(ModelMap map) {
		return "view-list";
	}

	@RequestMapping("/view-add")
	public String view_add(ModelMap map) {
		return "view-add";
	}

	@RequestMapping("/addView")
	@ResponseBody
	public JSONResultUtil addView(View view) {
		view.setCreatetime(new Date());

		try {
			viewService.addView(view);
		} catch (Exception e) {
			return JSONResultUtil.error("添加景点出错");
		}

		return JSONResultUtil.ok();
	}
	
	@RequestMapping("deleteView")
	@ResponseBody
	public JSONResultUtil deleteView(int id) {
		viewService.deleteView(id);
		return JSONResultUtil.ok();
	}
	
	@RequestMapping("updateView")
	public String updateView(int id, ModelMap map) {
		View view = viewService.getView(id);
		map.addAttribute("view", view);
		return "updateView";
	}
	
	@RequestMapping("doUpdateView")
	@ResponseBody
	public JSONResultUtil doUpdateView(View view) {
		logger.info("view -> {}", view);
		viewService.updateView(view);
		return JSONResultUtil.ok();
	}
	
	@RequestMapping("/getViews")
	@ResponseBody
	public PageInfo<View> getViews(@RequestParam Map condition) {
		int pageNum = 1;
		if (ValidateCheck.isNotNull(MapUtils.getString(condition, "pageNum"))) { // 如果不为空的话改变当前页号
			pageNum = Integer.parseInt(MapUtils.getString(condition, "pageNum"));
		}
		int pageSize = DefaultValue.PAGE_SIZE;
		if (ValidateCheck.isNotNull(MapUtils.getString(condition, "pageSize"))) { // 如果不为空的话改变当前页大小
			pageSize = Integer.parseInt(MapUtils.getString(condition, "pageSize"));
		}
		// 开始分页
		PageHelper.startPage(pageNum, pageSize);
		List<View> views = new ArrayList<View>();
		try {
			views = viewService.getViews(condition);
		} catch (Exception e) {
			logger.error("getUsers error！", e);
		}
		PageInfo<View> pageInfo = new PageInfo<View>(views);
		return pageInfo;
	}
}
