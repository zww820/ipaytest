package org.ipay.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class T_pay_order_refund implements Serializable {
    /**
     * 表 : IPAY_CORE_TEST.T_PAY_ORDER_REFUND
     * 对应字段 : ID
     */
    private Long ID;

    /**
     * 表 : IPAY_CORE_TEST.T_PAY_ORDER_REFUND
     * 对应字段 : AMOUNT
     */
    private BigDecimal AMOUNT;

    /**
     * 表 : IPAY_CORE_TEST.T_PAY_ORDER_REFUND
     * 对应字段 : REFUND_POINTS
     */
    private Long REFUND_POINTS;

    /**
     * 表 : IPAY_CORE_TEST.T_PAY_ORDER_REFUND
     * 对应字段 : STATUS
     */
    private String STATUS;

    /**
     * 表 : IPAY_CORE_TEST.T_PAY_ORDER_REFUND
     * 对应字段 : CHANNEL_ID
     */
    private BigDecimal CHANNEL_ID;

    /**
     * 表 : IPAY_CORE_TEST.T_PAY_ORDER_REFUND
     * 对应字段 : SHOP_ID
     */
    private BigDecimal SHOP_ID;

    /**
     * 表 : IPAY_CORE_TEST.T_PAY_ORDER_REFUND
     * 对应字段 : ORDER_ID
     */
    private BigDecimal ORDER_ID;

    /**
     * 表 : IPAY_CORE_TEST.T_PAY_ORDER_REFUND
     * 对应字段 : REFUND_NO
     */
    private String REFUND_NO;

    /**
     * 表 : IPAY_CORE_TEST.T_PAY_ORDER_REFUND
     * 对应字段 : SERIAL_NO
     */
    private String SERIAL_NO;

    /**
     * 表 : IPAY_CORE_TEST.T_PAY_ORDER_REFUND
     * 对应字段 : CREATED_ID
     */
    private BigDecimal CREATED_ID;

    /**
     * 表 : IPAY_CORE_TEST.T_PAY_ORDER_REFUND
     * 对应字段 : CREATED_TIME
     */
    private Date CREATED_TIME;

    /**
     * 表 : IPAY_CORE_TEST.T_PAY_ORDER_REFUND
     * 对应字段 : CHANNEL_CODE
     */
    private String CHANNEL_CODE;

    /**
     * 表 : IPAY_CORE_TEST.T_PAY_ORDER_REFUND
     * 对应字段 : SHOP_NAME
     */
    private String SHOP_NAME;

    /**
     * 表 : IPAY_CORE_TEST.T_PAY_ORDER_REFUND
     * 对应字段 : CASHIER
     */
    private String CASHIER;

    /**
     * 表 : IPAY_CORE_TEST.T_PAY_ORDER_REFUND
     * 对应字段 : MESSAGE
     */
    private String MESSAGE;

    /**
     * 表 : IPAY_CORE_TEST.T_PAY_ORDER_REFUND
     * 对应字段 : ORDER_NO
     */
    private String ORDER_NO;

    /**
     * 表 : IPAY_CORE_TEST.T_PAY_ORDER_REFUND
     * 对应字段 : REMARK
     */
    private String REMARK;

    /**
     * 表 : IPAY_CORE_TEST.T_PAY_ORDER_REFUND
     * 对应字段 : LEAVE_MESSAGE
     */
    private String LEAVE_MESSAGE;

    /**
     * 表 : IPAY_CORE_TEST.T_PAY_ORDER_REFUND
     * 对应字段 : ORDER_PAY_TIME
     */
    private Date ORDER_PAY_TIME;

    /**
     * 表 : IPAY_CORE_TEST.T_PAY_ORDER_REFUND
     * 对应字段 : ORDER_TRADE_NO
     */
    private String ORDER_TRADE_NO;

    /**
     * 表 : IPAY_CORE_TEST.T_PAY_ORDER_REFUND
     * 对应字段 : CHANNEL_REFUND_TIME
     */
    private Date CHANNEL_REFUND_TIME;

    /**
     * 表 : IPAY_CORE_TEST.T_PAY_ORDER_REFUND
     * 对应字段 : REFUND_DATE
     */
    private String REFUND_DATE;

    /**
     * 表 : IPAY_CORE_TEST.T_PAY_ORDER_REFUND
     * 对应字段 : CHECK_STATUS
     */
    private String CHECK_STATUS;

    /**
     * 表 : IPAY_CORE_TEST.T_PAY_ORDER_REFUND
     * 对应字段 : CHECK_DATE
     */
    private String CHECK_DATE;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table IPAY_CORE_TEST.T_PAY_ORDER_REFUND
     *
     * @MBG Generated Wed Aug 23 12:24:29 CST 2017
     */
    private static final long serialVersionUID = 1L;

    /**
     * get method 
     *
     * @return IPAY_CORE_TEST.T_PAY_ORDER_REFUND.ID：null
     */
    public Long getID() {
        return ID;
    }

    /**
     * set method 
     *
     * @param ID  null
     */
    public void setID(Long ID) {
        this.ID = ID;
    }

    /**
     * get method 
     *
     * @return IPAY_CORE_TEST.T_PAY_ORDER_REFUND.AMOUNT：null
     */
    public BigDecimal getAMOUNT() {
        return AMOUNT;
    }

    /**
     * set method 
     *
     * @param AMOUNT  null
     */
    public void setAMOUNT(BigDecimal AMOUNT) {
        this.AMOUNT = AMOUNT;
    }

    /**
     * get method 
     *
     * @return IPAY_CORE_TEST.T_PAY_ORDER_REFUND.REFUND_POINTS：null
     */
    public Long getREFUND_POINTS() {
        return REFUND_POINTS;
    }

    /**
     * set method 
     *
     * @param REFUND_POINTS  null
     */
    public void setREFUND_POINTS(Long REFUND_POINTS) {
        this.REFUND_POINTS = REFUND_POINTS;
    }

    /**
     * get method 
     *
     * @return IPAY_CORE_TEST.T_PAY_ORDER_REFUND.STATUS：null
     */
    public String getSTATUS() {
        return STATUS;
    }

    /**
     * set method 
     *
     * @param STATUS  null
     */
    public void setSTATUS(String STATUS) {
        this.STATUS = STATUS == null ? null : STATUS.trim();
    }

    /**
     * get method 
     *
     * @return IPAY_CORE_TEST.T_PAY_ORDER_REFUND.CHANNEL_ID：null
     */
    public BigDecimal getCHANNEL_ID() {
        return CHANNEL_ID;
    }

    /**
     * set method 
     *
     * @param CHANNEL_ID  null
     */
    public void setCHANNEL_ID(BigDecimal CHANNEL_ID) {
        this.CHANNEL_ID = CHANNEL_ID;
    }

    /**
     * get method 
     *
     * @return IPAY_CORE_TEST.T_PAY_ORDER_REFUND.SHOP_ID：null
     */
    public BigDecimal getSHOP_ID() {
        return SHOP_ID;
    }

    /**
     * set method 
     *
     * @param SHOP_ID  null
     */
    public void setSHOP_ID(BigDecimal SHOP_ID) {
        this.SHOP_ID = SHOP_ID;
    }

    /**
     * get method 
     *
     * @return IPAY_CORE_TEST.T_PAY_ORDER_REFUND.ORDER_ID：null
     */
    public BigDecimal getORDER_ID() {
        return ORDER_ID;
    }

    /**
     * set method 
     *
     * @param ORDER_ID  null
     */
    public void setORDER_ID(BigDecimal ORDER_ID) {
        this.ORDER_ID = ORDER_ID;
    }

    /**
     * get method 
     *
     * @return IPAY_CORE_TEST.T_PAY_ORDER_REFUND.REFUND_NO：null
     */
    public String getREFUND_NO() {
        return REFUND_NO;
    }

    /**
     * set method 
     *
     * @param REFUND_NO  null
     */
    public void setREFUND_NO(String REFUND_NO) {
        this.REFUND_NO = REFUND_NO == null ? null : REFUND_NO.trim();
    }

    /**
     * get method 
     *
     * @return IPAY_CORE_TEST.T_PAY_ORDER_REFUND.SERIAL_NO：null
     */
    public String getSERIAL_NO() {
        return SERIAL_NO;
    }

    /**
     * set method 
     *
     * @param SERIAL_NO  渠道退款流水
     */
    public void setSERIAL_NO(String SERIAL_NO) {
        this.SERIAL_NO = SERIAL_NO == null ? null : SERIAL_NO.trim();
    }

    /**
     * get method 
     *
     * @return IPAY_CORE_TEST.T_PAY_ORDER_REFUND.CREATED_ID：null
     */
    public BigDecimal getCREATED_ID() {
        return CREATED_ID;
    }

    /**
     * set method 
     *
     * @param CREATED_ID  null
     */
    public void setCREATED_ID(BigDecimal CREATED_ID) {
        this.CREATED_ID = CREATED_ID;
    }

    /**
     * get method 
     *
     * @return IPAY_CORE_TEST.T_PAY_ORDER_REFUND.CREATED_TIME：null
     */
    public Date getCREATED_TIME() {
        return CREATED_TIME;
    }

    /**
     * set method 
     *
     * @param CREATED_TIME  null
     */
    public void setCREATED_TIME(Date CREATED_TIME) {
        this.CREATED_TIME = CREATED_TIME;
    }

    /**
     * get method 
     *
     * @return IPAY_CORE_TEST.T_PAY_ORDER_REFUND.CHANNEL_CODE：null
     */
    public String getCHANNEL_CODE() {
        return CHANNEL_CODE;
    }

    /**
     * set method 
     *
     * @param CHANNEL_CODE  null
     */
    public void setCHANNEL_CODE(String CHANNEL_CODE) {
        this.CHANNEL_CODE = CHANNEL_CODE == null ? null : CHANNEL_CODE.trim();
    }

    /**
     * get method 
     *
     * @return IPAY_CORE_TEST.T_PAY_ORDER_REFUND.SHOP_NAME：null
     */
    public String getSHOP_NAME() {
        return SHOP_NAME;
    }

    /**
     * set method 
     *
     * @param SHOP_NAME  null
     */
    public void setSHOP_NAME(String SHOP_NAME) {
        this.SHOP_NAME = SHOP_NAME == null ? null : SHOP_NAME.trim();
    }

    /**
     * get method 
     *
     * @return IPAY_CORE_TEST.T_PAY_ORDER_REFUND.CASHIER：null
     */
    public String getCASHIER() {
        return CASHIER;
    }

    /**
     * set method 
     *
     * @param CASHIER  null
     */
    public void setCASHIER(String CASHIER) {
        this.CASHIER = CASHIER == null ? null : CASHIER.trim();
    }

    /**
     * get method 
     *
     * @return IPAY_CORE_TEST.T_PAY_ORDER_REFUND.MESSAGE：null
     */
    public String getMESSAGE() {
        return MESSAGE;
    }

    /**
     * set method 
     *
     * @param MESSAGE  null
     */
    public void setMESSAGE(String MESSAGE) {
        this.MESSAGE = MESSAGE == null ? null : MESSAGE.trim();
    }

    /**
     * get method 
     *
     * @return IPAY_CORE_TEST.T_PAY_ORDER_REFUND.ORDER_NO：null
     */
    public String getORDER_NO() {
        return ORDER_NO;
    }

    /**
     * set method 
     *
     * @param ORDER_NO  null
     */
    public void setORDER_NO(String ORDER_NO) {
        this.ORDER_NO = ORDER_NO == null ? null : ORDER_NO.trim();
    }

    /**
     * get method 
     *
     * @return IPAY_CORE_TEST.T_PAY_ORDER_REFUND.REMARK：null
     */
    public String getREMARK() {
        return REMARK;
    }

    /**
     * set method 
     *
     * @param REMARK  null
     */
    public void setREMARK(String REMARK) {
        this.REMARK = REMARK == null ? null : REMARK.trim();
    }

    /**
     * get method 
     *
     * @return IPAY_CORE_TEST.T_PAY_ORDER_REFUND.LEAVE_MESSAGE：null
     */
    public String getLEAVE_MESSAGE() {
        return LEAVE_MESSAGE;
    }

    /**
     * set method 
     *
     * @param LEAVE_MESSAGE  null
     */
    public void setLEAVE_MESSAGE(String LEAVE_MESSAGE) {
        this.LEAVE_MESSAGE = LEAVE_MESSAGE == null ? null : LEAVE_MESSAGE.trim();
    }

    /**
     * get method 
     *
     * @return IPAY_CORE_TEST.T_PAY_ORDER_REFUND.ORDER_PAY_TIME：null
     */
    public Date getORDER_PAY_TIME() {
        return ORDER_PAY_TIME;
    }

    /**
     * set method 
     *
     * @param ORDER_PAY_TIME  null
     */
    public void setORDER_PAY_TIME(Date ORDER_PAY_TIME) {
        this.ORDER_PAY_TIME = ORDER_PAY_TIME;
    }

    /**
     * get method 
     *
     * @return IPAY_CORE_TEST.T_PAY_ORDER_REFUND.ORDER_TRADE_NO：null
     */
    public String getORDER_TRADE_NO() {
        return ORDER_TRADE_NO;
    }

    /**
     * set method 
     *
     * @param ORDER_TRADE_NO  原支付流水号
     */
    public void setORDER_TRADE_NO(String ORDER_TRADE_NO) {
        this.ORDER_TRADE_NO = ORDER_TRADE_NO == null ? null : ORDER_TRADE_NO.trim();
    }

    /**
     * get method 
     *
     * @return IPAY_CORE_TEST.T_PAY_ORDER_REFUND.CHANNEL_REFUND_TIME：null
     */
    public Date getCHANNEL_REFUND_TIME() {
        return CHANNEL_REFUND_TIME;
    }

    /**
     * set method 
     *
     * @param CHANNEL_REFUND_TIME  null
     */
    public void setCHANNEL_REFUND_TIME(Date CHANNEL_REFUND_TIME) {
        this.CHANNEL_REFUND_TIME = CHANNEL_REFUND_TIME;
    }

    /**
     * get method 
     *
     * @return IPAY_CORE_TEST.T_PAY_ORDER_REFUND.REFUND_DATE：null
     */
    public String getREFUND_DATE() {
        return REFUND_DATE;
    }

    /**
     * set method 
     *
     * @param REFUND_DATE  null
     */
    public void setREFUND_DATE(String REFUND_DATE) {
        this.REFUND_DATE = REFUND_DATE == null ? null : REFUND_DATE.trim();
    }

    /**
     * get method 
     *
     * @return IPAY_CORE_TEST.T_PAY_ORDER_REFUND.CHECK_STATUS：null
     */
    public String getCHECK_STATUS() {
        return CHECK_STATUS;
    }

    /**
     * set method 
     *
     * @param CHECK_STATUS  null
     */
    public void setCHECK_STATUS(String CHECK_STATUS) {
        this.CHECK_STATUS = CHECK_STATUS == null ? null : CHECK_STATUS.trim();
    }

    /**
     * get method 
     *
     * @return IPAY_CORE_TEST.T_PAY_ORDER_REFUND.CHECK_DATE：null
     */
    public String getCHECK_DATE() {
        return CHECK_DATE;
    }

    /**
     * set method 
     *
     * @param CHECK_DATE  null
     */
    public void setCHECK_DATE(String CHECK_DATE) {
        this.CHECK_DATE = CHECK_DATE == null ? null : CHECK_DATE.trim();
    }

    /**
     *
     * @param that
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        T_pay_order_refund other = (T_pay_order_refund) that;
        return (this.getID() == null ? other.getID() == null : this.getID().equals(other.getID()))
            && (this.getAMOUNT() == null ? other.getAMOUNT() == null : this.getAMOUNT().equals(other.getAMOUNT()))
            && (this.getREFUND_POINTS() == null ? other.getREFUND_POINTS() == null : this.getREFUND_POINTS().equals(other.getREFUND_POINTS()))
            && (this.getSTATUS() == null ? other.getSTATUS() == null : this.getSTATUS().equals(other.getSTATUS()))
            && (this.getCHANNEL_ID() == null ? other.getCHANNEL_ID() == null : this.getCHANNEL_ID().equals(other.getCHANNEL_ID()))
            && (this.getSHOP_ID() == null ? other.getSHOP_ID() == null : this.getSHOP_ID().equals(other.getSHOP_ID()))
            && (this.getORDER_ID() == null ? other.getORDER_ID() == null : this.getORDER_ID().equals(other.getORDER_ID()))
            && (this.getREFUND_NO() == null ? other.getREFUND_NO() == null : this.getREFUND_NO().equals(other.getREFUND_NO()))
            && (this.getSERIAL_NO() == null ? other.getSERIAL_NO() == null : this.getSERIAL_NO().equals(other.getSERIAL_NO()))
            && (this.getCREATED_ID() == null ? other.getCREATED_ID() == null : this.getCREATED_ID().equals(other.getCREATED_ID()))
            && (this.getCREATED_TIME() == null ? other.getCREATED_TIME() == null : this.getCREATED_TIME().equals(other.getCREATED_TIME()))
            && (this.getCHANNEL_CODE() == null ? other.getCHANNEL_CODE() == null : this.getCHANNEL_CODE().equals(other.getCHANNEL_CODE()))
            && (this.getSHOP_NAME() == null ? other.getSHOP_NAME() == null : this.getSHOP_NAME().equals(other.getSHOP_NAME()))
            && (this.getCASHIER() == null ? other.getCASHIER() == null : this.getCASHIER().equals(other.getCASHIER()))
            && (this.getMESSAGE() == null ? other.getMESSAGE() == null : this.getMESSAGE().equals(other.getMESSAGE()))
            && (this.getORDER_NO() == null ? other.getORDER_NO() == null : this.getORDER_NO().equals(other.getORDER_NO()))
            && (this.getREMARK() == null ? other.getREMARK() == null : this.getREMARK().equals(other.getREMARK()))
            && (this.getLEAVE_MESSAGE() == null ? other.getLEAVE_MESSAGE() == null : this.getLEAVE_MESSAGE().equals(other.getLEAVE_MESSAGE()))
            && (this.getORDER_PAY_TIME() == null ? other.getORDER_PAY_TIME() == null : this.getORDER_PAY_TIME().equals(other.getORDER_PAY_TIME()))
            && (this.getORDER_TRADE_NO() == null ? other.getORDER_TRADE_NO() == null : this.getORDER_TRADE_NO().equals(other.getORDER_TRADE_NO()))
            && (this.getCHANNEL_REFUND_TIME() == null ? other.getCHANNEL_REFUND_TIME() == null : this.getCHANNEL_REFUND_TIME().equals(other.getCHANNEL_REFUND_TIME()))
            && (this.getREFUND_DATE() == null ? other.getREFUND_DATE() == null : this.getREFUND_DATE().equals(other.getREFUND_DATE()))
            && (this.getCHECK_STATUS() == null ? other.getCHECK_STATUS() == null : this.getCHECK_STATUS().equals(other.getCHECK_STATUS()))
            && (this.getCHECK_DATE() == null ? other.getCHECK_DATE() == null : this.getCHECK_DATE().equals(other.getCHECK_DATE()));
    }

    /**
     *
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getID() == null) ? 0 : getID().hashCode());
        result = prime * result + ((getAMOUNT() == null) ? 0 : getAMOUNT().hashCode());
        result = prime * result + ((getREFUND_POINTS() == null) ? 0 : getREFUND_POINTS().hashCode());
        result = prime * result + ((getSTATUS() == null) ? 0 : getSTATUS().hashCode());
        result = prime * result + ((getCHANNEL_ID() == null) ? 0 : getCHANNEL_ID().hashCode());
        result = prime * result + ((getSHOP_ID() == null) ? 0 : getSHOP_ID().hashCode());
        result = prime * result + ((getORDER_ID() == null) ? 0 : getORDER_ID().hashCode());
        result = prime * result + ((getREFUND_NO() == null) ? 0 : getREFUND_NO().hashCode());
        result = prime * result + ((getSERIAL_NO() == null) ? 0 : getSERIAL_NO().hashCode());
        result = prime * result + ((getCREATED_ID() == null) ? 0 : getCREATED_ID().hashCode());
        result = prime * result + ((getCREATED_TIME() == null) ? 0 : getCREATED_TIME().hashCode());
        result = prime * result + ((getCHANNEL_CODE() == null) ? 0 : getCHANNEL_CODE().hashCode());
        result = prime * result + ((getSHOP_NAME() == null) ? 0 : getSHOP_NAME().hashCode());
        result = prime * result + ((getCASHIER() == null) ? 0 : getCASHIER().hashCode());
        result = prime * result + ((getMESSAGE() == null) ? 0 : getMESSAGE().hashCode());
        result = prime * result + ((getORDER_NO() == null) ? 0 : getORDER_NO().hashCode());
        result = prime * result + ((getREMARK() == null) ? 0 : getREMARK().hashCode());
        result = prime * result + ((getLEAVE_MESSAGE() == null) ? 0 : getLEAVE_MESSAGE().hashCode());
        result = prime * result + ((getORDER_PAY_TIME() == null) ? 0 : getORDER_PAY_TIME().hashCode());
        result = prime * result + ((getORDER_TRADE_NO() == null) ? 0 : getORDER_TRADE_NO().hashCode());
        result = prime * result + ((getCHANNEL_REFUND_TIME() == null) ? 0 : getCHANNEL_REFUND_TIME().hashCode());
        result = prime * result + ((getREFUND_DATE() == null) ? 0 : getREFUND_DATE().hashCode());
        result = prime * result + ((getCHECK_STATUS() == null) ? 0 : getCHECK_STATUS().hashCode());
        result = prime * result + ((getCHECK_DATE() == null) ? 0 : getCHECK_DATE().hashCode());
        return result;
    }
}