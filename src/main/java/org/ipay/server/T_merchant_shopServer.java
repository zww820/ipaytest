package org.ipay.server;

import org.springframework.stereotype.Component;

/**
 * @author Audience
 * @since 2017年9月12日 下午3:52:23
 */
@Component
public interface T_merchant_shopServer {

	public void insertData(long org_id,long merchant_id,String shop_code,String shop_name);
}
