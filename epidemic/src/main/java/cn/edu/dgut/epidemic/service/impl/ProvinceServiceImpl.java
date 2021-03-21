package cn.edu.dgut.epidemic.service.impl;

import org.springframework.stereotype.Service;

import cn.edu.dgut.epidemic.service.ProvinceService;

@Service
public class ProvinceServiceImpl implements ProvinceService {
	/*@Autowired
	private ExtendMapper extendMapper;

	@Override
	public List<Province> findNoDataProvinces(String date) {
		short year = 0, month = 0, day = 0;
		String[] array = date.split("-");
		List<Province> list = null;
		if (array.length >= 3) {
			year = Short.parseShort(array[0]);
			month = Short.parseShort(array[1]);
			day = Short.parseShort(array[2]);

			list = this.extendMapper.findNoDataProvinces(year, month, day);
		}
		return list;
	}*/
}
