package org.ipay.model;

/**
 * author:Audience
 * date:2018/5/24
 * time:15:05
 */
public class T_merchant_related {

    /**
     * 商户ID
     */
    private long MERCHANT_ID;

    /**
     * 汇率模板ID
     */
    private long RATE_TMP_TYPE_ID;

    /**
     * 机构ID
     */
    private long ORG_ID;

    /**
     * 商户名称
     */
    private String MERCHANT_NAME;

    /**
     * 店铺ID
     */
    private long SHOP_ID;

    /**
     * 店铺名称
     */
    private String SHOP_NAME;

    public long getMERCHANT_ID() {
        return MERCHANT_ID;
    }

    public void setMERCHANT_ID(long MERCHANT_ID) {
        this.MERCHANT_ID = MERCHANT_ID;
    }

    public long getORG_ID() {
        return ORG_ID;
    }

    public void setORG_ID(long ORG_ID) {
        this.ORG_ID = ORG_ID;
    }

    public long getRATE_TMP_TYPE_ID() {
        return RATE_TMP_TYPE_ID;
    }

    public void setRATE_TMP_TYPE_ID(long RATE_TMP_TYPE_ID) {
        this.RATE_TMP_TYPE_ID = RATE_TMP_TYPE_ID;
    }

    public long getSHOP_ID() {
        return SHOP_ID;
    }

    public void setSHOP_ID(long SHOP_ID) {
        this.SHOP_ID = SHOP_ID;
    }

    public String getMERCHANT_NAME() {
        return MERCHANT_NAME;
    }

    public void setMERCHANT_NAME(String MERCHANT_NAME) {
        this.MERCHANT_NAME = MERCHANT_NAME;
    }

    public String getSHOP_NAME() {
        return SHOP_NAME;
    }

    public void setSHOP_NAME(String SHOP_NAME) {
        this.SHOP_NAME = SHOP_NAME;
    }
}
