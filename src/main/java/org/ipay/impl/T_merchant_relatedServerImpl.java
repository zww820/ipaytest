package org.ipay.impl;

import org.ipay.dao.T_merchant_relatedMpper;
import org.ipay.model.T_merchant_related;
import org.ipay.server.T_merchant_relatedServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * author:Audience
 * date:2018/5/24
 * time:16:22
 */
@Service
@Transactional
public class T_merchant_relatedServerImpl implements T_merchant_relatedServer {

    @Autowired
    T_merchant_relatedMpper t_merchant_relatedMpper;

    @Override
    public T_merchant_related search(long id) {
        return t_merchant_relatedMpper.search(id);
    }
}
