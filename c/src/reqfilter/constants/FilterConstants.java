package reqfilter.constants;

import java.util.HashMap;
import java.util.Map;

import reqfilter.base.BaseFilter;
/*
* @author : Nimesh Makwana
*/
public final class FilterConstants extends BaseFilter implements FilterConstantsImpl{
	private static final Map<String,String > FILTER_CONSTANTS = new HashMap<String, String>();
	private static final Map<String,String> FILTER_CLASSNAMES = new HashMap<String, String>();
	public static final String __EVENT_ID  = "__eventid";
	public static final String __REQUEST_TYPE  = "__reqtype";
	static{
		FILTER_CLASSNAMES.put("TEST","TEST");
	}
	@Override
	public String getFilterConstantValueByKey(String key) {
		
		return null;
	}
	public static void main(String[] args) {
		System.out.println(FILTER_CLASSNAMES.get("TEST"));
		System.out.println(new FilterConstants().getFilterClassNamesByKey(FilterConstants.class));
		System.out.println("base : " + "");
	}
	@Override
	public String getFilterClassNamesByKey(Class cls) {
		System.out.println("class name" + cls.getName());
		return null;
	}
	
}
