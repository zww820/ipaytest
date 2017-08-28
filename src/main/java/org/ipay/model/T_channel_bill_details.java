package org.ipay.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class T_channel_bill_details implements Serializable {
    /**
     * 表 : IPAY_CORE_TEST.T_CHANNEL_BILL_DETAILS
     * 对应字段 : ID
     */
    private Long ID;

    /**
     * 表 : IPAY_CORE_TEST.T_CHANNEL_BILL_DETAILS
     * 对应字段 : CHECK_DATE
     */
    private String CHECK_DATE;

    /**
     * 表 : IPAY_CORE_TEST.T_CHANNEL_BILL_DETAILS
     * 对应字段 : CHANNEL_ID
     */
    private BigDecimal CHANNEL_ID;

    /**
     * 表 : IPAY_CORE_TEST.T_CHANNEL_BILL_DETAILS
     * 对应字段 : CHANNEL_CODE
     */
    private String CHANNEL_CODE;

    /**
     * 表 : IPAY_CORE_TEST.T_CHANNEL_BILL_DETAILS
     * 对应字段 : CHANNEL_ORDER_NO
     */
    private String CHANNEL_ORDER_NO;

    /**
     * 表 : IPAY_CORE_TEST.T_CHANNEL_BILL_DETAILS
     * 对应字段 : OUT_ORDER_NO
     */
    private String OUT_ORDER_NO;

    /**
     * 表 : IPAY_CORE_TEST.T_CHANNEL_BILL_DETAILS
     * 对应字段 : PAY_TYPE
     */
    private String PAY_TYPE;

    /**
     * 表 : IPAY_CORE_TEST.T_CHANNEL_BILL_DETAILS
     * 对应字段 : BUSINESS_TYPE
     */
    private String BUSINESS_TYPE;

    /**
     * 表 : IPAY_CORE_TEST.T_CHANNEL_BILL_DETAILS
     * 对应字段 : CHANNEL_TOTAL_AMOUNT
     */
    private BigDecimal CHANNEL_TOTAL_AMOUNT;

    /**
     * 表 : IPAY_CORE_TEST.T_CHANNEL_BILL_DETAILS
     * 对应字段 : CHANNEL_DISCOUNT_AMOUNT
     */
    private BigDecimal CHANNEL_DISCOUNT_AMOUNT;

    /**
     * 表 : IPAY_CORE_TEST.T_CHANNEL_BILL_DETAILS
     * 对应字段 : CHANNEL_EXPIRE_TIME
     */
    private Date CHANNEL_EXPIRE_TIME;

    /**
     * 表 : IPAY_CORE_TEST.T_CHANNEL_BILL_DETAILS
     * 对应字段 : CHANNEL_REFUND_NO
     */
    private String CHANNEL_REFUND_NO;

    /**
     * 表 : IPAY_CORE_TEST.T_CHANNEL_BILL_DETAILS
     * 对应字段 : OUT_REFUND_NO
     */
    private String OUT_REFUND_NO;

    /**
     * 表 : IPAY_CORE_TEST.T_CHANNEL_BILL_DETAILS
     * 对应字段 : FEE
     */
    private BigDecimal FEE;

    /**
     * 表 : IPAY_CORE_TEST.T_CHANNEL_BILL_DETAILS
     * 对应字段 : MESSAGE
     */
    private String MESSAGE;

    /**
     * 表 : IPAY_CORE_TEST.T_CHANNEL_BILL_DETAILS
     * 对应字段 : CHECK_STATUS
     */
    private String CHECK_STATUS;

    /**
     * 表 : IPAY_CORE_TEST.T_CHANNEL_BILL_DETAILS
     * 对应字段 : DFILE_ID
     */
    private BigDecimal DFILE_ID;

    /**
     * 表 : IPAY_CORE_TEST.T_CHANNEL_BILL_DETAILS
     * 对应字段 : NOTE
     */
    private String NOTE;

    /**
     * 表 : IPAY_CORE_TEST.T_CHANNEL_BILL_DETAILS
     * 对应字段 : CREATED_TIME
     */
    private Date CREATED_TIME;

    /**
     * 表 : IPAY_CORE_TEST.T_CHANNEL_BILL_DETAILS
     * 对应字段 : UPDATED_TIME
     */
    private Date UPDATED_TIME;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table IPAY_CORE_TEST.T_CHANNEL_BILL_DETAILS
     *
     * @MBG Generated Mon Aug 07 19:43:33 CST 2017
     */
    private static final long serialVersionUID = 1L;

    /**
     * get method 
     *
     * @return IPAY_CORE_TEST.T_CHANNEL_BILL_DETAILS.ID：null
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
     * @return IPAY_CORE_TEST.T_CHANNEL_BILL_DETAILS.CHECK_DATE：null
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
     * get method 
     *
     * @return IPAY_CORE_TEST.T_CHANNEL_BILL_DETAILS.CHANNEL_ID：null
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
     * @return IPAY_CORE_TEST.T_CHANNEL_BILL_DETAILS.CHANNEL_CODE：null
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
     * @return IPAY_CORE_TEST.T_CHANNEL_BILL_DETAILS.CHANNEL_ORDER_NO：null
     */
    public String getCHANNEL_ORDER_NO() {
        return CHANNEL_ORDER_NO;
    }

    /**
     * set method 
     *
     * @param CHANNEL_ORDER_NO  null
     */
    public void setCHANNEL_ORDER_NO(String CHANNEL_ORDER_NO) {
        this.CHANNEL_ORDER_NO = CHANNEL_ORDER_NO == null ? null : CHANNEL_ORDER_NO.trim();
    }

    /**
     * get method 
     *
     * @return IPAY_CORE_TEST.T_CHANNEL_BILL_DETAILS.OUT_ORDER_NO：null
     */
    public String getOUT_ORDER_NO() {
        return OUT_ORDER_NO;
    }

    /**
     * set method 
     *
     * @param OUT_ORDER_NO  null
     */
    public void setOUT_ORDER_NO(String OUT_ORDER_NO) {
        this.OUT_ORDER_NO = OUT_ORDER_NO == null ? null : OUT_ORDER_NO.trim();
    }

    /**
     * get method 
     *
     * @return IPAY_CORE_TEST.T_CHANNEL_BILL_DETAILS.PAY_TYPE：null
     */
    public String getPAY_TYPE() {
        return PAY_TYPE;
    }

    /**
     * set method 
     *
     * @param PAY_TYPE  null
     */
    public void setPAY_TYPE(String PAY_TYPE) {
        this.PAY_TYPE = PAY_TYPE == null ? null : PAY_TYPE.trim();
    }

    /**
     * get method 
     *
     * @return IPAY_CORE_TEST.T_CHANNEL_BILL_DETAILS.BUSINESS_TYPE：null
     */
    public String getBUSINESS_TYPE() {
        return BUSINESS_TYPE;
    }

    /**
     * set method 
     *
     * @param BUSINESS_TYPE  null
     */
    public void setBUSINESS_TYPE(String BUSINESS_TYPE) {
        this.BUSINESS_TYPE = BUSINESS_TYPE == null ? null : BUSINESS_TYPE.trim();
    }

    /**
     * get method 
     *
     * @return IPAY_CORE_TEST.T_CHANNEL_BILL_DETAILS.CHANNEL_TOTAL_AMOUNT：null
     */
    public BigDecimal getCHANNEL_TOTAL_AMOUNT() {
        return CHANNEL_TOTAL_AMOUNT;
    }

    /**
     * set method 
     *
     * @param CHANNEL_TOTAL_AMOUNT  null
     */
    public void setCHANNEL_TOTAL_AMOUNT(BigDecimal CHANNEL_TOTAL_AMOUNT) {
        this.CHANNEL_TOTAL_AMOUNT = CHANNEL_TOTAL_AMOUNT;
    }

    /**
     * get method 
     *
     * @return IPAY_CORE_TEST.T_CHANNEL_BILL_DETAILS.CHANNEL_DISCOUNT_AMOUNT：null
     */
    public BigDecimal getCHANNEL_DISCOUNT_AMOUNT() {
        return CHANNEL_DISCOUNT_AMOUNT;
    }

    /**
     * set method 
     *
     * @param CHANNEL_DISCOUNT_AMOUNT  null
     */
    public void setCHANNEL_DISCOUNT_AMOUNT(BigDecimal CHANNEL_DISCOUNT_AMOUNT) {
        this.CHANNEL_DISCOUNT_AMOUNT = CHANNEL_DISCOUNT_AMOUNT;
    }

    /**
     * get method 
     *
     * @return IPAY_CORE_TEST.T_CHANNEL_BILL_DETAILS.CHANNEL_EXPIRE_TIME：null
     */
    public Date getCHANNEL_EXPIRE_TIME() {
        return CHANNEL_EXPIRE_TIME;
    }

    /**
     * set method 
     *
     * @param CHANNEL_EXPIRE_TIME  null
     */
    public void setCHANNEL_EXPIRE_TIME(Date CHANNEL_EXPIRE_TIME) {
        this.CHANNEL_EXPIRE_TIME = CHANNEL_EXPIRE_TIME;
    }

    /**
     * get method 
     *
     * @return IPAY_CORE_TEST.T_CHANNEL_BILL_DETAILS.CHANNEL_REFUND_NO：null
     */
    public String getCHANNEL_REFUND_NO() {
        return CHANNEL_REFUND_NO;
    }

    /**
     * set method 
     *
     * @param CHANNEL_REFUND_NO  null
     */
    public void setCHANNEL_REFUND_NO(String CHANNEL_REFUND_NO) {
        this.CHANNEL_REFUND_NO = CHANNEL_REFUND_NO == null ? null : CHANNEL_REFUND_NO.trim();
    }

    /**
     * get method 
     *
     * @return IPAY_CORE_TEST.T_CHANNEL_BILL_DETAILS.OUT_REFUND_NO：null
     */
    public String getOUT_REFUND_NO() {
        return OUT_REFUND_NO;
    }

    /**
     * set method 
     *
     * @param OUT_REFUND_NO  null
     */
    public void setOUT_REFUND_NO(String OUT_REFUND_NO) {
        this.OUT_REFUND_NO = OUT_REFUND_NO == null ? null : OUT_REFUND_NO.trim();
    }

    /**
     * get method 
     *
     * @return IPAY_CORE_TEST.T_CHANNEL_BILL_DETAILS.FEE：null
     */
    public BigDecimal getFEE() {
        return FEE;
    }

    /**
     * set method 
     *
     * @param FEE  null
     */
    public void setFEE(BigDecimal FEE) {
        this.FEE = FEE;
    }

    /**
     * get method 
     *
     * @return IPAY_CORE_TEST.T_CHANNEL_BILL_DETAILS.MESSAGE：null
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
     * @return IPAY_CORE_TEST.T_CHANNEL_BILL_DETAILS.CHECK_STATUS：null
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
     * @return IPAY_CORE_TEST.T_CHANNEL_BILL_DETAILS.DFILE_ID：null
     */
    public BigDecimal getDFILE_ID() {
        return DFILE_ID;
    }

    /**
     * set method 
     *
     * @param DFILE_ID  null
     */
    public void setDFILE_ID(BigDecimal DFILE_ID) {
        this.DFILE_ID = DFILE_ID;
    }

    /**
     * get method 
     *
     * @return IPAY_CORE_TEST.T_CHANNEL_BILL_DETAILS.NOTE：null
     */
    public String getNOTE() {
        return NOTE;
    }

    /**
     * set method 
     *
     * @param NOTE  null
     */
    public void setNOTE(String NOTE) {
        this.NOTE = NOTE == null ? null : NOTE.trim();
    }

    /**
     * get method 
     *
     * @return IPAY_CORE_TEST.T_CHANNEL_BILL_DETAILS.CREATED_TIME：null
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
     * @return IPAY_CORE_TEST.T_CHANNEL_BILL_DETAILS.UPDATED_TIME：null
     */
    public Date getUPDATED_TIME() {
        return UPDATED_TIME;
    }

    /**
     * set method 
     *
     * @param UPDATED_TIME  null
     */
    public void setUPDATED_TIME(Date UPDATED_TIME) {
        this.UPDATED_TIME = UPDATED_TIME;
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
        T_channel_bill_details other = (T_channel_bill_details) that;
        return (this.getID() == null ? other.getID() == null : this.getID().equals(other.getID()))
            && (this.getCHECK_DATE() == null ? other.getCHECK_DATE() == null : this.getCHECK_DATE().equals(other.getCHECK_DATE()))
            && (this.getCHANNEL_ID() == null ? other.getCHANNEL_ID() == null : this.getCHANNEL_ID().equals(other.getCHANNEL_ID()))
            && (this.getCHANNEL_CODE() == null ? other.getCHANNEL_CODE() == null : this.getCHANNEL_CODE().equals(other.getCHANNEL_CODE()))
            && (this.getCHANNEL_ORDER_NO() == null ? other.getCHANNEL_ORDER_NO() == null : this.getCHANNEL_ORDER_NO().equals(other.getCHANNEL_ORDER_NO()))
            && (this.getOUT_ORDER_NO() == null ? other.getOUT_ORDER_NO() == null : this.getOUT_ORDER_NO().equals(other.getOUT_ORDER_NO()))
            && (this.getPAY_TYPE() == null ? other.getPAY_TYPE() == null : this.getPAY_TYPE().equals(other.getPAY_TYPE()))
            && (this.getBUSINESS_TYPE() == null ? other.getBUSINESS_TYPE() == null : this.getBUSINESS_TYPE().equals(other.getBUSINESS_TYPE()))
            && (this.getCHANNEL_TOTAL_AMOUNT() == null ? other.getCHANNEL_TOTAL_AMOUNT() == null : this.getCHANNEL_TOTAL_AMOUNT().equals(other.getCHANNEL_TOTAL_AMOUNT()))
            && (this.getCHANNEL_DISCOUNT_AMOUNT() == null ? other.getCHANNEL_DISCOUNT_AMOUNT() == null : this.getCHANNEL_DISCOUNT_AMOUNT().equals(other.getCHANNEL_DISCOUNT_AMOUNT()))
            && (this.getCHANNEL_EXPIRE_TIME() == null ? other.getCHANNEL_EXPIRE_TIME() == null : this.getCHANNEL_EXPIRE_TIME().equals(other.getCHANNEL_EXPIRE_TIME()))
            && (this.getCHANNEL_REFUND_NO() == null ? other.getCHANNEL_REFUND_NO() == null : this.getCHANNEL_REFUND_NO().equals(other.getCHANNEL_REFUND_NO()))
            && (this.getOUT_REFUND_NO() == null ? other.getOUT_REFUND_NO() == null : this.getOUT_REFUND_NO().equals(other.getOUT_REFUND_NO()))
            && (this.getFEE() == null ? other.getFEE() == null : this.getFEE().equals(other.getFEE()))
            && (this.getMESSAGE() == null ? other.getMESSAGE() == null : this.getMESSAGE().equals(other.getMESSAGE()))
            && (this.getCHECK_STATUS() == null ? other.getCHECK_STATUS() == null : this.getCHECK_STATUS().equals(other.getCHECK_STATUS()))
            && (this.getDFILE_ID() == null ? other.getDFILE_ID() == null : this.getDFILE_ID().equals(other.getDFILE_ID()))
            && (this.getNOTE() == null ? other.getNOTE() == null : this.getNOTE().equals(other.getNOTE()))
            && (this.getCREATED_TIME() == null ? other.getCREATED_TIME() == null : this.getCREATED_TIME().equals(other.getCREATED_TIME()))
            && (this.getUPDATED_TIME() == null ? other.getUPDATED_TIME() == null : this.getUPDATED_TIME().equals(other.getUPDATED_TIME()));
    }

    /**
     *
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getID() == null) ? 0 : getID().hashCode());
        result = prime * result + ((getCHECK_DATE() == null) ? 0 : getCHECK_DATE().hashCode());
        result = prime * result + ((getCHANNEL_ID() == null) ? 0 : getCHANNEL_ID().hashCode());
        result = prime * result + ((getCHANNEL_CODE() == null) ? 0 : getCHANNEL_CODE().hashCode());
        result = prime * result + ((getCHANNEL_ORDER_NO() == null) ? 0 : getCHANNEL_ORDER_NO().hashCode());
        result = prime * result + ((getOUT_ORDER_NO() == null) ? 0 : getOUT_ORDER_NO().hashCode());
        result = prime * result + ((getPAY_TYPE() == null) ? 0 : getPAY_TYPE().hashCode());
        result = prime * result + ((getBUSINESS_TYPE() == null) ? 0 : getBUSINESS_TYPE().hashCode());
        result = prime * result + ((getCHANNEL_TOTAL_AMOUNT() == null) ? 0 : getCHANNEL_TOTAL_AMOUNT().hashCode());
        result = prime * result + ((getCHANNEL_DISCOUNT_AMOUNT() == null) ? 0 : getCHANNEL_DISCOUNT_AMOUNT().hashCode());
        result = prime * result + ((getCHANNEL_EXPIRE_TIME() == null) ? 0 : getCHANNEL_EXPIRE_TIME().hashCode());
        result = prime * result + ((getCHANNEL_REFUND_NO() == null) ? 0 : getCHANNEL_REFUND_NO().hashCode());
        result = prime * result + ((getOUT_REFUND_NO() == null) ? 0 : getOUT_REFUND_NO().hashCode());
        result = prime * result + ((getFEE() == null) ? 0 : getFEE().hashCode());
        result = prime * result + ((getMESSAGE() == null) ? 0 : getMESSAGE().hashCode());
        result = prime * result + ((getCHECK_STATUS() == null) ? 0 : getCHECK_STATUS().hashCode());
        result = prime * result + ((getDFILE_ID() == null) ? 0 : getDFILE_ID().hashCode());
        result = prime * result + ((getNOTE() == null) ? 0 : getNOTE().hashCode());
        result = prime * result + ((getCREATED_TIME() == null) ? 0 : getCREATED_TIME().hashCode());
        result = prime * result + ((getUPDATED_TIME() == null) ? 0 : getUPDATED_TIME().hashCode());
        return result;
    }
}