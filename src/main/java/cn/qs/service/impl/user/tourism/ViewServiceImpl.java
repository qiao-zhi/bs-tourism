package cn.qs.service.impl.user.tourism;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.qs.bean.tourism.View;
import cn.qs.bean.tourism.ViewExample;
import cn.qs.mapper.tourism.ViewMapper;
import cn.qs.service.tourism.ViewService;

@Service
public class ViewServiceImpl implements ViewService {

	@Autowired
	private ViewMapper viewMapper;

	@Override
	public void addView(View view) {
		viewMapper.insert(view);
	}

	@Override
	public List<View> getViews(Map condition) {
		ViewExample viewExample = new ViewExample();
		List<View> list = viewMapper.selectByExampleWithBLOBs(viewExample);
		return list;
	}

	@Override
	public void deleteView(int id) {
		viewMapper.deleteByPrimaryKey(id);
	}

	@Override
	public View getView(int id) {
		return viewMapper.selectByPrimaryKey(id);
	}

	@Override
	public void updateView(View view) {
		viewMapper.updateByPrimaryKeySelective(view);
	}

}
