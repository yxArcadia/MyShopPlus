package tk.mybatis.mapper;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author yangxiang
 * @date 2019/11/13 18:17
 */
public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
