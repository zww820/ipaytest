package org.ipay.server;

import org.apache.ibatis.annotations.Mapper;
import org.ipay.model.T_merchant;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Audience
 * @since 2017年9月1日 下午4:15:21
 */
@Component
public interface T_merchantServer {
	public void insertData(String merchant_name,String merchant_code);

	public List searchMerchantID();

}
